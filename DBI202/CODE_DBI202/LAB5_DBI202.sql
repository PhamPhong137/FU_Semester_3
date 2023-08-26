-- Procedure 1 : List all information of employees whose date of birth is from s to f. 
create procedure SP_1 @s date, @f date
as
select nv.MANV, 
	nv.HONV + ' ' + nv.TENLOT + ' ' + nv.TEN as Name,
	nv.NGSINH, 
	nv.MA_NQL,
	nv2.HONV + ' ' + nv2.TENLOT + ' ' + nv2.TEN as 'SuperVisors Name' 
from NHANVIEN nv, NHANVIEN nv2 where nv2.MANV = nv.MA_NQL and nv.NGSINH >= @s and nv.NGSINH <= @f


-- Procedure 2 : List all employees (code, name, salary) whose salary more than the average salary 
-- of the department that they work in
create procedure SP_2 
AS
BEGIN
    SELECT nv.MANV, CONCAT(nv.HONV, ' ', nv.TENLOT, ' ', nv.TEN) AS 'Name', nv.LUONG
    FROM NHANVIEN nv
    INNER JOIN (
        SELECT PHG, AVG(LUONG) AS AvgSalary
        FROM NHANVIEN
        GROUP BY PHG
    ) AS avg ON nv.PHG = avg.PHG
    WHERE nv.LUONG > avg.AvgSalary
END


-- Procedure 3 : List N employees that have the highest salary. N is the input parameter
create procedure SP_3 @N int
as 
begin
select top (@N) * from NHANVIEN order by LUONG DESC;
end


-- Procedure 4 : Increase 10% for salary of all employees in the city A. A is the input parameter.
create procedure SP_4 @A nvarchar(255)
as 
begin
update nv set Luong = Luong * 1.1 from NHANVIEN nv
join DIADIEM_PHG dd on dd.MAPHG = nv.PHG
where dd.DIADIEM = (@A)
end


-- Procedure 5 : Delete all no personnel departments. 
create procedure SP_5
as
BEGIN
delete from DIADIEM_PHG 
WHERE MAPHG IN (
	SELECT pb.MAPH
	FROM PHONGBAN pb
	INNER JOIN NHANVIEN nv ON nv.PHG = pb.MAPH
	GROUP BY pb.MAPH
	HAVING COUNT(*) = 1);
delete from PHONGBAN
WHERE MAPH IN (
	SELECT pb.MAPH
	FROM PHONGBAN pb
	INNER JOIN NHANVIEN nv ON nv.PHG = pb.MAPH
	GROUP BY pb.MAPH
	HAVING COUNT(*) = 1);
END

-----------------------------------TRIGGER---------------------------------

-- 1 The average salary of each department must be fewer than 50000.
CREATE TRIGGER AVG_SALARY
ON NHANVIEN
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    IF (SELECT AVG(LUONG) FROM NHANVIEN WHERE PHG = (SELECT PHG FROM inserted)) > 50000
    BEGIN
        RAISERROR ('Luong trung binh cua phong ban phai nho hon 50000.', 16, 1)
        ROLLBACK TRANSACTION
    END
END

-- 2 The salary of the head of each department must be greater than or equal to salary of 
-- all employees in this department 
CREATE TRIGGER AVG_HEAD
ON NHANVIEN
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
	IF EXISTS (
		SELECT * FROM PHONGBAN pb 
		JOIN NHANVIEN head ON pb.TRPHG = head.MANV 
		JOIN NHANVIEN emp on emp.PHG = pb.MAPH
		where head.LUONG < emp.LUONG
	)
	BEGIN
		ROLLBACK TRANSACTION
	END
END

-- 3 The different between average salary of employees in HCM and HN must fewer than 10000.
create trigger HN_VS_HCM
ON NHANVIEN
after INSERT, UPDATE, DELETE
AS
BEGIN
	DECLARE @avgHCM INT
	SELECT @avgHCM = AVG(LUONG)
	FROM NHANVIEN AS nv
	INNER JOIN DIADIEM_PHG AS dd ON nv.PHG = dd.MAPHG
	WHERE dd.DIADIEM = 'TP HCM'

	declare @avgHN INT
	select @avgHN = AVG(LUONG)
	FROM NHANVIEN AS nv
	INNER JOIN DIADIEM_PHG AS dd ON nv.PHG = dd.MAPHG
	WHERE dd.DIADIEM = 'Ha Noi'

	IF @avgHN - @avgHCM < 10000 AND @avgHN - @avgHCM > -10000
	ROLLBACK TRANSACTION
END

--4.	There is not group that have more than five employees that are in the same family.
CREATE TRIGGER enforce_family_group
ON NHANVIEN
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @max_family_count INT;
    SET @max_family_count = 5; -- Maximum number of employees from the same family in a group

    IF EXISTS (
        SELECT n.PHG
        FROM NHANVIEN n
        INNER JOIN (
            SELECT PHG, COUNT(*) AS family_count
            FROM NHANVIEN n1
            INNER JOIN THANNHAN t ON n1.MANV = t.MA_NVIEN
            WHERE t.QUANHE = 'Con trai'
            GROUP BY PHG
            HAVING COUNT(*) > @max_family_count
        ) AS family_groups ON n.PHG = family_groups.PHG
        WHERE n.MANV IN (SELECT MANV FROM inserted)
		OR n.MANV IN (SELECT MANV FROM deleted)
    )
    BEGIN
        -- Raise an error or take appropriate action
        RAISERROR('There is a group with more than five employees from the same family.', 16, 1);
        ROLLBACK TRANSACTION; -- Rollback the transaction if necessary
    END;
END;


--5 The different between number of male and female employees must fewer than 10%.
CREATE TRIGGER MALE_VS_FEMALE
ON NHANVIEN
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    IF EXISTS (
        SELECT pb.MAPH, ABS((SUM(CASE WHEN nv.PHAI = 'Nam' THEN 1 ELSE 0 END) - SUM(CASE WHEN nv.PHAI = 'Nu' THEN 1 ELSE 0 END)) * 1.0 / NULLIF(COUNT(*), 0)) AS GenderDiff
        FROM PHONGBAN pb
        INNER JOIN NHANVIEN nv ON nv.PHG = pb.MAPH
        GROUP BY pb.MAPH
        HAVING ABS((SUM(CASE WHEN nv.PHAI = 'Nam' THEN 1 ELSE 0 END) - SUM(CASE WHEN nv.PHAI = 'Nu' THEN 1 ELSE 0 END)) * 1.0 / NULLIF(COUNT(*), 0)) > 0.1
    )
    BEGIN
        ROLLBACK TRANSACTION
    END
END



