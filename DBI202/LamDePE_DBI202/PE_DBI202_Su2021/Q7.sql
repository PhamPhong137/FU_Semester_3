select * from (select s.store_name, o.staff_id, st.first_name, st.last_name,
		count(s.store_name) as NumberOfOrders  from orders o, stores s, staffs st
	where st.staff_id = o.staff_id and o.store_id = s.store_id
	group by s.store_name, o.staff_id, st.first_name, st.last_name
	having count(s.store_name) in
		(select max(a.NumberOfOrders) 
		from (	
				select s.store_name, 
				count(*) as NumberOfOrders  from orders o, stores s
				where o.store_id = s.store_id
				group by s.store_name, o.staff_id) as a
				group by a.store_name)
			) as c
order by c.store_name ASC