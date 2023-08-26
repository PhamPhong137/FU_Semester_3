create trigger tr_delete_productInventory_location
on ProductInventory instead of delete
as
begin
	select d.ProductID, d.LocationID, l.Name LocationName,
			d.Shelf, d.Bin, d.Quantity
	from deleted d, Product p, Location l
	where d.ProductID = p.ProductID and d.LocationID = l.LocationID
end

