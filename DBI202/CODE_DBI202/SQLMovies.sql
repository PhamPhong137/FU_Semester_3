CREATE DATABASE Thuctap

USE Thuctap

Create Table Movies(
title nvarchar(100),
year real not null,
length int not null,
genre char(10),
studioName char(30) not null,
producerC# int 
)

Alter table Movies 
Add price int 

Alter table Movies
DROP COLUMN genre 

Alter table Movies add primary key(year,length)

insert into Movies(title, year, studioName,length)
values(N'Lat mat','2023','Hai',500);

insert into Movies(title, year, studioName,length)
values(N'Doremon','2022','Long',400);

Update Movies
set year = 2022
where year = 2021;

Update Movies
set title = N'L?t m?t'
where title = N'Lat mat';

Delete from Movies 
