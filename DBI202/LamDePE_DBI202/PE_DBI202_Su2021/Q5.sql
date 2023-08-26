select s.store_id, s.store_name, COUNT(*) NumberOfOrdersIn2018
from stores s, orders o
where (s.store_id = o.store_id) and YEAR(o.order_date) = 2018
group by s.store_id, s.store_name
order by NumberOfOrdersIn2018 desc