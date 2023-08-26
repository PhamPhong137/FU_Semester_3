update ProductInventory set Quantity = 2000
where ProductID in (select ProductID from Product where ModelID = 33)



