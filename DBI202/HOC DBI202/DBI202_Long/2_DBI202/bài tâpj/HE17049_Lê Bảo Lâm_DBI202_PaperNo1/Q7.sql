select * from 
(select top(5) * from Product p
order by p.UnitPrice desc) as s
union 
select * from (
select top(5) * from Product p
order by p.UnitPrice) as s1
order by s.UnitPrice DESC