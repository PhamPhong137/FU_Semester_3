select p.product_name, p.model_year, p.list_price, p.brand_name
from products p 
where  p.brand_name = 'Trek' and p.model_year = 2018 
and p.list_price > 3000
order by p.list_price