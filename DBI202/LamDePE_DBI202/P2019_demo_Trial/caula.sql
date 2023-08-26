--1
create table Teachers(
TeacherID int primary key,
Name nvarchar(50),
Address nvarchar(200),
Gender char(1)
)
create table Classes(
ClassID int Primary Key,
GroupID char(6),
coueseID char(6),
NoCredits int,
Semester char(10),
year int,
TeacherID int
constraint fk_Classes_Teachers FOREIGN KEY(TeacherID) references Teachers(TeacherID)
)
create table Students(
StudentID int Primary Key,
Name nvarchar(50),
Address nvarchar(200),
Gender char(1),
)
create table Attend(
Date date,
Slot int,
Attend bit,
StudentID int,
ClassID int,
primary key(Date, Slot, StudentID, ClassID),
constraint fk_Attend_Students FOREIGN KEY(StudentID) references Students(StudentID),
constraint fk_Attend_Classes FOREIGN KEY(ClassID) references Classes(ClassID)
)


--3
SELECT c.ID,c.CustomerName,c.City,c.State
FROM Customer c
INNER JOIN
Orders o ON c.ID =o.CustomerID 
WHERE (o.OrderDate BETWEEN '2017-12-05' AND '2017-12-10')
AND o.ShipDate - o.OrderDate < 3
ORDER BY c.State ,c.City DESC 

--4
SELECT od.OrderID, o.OrderDate, ((od.Quantity)*(od.SalePrice)*(1-od.Discount)) as TotalAmount FROM Orders o
INNER JOIN OrderDetails od ON o.ID = od.OrderID WHERE ((od.Quantity)*(od.SalePrice)*(1-od.Discount)) > 8000
ORDER BY TotalAmount DESC

--4
SELECT od.OrderID, o.OrderDate, SUM(od.Quantity * od.SalePrice * (1 - od.Discount)) AS TotalAmount
FROM Orders o
INNER JOIN OrderDetails od ON o.ID = od.OrderID
GROUP BY od.OrderID, o.OrderDate
HAVING SUM(od.Quantity * od.SalePrice * (1 - od.Discount)) > 8000
ORDER BY TotalAmount DESC;

--4 > 100 gi do
select p.SubCategoryID, s.SubCategoryName, 
		COUNT(p.SubCategoryID) as NumberOfProducts
from SubCategory s, Product p
where s.ID = p.SubCategoryID 
group by p.SubCategoryID, s.SubCategoryName
having COUNT(p.SubCategoryID) > 100
order by NumberOfProducts desc
--5 same day
select o.ID, o.OrderDate, o.ShipDate, o.ShipDate, 
		o.ShipMode, c.ID
from Orders o, Customer c
where (o.CustomerID = c.ID) and o.OrderDate = (select top(1) o.OrderDate
from Orders o, Customer c
where (o.CustomerID = c.ID)
order by o.OrderDate desc)
order by o.OrderDate
--6
select p.ID, p.ProductName, count(od.OrderID) as NumberOfOrders
from Product p
left join OrderDetails od on p.ID = od.ProductID
group by p.ID, p.ProductName
having count(od.OrderID) = (
	select min(OrderCount)
	from (
	select count(OrderID) as OrderCount
	from OrderDetails
	group by ProductID
	) as OrderCount
)
order by p.ID
--7
select *
from (select top 5 p.SubCategoryID ,count(p.ProductName) as NumberOfProducts
from Product p join SubCategory s on p.SubCategoryID=s.ID
group by p.SubCategoryID
order by NumberOfProducts ) as s
union 
select * 
from (select top 5 p.SubCategoryID ,count(p.ProductName) as NumberOfProducts
from Product p join SubCategory s on p.SubCategoryID=s.ID
group by p.SubCategoryID
order by NumberOfProducts desc) as s1

order by s.NumberOfProducts desc

--8
create proc TotalAmount(
	@OrderID nvarchar(255), 
	@TotalAmount float output
)
as
begin
	set @TotalAmount = (
	select SUM(d.Quantity * d.SalePrice * (1-d.Discount))
	from Orders o, OrderDetails d
	where o.ID = @OrderID and o.ID = d.OrderID
	)
end
--9
create trigger InsertSubCategory on SubCategory
for insert
as
	begin
		select i.SubCategoryName, c.CategoryName
		from inserted i, Category c
		where i.CategoryID = c.ID
	end

	drop proc CountProduct
	drop trigger InsertSubCategory


























