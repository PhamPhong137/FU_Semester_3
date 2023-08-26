SELECT TOP 1 si.UnitPackageID ,pt.PackageTypeName AS UnitPackageTypeName,
			COUNT(si.UnitPackageID) AS NumberOfStockItems
FROM PackageTypes pt
JOIN StockItems si
 ON pt.PackageTypeID = si.UnitPackageID
GROUP BY si.UnitPackageID,pt.PackageTypeName
HAVING COUNT(si.UnitPackageID) = (SELECT TOP 1 COUNT(si.UnitPackageID) AS NumberOfStockItems
FROM PackageTypes pt
JOIN StockItems si
ON pt.PackageTypeID = si.UnitPackageID
GROUP BY si.UnitPackageID, pt.PackageTypeName
ORDER BY NumberOfStockItems ASC)
ORDER BY NumberOfStockItems ASC