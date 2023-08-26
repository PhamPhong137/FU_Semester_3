use Northwind

/* 
select ...
from a join b
where ...
group by
having
order by

select -- where -- group by -- having
*/

select * from Products
order by UnitsInStock desc, ProductName -- first sort by UnitsInStock, if UnitInStock equals -> sort by productName
-- sort by ProductName
-- function
select Count(*) from Products
--
select Count(*) from Products where UnitsInStock = 0
--
select Count(ProductName) from Products where UnitsInStock = 0
--
select sum(UnitsInStock) from Products
where UnitsInStock > 10
--
select avg(UnitPrice) from Products
--
select max(UnitPrice) from Products
--
select a.ProductID, a.ProductName, a.UnitPrice, a.UnitsInStock, a.UnitsOnOrder
, b.SupplierID, b.CompanyName, c.CategoryID, c.CategoryName 
from Products as a join Suppliers as b on a.SupplierID = b.SupplierID
join Categories as c on a.CategoryID = c.CategoryID
-- số lượng sản phẩm của mỗi supplier là bao nhiêu
-- các hàm sum, avg, count, max, min sẽ tính toán theo nhóm group by
select b.SupplierID, COUNT(a.UnitsInStock) as numberOfProductBySupplier
from Products as a join Suppliers as b on a.SupplierID = b.SupplierID
join Categories as c on a.CategoryID = c.CategoryID
group by b.SupplierID
--
select b.SupplierID, Max(a.UnitsInStock) as MaxNumberOfProductBySupplier
from Products as a join Suppliers as b on a.SupplierID = b.SupplierID
join Categories as c on a.CategoryID = c.CategoryID
group by b.SupplierID
-- name
select b.SupplierID, b.CompanyName, Max(a.UnitsInStock) as MaxNumberOfProductBySupplier
from Products as a join Suppliers as b on a.SupplierID = b.SupplierID
join Categories as c on a.CategoryID = c.CategoryID
group by b.SupplierID
-- những cái trương xuất hiện ở group by, các trường có ở group by mới được xuất hiện ở select
select b.SupplierID, b.CompanyName, Max(a.UnitsInStock) as MaxNumberOfProductBySupplier
from Products as a join Suppliers as b on a.SupplierID = b.SupplierID
join Categories as c on a.CategoryID = c.CategoryID
group by b.SupplierID, b.CompanyName
-- group by cũng thoe thứ tự ưu tiên từ trái sang phải
select  c.CategoryID, c.CategoryName,b.SupplierID, b.CompanyName, Max(a.UnitsInStock) as MaxNumberOfProductBySupplier
from Products as a join Suppliers as b on a.SupplierID = b.SupplierID
join Categories as c on a.CategoryID = c.CategoryID
group by c.CategoryID, c.CategoryName,b.SupplierID, b.CompanyName
order by c.CategoryID
-- 
select TitleOfCourtesy,count(*) from Employees
group by TitleOfCourtesy
--
select  c.CategoryID, c.CategoryName,b.SupplierID, b.CompanyName, Count(a.UnitsInStock) as MaxNumberOfProductBySupplier
from Products as a join Suppliers as b on a.SupplierID = b.SupplierID
join Categories as c on a.CategoryID = c.CategoryID
where a.UnitsInStock >= 20
group by c.CategoryID, c.CategoryName,b.SupplierID, b.CompanyName
having count(a.UnitsInStock) > 1
order by c.CategoryID








