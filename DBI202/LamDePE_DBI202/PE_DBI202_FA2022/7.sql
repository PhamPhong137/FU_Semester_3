SELECT rs2.PackageTypeID, rs2.PackageTypeName, rs1.NumberOfStockItems_UnitPackage,
		rs2.NumberOfStockItems_OuterPackage
FROM (SELECT pt.PackageTypeID, COUNT(si.UnitPackageID) AS NumberOfStockItems_UnitPackage
FROM PackageTypes pt
LEFT JOIN StockItems si
ON pt.PackageTypeID = si.UnitPackageID
WHERE pt.PackageTypeName IN ('Each', 'Carton', 'Packet', 'Pair', 'Bag', 'Box')
GROUP BY pt.PackageTypeID) rs1
JOIN (SELECT pt.PackageTypeID, pt.PackageTypeName, 
			COUNT(si.QuantityPerOuter) AS NumberOfStockItems_OuterPackage
FROM PackageTypes pt
LEFT JOIN StockItems si
ON pt.PackageTypeID = si.OuterPackageID
WHERE pt.PackageTypeName IN ('Each', 'Carton', 'Packet', 'Pair', 'Bag', 'Box')
GROUP BY pt.PackageTypeID ,pt.PackageTypeName) rs2
ON rs1.PackageTypeID = rs2.PackageTypeID
ORDER BY rs2.NumberOfStockItems_OuterPackage DESC, rs2.PackageTypeName