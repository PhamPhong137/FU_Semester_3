--use PE_Demo_S2019
SELECT c.ID, c.CustomerName, 
COUNT(*) AS NumberOfOrders 
FROM Customer c 
JOIN Orders o ON c.ID = o.CustomerID 
WHERE (SELECT COUNT(*) 
FROM Orders WHERE CustomerID = c.ID) = (
SELECT MAX(OrderCount) 
FROM ( SELECT COUNT(*) AS OrderCount FROM Orders GROUP BY CustomerID ) AS OrderCounts) 
GROUP BY 
c.ID, 
c.CustomerName;

