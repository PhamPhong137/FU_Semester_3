--1
Create Table Items(
	ItemID int Primary Key,
	Name nvarchar(255),
	Price float
);
Create Table ItemVariants(
	variantID int Primary Key,
	Details nvarchar(200),
	Color nvarchar(50),
	Size nvarchar(30),
	ItemID int,
	Constraint FK_ItemVariants_Items Foreign Key(ItemID) References Items(ItemID)
);
Create Table Categories(
	CatID int Primary Key,
	Name nvarchar(255)
);
Create Table belongTo(
	ItemID int,
	CatID int,
	Constraint PK_belongTo Primary Key(CatID, ItemID),
	Constraint FK_belongTo_Categories Foreign Key(CatID) References Categories(CatID),
	Constraint FK_belongTo_Items Foreign Key(ItemID) References Items(ItemID)
)
--2
select *
from Employees
where Salary > 9000

--3
select JobID, JobTitle, min_salary
from Jobs
where min_salary >5000 AND JobTitle like '%Manager%'
order by min_salary desc, JobTitle 

--4
select e.EmployeeID, e.FirstName, e.LastName, e.Salary, d.DepartmentName, l.StateProvince, l.CountryID
from Employees e 
join Departments d on e.DepartmentID = d.DepartmentID
join Locations l on d.LocationID = l.LocationID
WHERE Salary >3000 AND StateProvince='Washington' AND CountryID='US'

--5
SELECT L.LocationID,StreetAddress,City,StateProvince,CountryID, Count(D.DepartmentID) as NumberOfDepartments
  FROM Locations L
  LEFT JOIN Departments D 
  ON L.LocationID=D.LocationID 
  Group by L.LocationID,StreetAddress,City,StateProvince,CountryID
  Order by NumberOfDepartments desc, L.LocationID asc 

--6
-- Method 1
SELECT TOP 1 E.JobID, JobTitle, Count(E.JobID) as NumberOfEmployees
  FROM Jobs J, Employees E
  WHERE J.JobID = E.JobID 
  GROUP BY E.JobID, JobTitle 
  ORDER BY NumberOfEmployees Desc

--Method 2
with temp as(
	SELECT Count(E.JobID) as NumberOfEmployees
	FROM Employees E
	GROUP BY E.JobID
)
SELECT E.JobID, J.JobTitle, Count(E.JobID) as NumberOfEmployees
  From Jobs J, Employees E
  WHERE J.JobID = E.JobID 
  GROUP BY E.JobID, JobTitle 
  Having Count(E.JobID)=(Select MAX(NumberOfEmployees) From temp)
  ORDER BY NumberOfEmployees Desc

--7
with temp1 as (
    select e1.EmployeeID, count(e2.EmployeeID) as NumberOfSubordinates
    from Employees e1 join Employees e2 on e1.EmployeeID=e2.ManagerID
    group by e1.EmployeeID
), temp2 as (
    select EmployeeID, 0 as NumberOfSubordinates
    from Employees e
    where e.EmployeeID<>ALL(select EmployeeID from temp1) and e.Salary > 10000
    union
    select EmployeeID, NumberOfSubordinates from temp1
)
select temp2.EmployeeID, e1.FirstName, e1.LastName, e1.Salary, e1.DepartmentID, d.DepartmentName, temp2.NumberOfSubordinates
from temp2
join Employees e1 on temp2.EmployeeID=e1.EmployeeID
join Departments d on e1.DepartmentID = d.DepartmentID
group by temp2.EmployeeID, e1.FirstName, e1.LastName, e1.Salary, e1.DepartmentID, d.DepartmentName, temp2.NumberOfSubordinates
order by temp2.NumberOfSubordinates desc, e1.LastName;


--8
Create Proc PR1 @countryID varchar(10), @numberOfDepartments int output
as
Begin
	Set @numberOfDepartments=
		(	
		Select Count(*) From dbo.Departments D, dbo.Locations L
		Where D.LocationID = L.LocationID AND L.CountryID = @countryID
		)
End
--Declare @x int
--exec PR1 'US', @x output
--Select @x as NumberOfDepartments

--9
CREATE TRIGGER Tr1 ON Employees
AFTER INSERT
AS
BEGIN
    SELECT i.EmployeeID, i.FirstName, i.LastName, i.DepartmentID, D.DepartmentName
    FROM inserted i
    LEFT JOIN Departments D ON i.DepartmentID = D.DepartmentID
END
Insert Into Employees(EmployeeID, FirstName, LastName, Email, JobID, DepartmentID) Values
(1003,'Alain','Boucher','alain.boucher@gmail.com','SH_CLERK',50),
(1004,'Muriel','Visani','muriel.visani@gmail.com','SA_REP', null)


delete from Employees
Where EmployeeID in (1003,1004)
--10
Delete FROM Departments 
Where ManagerID is null
Select * FROM Departments;











