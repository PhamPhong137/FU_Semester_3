drop trigger Tr2
create trigger Tr2 
on stocks after delete
as
begin
	select d.product_id, p.product_name, d.store_id, s.store_name, d.quantity   
	from deleted d, products p, stores s 
	where p.product_id = d.product_id and s.store_id=d.store_id
end

delete from stocks
where store_id = 1 and product_id in (10, 11, 12)

