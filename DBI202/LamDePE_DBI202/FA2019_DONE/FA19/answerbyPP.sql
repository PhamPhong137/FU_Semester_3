--1
create table Departments(
DeptID varchar(15) primary key,
Name nvarchar(60),
)
create table Offices(
OfficeNumber int primary key,
Address nvarchar(30),
Phone varchar(15),
DeptID int,
foreign key(DeptID) references Departments(DeptID),
)
create table Employees(
EmployeeID int primary key,
Fullname nvarchar(50),
OfficeNumber int,
foreign key(OfficeNumber) references Offices(OfficeNumber)
)
create table WorkFor(
[From] Date ,
salary float,
[To] Date,
EmployeeID int,
DeptID varchar(15),
primary key([From],EmployeeID,DeptID),
foreign key(EmployeeID) references Employees(EmployeeID),
foreign key(DeptID) references Departments(DeptID)
)



--2
select *
from Locations
where CountryID='US' OR CountryID='CA'

--3(note SQL k phan biet chu hoa và thuong -> E or e just one)
select EmployeeID, FirstName, LastName, Salary, Commission_pct, HireDate 
from Employees 
where Salary between 4000 and 10000
and Commission_pct > 0 and FirstName like '%E%'
order by HireDate DESC

--4
select e.EmployeeID, e.FirstName, e.LastName, e.HireDate, 
j.JobID, j.JobTitle,e.DepartmentID
from Jobs j, Employees e
where j.JobID = e.JobID
and j.JobTitle = 'Stock Clerk'
and e.HireDate between '2005-01-01' and '2005-12-31'

--5
select e.JobID, j.JobTitle, count(e.EmployeeID) as NumberOfEmployess
from Employees e, Jobs j
where j.JobID = e.JobID
group by e.JobID, j.JobTitle
order by NumberOfEmployess DESC

--6
Select * 
from Countries
where CountryID not in 
(Select l.CountryID from Locations l, Departments d 
where l.LocationID = d.LocationID);

--7
SELECT a.EmployeeID ,a.FirstName ,a.LastName,a.DepartmentID,de.DepartmentName, COUNT(b.EmployeeID) AS NumberOfSubordinates
FROM  Employees a
left JOIN Employees b ON a.EmployeeID = b.ManagerID
INNER JOIN Departments de ON de.DepartmentID = a.DepartmentID
WHERE a.EmployeeID in (
	Select EmployeeID from (
	(Select e.EmployeeID from Employees e, Departments d where e.DepartmentID = d.DepartmentID and d.DepartmentName = 'IT') 
	Union
	(Select e.EmployeeID from Employees e , Employees e1, Departments d where (e.DepartmentID = d.DepartmentID and e.EmployeeID = e1.ManagerID))
	) t)
GROUP BY a.EmployeeID, a.FirstName,a.LastName,a.DepartmentID,de.DepartmentName
ORDER BY NumberOfSubordinates DESC

--8
create procedure proc2 @fromDate date, @toDate date, @count int output
as
begin
	set @count =(
		select count(e.EmployeeID) 
		from Employees e 
		where HireDate between @fromDate and @toDate
	)
end

--9
CREATE TRIGGER Tr2 ON Departments
AFTER UPDATE
AS
BEGIN  
IF UPDATE(ManagerID)
		BEGIN
        SELECT de.DepartmentID, de.DepartmentName, de.ManagerID AS OldManagerID, i.ManagerID AS NewManagerID
        FROM inserted i
        INNER JOIN deleted de ON i.DepartmentID = de.DepartmentID  
		END 
END;


--10
delete from Locations
where LocationID not in ( select LocationID from Departments
)






























