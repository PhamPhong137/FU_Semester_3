--1 
create table Genres(
	Genre varchar(50) primary key,
	Description varchar(200)
)

create table Movies(
	MovieNumber int primary key,
	Title nvarchar(200),
	Year int,
	Genre varchar(50) foreign key(Genre) references Genres(Genre)
)

create table Persons(
	PersonID int primary key,
	FullName nvarchar(200),
	Gender nvarchar(10)
)

create table Rate(
	MovieNumber int foreign key(MovieNumber) references Movies(MovieNumber),
	PersonID int foreign key(PersonID) references Persons(PersonID),
	Time DateTime,
	Comment text,
	NumericRating float,
	primary key(MovieNumber, PersonID)
)

--2
select * from customers 
where state = 'CA'

--3
select orderNumber, productCode, quantityOrdered, priceEach
from orderdetails
where (productCode = 'S18_1749') and (quantityOrdered > 25)
order by priceEach, quantityOrdered desc

--4
select o.orderNumber, o.orderDate, o.requiredDate, o.shippedDate, o.status,
		c.customerNumber, c.customerName, c.city, c.country
from orders o, customers c
where (o.customerNumber = c.customerNumber) 
and (o.shippedDate is null) and (c.country = 'USA')
order by customerName

--5
select c.customerNumber, c.customerName, c.city, c.country,
		SUM(p.amount) totalAmountOfPayments
from customers c 
left join payments p on (c.customerNumber = p.customerNumber) 
where c.country = 'Germany'
group by c.customerNumber, c.customerName, c.city, c.country
order by totalAmountOfPayments

--6
select * from employees
where employeeNumber not in 
(
	select e.employeeNumber from employees e, customers c 
	where (c.salesRepEmployeeNumber = e.employeeNumber)
)

--7
select p.productCode, p.productName, p.productCategory, 
		COUNT(p.productCode) as numberOfOrders,
		COUNT(distinct c.customerNumber) as numberOfCustomers,
		SUM(od.quantityOrdered) as totalQuantityOrdered,
		SUM((od.priceEach - p.buyPrice) * od.quantityOrdered) as totalProfit
from products p, customers c, orders o, orderdetails od 
where (p.productCode = od.productCode) and (c.customerNumber = o.customerNumber)
and (o.orderNumber = od.orderNumber) and (p.productCategory = 'Planes')
group by p.productCode, p.productName, p.productCategory
order by totalProfit desc

--8
drop proc proc_numberOfOrders
create proc proc_numberOfOrders
@customerNumber int,
@numberOfOrders int output
as
begin 
	set @numberOfOrders = (
	select COUNT(o.orderNumber) from orders o, customers c
	where (o.customerNumber = c.customerNumber) and @customerNumber = c.customerNumber
	)
end

declare @x int
exec proc_numberOfOrders 103, @x output
select @x as NumberOfOrders

--9
drop trigger tr_insertPayment
create trigger tr_insertPayment
on payments for insert
as
begin
	select c.customerNumber, c.customerName, i.checkNumber, i.paymentDate,
			i.amount
	from inserted i, customers c
	where (i.customerNumber = c.customerNumber)
	order by c.customerNumber desc
end

insert into payments(customerNumber, checkNumber, paymentDate, amount)
values(103, 'HQ336364', '2004-10-29', 1000), (112, 'QM789234', '2005-10-30', 200)

--10
delete from products
where productCode not in (select productCode from orderdetails)