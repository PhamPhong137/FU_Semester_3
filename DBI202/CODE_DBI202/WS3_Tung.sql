create database WS3
use WS3

-----
create table KhachHang(
	maKH varchar(5) primary key, 
	tenKH varchar(30) not null, diaChi varchar(50),
	dt varchar(10) check(len(dt)>=7 AND len(dt)<=10) , 
	email varchar(30)
)
go

insert into KhachHang values('KH01', 'NGUYEN THI BE', 'TAN BINH', '8457895', 'bnt@yahoo.com')
insert into KhachHang values('KH02', 'LE HOANG NAM', 'BINH CHANH', '9878987', 'namlehoang@abc.com')
insert into KhachHang values('KH03', 'TRAN THI CHIEU', 'TAN BINH', '8457895', null)
insert into KhachHang values('KH04', 'MAI THI QUE ANH', 'BINH CHANH', null, null)
insert into KhachHang values('KH05', 'LE VAN SANG', 'QUAN10', null, 'sanglv@hcm.vnn.vn')
insert into KhachHang values('KH06', 'TRAN HOANG KHAI', 'TAN BINH', '8457897', null)
select *from KhachHang
-----
create table SanPham(
	maVT varchar(10) primary key, 
	tenVT varchar(30) not null,
	DVT varchar(20),
	giaMua int check(giaMua >0), 
	slTon int check(slTon>=0)
)

insert into SanPham values('VT01', 'XI MANG', 'BAO', '50000', '5000')
insert into SanPham values('VT02', 'CAT', 'KHOI', '45000', '50000')
insert into SanPham values('VT03', 'GACH ONG', 'VIEN', '120', '800000')
insert into SanPham values('VT04', 'GACH THE', 'VIEN', '110', '800000')
insert into SanPham values('VT05', 'DA LON', 'KHOI', '25000', '100000')
insert into SanPham values('VT06', 'DA NHO', 'KHOI', '33000', '100000')
select * from SanPham
-----
create table HoaDon(
maHD varchar(10) primary key, 
ngay date, 
maKH varchar(5) foreign key references KhachHang(maKH),
tongTG int
)
go

insert into HoaDon(maHD,ngay,maKH) values('HD01', '12/05/2000', 'KH01')
insert into HoaDon(maHD,ngay,maKH) values('HD02', '05/25/2000', 'KH02')
insert into HoaDon(maHD,ngay,maKH) values('HD03', '05/25/2000', 'KH01')
insert into HoaDon(maHD,ngay,maKH) values('HD04', '05/25/2000', 'KH04')
insert into HoaDon(maHD,ngay,maKH) values('HD05', '05/26/2000', 'KH04')
insert into HoaDon(maHD,ngay,maKH) values('HD06', '06/02/2000', 'KH03')
insert into HoaDon(maHD,ngay,maKH) values('HD07', '06/22/2000', 'KH04')
insert into HoaDon(maHD,ngay,maKH) values('HD08', '06/25/2000', 'KH03')
insert into HoaDon(maHD,ngay,maKH) values('HD09', '08/15/2000', 'KH04')
insert into HoaDon(maHD,ngay,maKH) values('HD010', '09/30/2000', 'KH01')
select * from HoaDon
-----
create table ChiTietHoaDon(
	maHD varchar(10) foreign key references HoaDon(maHD),
	maVT varchar(10) foreign key references SanPham(maVT),
	primary key(maHD,maVT),
	SL int check(SL>0), 
	khuyenMai int, 
	giaBan int
)
go

insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD01', 'VT01', '5', '52000')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD01', 'VT05', '10', '30000')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD02', 'VT03', '10000', '150')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD03', 'VT02', '20', '55000')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD04', 'VT03', '50000', '150')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD04', 'VT04', '20000', '120')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD05', 'VT05', '10', '30000')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD06', 'VT04', '10000', '120')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD07', 'VT04', '20000', '125')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD08', 'VT01', '100', '55000')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD09', 'VT02', '25', '48000')
insert into ChiTietHoaDon(maHD, maVT,SL, giaBan) values('HD010', 'VT01', '25', '57000')
select *from ChiTietHoaDon
-----
UPDATE ChiTietHoaDon SET SL 

--2
select * from KhachHang
where diaChi = 'TAN BINH'
go

--3 
select * from SanPham
where tenVT like '%GACH%' and giaMua > 110 
go

--4
SELECT HoaDon.maHD, HoaDon.ngay, KhachHang.tenKH, 
	   KhachHang.diaChi, KhachHang.dt
FROM HoaDon
JOIN KhachHang ON HoaDon.maKH = KhachHang.maKH
order by ngay asc
go

--5
SELECT * FROM KhachHang
WHERE maKH NOT IN (
    SELECT maKH
    FROM HoaDon
    WHERE ngay >= '2000-06-01' AND ngay < '2000-07-01'
)
go

--6 
SELECT a.maHD, a.maVT, b.tenVT, b.DVT, 
       a.giaBan, 
       b.giaMua,
       a.SL AS SL,
       b.giaMua * a.SL AS TriGiaMua,
       a.giaBan * a.SL AS TriGiaBan
FROM ChiTietHoaDon AS a
JOIN SanPham AS b ON b.maVT = a.maVT
WHERE a.giaBan >= b.giaMua
ORDER BY a.maHD asc
go

--7 List all orders which has maximum total value 
SELECT a.maHD AS MAHD, a.ngay AS NGAY, a.maKH as MAKH, b.tenKH AS TENKH,
	   b.diaChi AS DIACHI, a.tongTG AS TongGiaTri
FROM HoaDon AS a JOIN KhachHang AS b ON a.maKH = b.maKH
where a.tongTG = (
	SELECT MAX(tongTG)
    FROM HoaDon
);
go

-- 8 List all products which were bought in minimum number of orders 
SELECT b.maVT AS MAVT, a.tenVT AS TENVT, a.DVT, a.giaMua AS GIAMUA, COUNT(*) AS SL
FROM SanPham AS a
JOIN ChiTietHoaDon AS b ON a.maVT = b.maVT
GROUP BY b.maVT, a.tenVT, a.DVT, a.giaMua
HAVING COUNT(*) = (
    SELECT MIN(OrderCount)
    FROM (
        SELECT maVT, COUNT(*) AS OrderCount
        FROM ChiTietHoaDon
        GROUP BY maVT
    ) AS Counts
)
go


