select l.LocationID, l.Name LocationName, COUNT(*) NumberOfProducts 
from Location l, ProductInventory pdi
where (l.LocationID = pdi.LocationID)
group by l.LocationID, l.Name
order by NumberOfProducts desc, LocationName asc
