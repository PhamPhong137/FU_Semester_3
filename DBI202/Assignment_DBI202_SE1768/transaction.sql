-- Transaction tạo một đơn hàng
BEGIN TRANSACTION;

BEGIN TRY
    -- Tạo đơn hàng mới
    DECLARE @NewOrderID INT;
    INSERT INTO [Order] (Store_ID, Order_Date) 
    VALUES (1, GETDATE());
    SELECT @NewOrderID = SCOPE_IDENTITY(); -- Lấy ID của đơn hàng mới

    -- Thêm các mục vào đơn hàng
    INSERT INTO OrderItem (Order_ID, ISBN, Quantity) 
    VALUES (@NewOrderID, '978-3-16-148410-0', 5);
    
    INSERT INTO OrderItem (Order_ID, ISBN, Quantity)
    VALUES (@NewOrderID, '978-1-861003-45-3', 3);

    -- Cập nhật số lượng sách trong kho
    UPDATE Storage 
    SET Quantity = Quantity - 5 
    WHERE Store_ID = 1 AND ISBN = '978-3-16-148410-0';
    
    UPDATE Storage 
    SET Quantity = Quantity - 3 
    WHERE Store_ID = 1 AND ISBN = '978-1-861003-45-3';
    
    -- Kiểm tra để đảm bảo rằng không có sách nào được bán khi hết hàng
    IF EXISTS (SELECT * FROM Storage WHERE Quantity < 0)
    BEGIN
        THROW 51000, 'Insufficient quantity in storage.', 1;
        ROLLBACK TRANSACTION;
    END

    COMMIT TRANSACTION;
END TRY

BEGIN CATCH
    -- Nếu có lỗi xảy ra, hoàn tác giao dịch
    ROLLBACK TRANSACTION;
END CATCH;