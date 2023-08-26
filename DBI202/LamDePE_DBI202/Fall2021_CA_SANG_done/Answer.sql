--2
select * from ProductSubcategory
where Category = 'Accessories'

--3
select ProductID, LocationID, Quantity
from ProductInventory
where (LocationID = 7) and (Quantity > 250)
order by Quantity desc

--4
select p.ProductID, p.Name ProductName, p.Price,
		pm.Name ModelName, ps.Name SubCategoryName, ps.Category
from Product p
left join ProductModel pm on p.ModelID = pm.ModelID
left join ProductSubcategory ps on p.SubcategoryID = ps.SubcategoryID
where (p.Price < 100) and (p.Color = 'Black')

--5
select ps.SubcategoryID, ps.Name SubCategoryName, ps.Category,
		COUNT(distinct p.ProductID) NumberOfProducts 
from ProductSubcategory ps,	Product p
where (ps.SubcategoryID = p.SubcategoryID)
group by ps.SubcategoryID, ps.Name, ps.Category
order by ps.Category, NumberOfProducts desc, ps.Name 

--6
select distinct l.LocationID, l.Name LocationName, 
		COUNT(p.ProductID) NumberOfProducts
from Location l, ProductInventory prt, Product p
where (l.LocationID = prt.LocationID) and (p.ProductID = prt.ProductID)
group by l.LocationID, l.Name
having COUNT(p.ProductID) = 
(
	select MIN(min_product)
	from (select COUNT(p.ProductID) min_product
			from Location l, ProductInventory prt, Product p
			where (l.LocationID = prt.LocationID) and (p.ProductID = prt.ProductID)
			group by l.LocationID, l.Name) as subquery
)

--7
SELECT ps.Category, ps.Name AS SubcategoryName, COUNT(DISTINCT p.ProductID) AS NumberOfProducts
FROM ProductSubcategory ps
JOIN Product p ON ps.SubcategoryID = p.SubcategoryID
GROUP BY ps.Category, ps.Name
HAVING COUNT(DISTINCT p.ProductID) = (
    SELECT MAX(ProductCount)
    FROM (
        SELECT ps.Category, ps.Name, COUNT(DISTINCT p.ProductID) AS ProductCount
        FROM ProductSubcategory ps
        JOIN Product p ON ps.SubcategoryID = p.SubcategoryID
        GROUP BY ps.Category, ps.Name
    ) AS subquery
    WHERE subquery.Category = ps.Category
)
ORDER BY NumberOfProducts desc

--8
drop proc proc_product_model 
create proc proc_product_model 
@modelID int,
@numberOfProducts int output
as
begin 
	set @numberOfProducts = (select distinct COUNT(p.ProductID)
	from Product p, ProductModel pm
	where (p.ModelID = pm.ModelID) and (pm.ModelID = @modelID))
end

declare @x int
exec proc_product_model 9, @x output
select @x as NumberOfProducts

--9
drop trigger tr_insert_Product_Subcategory
create trigger tr_insert_Product_Subcategory
on Product for insert
as
begin
	select i.ProductID, i.Name ProductName, ps.SubcategoryID,
			ps.Name SubcategoryName, ps.Category
	from inserted i, ProductSubcategory ps
	where (i.SubcategoryID = ps.SubcategoryID)
end

insert into Product(ProductID, Name, Cost, Price, SubcategoryID, SellStartDate)
values(1005, 'Product Test', 12, 15, 1, '2021-10-25')

--10
delete from ProductInventory
where ProductID in 
(
	select ProductID from Product
	where ModelID = 33
)

	
