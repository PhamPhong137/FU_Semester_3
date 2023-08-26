create proc proc_product_subcategory
@subcategoryID int,
@numberOfProduct int output
as
begin
	set @numberOfProduct = 
	(
		select COUNT(p.ProductID) from Product p, ProductSubcategory ps
		where (p.SubcategoryID = ps.SubcategoryID) and (ps.SubcategoryID = @subcategoryID)
	)
end



