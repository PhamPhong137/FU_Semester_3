--cau1
create table Students(
StudentID int primary key,
Name nvarchar(100),
Address nvarchar(200),
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
[year] int,
Semester char(10),
GroupID char(6),
courseID char(6),
NoCredits char(6),
teacherID int references Teachers(TeacherID)

)

create table Attend(
Date date ,
Slot int,
studentID int ,
classID int,
Attend bit,
foreign key(studentID) references students(studentID),
foreign key(classID) references classes(classID),
primary key(studentID,classID,Date,slot,Attend)

)
--cau2
select * from Customer 
where Segment = 'Comsumer' and City = 'Arlington'

--cau3
select * 
from Customer c, Orders o
where c.ID = o.CustomerID and c.CustomerName like 'B%' and (MONTH(o.OrderDate) = '12' and YEAR(o.OrderDate) = '2017')
order by c.Segment desc, c.CustomerName asc
-- OR
select * from Customer 
where CustomerName LIKE 'B%'
And ID in (select CustomerID from Orders where OrderDate BETWEEN '2017-12-01' AND '2017-12-31')
ORDER BY Segment DESC, CustomerName ASC;

--cau4

with t as(
	select p.SubCategoryID, count(*) as Number 
	from Product p, SubCategory s
	where p.SubCategoryID = s.ID
	group by p.SubCategoryID
)
select t.SubCategoryID, s.SubCategoryName, t.Number
from t, SubCategory as s
where  t.SubCategoryID = s.ID
order by t.Number desc
-- OR
select s.ID, s.SubCategoryName, count(*) as Number 
	from Product p, SubCategory s
	where p.SubCategoryID = s.ID
	group by s.ID, s.SubCategoryName having count(*)>100
	order by Number desc
-- OR (No2)
with x as (select OrderID, (Quantity*SalePrice*(1-Discount)) as Amount from OrderDetails),
y as (select x.OrderID, o.OrderDate, 
      sum(x.Amount) as TotalAmount from x, Orders o where x.orderID= o.ID group by x.orderID, o.OrderDate)

select y.OrderID, od.OrderDate, y.TotalAmount from y, Orders od where y.OrderID=od.ID and y.TotalAmount>8000 
order by y.TotalAmount desc

--cau5
with t2 as(
select p.ID, p.ProductName, o.Quantity
from Product p, OrderDetails o
where p.ID = o.ProductID
)
select distinct t2.*
from t2, Product p
where t2.Quantity = (select MAX(t2.quantity) from t2)

-- OR
select p.ID, p.ProductName, o.quantity from Product p, OrderDetails o
where o.Quantity = (select MAX(o.quantity) from OrderDetails o) and p.id = o.ProductID

--cau6
with t3 as(
select c.ID, count(*) as NumberOfOrders
from Customer c, Orders o
where c.ID = o.CustomerID
group by c.ID
)
select distinct t3.ID, c.CustomerName, t3.NumberOfOrders 
from t3, Customer c
where t3.NumberOfOrders = (select MAX(t3.NumberOfOrders) from t3) and c.ID = t3.ID
-- or
select distinct c.ID, c.CustomerName, count(*) as NumberOfOrders
from Customer c, Orders o
where c.ID = o.CustomerID
Group by c.ID, c.CustomerName having count(*) >= all (select count(*) as NumberOfOrders
from Customer a, Orders b
where a.ID = b.CustomerID
Group by a.ID, a.CustomerName)



-- OR
with tt as (
select customer.ID, CustomerName, count(*) as number
from Customer, Orders
where Customer.id = Orders.CustomerID
group by Customer.CustomerName, Customer.id)
select c.ID, c.CustomerName, COUNT(*) AS NumberOfOrders from Customer c, Orders o
where c.id = o.CustomerID
group by c.CustomerName, c.id
having COUNT(*) = (select max(tt.number) from tt)

--cau7
with t4 as(
Select top(5) *
from Product 
order by UnitPrice desc
),
t5 as(
Select top(5) *
from Product 
order by UnitPrice asc
)
select *
from t4
union all
select *
from t5 order by UnitPrice desc
-- OR

select * from (select top(5) * from Product order by UnitPrice asc) a
union
select * from (select top(5) * from Product order by UnitPrice desc) b
order by UnitPrice desc
-- OR

select * from Product Where
UnitPrice in (select top(5) * from Product order by UnitPrice asc)
or
UnitPrice in (select top(5) * from Product order by UnitPrice desc)
order by UnitPrice desc

--cau8
create procedure CountProduct (
		@OrderID nvarchar(255),
		@t int OUTPUT
	)
as
Begin
	Select count(*)
	from OrderDetails s, Orders o
	where o.ID = @OrderID and o.ID = s.OrderID
End
declare @t int
exec CountProduct 'CA-2014-100391', @t output 
print @t

--cau9
create trigger InsertProduct on Product after insert as
begin
	select top(1) p.ProductName, s.SubCategoryName
	from inserted p, SubCategory s
	where s.ID = p.SubCategoryID
end
insert into Product(ProductName, UnitPrice, SubCategoryID)
values ('Craft paper', 0.5, 3)
--cau10
SET IDENTITY_INSERT dbo.Category ON
insert into dbo.Category(ID,CategoryName)
values (4,N'Sports')

declare @top int
set @top = (select max(dbo.SubCategory.ID) from dbo.SubCategory)
declare @next int
set @next =1

set IDENTITY_INSERT dbo.SubCategory ON
insert into dbo.SubCategory(ID,SubCategoryName,CategoryID)
values ((@top+@next),N'Tennis',(select max(dbo.Category.ID) from dbo.Category))

--Or
insert into dbo.Category(
    CategoryName)
values('Sports' -- CategoryName - nvarchar(255)
    )

	select * from dbo.Category
insert into dbo.SubCategory(
    SubCategoryName,CategoryID
)
values(   N'Tennis', -- SubCategoryName - nvarchar(255)
    4    -- CategoryID - int
    )
	insert into dbo.SubCategory(
    SubCategoryName, CategoryID
)
values(   N'Football', -- SubCategoryName - nvarchar(255)
    4    -- CategoryID - int
    )
	-- Trần Trung Việt SE1632
	insert into Category(CategoryName)
values('Sport')
insert into SubCategory(CategoryID, SubCategoryName)
values
((select c.ID from Category c where c.CategoryName = 'Sport'),'Tennis'),
((select c.ID from Category c where c.CategoryName = 'Sport'),'Football')
