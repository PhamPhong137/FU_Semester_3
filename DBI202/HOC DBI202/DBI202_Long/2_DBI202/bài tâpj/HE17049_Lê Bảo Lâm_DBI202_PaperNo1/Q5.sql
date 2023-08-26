--use PE_Demo_S2019

SELECT od.ProductID, p.ProductName, 
MAX(od.Quantity) AS Quantity 
FROM OrderDetails od 
Join Product p ON od.ProductID = p.ID 
WHERE od.Quantity = (SELECT MAX(Quantity) FROM OrderDetails) 
GROUP BY 
od.ProductID, 
p.ProductName;