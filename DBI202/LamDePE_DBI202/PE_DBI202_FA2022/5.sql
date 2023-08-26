select s.SupplierID, s.SupplierName,
		COUNT(p.SupplierID) as NumberOfPurchaseOrders
from Suppliers s
left join PurchaseOrders p on s.SupplierID = p.SupplierID
group by s.SupplierID, s.SupplierName
order by NumberOfPurchaseOrders desc
