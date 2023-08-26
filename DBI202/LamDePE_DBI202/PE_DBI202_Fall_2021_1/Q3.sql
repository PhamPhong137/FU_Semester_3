select pr.ProductID, pr.Price, pr.StartDate, pr.EndDate
from ProductPriceHistory pr
where pr.Price < 100 and YEAR(pr.EndDate) = 2003
group by pr.ProductID, pr.Price, pr.StartDate, pr.EndDate
order by pr.Price desc