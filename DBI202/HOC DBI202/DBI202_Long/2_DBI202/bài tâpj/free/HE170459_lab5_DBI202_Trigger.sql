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

-- Create a trigger Insertemployee which will be activated by an insert statement into 
-- the NHANVIEN table. The trigger will display the employee's Full Name and the 
-- employee's TENPHG which have just been inserted by the insert statement.
create trigger Insertemployee 
on NHANVIEN
after INSERT
as 
BEGIN
	select i.HONV + ' ' + i.TENLOT + ' ' + i.TEN as 'Full Name',pb.TENPHG from inserted i
	join PHONGBAN pb on pb.MAPH = i.PHG
END