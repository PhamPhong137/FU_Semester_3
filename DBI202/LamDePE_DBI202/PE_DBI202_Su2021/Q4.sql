select o.order_id, o.order_date, c.customer_id,
		c.first_name, c.last_name, s.store_name
from orders o
join customers c on c.customer_id = o.customer_id
join stores s on s.store_id = o.store_id
where s.store_name = 'Santa Cruz Bikes' 
and o.order_date between '2016-01-01' and '2016-01-31' 