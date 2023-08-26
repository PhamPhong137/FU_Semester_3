--1
create table Stations(
	StationName nvarchar(50) primary key,
	Address nvarchar(100)
)

create table Routes(
	RouteNumber int primary key,
	StartTime time,
	EndTime time
)

create table Buses(
	BusNumber varchar(15) primary key,
	RouteNumber int foreign key(RouteNumber) references Routes(RouteNumber),
	totalSeats int,
	Company nvarchar(100)
)

create table Has(
	StationNumber int,
	RouteNumber int foreign key(RouteNumber) references Routes(RouteNumber),
	StationName nvarchar(50) foreign key(StationName) references Stations(StationName)
	primary key(StationNumber, RouteNumber, StationName)
)

--2
select employeeNumber, lastName, firstName, email, jobTitle
from employees
where jobTitle = 'Sales Rep'

--3
select e.employeeNumber, CONCAT(e.firstName, ' ', e.lastName) as employeeFullname,
		e.jobTitle, o.officeCode, o.city as officeCity, 
		o.state officeState, o.country officeCountry
from employees e
left join offices o on e.officeCode = o.officeCode 
where o.country = 'France' or o.country = 'USA'
order by o.country, o.city, e.employeeNumber

--4
select distinct c.customerNumber, c.customerName, c.city, c.[state], c.country from customers c
join orders o on c.customerNumber = o.customerNumber
join orderdetails od on od.orderNumber = o.orderNumber
join products p on p.productCode = od.productCode
where (p.productLine = 'Classic Cars') 
and (o.orderDate between '2004-04-01' and '2004-05-31')
order by c.country asc, c.customerName asc

--5
select c.customerNumber, customerName, c.city, c.state,
		c.country, COUNT(distinct o.orderNumber) NumbersOfOrders, 
		SUM(p.amount) TotalPaymentAmount
from customers c, payments p, orders o
where (c.customerNumber = p.customerNumber) 
and (o.customerNumber = c.customerNumber) 
and (c.state = 'CA' or c.state = 'NY') and c.country = 'USA'
group by c.customerNumber, customerName, c.city, c.state, c.country
order by c.state asc, c.customerName asc

--6
SELECT e.employeeNumber, e.lastName, e.firstName, COUNT(c.customerNumber) AS NumberOfCustomers
FROM Employees e
LEFT JOIN Customers c ON e.employeeNumber = c.salesRepEmployeeNumber
WHERE e.jobTitle = 'Sales Rep'
GROUP BY e.employeeNumber, e.lastName, e.firstName
HAVING COUNT(c.customerNumber) = (
    SELECT MIN(CustomerCount)
    FROM (
        SELECT COUNT(c2.customerNumber) AS CustomerCount
        FROM Employees e2
        LEFT JOIN Customers c2 ON e2.employeeNumber = c2.salesRepEmployeeNumber
        WHERE e2.jobTitle = 'Sales Rep'
        GROUP BY e2.employeeNumber
    ) AS T)
OR COUNT(c.customerNumber) = (
    SELECT MAX(CustomerCount)
    FROM (
        SELECT COUNT(c3.customerNumber) AS CustomerCount
        FROM Employees e3
        JOIN Customers c3 ON e3.employeeNumber = c3.salesRepEmployeeNumber
        WHERE e3.jobTitle = 'Sales Rep'
        GROUP BY e3.employeeNumber
    ) AS T);

--7
SELECT * FROM (
  SELECT o.officeCode, o.city, o.state, o.country, e.employeeNumber, 
		e.lastName, e.firstName, e.jobTitle, 
		COUNT(c.customerNumber) AS NumberOfCustomers
  FROM Offices o
  JOIN Employees e ON o.officeCode = e.officeCode
  LEFT JOIN Customers c ON e.employeeNumber = c.salesRepEmployeeNumber
  WHERE e.jobTitle = 'Sales Rep'
  GROUP BY o.officeCode, o.city, o.state, o.country, e.employeeNumber, 
			e.lastName, e.firstName, e.jobTitle) as A1
JOIN (SELECT t.officeCode, min(T.NumberOfCustomers) AS MinNumberOfCustomers 
FROM (SELECT o.officeCode, o.city, o.state, o.country, 
			e.employeeNumber, e.lastName, e.firstName, e.jobTitle, 
			COUNT(c.customerNumber) AS NumberOfCustomers
		FROM Offices o
		JOIN Employees e ON o.officeCode = e.officeCode
		LEFT JOIN Customers c ON e.employeeNumber = c.salesRepEmployeeNumber
		WHERE e.jobTitle = 'Sales Rep'
		GROUP BY o.officeCode, o.city, o.state, o.country, 
			e.employeeNumber, e.lastName, e.firstName, e.jobTitle) AS T
		GROUP BY t.officeCode) AS A2
		ON A1.officeCode = A2.officeCode AND A1.NumberOfCustomers = A2.MinNumberOfCustomers
ORDER BY A1.officeCode

--8
drop proc Proc1
create proc Proc1
@customerNumber int,
@numberOfOrders int output
as
begin
	set @numberOfOrders = (select COUNT(*) 
	from customers c, orders o
	where (c.customerNumber = o.customerNumber) 
	and c.customerNumber = @customerNumber)
end

declare @x int
exec Proc1 114, @x output
select @x as NumberOfOrders

--9
drop trigger Tr1
create trigger Tr1
on orderdetails after delete
as
begin 
	select p.productCode, p.productName, d.orderNumber, o.orderDate, d.quantityOrdered, d.priceEach 
	from deleted d 
	join orders o on o.orderNumber = d.orderNumber
	join products p on p.productCode = d.productCode
	order by p.productCode desc
end

delete from orderdetails where orderNumber = 10100

--10
insert into orders(orderNumber, orderDate, requiredDate, shippedDate, status, customerNumber)
values (10900,'2022-08-12','2022-08-17', '2022-08-16', 'Shipped', 450)