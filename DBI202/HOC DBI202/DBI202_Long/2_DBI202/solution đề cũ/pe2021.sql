--2
select * from ProductSubcategory where Category = 'Accessories'
--3
select pv.ProductID,pv.LocationID,pv.Quantity from ProductInventory pv
where pv.LocationID = 7 and pv.Quantity > 250
order by pv.Quantity desc
--4
select p.ProductID, p.Name as ProoductName, p.Price
, ps.Name as SubcategoryName, ps.Category, pm.Name as ModelName
from Product p 
left join ProductSubcategory ps on p.SubcategoryID = ps.SubcategoryID
left join ProductModel pm on p.ModelID = pm.ModelID
where p.Price < 100 and p.Color = 'Black'
--5 
select pm.ModelID, pm.Name as ModelName, count(p.ProductID) as NumberOfProduct
from Product p right join ProductModel pm
on p.ModelID = pm.ModelID
group by pm.ModelID, pm.Name
having pm.Name like 'Mountain%' or pm.Name like 'ML Mountain%'
order by NumberOfProduct desc, pm.Name asc
--6 
select l.LocationID, l.Name as LocationName, count(pv.ProductID) as NumberOfProducts 
from ProductInventory pv join Location l on pv.LocationID = L.LocationID
group by l.LocationID, l.Name
having 
count(pv.ProductID) = (select top 1 count(pv.ProductID) as NumberOfProducts 
from ProductInventory pv join Location l on pv.LocationID = L.LocationID
group by l.LocationID, l.Name
order by NumberOfProducts )
--8
create procedure proc_product_model 
@modelID int,
@numberOfProduct int output
as 
begin 
select count(p.ProductID) as NumberOfProducts
from Product p join ProductModel pm on p.ModelID = pm.ModelID
where pm.ModelID = @modelID
end
declare @x int
exec proc_product_model 9,@x output
select @x as NumberOfProducts
--9
create trigger tr_insert_Product
on Product
after insert
as
begin 
select i.ProductID,i.Name as ProductName,pm.ModelID,pm.Name as ModelName
from inserted i join ProductModel pm on i.ModelID = pm.ModelID
end
insert into Product(ProductID, Name, Cost,Price,ModelID,SellStartDate)
values (88888,'Product Test99', 12.5,15.5,1,'2021-10-15')