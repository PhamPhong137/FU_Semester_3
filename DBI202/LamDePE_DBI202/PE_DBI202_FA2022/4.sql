select si.StockItemID, si.StockItemName, s.SupplierID,
		s.SupplierName, si.OuterPackageID, p.PackageTypeName OuterPackageTypeName,
		si.UnitPrice
from StockItems si
join PackageTypes p on si.OuterPackageID = p.PackageTypeID
join Suppliers s on si.SupplierID = s.SupplierID
WHERE si.StockItemID >= 135
ORDER BY OuterPackageTypeName ASC, si.StockItemName ASC

