USE FUH_COMPANY
GO

--1
SELECT e.depNum, e.empSSN, e.empName, d.depName
FROM tblEmployee as e JOIN tblDepartment as d on e.depNum=d.depNum
WHERE d.depName = N'Phòng Nghiên cứu và phát triển'

--2
SELECT p.proNum, p.proName, d.depName
FROM dbo.tblProject p
JOIN dbo.tblDepartment d on p.depNum=d.depNum
WHERE d.depName = N'Phòng Nghiên cứu và phát triển'

--3
SELECT p.proNum, p.proName, d.depName
FROM dbo.tblProject p
 JOIN dbo.tblDepartment d on p.depNum=d.depNum
WHERE p.proName='ProjectB'

--4
--Cach 1
SELECT empSSN ,empName
FROM dbo.tblEmployee
WHERE supervisorSSN = ( 
	SELECT empSSN 
	FROM dbo.tblEmployee
	WHERE empName = N'Mai Duy An')

--Cach 2
SELECT a.empSSN, a.empName
FROM tblEmployee a
left join tblEmployee b on a.supervisorSSN = b.empSSN
WHERE b.empName = 'Mai Duy An'

--5
--Cach 1
SELECT empSSN ,empName
FROM dbo.tblEmployee e
WHERE  e.empSSN = ( 
	SELECT supervisorSSN 
	FROM dbo.tblEmployee 
	WHERE empName = N'Mai Duy An')

--Cach 2
SELECT b.empSSN, b.empName
FROM tblEmployee a
left join tblEmployee b on a.supervisorSSN = b.empSSN
WHERE a.empName = 'Mai Duy An'

--6
SELECT p.proNum, l.locName
FROM tblProject p JOIN tblLocation l on p.locNum=l.locNum 
WHERE p.proName='ProjectA'

--7
SELECT p.proNum ,p.proName 
FROM tblProject p JOIN tblLocation l on p.locNum=l.locNum 
WHERE l.locName=N'TP Hồ Chí Minh'

--8
SELECT d.depName,d.depBirthdate, e.empName
FROM tblEmployee e JOIN tblDependent d on d.empSSN=e.empSSN
WHERE DATEDIFF(year, d.depBirthdate, GETDATE()) > 18;

--9
SELECT d.depName,d.depBirthdate, e.empName
FROM tblEmployee e JOIN tblDependent d on d.empSSN=e.empSSN
WHERE d.depSex='M'

--10
SELECT d.depNum, d.depName,l.locName
FROM tblDepartment d JOIN tblDepLocation dl on d.depNum=dl.depNum JOIN tblLocation l on dl.locNum=l.locNum
WHERE d.depName = N'Phòng Nghiên cứu và phát triển' 

--11
SELECT DISTINCT p.proNum ,p.proName,d.depName
FROM tblProject p 
JOIN tblLocation l on p.locNum=l.locNum 
JOIN tblDepLocation dl on p.depNum=dl.depNum 
JOIN tblDepartment d on d.depNum=dl.depNum
WHERE l.locName=N'TP Hồ Chí Minh' 

--12 
SELECT e.empName,d.depName, d.depRelationship
FROM tblEmployee e 
JOIN tblDependent d on d.empSSN = e.empSSN 
JOIN tblDepartment on tblDepartment.depNum = e.depNum 
WHERE d.depSex='F' AND tblDepartment.depName = N'Phòng Nghiên cứu và phát triển' 

--13 
SELECT e.empName,d.depName, d.depRelationship
FROM tblEmployee e 
JOIN tblDependent d on d.empSSN = e.empSSN 
JOIN tblDepartment on tblDepartment.depNum = e.depNum 
WHERE DATEDIFF(year, d.depBirthdate, GETDATE()) > 18;

--14
SELECT d.depSex, COUNT(d.depSex) AS Number        
FROM tblDependent d
GROUP BY d.depSex;

--15
SELECT d.depRelationship ,COUNT(d.depRelationship) AS Number        
FROM tblDependent d
GROUP BY d.depRelationship;

--16
SELECT d.depNum, d.depName, COUNT(dep.depName) AS dependentCount
FROM tblDepartment d
 JOIN tblEmployee e ON d.depNum = e.depNum
 JOIN tblDependent dep ON e.empSSN = dep.empSSN
GROUP BY d.depNum, d.depName;

--17
SELECT d.depNum, d.depName, COUNT(dep.empSSN) as numberOfDependent
FROM tblDepartment d
JOIN tblEmployee e on d.depNum = e.depNum
JOIN tblDependent dep on e.empSSN = dep.empSSN
GROUP BY d.depNum, d.depName
HAVING COUNT(dep.empSSN) = (
    SELECT MIN(dependents)
    FROM (
        SELECT COUNT(dep.empSSN) as dependents
        FROM tblDepartment d
        JOIN tblEmployee e on d.depNum = e.depNum
        JOIN tblDependent dep on e.empSSN = dep.empSSN
        GROUP BY d.depNum, d.depName
    ) t
)

--18
SELECT d.depNum, d.depName, COUNT(dep.empSSN) as numberOfDependent
FROM tblDepartment d
JOIN tblEmployee e on d.depNum = e.depNum
JOIN tblDependent dep on e.empSSN = dep.empSSN
GROUP BY d.depNum, d.depName
HAVING COUNT(dep.empSSN) = (
    SELECT MAX(dependents)
    FROM (
        SELECT COUNT(dep.empSSN) as dependents
        FROM tblDepartment d
        JOIN tblEmployee e on d.depNum = e.depNum
        JOIN tblDependent dep on e.empSSN = dep.empSSN
        GROUP BY d.depNum, d.depName
    ) t
)

--19
SELECT e.empSSN,e.empName, d.depName, SUM(workHours) as totalhours
FROM tblWorksOn w
JOIN tblEmployee e on w.empSSN = e.empSSN 	
JOIN tblDepartment d on d.depNum=e.depNum
GROUP BY e.empSSN,e.empName, d.depName

--20
SELECT d.depNum ,d.depName,SUM(workHours) as totalhours
FROM tblWorksOn w
JOIN tblEmployee e on w.empSSN = e.empSSN 	
JOIN tblDepartment d on d.depNum = e.depNum
GROUP BY d.depName,d.depNum

--21
SELECT e.empSSN,e.empName, d.depName, SUM(workHours) as minhours
FROM tblWorksOn w
JOIN tblEmployee e on w.empSSN = e.empSSN 	
JOIN tblDepartment d on d.depNum=e.depNum
GROUP BY e.empSSN,e.empName, d.depName
HAVING SUM(workHours)=(
	SELECT MIN(minhours)
	FROM(
		SELECT e.empSSN,e.empName, d.depName, SUM(workHours) as minhours
		FROM tblWorksOn w
		JOIN tblEmployee e on w.empSSN = e.empSSN 	
		JOIN tblDepartment d on d.depNum=e.depNum
		GROUP BY e.empSSN,e.empName, d.depName
		)t
	)

--22
SELECT e.empSSN,e.empName, d.depName, SUM(workHours) as maxhours
FROM tblWorksOn w
JOIN tblEmployee e on w.empSSN = e.empSSN 	
JOIN tblDepartment d on d.depNum=e.depNum
GROUP BY e.empSSN,e.empName, d.depName
HAVING SUM(workHours)=(
	SELECT MAX(maxhours)
	FROM(
		SELECT e.empSSN,e.empName, d.depName, SUM(workHours) as maxhours
		FROM tblWorksOn w
		JOIN tblEmployee e on w.empSSN = e.empSSN 	
		JOIN tblDepartment d on d.depNum=e.depNum
		GROUP BY e.empSSN,e.empName, d.depName
		)t
	)

--23
select e.empSSN, e.empName, d.depName
from tblWorksOn w
inner join tblEmployee e on w.empSSN = e.empSSN
inner join tblDepartment d on e.depNum = d.depNum
group by e.empSSN, e.empName, d.depName
having count(w.empSSN) = 1

--24
select e.empSSN, e.empName, d.depName
from tblWorksOn w
inner join tblEmployee e on w.empSSN = e.empSSN
inner join tblDepartment d on e.depNum = d.depNum
group by e.empSSN, e.empName, d.depName
having count(w.empSSN) = 2

--25
select e.empSSN, e.empName, d.depName
from tblWorksOn w
inner join tblEmployee e on w.empSSN = e.empSSN
inner join tblDepartment d on e.depNum = d.depNum
group by e.empSSN, e.empName, d.depName
having count(w.empSSN) >=2

--26
select p.proNum, p.proName, count(w.empSSN) as number_of_emp
from tblWorksOn w
inner join tblEmployee e on w.empSSN =e.empSSN
inner join tblProject p on w.proNum = p.proNum
group by p.proNum, p.proName

--27
--Cach 1
select p.proNum, p.proName,sum(w.workHours) as total_hours
from tblWorksOn w
inner join tblEmployee e on w.empSSN =e.empSSN
inner join tblProject p on w.proNum = p.proNum
group by p.proNum, p.proName

--Cach 2
SELECT w.proNum, p.proName,sum(workHours) as total_hours
FROM tblWorksOn w join tblProject p on p.proNum=w.proNum
GROUP BY w.proNum, p.proName

--28
select p.proNum, p.proName, count(w.empSSN) as minnumber_of_emp
from tblWorksOn w
inner join tblEmployee e on w.empSSN =e.empSSN
inner join tblProject p on w.proNum = p.proNum
group by p.proNum, p.proName
having count(w.empSSN)=(
	select min(number_of_emp)
	from (
		select p.proNum, p.proName, count(w.empSSN) as number_of_emp
		from tblWorksOn w
		inner join tblEmployee e on w.empSSN =e.empSSN
		inner join tblProject p on w.proNum = p.proNum
		group by p.proNum, p.proName
		)t
	)

--29

select p.proNum, p.proName, count(w.empSSN) as maxnumber_of_emp
from tblWorksOn w
inner join tblEmployee e on w.empSSN =e.empSSN
inner join tblProject p on w.proNum = p.proNum
group by p.proNum, p.proName
having count(w.empSSN)=(
	select max(number_of_emp)
	from (
		select p.proNum, p.proName, count(w.empSSN) as number_of_emp
		from tblWorksOn w
		inner join tblEmployee e on w.empSSN =e.empSSN
		inner join tblProject p on w.proNum = p.proNum
		group by p.proNum, p.proName
		)t
	)

--30
SELECT w.proNum, p.proName,sum(workHours) as mintotal_hours
FROM tblWorksOn w join tblProject p on p.proNum=w.proNum
GROUP BY w.proNum, p.proName
HAVING sum(workHours)=(
	SELECT min(total_hours)
	FROM (
		SELECT w.proNum, p.proName,sum(workHours) as total_hours
		FROM tblWorksOn w join tblProject p on p.proNum=w.proNum
		GROUP BY w.proNum, p.proName
		)t
	)

--31
SELECT w.proNum, p.proName,sum(workHours) as maxtotal_hours
FROM tblWorksOn w join tblProject p on p.proNum=w.proNum
GROUP BY w.proNum, p.proName
HAVING sum(workHours)=(
	SELECT max(total_hours)
	FROM (
		SELECT w.proNum, p.proName,sum(workHours) as total_hours
		FROM tblWorksOn w join tblProject p on p.proNum=w.proNum
		GROUP BY w.proNum, p.proName
		)t
	)

--32
select l.locName, count(dep.depNum) as number_of_department
from  tblDepLocation dep
inner join tblLocation l on dep.locNum = l.locNum
group by l.locName

--33
select dep.depNum, d.depName, count(dep.locNum) as number_of_location
from tblDepLocation dep
inner join tblDepartment d on dep.depNum = d.depNum
group by dep.depNum, d.depName

--34
select dep.depNum, d.depName, count(dep.locNum) as number_of_location
from tblDepLocation dep
inner join tblDepartment d on dep.depNum = d.depNum
group by dep.depNum, d.depName
having count(dep.locNum) = (
        	select max(a)
        	from (
        	select depNum,count(locNum) as a
        	from tblDepLocation
        	group by depNum)t
        	)
--35
select dep.depNum, d.depName, count(dep.locNum) as number_of_location
from tblDepLocation dep
inner join tblDepartment d on dep.depNum = d.depNum
group by dep.depNum, d.depName
having count(dep.locNum) = (
        	select min(a)
        	from (
        	select depNum,count(locNum) as a
        	from tblDepLocation
        	group by depNum)t
        	)
--36
select l.locName, count(dep.depNum) as maxnumber_of_department
from  tblDepLocation dep
inner join tblLocation l on dep.locNum = l.locNum
group by l.locName
having count(dep.depNum) = (
        	select max(a)
        	from (
        	select count(depNum) as a
        	from tblDepLocation
        	group by locNum
        	) t
)

--37
select l.locName, count(dep.depNum) as minnumber_of_department
from  tblDepLocation dep
inner join tblLocation l on dep.locNum = l.locNum
group by l.locName
having count(dep.depNum) = (
        	select min(a)
        	from (
        	select count(depNum) as a
        	from tblDepLocation
        	group by locNum
        	) t
)

--38
SELECT e.empSSN, e.empName, count(de.depName) as minnumber_depend
FROM tblEmployee e join tblDependent de on e.empSSN=de.empSSN
GROUP BY e.empSSN, e.empName
HAVING count(de.depName) = (
		SELECT min(number_depend)
		FROM (
			Select e.empSSN, e.empName, count(de.depName) as number_depend
			FROM tblEmployee e join tblDependent de on e.empSSN=de.empSSN
			GROUP BY e.empSSN, e.empName 
		)t
	)

--39
SELECT e.empSSN, e.empName, count(de.depName) as maxnumber_depend
FROM tblEmployee e join tblDependent de on e.empSSN=de.empSSN
GROUP BY e.empSSN, e.empName
HAVING count(de.depName) = (
		SELECT max(number_depend)
		FROM (
			Select e.empSSN, e.empName, count(de.depName) as number_depend
			FROM tblEmployee e join tblDependent de on e.empSSN=de.empSSN
			GROUP BY e.empSSN, e.empName 
		)t
	)


--40

select e.empSSN, e.empName,d.depName
from tblEmployee e
full join tblDependent dep on e.empSSN = dep.empSSN
full join tblDepartment d on e.depNum = d.depNum
group by e.empSSN, e.empName, d.depName
having count( dep.depName) = 0

--41 
select d.depNum, d.depName
from tblEmployee e
left join tblDependent dep on e.empSSN = dep.empSSN
inner join tblDepartment d on e.depNum = d.depNum
group by  d.depNum, d.depName
having count( dep.depName) = 0

--42
select e.empSSN, e.empName, d.depName
from tblWorksOn w
full join tblEmployee e on w.empSSN = e.empSSN
full join tblDepartment d on e.depNum = d.depNum
where proNum is Null

 --43
select  e.empSSN, e.empName, d.depName
from tblWorksOn w
inner join tblEmployee e on w.empSSN = e.empSSN
inner join tblDepartment d on e.depNum = d.depNum
where d.depName not in(
		select  d.depName
		from tblWorksOn w
		inner join tblEmployee e on w.empSSN = e.empSSN
		inner join tblDepartment d on e.depNum = d.depNum)

--44
select d.depNum,d.depName
from tblDepartment d
join tblEmployee e on e.depNum =d.depNum
join tblWorksOn w on e.empSSN =w.empSSN
join tblProject p on p.proNum = w.proNum
where  depName not in(
		select depName
		from tblDepartment d
		join tblEmployee e on e.depNum =d.depNum
		join tblWorksOn w on e.empSSN =w.empSSN
		join tblProject p on p.proNum = w.proNum
		where proName = 'ProjectA'
	)
group by d.depNum,d.depName

--45
SELECT d.depNum, d.depName, COUNT( distinct w.proNum) as numberofproject
from tblDepartment d
join tblEmployee e on e.depNum =d.depNum
join tblWorksOn w on e.empSSN =w.empSSN
join tblProject p on p.proNum = w.proNum
GROUP BY d.depNum, d.depName

--46
select d.depNum, d.depName, count(distinct p.proNum) as number_of_project
from tblDepartment d
join tblEmployee e on e.depNum =d.depNum
join tblWorksOn w on e.empSSN =w.empSSN
join tblProject p on p.proNum = w.proNum
group by d.depNum, d.depName
having count(distinct p.proNum) = (
        	select min(a)
        	from (
        	select distinct d.depNum, d.depName, count(distinct p.proNum) as a
        	from tblDepartment d
        	join tblEmployee e on e.depNum =d.depNum
        	join tblWorksOn w on e.empSSN =w.empSSN
        	join tblProject p on p.proNum = w.proNum
        	group by d.depNum, d.depName)t
)

--47
select d.depNum, d.depName, count(distinct p.proNum) as number_of_project
from tblDepartment d
join tblEmployee e on e.depNum =d.depNum
join tblWorksOn w on e.empSSN =w.empSSN
join tblProject p on p.proNum = w.proNum
group by d.depNum, d.depName
having count(distinct p.proNum) = (
        	select max(a)
        	from (
        	select distinct d.depNum, d.depName, count(distinct p.proNum) as a
        	from tblDepartment d
        	join tblEmployee e on e.depNum =d.depNum
        	join tblWorksOn w on e.empSSN =w.empSSN
        	join tblProject p on p.proNum = w.proNum
        	group by d.depNum, d.depName)t
)

--48
SELECT d.depNum, d.depName,p.proName, count(distinct e.empSSN)
FROM tblDepartment d
FUll JOIN tblEmployee e ON e.depNum = d.depNum
full JOIN tblWorksOn w ON e.empSSN = w.empSSN
full JOIN tblProject p ON d.depNum = p.depNum
group by d.depNum, d.depName,p.proName
having count(distinct e.empSSN) > 5

--49
select e.empSSN, e.empName
from tblEmployee e
full join tblDepartment d on e.depNum = d.depNum
full join tblDependent dep on e.empSSN = dep.empSSN
where d.depName Like N'Phòng Nghiên cứu%' and dep.depName is null

--50
select e.empSSN, e.empName, sum(w.workHours) as totalHours
from tblEmployee e
full join tblDependent dep on e.empSSN = dep.empSSN
join tblWorksOn w on e.empSSN = w.empSSN
where dep.depName is null
group by e.empSSN, e.empName

--51 
select e.empSSN, e.empName, sum(w.workHours) as totalHours
from tblEmployee e
full join tblDependent dep on e.empSSN = dep.empSSN
inner join tblWorksOn w on e.empSSN = w.empSSN
group by e.empSSN, e.empName
having count(distinct dep.depName) >= 3

--52

select a.empSSN, a.empName, sum(w.workHours) as totalHours
from tblEmployee a
join tblEmployee b on a.supervisorSSN = b.empSSN
join tblWorksOn w on w.empSSN = a.empSSN
where b.empName like 'Mai Duy An'
group by a.empSSN, a.empName








