create table Products(
ProductNo varchar(30) primary key,
[Name] nvarchar(50),
[Description] nvarchar(255),
Category nvarchar(50),
)
create table Colors(
ColorCode varchar(20) primary key,
[Name] nvarchar(100),
)
create table Sizes(
SizeCode varchar(15) primary key,
[Description] nvarchar(200),
)
create table Has(
quantity int,
ProductNo varchar(30),
ColorCode varchar(20),
SizeCode varchar(15),
primary key(ProductNo, ColorCode, SizeCode),
foreign key(ProductNo) references Products(ProductNo),
foreign key(ColorCode) references Colors(ColorCode),
foreign key(SizeCode) references Sizes(SizeCode)
)

