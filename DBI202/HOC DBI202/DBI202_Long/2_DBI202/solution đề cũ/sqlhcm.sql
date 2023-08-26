--Q2
select Bdate, Address from EMPLOYEE
where (Fname + ' ' + Minit + '. ' + Lname) = 'John B. Smith'
--Q3
SELECT E1.Fname, E1.Lname AS SupervisesCount 
FROM EMPLOYEE E1 
JOIN EMPLOYEE E2 ON E1.Ssn = E2.Super_ssn 
GROUP BY E1.Fname, E1.Lname 
HAVING COUNT(*) > 6
--Q4
Select Lname, Fname from EMPLOYEE
where Salary > (select top 1 Salary from EMPLOYEE 
where Dno = 5
order by salary desc)
--Q5

