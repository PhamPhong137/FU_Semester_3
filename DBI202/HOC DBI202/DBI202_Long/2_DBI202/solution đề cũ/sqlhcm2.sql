--Q2
select d.Dname as department, avg(e.Salary) as 'average salaery'
from EMPLOYEE e join DEPARTMENT d on e.Dno = d.Dnumber
group by d.Dname 
--Q3
select e1.Fname, e1.Lname
from EMPLOYEE e1 join EMPLOYEE e2 on e1.Ssn = e2.Super_ssn
group by e1.Fname, e1.Lname
having count(e2.Super_ssn) > 6
--Q4
select (e.Fname + ' ' + e.Lname) as "Employee's Name" 
from EMPLOYEE e join DEPENDENT d on e.Ssn = d.Essn
where d.Relationship in ('Son', 'Daughter')
group by e.Fname, e.Lname
having  count(d.Relationship) > 

--Q5
select D.Dnumber,D.Dname,COUNT(E.Ssn)
from DEPARTMENT D
join EMPLOYEE E on E.Dno = D.Dnumber
where D.Dnumber in (select tb1.Dnumber
from
(select D.Dnumber, COUNT(E.Ssn) as count_
from DEPARTMENT D
join EMPLOYEE E on E.Dno = D.Dnumber
group by D.Dnumber) as tb1
where tb1.count_ > 5) and E.Salary > 40000
group by D.Dnumber,D.Dname