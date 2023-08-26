-- Procedure 1 : List all information of employees whose date of birth is from s to f. 
-- S and f are date value that were been input parameters.
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
create procedure SP_3
	@N int
as select top (@N) * from NHANVIEN order by LUONG DESC;


-- Procedure 4 : Increase 10% for salary of all employees in the city A. A is the input parameter.
create procedure SP_4 @A nvarchar(255)
as 
update nv set Luong = Luong * 1.1 from NHANVIEN nv
join DIADIEM_PHG dd on dd.MAPHG = nv.PHG
where dd.DIADIEM = (@A)


