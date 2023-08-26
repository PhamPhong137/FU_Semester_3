--2
select Dname as department, AVG(e.Salary) [average salary]
from DEPARTMENT d, EMPLOYEE e
where (e.Dno = d.Dnumber)
group by Dname

--7
SELECT D.Dnumber, D.Dname
FROM DEPARTMENT D
WHERE NOT EXISTS (
    SELECT 1
    FROM EMPLOYEE E
    JOIN WORKS_ON W ON E.Ssn = W.Essn
    JOIN PROJECT P ON W.Pno = P.Pnumber
    WHERE P.Pname = 'ProductZ' AND E.Dno = D.Dnumber
);

--8
drop proc proc_SumSalary
create proc proc_SumSalary
@depNo int,
@sumOfSalarys int output
as
begin
	set @sumOfSalarys = (select SUM(e.Salary)
	from EMPLOYEE e, DEPARTMENT d
	where (e.Dno = d.Dnumber) and d.Dnumber = @depNo)
end

declare @x int
exec proc_SumSalary 1, @x output
select @x as sumOfSalarys
