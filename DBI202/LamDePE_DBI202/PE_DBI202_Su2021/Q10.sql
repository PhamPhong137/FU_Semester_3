update stocks set quantity = 30
where store_id = 1 and product_id in 
(select p.product_id from stocks s, products p
where (p.product_id = s.product_id) and 
p.category_name = 'Cruisers Bicycles' and s.store_id = 1)

