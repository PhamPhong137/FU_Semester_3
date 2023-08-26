--2
select * from products where category_name = 'Cyclocross Bicycles'
--3
select product_name,model_year,list_price,brand_name 
from products where
brand_name = 'Trek' and model_year = 2018 and list_price > 3000
order by list_price
--4
select o.order_id, o.order_date, c.customer_id, c.first_name, c.last_name,s.store_id
from orders o join customers c on o.customer_id = c.customer_id
join stores s on o.store_id = s.store_id
where o.order_date BETWEEN '2016-01-01' AND '2016-01-31'
and s.store_name = 'Santa Cruz Bikes'
--5
select s.store_id, s.store_name, count(*) as NumberOfOrderIn2018
from stores s join orders o on s.store_id = o.store_id
where year(o.order_date) = 2018
group by s.store_id, s.store_name
order by NumberOfOrderIn2018 desc
--6
select p.product_id, p.product_name, p.model_year, sum(s.quantity) as TotalStockQuantity
from products p left join stocks s on p.product_id = s.product_id
group by p.product_id, p.product_name, p.model_year
having sum(s.quantity) = (select top 1 sum(s.quantity)
from products p left join stocks s on p.product_id = s.product_id
group by p.product_id, p.product_name, p.model_year
order by sum(s.quantity) desc)
--8 
create procedure pr1
@store_id int,
@numberOfStaffs int output
as 
begin
select count(sf.staff_id) as NumberOfStaffs
from staffs sf join stores sr on sf.store_id = sr.store_id
where sr.store_id = @store_id
end
declare @x int
exec pr1 3, @x output
select @x as NumberOfStaffs
--9
create trigger Tr2
on stocks
after delete
as
begin 
select d.product_id, p.product_name,d.store_id, s.store_name, d.quantity
from deleted d join stores s on d.store_id = s.store_id
join products p on d.product_id = p.product_id
end
delete from stocks
where store_id = 1 and product_id in (10,11,12)
