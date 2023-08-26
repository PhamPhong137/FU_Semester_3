--Q2
select StockItemID, StockItemName, SupplierID, Color 
from StockItems where Color = 'Blue' 
--Q3
select st.SupplierTransactionID, st.SupplierID, s.SupplierName, st.TransactionDate, st.TransactionAmount
from SupplierTransactions st join Suppliers s on st.SupplierID = s.SupplierID
where st.TransactionDate between '2013-02-01' and '2013-02-15'
--Q4
select st.StockItemID, st.StockItemName, sp.SupplierID, sp.SupplierName
, st.OuterPackageID, pt.PackageTypeName as OuterPackageTypeName, st.UnitPrice
from StockItems st join
PackageTypes pt on st.OuterPackageID = pt.PackageTypeID
join Suppliers sp on st.SupplierID = sp.SupplierID
where st.StockItemID >= 135 
order by pt.PackageTypeName, st.StockItemName
--5
select s.SupplierID, s.SupplierName, count(po.PurchaseOrderID) as NumberOfPurchaseOrders
from Suppliers s left join PurchaseOrders po on s.SupplierID = po.SupplierID
group by s.SupplierID, s.SupplierName
order by NumberOfPurchaseOrders desc, s.SupplierName
--6
select st.UnitPackageID, pt.PackageTypeName as UnitPackageTypeName,
count(st.StockItemID) as NumberOfStockItems
from StockItems st join PackageTypes pt on st.UnitPackageID = pt.PackageTypeID
group by st.UnitPackageID, pt.PackageTypeName
having count(st.StockItemID) = (select top 1 count(*)
from StockItems st join PackageTypes pt on st.UnitPackageID = pt.PackageTypeID
group by st.UnitPackageID, pt.PackageTypeName
order by count(st.StockItemID))
--8
create procedure Proc4
@stockItemID int,
@OrderYear int,
@numberOfPurchaseOrders int output
as 
begin 
select count(*) as NumberOfPurchaseOrders 
from PurchaseOrderLines pl 
join StockItems st on pl.StockItemID = st.StockItemID
join PurchaseOrders po on pl.PurchaseOrderID = po.PurchaseOrderID
where st.StockItemID = @stockItemID and year(po.OrderDate) = @OrderYear
end
declare @x int
exec Proc4 95, 2013, @x output
select @x as NumberOfPurchaseOrders
--9
create trigger Tr4
on StockItems
after insert
as
begin
select i.StockItemID, i.StockItemName, i.OuterPackageID,
pt.PackageTypeName as OuterPackageTypeName, i.UnitPrice, i.TaxRate 
from inserted i join PackageTypes pt on i.OuterPackageID = pt.PackageTypeID
end 
insert into 
StockItems(StockItemID, StockItemName, UnitPackageID, OuterPackageID, QuantityPerOuter, IsChillerStock, TaxRate, UnitPrice, TypicalWeightPerUnit, SupplierID) 
values 
(308, 'T-shirt Red bull', 7, 6, 1, 0, 0.15, 10.5, 0.4, 4)
--10
delete from PackageTypes where PackageTypeID not in (select distinct UnitPackageID as Number 
from StockItems
UNION 
select distinct OuterPackageID 
from StockItems)

select distinct UnitPackageID as Number 
from StockItems
UNION 
select distinct OuterPackageID 
from StockItems 