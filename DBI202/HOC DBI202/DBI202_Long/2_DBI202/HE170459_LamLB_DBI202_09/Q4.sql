select od.OrderID, o.OrderDate, sum(od.Quantity * od.SalePrice * (1 - od.Discount)) as TotalAmount
from OrderDetails od 
join Orders o on od.OrderID = o.ID
group by od.OrderID, o.OrderDate
having sum(od.Quantity * od.SalePrice * (1 - od.Discount)) > 8000 
order by sum(od.Quantity * od.SalePrice * (1 - od.Discount)) desc