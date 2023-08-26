SELECT p.product_id, p.product_name, p.model_year, SUM(s.quantity) AS TotalStockQuantity
FROM products p
JOIN stocks s ON p.product_id = s.product_id
GROUP BY p.product_id, p.product_name, p.model_year
having sum(s.quantity) = (
	select MAX(TotalStockQuantity)
	from (select SUM(s.quantity) AS TotalStockQuantity
			FROM products p
			JOIN stocks s ON p.product_id = s.product_id
			GROUP BY p.product_id, p.product_name, p.model_year
	) as Subquery
) 
