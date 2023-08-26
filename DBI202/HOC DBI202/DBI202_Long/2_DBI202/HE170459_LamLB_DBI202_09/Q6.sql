select c.id as 'CustomerID', c.CustomerName, COUNT(o.ID) from Customer c
join Orders o on c.ID = o.CustomerID
group by c.ID, c.CustomerName
having count(o.ID) = (select top 1 count(ID) from Orders group by CustomerID order by COUNT(ID) Desc)