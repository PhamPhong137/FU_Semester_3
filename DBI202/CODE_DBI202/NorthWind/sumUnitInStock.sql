
create proc sumUnitInStock @num int, @sum int Output
as
select @sum=sum(UnitsInStock) from Products
where UnitsInStock >= @num

declare @sumsales money;
exec sumUnitInStock 10, @sum = @sumsales Output;
print 'sum of UnitInStock is ' + convert(varchar(100), @sumsales);