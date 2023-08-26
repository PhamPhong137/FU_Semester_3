create trigger Tr4
on StockItems after of insert
as
begin
	select i.StockItemID, i.StockItemName, i.OuterPackageID,
			p.PackageTypeName as OuterPackageTypeName,
			i.UnitPrice, i.TaxRate
	from inserted i, PackageTypes p
	where (i.OuterPackageID = p.PackageTypeID)
	order by i.StockItemID desc
end

insert into StockItems(StockItemID, StockItemName, UnitPackageID, OuterPackageID,
QuantityPerOuter, IsChillerStock, TaxRate, UnitPrice, TypicalWeightPerUnit, SupplierID)
values(308, 'T-shirt Red bull', 7, 6, 1, 0, 0.15, 10.5, 0.4, 4), 
(309, 'T-shirt Mickey', 10, 9, 1, 0, 0.15, 12.0, 0.45, 1)

