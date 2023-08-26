select c.ID,c.CustomerName,c.City,c.State from Customer c 
join  Orders o on  c.ID = o.CustomerID
where o.OrderDate between '2017-12-05' and '2017-12-10'
and (day(o.Shipdate) - day(o.OrderDate)) <3
order by c.State asc, c.City desc