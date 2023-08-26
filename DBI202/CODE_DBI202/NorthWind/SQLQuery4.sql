create proc sumUnitInstock
@num int, @sum int Output
as
select @sum=sum(UnitsInStock) from Products
where UnitsInStock > @sum

DECLARE @sumsales money
EXEC sumUnitInstock 10, @sum = @sumsales OUTPUT
PRINT 'sum of unitInstock is ' + convert(varchar(100), @sumsales);
GO