use BookRetail
-- Danh sách thông tin đơn hàng của khách hàng có ID 1 dùng inner join
SELECT * FROM [Order] o 
INNER JOIN OrderItem oi ON o.Order_ID = oi.Order_ID 
WHERE o.Customer_ID = 1;

-- Danh sách thông tin sách trong kho của các cửa hàng dùng outer join
SELECT * FROM Book b 
LEFT OUTER JOIN Storage s ON b.ISBN = s.ISBN;

-- Danh sách customer có đơn hàng sau 1/1/2023 dùng where
SELECT * FROM Customer c 
WHERE c.Customer_ID IN (SELECT o.Customer_ID FROM [Order] o WHERE o.Order_Date > '2023-01-01');

-- Danh sách các ID sách có số lượng hiện tại >10 dùng from
SELECT a.ISBN, a.totalQuantity 
FROM (SELECT ISBN, SUM(Quantity) AS totalQuantity FROM Storage GROUP BY ISBN) a 
WHERE a.totalQuantity > 20;

-- Đếm số đầu sách của từng store dùng group by
SELECT Store_ID, COUNT(ISBN) AS NumberOfBooks 
FROM Storage 
GROUP BY Store_ID;