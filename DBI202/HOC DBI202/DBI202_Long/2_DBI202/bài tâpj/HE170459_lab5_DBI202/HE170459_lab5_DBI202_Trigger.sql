-- T?o b?ng NHANVIEN
CREATE TABLE NHANVIEN (
    HONV VARCHAR(50),
    TENLOT VARCHAR(50),
    TEN VARCHAR(50),
    MANV VARCHAR(20) PRIMARY KEY,
    NGSINH DATE,
    DCHI VARCHAR(100),
    PHAI VARCHAR(5) CHECK (PHAI = 'Nam' or PHAI = 'Nu'),
    LUONG FLOAT,
    MA_NQL VARCHAR(20),
    PHG int,
);
-- T?o b?ng PHONGBAN
CREATE TABLE PHONGBAN (
    TENPHG VARCHAR(50),
    MAPH int PRIMARY KEY,
    TRPHG VARCHAR(20),
    NG_NHANCHUC DATE

);

-- T?o b?ng DIADIEM_PHG
CREATE TABLE DIADIEM_PHG (
    MAPHG int,
    DIADIEM VARCHAR(100) ,
    FOREIGN KEY (MAPHG) REFERENCES PHONGBAN(MAPH)
);

-- T?o b?ng THANNHAN
CREATE TABLE THANNHAN (
    MA_NVIEN VARCHAR(20),
    TENTN VARCHAR(50),
    PHAI VARCHAR(5),
    NGSINH DATE,
    QUANHE VARCHAR(50),
	FOREIGN KEY (MA_NVIEN) REFERENCES NHANVIEN(MANV)
);

-- T?o b?ng DEAN
CREATE TABLE DEAN (
    TENDA VARCHAR(50),
    MADA VARCHAR(10) PRIMARY KEY,
    DDIEM_DA VARCHAR(100),
    PHONG INT,
    FOREIGN KEY (PHONG) REFERENCES PHONGBAN(MAPH)
);

-- T?o b?ng PHANCONG
CREATE TABLE PHANCONG (
    MA_NVIEN VARCHAR(20),
    SODA VARCHAR(10),
    THOIGIAN VARCHAR(50),
    PRIMARY KEY (MA_NVIEN, SODA),
    FOREIGN KEY (MA_NVIEN) REFERENCES NHANVIEN(MANV),
    FOREIGN KEY (SODA) REFERENCES DEAN(MADA)
);

-- INSERT NHANVIEN
INSERT INTO NHANVIEN (HONV, TENLOT, TEN, MANV, NGSINH, DCHI,PHAI,LUONG,MA_NQL,PHG) VALUES 
('Dinh', 'Ba', 'Tien', 123456789, '1955/01/09', '731 Tran Hung Dao, Q1, TPHCM', 'Nam', 30000,3334455555, 5),
('Nguyen', 'Thanh', 'Tung', 333445555, '1945/12/08', '638 Nguyen Van Cu, Q5, TPHCM', 'Nam', 40000, 888665555, 5),
('Bui', 'Thuy', 'Vu', 999887777, '1958/07/19', '332 Nguyen Thai Hoc, Q1, TPHCM', 'Nam', 25000, 987654321, 4),
('Le', 'Thi', 'Nhan', 987654321, '1932/06/20', '291 Ho Van Hue, QPN, TPHCM', 'Nu', 43000, 888665555, 4),
('Nguyen', 'Manh', 'Hung', 666884444, '1952/09/15', '975 Ba Ria, Vung Tau', 'Nam', 38000, 333445555, 5),
('Tran', 'Thanh', 'Tam', 453453453, '1962/07/31', '543 Mai Thi Luu, Q1, TPHCM', 'Nam', 25000, 333445555, 5),
('Tran', 'Hong', 'Quan', 987987987, '1959/03/29', '980Le Hong Phong, Q10, TPHCM', 'Nam', 25000, 987654321, 4),
('Vuong', 'Ngoc', 'Quyen', 888665555, '1927/10/10', '450 Trung Vuong, HaNoi', 'Nu', 55000,NULL, 1);

-- INSERT PHONGBAN
INSERT INTO PHONGBAN VALUES
('Nghien cuu', 5, 333445555, '1978/05/22'),
('Dieu hanh', 4, 987987987, '1985/01/01'),
('Quan ly', 1, 888665555, '1971/06/19');

-- INSERT THANNHAN
INSERT INTO THANNHAN VALUES
(333445555, 'Quang', 'Nu', '1976/04/05','Con gai'),
(333445555, 'Khang', 'Nam', '1973/10/25', 'Con gai'),
(333445555, 'Duong', 'Nu', '1948/05/03', 'Vo chong'),
(987654321, 'Dang', 'Nam', '1932/02/29', 'Vo chong'),
(123456789, 'Duy', 'Nam', '1978/01/01', 'Con gai'),
(123456789, 'Chau', 'Nu', '1978/12/31', 'Con gai');

-- INSERT DEAN
INSERT INTO DEAN VALUES 
('San pham X', 1, 'VUNG TAU', 5),
('San pham Y', 2, 'NHA TRANG', 5),
('San pham Z', 3, 'TP HCM', 5),
('Tin hoc hoa', 10, 'HA NOI', 4),
('Cap quang', 20, 'TP HCM', 1),
('Dao tao', 30, 'HA NOI', 4);

-- INSERT DIADIEM_PHG
INSERT INTO DIADIEM_PHG VALUES
(1, 'TP HCM'),
(4, 'HA NOI'),
(5, 'VUNG TAU'),
(5, 'NHA TRANG'),
(5, 'TP HCM');

-- INSERT PHANCONG
INSERT PHANCONG VALUES 
(123456789, 1, 32.5),
(123456789, 2, 7.5),
(666884444, 3, 40.0),
(453453453, 1, 20.0),
(453453453, 2, 20.0),
(333445555, 3, 10.0),
(333445555, 10, 10.0),
(333445555, 20, 10.0),
(999887777, 30, 30.0),
(999887777, 10, 10.0),
(987987987, 10, 35.0),
(987987987, 30, 5.0),
(987654321, 30, 20.0),
(987654321, 20, 15.00),
(888665555, 20, NULL );


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
--4	There is not group that have more than five employees that are in the same family.
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