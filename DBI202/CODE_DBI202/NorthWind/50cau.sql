USE Northwind
GO

--1 Create a report that shows the CategoryName and Description from the categories table sorted by CategoryName.
SELECT CategoryName, Description
FROM Categories
ORDER BY CategoryName

--2 Create a report that shows the ContactName, CompanyName, ContactTitle and Phone number from the customers table sorted by Phone.
SELECT ContactName, CompanyName, ContactTitle, Phone
From Customers
ORDER BY Phone;

--3  Create a report that shows the capitalized FirstName and capitalized LastName renamed as FirstName and Lastname respectively and HireDate from the employees table sorted from the newest to the oldest employee.
SELECT UPPER(FirstName) AS FirstName, UPPER( LastName) AS LastName, HireDate
FROM dbo.employees 
ORDER BY HireDate;

--4 Create a report that shows the top 10 OrderID, OrderDate, ShippedDate, CustomerID, Freight from the orders table sorted by Freight in descending order.
SELECT TOP 10 OrderID, OrderDate, ShippedDate, CustomerID, Freight
FROM dbo.orders
ORDER BY Freight Desc

--5  Create a report that shows all the CustomerID in lowercase letter and renamed as ID from the customers table.
SELECT Lower (CustomerID) as ID
FROM Customers

--6 Create a report that shows the CompanyName, Fax, Phone, Country, HomePage from the suppliers table sorted by the Country in descending order then by CompanyName in ascending order.
SELECT CompanyName, Fax, Phone,Country, HomePage
FROM dbo.suppliers
ORDER BY Country DESC, CompanyName

--7 Create a report that shows CompanyName, ContactName of all customers from ‘Buenos Aires' only.
SELECT CompanyName, ContactName
FROM dbo.Customers
WHERE City='Buenos Aires'

--8 Create a report showing ProductName, UnitPrice, QuantityPerUnit of products that are out of stock.
SELECT ProductName, UnitPrice, QuantityPerUnit
FROM dbo.Products
WHERE Discontinued = 1

--9 Create a report showing all the ContactName, Address, City of all customers not from Germany, Mexico, Spain.
SELECT ContactName, Address, City
FROM dbo.Customers
WHERE Country NOT IN ('Germany', 'Mexico', 'Spain')

--10 Create a report showing OrderDate, ShippedDate, CustomerID, Freight of all orders placed on 21 May 1996.
SELECT OrderDate, ShippedDate, CustomerID, Freight
FROM dbo.orders
WHERE OrderDate = '1996-05-21 ';

--11  Create a report showing FirstName, LastName, Country from the employees not from United States.
SELECT FirstName, LastName, Country
FROM dbo.Employees
WHERE Country <> 'USA'

--12 Create a report that shows the EmployeeID, OrderID, CustomerID, RequiredDate, ShippedDate from all orders shipped later than the required date.
SELECT EmployeeID, OrderID, CustomerID, RequiredDate, ShippedDate
FROM dbo.Orders
WHERE ShippedDate > RequiredDate

--13 Create a report that shows the City, CompanyName, ContactName of customers from cities starting with A or B.
SELECT City, CompanyName, ContactName
FROM dbo.Customers
WHERE City LIKE 'A%' OR City LIKE 'B%'

--14 Create a report showing all the even numbers of OrderID from the orders table.
SELECT OrderID
FROM dbo.Orders
WHERE OrderID % 2 =0

--15 Create a report that shows all the orders where the freight cost more than $500.
SELECT *
FROM dbo.Orders
WHERE Freight > 500

--16 Create a report that shows the ProductName, UnitsInStock, UnitsOnOrder, ReorderLevel of all products that are up for reorder.
SELECT ProductName, UnitsInStock,UnitsOnOrder,ReorderLevel
FROM dbo.products
WHERE ReorderLevel = 0;

--17 Create a report that shows the CompanyName, ContactName number of all customer that have no fax number.
SELECT CompanyName,ContactName
FROM dbo.customers
WHERE Fax IS NULL;

--18 Create a report that shows the FirstName, LastName of all employees that do not report to anybody.
SELECT FirstName, LastName
FROM dbo.Employees
WHERE ReportsTo IS NULL

--19 Create a report showing all the odd numbers of OrderID from the orders table.
SELECT OrderID
FROM dbo.orders 
WHERE OrderID % 2 = 1;

--20 Create a report that shows the CompanyName, ContactName, Fax of all customers that do not have Fax number and sorted by ContactName.
SELECT CompanyName,ContactName,Fax
FROM dbo.customers
WHERE Fax IS NULL
ORDER BY ContactName;

--21  Create a report that shows the City, CompanyName, ContactName of customers from cities that has letter L in the name sorted by ContactName. 
SELECT City,CompanyName,ContactName,city
FROM dbo.customers 
WHERE City LIKE '%L%' 
ORDER BY ContactName;

--22  Create a report that shows the FirstName, LastName, BirthDate of employees born in the 1950s.
SELECT FirstName, LastName,BirthDate 
FROM dbo.employees 
where BirthDate Between '1950-01-01' AND '1959-12-31';

--23 Create a report that shows the FirstName, LastName, the year of Birthdate as birth year from the employees table.
SELECT LastName, FirstName, DATEPART(YEAR, Birthdate) AS BirthYear
FROM dbo.employees;

--24 Create a report showing OrderID, total number of Order ID as NumberofOrders from the orderdetails table grouped by OrderID and sorted by NumberofOrders in descending order. HINT: you will need to use a Groupby statement
SELECT OrderID, count(OrderID) as NumberofOrders 
FROM dbo.[order details] 
GROUP BY OrderID
ORDER BY NumberofOrders DESC ;

--25  Create a report that shows the SupplierID, ProductName, CompanyName from all product Supplied by Exotic Liquids, Specialty Biscuits, Ltd., Escargots Nouveaux sorted by the supplier ID
SELECT s.SupplierID, p.ProductName, s.CompanyName
FROM dbo.suppliers s 
JOIN dbo.products p 
ON s.SupplierID = p.SupplierID
WHERE s.CompanyName IN ('Exotic Liquids','Specialty Biscuits, Ltd.','Escargots Nouveaux')
ORDER BY s.SupplierID;

--26 Create a report that shows the ShipPostalCode, OrderID, OrderDate, RequiredDate, ShippedDate, ShipAddress of all orders with ShipPostalCode beginning with "98124".
SELECT ShipPostalCode, OrderID, OrderDate, RequiredDate, ShippedDate, ShipAddress
FROM dbo.Orders
WHERE ShipPostalCode like '98124%'

--27 Create a report that shows the ContactName, ContactTitle, CompanyName of customers that the has no "Sales" in their ContactTitle.
SELECT ContactName, ContactTitle, CompanyName
FROM dbo.Customers
WHERE ContactTitle NOT LIKE '%Sales%';

--28 Create a report that shows the LastName, FirstName, City of employees in cities other "Seattle";
SELECT LastName, FirstName, City
FROM dbo.employees 
WHERE City != 'Seattle';

--29 Create a report that shows the CompanyName, ContactTitle, City, Country of all customers in any city in Mexico or other cities in Spain other than Madrid.
SELECT CompanyName, ContactTitle, City, Country
FROM dbo.Customers
WHERE Country IN ('Mexico','Spain') AND City <> 'Madrid';

--30 Create a select statement that outputs the following
SELECT CONCAT( FirstName,' ', LastName ,' can be reached at ', 'x',Extension ) AS Contactinfo
FROM dbo.employees;

--31 Create a report that shows the ContactName of all customers that do not have letter A as the second alphabet in their Contactname.
SELECT ContactName
FROM dbo.Customers
WHERE ContactName not like '_A%'

--32 Create a report that shows the average UnitPrice rounded to the next whole number, total price of UnitsInStock and maximum number of orders from the products table. All saved as AveragePrice, TotalStock and MaxOrder respectively.
SELECT round (avg (UnitPrice),0) AS AveragePrice, 
SUM(UnitsInStock) AS TotalStock, 
MAX(UnitsOnOrder) AS MaxOrder
FROM dbo.products;

--33 Create a report that shows the SupplierID, CompanyName, CategoryName, ProductName and UnitPrice from the products, suppliers and categories table.
SELECT s.SupplierID, s.CompanyName, c.CategoryName, p.ProductName, p.UnitPrice
FROM dbo.products p 
JOIN dbo.suppliers s 
ON s.SupplierID = p.SupplierID 
JOIN dbo.categories c 
On c.CategoryID = p.CategoryID;

--34  Create a report that shows the CustomerID, sum of Freight, from the orders table with sum of freight greater $200, grouped by CustomerID. HINT: you will need to use a Groupby and a Having statement.

SELECT CustomerID, SUM(Freight) as sumofFreight
FROM dbo.Orders
GROUP BY CustomerID
HAVING SUM(Freight) > 200

--35 Create a report that shows the OrderID ContactName, UnitPrice, Quantity, Discount from the order details, orders and customers table with discount given on every purchase.
SELECT od.OrderID, c.ContactName, od.UnitPrice, od.Quantity, od.Discount 
FROM dbo.[order details] od 
JOIN dbo.orders o 
ON od.OrderID = o.OrderID 
JOIN dbo.customers c 
ON c.CustomerID = o.CustomerID 
WHERE od.Discount != 0;

--36 Create a report that shows the EmployeeID, the LastName and FirstName as employee, and the LastName and FirstName of who they report to as manager from the employees table sorted by Employee ID. HINT: This is a SelfJoin.
SELECT a.EmployeeID, 
CONCAT (a.LastName, ' ' ,a.FirstName ) as employee,
CONCAT (b.LastName, ' ' , b.FirstName ) as manager 
FROM dbo.employees a 
 JOIN dbo.employees b
ON b.EmployeeID = a.ReportsTo
ORDER BY a.EmployeeID;

--37 Create a report that shows the average, minimum and maximum UnitPrice of all products as AveragePrice, MinimumPrice and MaximumPrice respectivel
SELECT AVG(UnitPrice) AveragePrice, MIN(UnitPrice) MinimumPrice, MAX(UnitPrice) MaximumPrice
FROM Products

--38 Create a view named CustomerInfo that shows the CustomerID, CompanyName, ContactName, ContactTitle, Address, City, Country, Phone, OrderDate, RequiredDate, ShippedDate from the customers and orders table. HINT: Create a View.
CREATE VIEW CustomerInfo AS 
SELECT c.CustomerID, c.CompanyName, c.ContactName, c.ContactTitle, c.Address, c.City,c.Country,c.Phone,o.OrderDate, o.RequiredDate, o.ShippedDate
FROM dbo.customers c 
FULL JOIN 
dbo.orders o ON c.CustomerID = o.CustomerID;

--39 Change the name of the view you created from customerinfo to customer details.
EXEC sp_rename 'dbo.customerinfo', 'CustomerDetails';

--40 Create a view named ProductDetails that shows the ProductID, CompanyName, ProductName, CategoryName, Description, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued from the supplier, products and categories tables. HINT: Create a View
CREATE VIEW ProductDetails AS
 
SELECT p.ProductID,S.CompanyName,p.ProductName,c.CategoryName, c.Description,p.QuantityPerUnit, p.UnitPrice, p.UnitsInStock, p.UnitsOnOrder,	p.ReorderLevel, p.Discontinued
FROM dbo.suppliers s 
JOIN dbo.products p ON s.SupplierID = p.SupplierID 
JOIN dbo.categories c 
ON c.CategoryID = p.CategoryID;

--41 Drop the customer details view.
 
DROP VIEW IF EXISTS customerdetails;

--42 Create a report that fetch the first 5 character of categoryName from the category tables and renamed as ShortInfo:
SELECT substring(CategoryName,1,5) as Short_info
FROM dbo.Categories

--43  Create a copy of the shipper table as shippers_duplicate. Then insert a copy of shippers data into the new table HINT: Create a Table, use the SELECT * INTO statement.
IF OBJECT_ID('shippers_dup', 'U') IS NOT NULL 
DROP TABLE shippers_dup; 
SELECT *
INTO shippers_dup
FROM dbo.shippers;

--44 Create a select statement that outputs the following from the shippers_duplicate Table:
ALTER TABLE shippers_dup
ADD Email varchar(50); 
UPDATE dbo.shippers_dup 
SET Email ='speedyexpress@gmail.com' 
WHERE ShipperID = '1'; 
UPDATE dbo.shippers_dup 
SET Email ='unitedpackage@gmail.com' 
WHERE ShipperID = '2';
UPDATE dbo.shippers_dup 
SET Email ='federalshipping@gmail.com' 
WHERE ShipperID = '3';

--45 Create a report that shows the CompanyName and ProductName from all product in the Seafood category.
SELECT s.CompanyName, p.ProductName 
FROM dbo.categories c 
JOIN dbo.products p 
ON c.CategoryID = p.CategoryID 
JOIN dbo.suppliers s 
ON s.SupplierID = p.SupplierID 
WHERE CategoryName = 'Seafood';

--46 Create a report that shows the CategoryID, CompanyName and ProductName from all product in the categoryID 5.
SELECT c.CategoryID, CompanyName, ProductName
FROM dbo.categories c 
JOIN dbo.products p 
ON c.CategoryID = p.CategoryID 
JOIN dbo.suppliers s 
ON s.SupplierID = p.SupplierID 
WHERE c.CategoryID=5

--47. Delete the shippers_duplicate table.
 
DROP table IF exists shippers_dup;

--48  Create a select statement that ouputs the following from the employees table. NB: The age might differ depending on the year you are attempting this query.
SELECT LastName, FirstName, Title, 
CONVERT(VARCHAR(10), DATEDIFF(year, BirthDate, GETDATE())) + ' Years' AS Age
FROM dbo.employees;

--49 Create a report that the CompanyName and total number of orders by customer renamed as number of orders since Decemeber 31, 1994. Show number of Orders greater than 10.
SELECT c.CompanyName, COUNT(c.CustomerID) AS NumberofOrders 
FROM dbo.customers c 
JOIN dbo.orders o ON o.CustomerID = c.CustomerID 
WHERE o.OrderDate >= '1994-12-31' 
GROUP BY c.CompanyName 
HAVING COUNT(c.CustomerID) > 10;

--50 Create a select statement that ouputs the following from the product table NB: It should return 77 rows.

SELECT CONCAT(ProductName, ' ', 'weighs/is', ' ', QuantityPerUnit, ' ', 'and costs', ' $', ROUND(UnitPrice, 0)) AS ProductInfo
 
FROM dbo.products;
