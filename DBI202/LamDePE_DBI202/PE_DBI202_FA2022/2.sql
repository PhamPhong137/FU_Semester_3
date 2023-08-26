select s.StockItemID, s.StockItemName, s.SupplierID, s.Color
from StockItems s
where s.Color = 'Blue'