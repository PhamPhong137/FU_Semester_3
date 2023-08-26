--1
create table Employee(
	empID int primary key,
	ename varchar(20),
	phone varchar(20),
	manageID int,	
	foreign key(manageID) references Employee(empID) 
)
create table Branch(
	brID int primary key,
	bname varchar(20),
	bcity varchar(20)
)
create table children(
children varchar(20),
empID int,
primary key(children,empID),
foreign key(empID) references Employee(empID)
)

create table workat(
	seniority int,
	since date,
	empID int foreign key(empID) references Employee(empID),
	brID int foreign key(brID) references Branch(brID),
	primary key(empID, brID)
)

--2
select e.Bdate, e.Address
from EMPLOYEE e
where e.Fname='John' and e.Minit = 'B' and e.Lname='Smith'

--3
select e.Fname, e.Lname
from EMPLOYEE e
join EMPLOYEE e1 on e.Ssn=e1.Super_ssn
group by e.Fname, e.Lname
having count(e.Ssn) > 6

--4
select e.Lname, e.Fname
from EMPLOYEE e join DEPARTMENT d on e.Dno = d.Dnumber
where e.Salary > (
	select max(Salary)
	from EMPLOYEE e
	where e.Dno = 5
)
--5
select d.Dnumber, d.Dname, count( e.Ssn) as NumOfEmployee
from EMPLOYEE e join DEPARTMENT d on e.Dno = d.Dnumber
where e.Salary > 40000 
group by d.Dnumber, d.Dname
having d.Dnumber in (select Dno 
					from EMPLOYEE e
					group by Dno
					having COUNT(e.Ssn) > 5
)

--6 
SELECT * 
FROM EMPLOYEE e
WHERE e.Ssn NOT IN (
    SELECT e.Ssn 
    FROM DEPENDENT d 
	join EMPLOYEE on d.Essn = e.Ssn
    WHERE DATEDIFF(YEAR, d.Bdate, GETDATE()) >= 18
)
order by e.Fname

--7
with temp as(
select count(p.Pnumber) as totalproject
from PROJECT p
where p.Plocation = 'Stafford'
group by p.Plocation
)
select w.Essn
from EMPLOYEE e, WORKS_ON w, PROJECT p
where (e.Ssn = w.Essn) and (w.Pno = p.Pnumber) 
and p.Plocation = 'Stafford' 
group by w.Essn
having count(p.Pnumber) = (select totalproject from temp )

--8 output not same 
create proc updateSalary @location varchar(15)
as
begin 
	update EMPLOYEE 
	set Salary=1.1*Salary
	where ssn in (
		select ssn
		from EMPLOYEE e
		join WORKS_ON w on e.Ssn = w.Essn
		join PROJECT p on w.Pno = p.Pnumber
		where p.Plocation='Stafford' and e.Salary < 30000
	)
end

-- Cach test ko update
/*begin transaction exec updateSalary 'Stafford'
select * from EMPLOYEE
rollback*/
--9 not understand 
create trigger tr_no_insert on EMPLOYEE
instead of insert
as
begin
	if Exists (
		select * 
		from inserted 
		where Dno in (
			select d.Dnumber from employee e, department d where e.Dno = d.Dnumber
			group by d.Dnumber
			having Count(e.Dno) <= 5
		)
	)
	select 'inserted' as [the result]
	else
	select 'no insert' as [the result]
end

--insert dbo.EMPLOYEE values('Tester','T','Tester',000111000, '2023/03/07', 'testing', 'F', 40000,987654321,5)

--10
update EMPLOYEE
set Salary = Salary * 1.1
where Ssn in (
    select distinct Essn
    from DEPENDENT de
    where DATEDIFF(year, de.Bdate, GETDATE()) < 18
);








































