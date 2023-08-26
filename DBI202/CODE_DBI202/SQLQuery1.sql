CREATE DATABASE QLSV
ON PRIMARY
(
    NAME = QLSV_Data,
    FILENAME = 'D:\DBI202\QLSV_dat.mdf',
    SIZE = 10MB,
    MAXSIZE = 50MB,
    FILEGROWTH = 2MB
)
LOG ON
(
    NAME = QLSVLog,
    FILENAME = 'D:\DBI202\QLSV_log.ldf',
    SIZE = 5MB,
    MAXSIZE = 25MB,
    FILEGROWTH = 1MB
);
