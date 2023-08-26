delete from PackageTypes where PackageTypeID not in 
(select si.OuterPackageID from StockItems si
join PackageTypes pt on si.OuterPackageID = pt.PackageTypeID
group by si.OuterPackageID
UNION
select si.UnitPackageID from StockItems si
join PackageTypes pt on si.UnitPackageID = pt.PackageTypeID
group by si.UnitPackageID)