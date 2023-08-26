--1
CREATE FUNCTION StudenID_Func1 (@mavt nvarchar(5))
RETURNS int
AS
BEGIN
    DECLARE @TotalAmount int;
    SELECT @TotalAmount = SUM(SL * GiaBan)
    FROM CHITIETHOADON
    WHERE MaVT = @mavt;

    RETURN @TotalAmount;
END;

--2
CREATE FUNCTION GetTotalHoaDonAmount (@MaHD nvarchar(10))
RETURNS int
AS
BEGIN
    DECLARE @TotalAmount int;

    SELECT @TotalAmount = SUM(SL * GiaBan)
    FROM CHITIETHOADON
    WHERE MaHD = @MaHD;

    RETURN @TotalAmount;
END;

--3
CREATE PROCEDURE StudenId_Proc1
    @MaKH nvarchar(5),
    @DiaChi nvarchar(50)
AS
BEGIN
    UPDATE KHACHHANG
    SET DiaChi = @DiaChi
    WHERE MaKH = @MaKH;
END;

--4
CREATE PROCEDURE AddItemToHoaDon
    @MaHD nvarchar(10),
    @Ngay datetime,
    @MaKH nvarchar(5),
    @MaVT nvarchar(5),
    @SL int,
    @GiaBan int
AS
BEGIN
    -- Insert into CHITIETHOADON
    INSERT INTO CHITIETHOADON (MaHD, MaVT, SL, GiaBan)
    VALUES (@MaHD, @MaVT, @SL, @GiaBan);  
END;

--5
ALTER TABLE Hoadon
ADD Tongtien int;

CREATE TRIGGER StudenId_Trig1 ON Chitiethoadon
AFTER INSERT 
AS
BEGIN
    UPDATE Hoadon
    SET Tongtien = (
        SELECT SUM(SL * GiaBan)
        FROM Chitiethoadon AS C
        WHERE C.MaHD = Hoadon.MaHD
    )
    FROM Hoadon
    JOIN inserted i ON Hoadon.MaHD = i.MaHD;
END;

--6
CREATE VIEW StudentID_View1 AS
SELECT KH.MaKH, KH.TenKH
FROM KHACHHANG AS KH
JOIN HOADON AS HD ON KH.MaKH = HD.MaKH
JOIN CHITIETHOADON AS CT ON HD.MaHD = CT.MaHD
JOIN VATTU AS VT ON CT.MaVT = VT.MaVT
WHERE VT.TenVT = 'GACH ONG';




