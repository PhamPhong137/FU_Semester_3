CREATE DATABASE QLDETAI_SV
GO

USE QLDETAI_SV
GO

CREATE TABLE SINHVIEN(
 MASV CHAR(6) NOT NULL,
 TENSV NVARCHAR(30) NOT NULL,
 SODT VARCHAR(10),
 LOP CHAR(6) NOT NULL,
 DIACHI NVARCHAR(50) NOT NULL,
 CONSTRAINT pk_SINHVIEN PRIMARY KEY(MASV)
 )
 GO

 CREATE TABLE DETAI(
 MADT CHAR(6) NOT NULL,
 TENDT NVARCHAR(50)  NOT NULL
 CONSTRAINT pk_DETAI PRIMARY KEY(MADT)
 )
 GO 

CREATE TABLE SINHVIEN_DETAI(
 MASV CHAR(6) NOT NULL,
 MADT CHAR(6) NOT NULL,
 NGAYBAOCAO DATETIME,
 CONSTRAINT pk_SINHVIEN_DETAI PRIMARY KEY(MASV, MADT),

 CONSTRAINT fk_Sinhvien_SINHVIEN_DETAI FOREIGN KEY(MASV) REFERENCES SINHVIEN(MASV),
 CONSTRAINT fk_detai_SINHVIEN_DETAI FOREIGN KEY(MADT) REFERENCES DETAI(MADT),
 )

INSERT INTO SINHVIEN(MASV,TENSV,SODT,LOP,DIACHI) VALUES('SV0001',N'Nguy?n V?n A', '0909029530','DTH04','B�nh Ch�nh')
INSERT INTO SINHVIEN(MASV,TENSV,SODT,LOP,DIACHI) VALUES('SV0002',N'Nguy?n V?n B', '0909029531','DTH04','B�nh Ch�nh')

INSERT INTO DETAI(MADT,TENDT) VALUES('DT0001',N'?? �n C? S?')
INSERT INTO DETAI(MADT,TENDT) VALUES('DT0002',N'?? �n T?t Nghi?p')


INSERT INTO SINHVIEN_DETAI(MASV,MADT) VALUES('SV0001',N'DT0001')
INSERT INTO SINHVIEN_DETAI(MASV,MADT) VALUES('SV0001',N'DT0002')

INSERT INTO SINHVIEN_DETAI(MASV,MADT) VALUES('SV0002',N'DT0001')
INSERT INTO SINHVIEN_DETAI(MASV,MADT) VALUES('SV0002',N'DT0002')