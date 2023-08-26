create proc Proc4 
@stockItemID int,
@OrderYear int,
@numberOfPurchaseOrders int output
as
begin
	set @numberOfPurchaseOrders = (select COUNT(*)
	from PurchaseOrders p, PurchaseOrderLines po
	where p.PurchaseOrderID = po.PurchaseOrderID and po.StockItemID = @stockItemID
	and YEAR(p.OrderDate) = @OrderYear)
end

