USE QuanLy_WS

--1
CREATE Proc SP_1 
	@Salary int
AS SELECT * FROM NHANVIEN WHERE LUONG > @Salary;
--EXEC SP_1 10000
--2
CREATE Proc SP_2
	@StartDate date,
	@EndDate date
AS SELECT NV.MANV, NV.TEN, NV.LUONG, NV.MA_NQL, THANNHAN.TENTN as TEN_Thannhan
	FROM NHANVIEN as NV
	 JOIN THANNHAN ON NV.MANV =THANNHAN.MA_NVIEN
	WHERE NV.NGSINH BETWEEN @StartDate AND @EndDate;

--EXEC SP_2 '01/09/1955','01/10/1965'

--3
CREATE Proc SP_3
		@Code int
AS SELECT * FROM NHANVIEN WHERE PHG =@Code;
--EXEC SP_3 5

--4
CREATE Proc SP_4
AS
SELECT * FROM NHANVIEN WHERE MA_NQL IS NULL;
--EXEC SP_4

--5
CREATE Proc SP_5
AS
SELECT TEN, MANV, DATEDIFF(MONTH, NGSINH, GETDATE()) AS WORKING_MONTHS FROM NHANVIEN;
EXEC SP_5
--6
CREATE Proc SP_6
AS
	SELECT PHG, TENPHG, COUNT(*) AS NUM_EMPLOYEES
	FROM NHANVIEN join PHONGBAN on NHANVIEN.PHG = PHONGBAN.MAPHG 
	GROUP BY PHG, TENPHG;

EXEC SP_6





