-- Các ràng buộc đảm bảo toàn vẹn dữ liệu:
ALTER TABLE Book ADD CONSTRAINT CHK_Price CHECK (Price > 0);

ALTER TABLE OrderItem ADD CONSTRAINT CHK_Quantity CHECK (Quantity >= 0);

ALTER TABLE Customer ADD CONSTRAINT CHK_Email CHECK (Email LIKE '%@%.%');

ALTER TABLE Book ADD CONSTRAINT CHK_Book_Price_NonNegative CHECK (Price >= 0);

ALTER TABLE Storage ADD CONSTRAINT CHK_Storage_Quantity_NonNegative CHECK (Quantity >= 0);

ALTER TABLE [Order] ADD CONSTRAINT CHK_Order_OrderDate_NotFuture CHECK (Order_Date <= '2123-01-01');