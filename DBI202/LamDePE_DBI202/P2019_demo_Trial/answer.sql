--1
create table Students(
	StudentID int primary key,
	Name nvarchar(50),
	Address	nvarchar(200),
	Gender char(1)
)
create table Teachers(
	TeacherID int primary key,
	Name nvarchar(50),
	Address nvarchar(200),
	Gender char(1)
)
create table Classes(
	ClassID int primary key,
	GroupID char(6),
	courseID char(6),
	NoCredits int,
	Semester char(10),
	year int,
	TeacherID int foreign key(TeacherID) references Teachers(TeacherID) 
)
create table Attend(
	Date date,
	Slot int,
	Attend bit,
	StudentID int FOREIGN KEY(StudentID) references Students(StudentID),
	ClassID int FOREIGN KEY(ClassID) references Classes(ClassID),
	primary key(Date, Slot, StudentID, ClassID)
)

--2 Write a query to display all customers who are ‘Consumer’ and are from Arlington city as follows:
SELECT *
FROM dbo.Customer
WHERE City = 'Arlington' AND Segment = 'Consumer'

--3
select c.City,c.Country,c.CustomerName,c.ID,c.PostalCode,c.Region,c.Segment,c.State
from Customer c, Orders o 
WHERE o.CustomerID = c.ID AND CustomerName like 'B%' AND o.OrderDate Between '2017-12-01' and '2017-12-31'
order by c.Segment DESC, c.CustomerName

--4
Select p.SubCategoryID, sc.SubCategoryName, count(SubCategoryID) as NumberOfProducts
from Product p JOIN SubCategory sc on p.SubCategoryID = sc.ID
GROUP BY p.SubCategoryID, sc.SubCategoryName
HAVING count(SubCategoryID) > 100
Order by NumberOfProducts desc

--5
select o.ProductID, p.ProductName,o.Quantity
from OrderDetails o
join Product p on p.ID = o.ProductID
WHERE o.Quantity = (select max(o2.Quantity) from OrderDetails o2 )

--6
with temp as(
select count(o.CustomerID) as NumberOfOrders
from Orders o
group by CustomerID
)
select c.ID, c.CustomerName, count(o.CustomerID) as NumberOfOrders
from Customer c join Orders o on  c.ID=o.CustomerID
group by c.ID, c.CustomerName
having  count(o.CustomerID) =(select max(NumberOfOrders)from temp)
					
--7				
select * 
from (select top(5) * from Product p
order by p.UnitPrice desc) as s
union 
select * 
from (select top(5) * from Product p
order by p.UnitPrice) as s1

order by s.UnitPrice desc
--8
create proc CountProduct @OrderID nvarchar(255), @NbProducts int output
as
begin
	set @NbProducts=(
	select count(*) from OrderDetails o
	where o.OrderID = @OrderID
	group by o.OrderID
	)
end

--drop proc CountProduct
--declare @t int
--exec CountProduct 'CA-2014-100391', @t output 
--print @t

--9
create trigger InsertProduct on Product
instead of insert 
as
begin
	select i.ProductName, s.SubCategoryName 
	from inserted i join SubCategory s on i.SubCategoryID=s.ID
end

--drop trigger InsertProduct

--insert into Product(ProductName, UnitPrice, SubCategoryID)
--values ('Craft paper', 0.5, 3)

--delete from Product
--where ProductName='Craft paper'

--10
insert into Category(CategoryName) values ('Sports')
insert into SubCategory(SubCategoryName, CategoryID) values
('Tennis', (select ID from Category where CategoryName='Sports')),
('Football', (select ID from Category where CategoryName='Sports'))


















