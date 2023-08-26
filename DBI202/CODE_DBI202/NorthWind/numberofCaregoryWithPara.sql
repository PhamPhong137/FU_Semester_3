create proc numberofCaregoryWithPara
@num int
as select  c.CategoryID, c.CategoryName,b.SupplierID, b.CompanyName, Count(a.UnitsInStock) as MaxNumberOfProductBySupplier
from Products as a join Suppliers as b on a.SupplierID = b.SupplierID
join Categories as c on a.CategoryID = c.CategoryID
group by c.CategoryID, c.CategoryName,b.SupplierID, b.CompanyName
having count(a.UnitsInStock) > @num
order by c.CategoryID

exec numberofCaregoryWithPara 2