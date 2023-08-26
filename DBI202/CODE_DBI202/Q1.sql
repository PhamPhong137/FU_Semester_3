--1
SELECT c.CompanyID, c.Name AS CompanyName, AVG(s.Quantity) AS AverageQuantity
FROM Company c
JOIN Supply s ON c.CompanyID = s.CompanyID
GROUP BY c.CompanyID, c.Name
ORDER BY AverageQuantity desc

--2.
SELECT *
INTO NewProduct
FROM Product;

--3.
UPDATE Company
SET Address = 'Hola, Vietnam'
WHERE CompanyID = 1;

--4.
DELETE FROM Supply
WHERE CompanyID = 13;

DELETE FROM Company
WHERE CompanyID = 13;

--5.
BACKUP DATABASE PT2
TO DISK = 'P:\Backup\PT2.bak'

