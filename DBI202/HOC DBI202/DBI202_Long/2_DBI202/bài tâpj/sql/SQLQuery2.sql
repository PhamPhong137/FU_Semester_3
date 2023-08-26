select * from ACCOUNT
select * from BRANCH
select * from BUSINESS
select * from CUSTOMER
select * from EMPLOYEE
select * from INDIVIDUAL
select * from PRODUCT
--
--4
select p.product_cd, p.name, count(a.product_cd) as 'So luong'
from PRODUCT p left join ACCOUNT a on p.PRODUCT_CD = a.PRODUCT_CD
group by p.PRODUCT_CD, p.NAME