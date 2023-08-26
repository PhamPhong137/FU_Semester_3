select c.ID,c.CustomerName,c.City,c.State from Customer c 
inner join  Orders o on  c.ID = o.CustomerID
where o.OrderDate between '2017-12-05' and '2017-12-10'
and DATEDIFF(day, o.ShipDate, o.OrderDate) < 3
order by c.State asc, c.City desc