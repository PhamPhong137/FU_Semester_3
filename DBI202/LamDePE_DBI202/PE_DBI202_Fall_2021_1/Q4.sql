select p.ProductID, p.Name ProductName, p.Color,
		ps.SubcategoryID, ps.Name SubcategoryName, ps.Category,
		pc.StartDate, pc.EndDate, pc.Cost HistoryCost
from Product p
left join ProductSubcategory ps on p.SubcategoryID = ps.SubcategoryID
left join ProductCostHistory pc on p.ProductID = pc.ProductID
where p.Color = 'Black' and p.Name like 'HL%'

