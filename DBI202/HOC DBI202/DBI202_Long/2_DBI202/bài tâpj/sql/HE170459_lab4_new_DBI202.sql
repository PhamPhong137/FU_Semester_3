use FUH_COMPANY
--1
select e.empSSN, d.depNum, d.depName from tblDepartment d
join tblEmployee e on e.empSSN = d.mgrSSN
where d.depName = N'Phòng Nghiên cứu và phát triển' 
--2
select p.proNum, p.proName, d.depName from tblDepartment d 
join tblProject p on d.depNum = p.depNum
where d.depName = N'Phòng Nghiên cứu và phát triển'
--3
select p.proNum, p.proName, d.depName from tblDepartment d 
join tblProject p on d.depNum = p.depNum
where p.proName = 'ProjectB'
--4
select e.empSSN, e.empName from tblEmployee e 
join tblEmployee s on e.supervisorSSN = s.empSSN
where s.empName = 'Mai Duy An'
--5
select e.empSSN, e.empName from tblEmployee s
join tblEmployee e on s.supervisorSSN = e.empSSN
where s.empName = 'Mai Duy An'
--6
SELECT l.locNum, l.locName
FROM tblLocation l
INNER JOIN tblProject p ON l.locNum = p.locNum
WHERE p.proName = 'ProjectA'
--7
SELECT p.proNum, p.proName
FROM tblProject p
INNER JOIN  tblLocation l ON p.locNum = l.locNum
WHERE l.locName = 'Tp Hồ Chí Minh'
--8
SELECT d.depName, d.depBirthdate, e.empName
FROM tblDependent d
JOIN tblEmployee e ON d.empSSN = e.empSSN
WHERE (2023 - year(d.depBirthdate)) > 18
--9
SELECT d.depName, d.depBirthdate, e.empName
FROM tblDependent d
INNER JOIN tblEmployee e ON d.empSSN = e.empSSN
WHERE d.depSex = 'M'
--10
SELECT dp.depName, dp.depNum, l.locName
FROM tblDepartment dp
INNER JOIN tblDepLocation dl ON dp.depNum = dl.depNum
INNER JOIN tblLocation l ON dl.locNum = l.locNum
WHERE dp.depNum = 5
--11
select p.proNum, p.proName, d.depName
from tblProject p 
join tblDepartment d on p.depNum = d.depNum
where p.locNum = 5
--12
select e.empName, de.depName, de.depRelationship
from tblEmployee e 
join tblDependent de on e.empSSN = de.empSSN
where e.depNum = 5 and de.depSex = 'F'
--13
select e.empName, de.depName, de.depRelationship
from tblEmployee e 
join tblDependent de on e.empSSN = de.empSSN
where e.depNum = 5 and (2023 - year(de.depBirthdate)) > 18
--14
SELECT depSex, COUNT(*) AS NumberOfDependents
FROM tblDependent GROUP BY depSex
--15 
SELECT d.depRelationship, COUNT(*) AS NumberOfDependents
FROM tblDependent d
GROUP BY d.depRelationship
--16
select e.depNum, d2.depName, count(*) as N'Số lượng người phụ thuộc'
from tblEmployee e join tblDependent d1 on e.empSSN = d1.empSSN
join tblDepartment d2 on d2.depNum =e .depNum
group by e.depNum, d2.depName
--17
select top 1 e.depNum, d2.depName, count(*) as N'Số lượng người phụ thuộc'
from tblEmployee e join tblDependent d1 on e.empSSN = d1.empSSN
join tblDepartment d2 on d2.depNum =e .depNum
group by e.depNum, d2.depName
order By count(*)
--18
select top 1 e.depNum, d2.depName, count(*) as N'Số lượng người phụ thuộc'
from tblEmployee e join tblDependent d1 on e.empSSN = d1.empSSN
join tblDepartment d2 on d2.depNum =e .depNum
group by e.depNum, d2.depName
order By count(*) Desc
--19 
select e.empSSN, e.empName, d.depName, Sum(w.workHours) as N'Tổng số giờ'
from tblEmployee e join tblDepartment d on e.depNum = d.depNum
join tblWorksOn w on e.empSSN = w.empSSN
group by e.empSSN, e.empName, d.depName
--20
select d.depNum, d.depName, sum(w.workHours) as N'Tổng số giờ'
from tblEmployee e join tblDepartment d on d.depNum = e. depNum
join tblWorksOn w on e.empSSN = w.empSSN
group by d.depNum, d.depName
--21
select top 1 e.empSSN, e.empName, Sum(w.workHours) as N'Tổng số giờ'
from tblEmployee e join tblDepartment d on e.depNum = d.depNum
join tblWorksOn w on e.empSSN = w.empSSN
group by e.empSSN, e.empName
order by Sum(w.workHours)
--22
select top 1 e.empSSN, e.empName, Sum(w.workHours) as N'Tổng số giờ'
from tblEmployee e join tblDepartment d on e.depNum = d.depNum
join tblWorksOn w on e.empSSN = w.empSSN
group by e.empSSN, e.empName
order by Sum(w.workHours) Desc
--23
select e.empSSN, e.empName, d.depName, count(w.proNum) as N'So luong'
from tblEmployee e join tblDepartment d on e.depNum = d.depNum
join tblWorksOn w on e.empSSN = w.empSSN
group by e.empSSN, e.empName, d.depName
having count(w.proNum) = 1
--24
select e.empSSN, e.empName, d.depName, count(w.proNum) as N'So luong'
from tblEmployee e join tblDepartment d on e.depNum = d.depNum
join tblWorksOn w on e.empSSN = w.empSSN
group by e.empSSN, e.empName, d.depName
having count(w.proNum) = 2
--25
select e.empSSN, e.empName, d.depName, count(w.proNum) as N'So luong'
from tblEmployee e join tblDepartment d on e.depNum = d.depNum
join tblWorksOn w on e.empSSN = w.empSSN
group by e.empSSN, e.empName, d.depName
having count(w.proNum) >= 2 order by count(w.proNum)
--26
select p.proNum, p.proName, count(e.empSSN) as 'Tong so nhan vien' from tblWorksOn w
join tblEmployee e on w.empSSN = e.empSSN
join tblProject p on p.proNum = w.proNum
group by p.proName, p.proNum
--27
SELECT p.proNum, p.proName, SUM(w.workHours) AS 'Tong so gio lam'
FROM tblProject p join tblWorksOn w on p.proNum = w.proNum
GROUP BY p.proNum, p.proName
--28
select top 1 p.proNum, p.proName, count(e.empSSN) as 'Tong so nhan vien' from tblWorksOn w
join tblEmployee e on w.empSSN = e.empSSN
join tblProject p on p.proNum = w.proNum
group by p.proName, p.proNum
order by count(e.empSSN)
--29
select top 1 p.proNum, p.proName, count(e.empSSN) as 'Tong so nhan vien' from tblWorksOn w
join tblEmployee e on w.empSSN = e.empSSN
join tblProject p on p.proNum = w.proNum
group by p.proName, p.proNum
order by count(e.empSSN) desc
--30
SELECT top 1 p.proNum, p.proName, SUM(w.workHours) AS 'Tong so gio lam'
FROM tblProject p join tblWorksOn w on p.proNum = w.proNum
GROUP BY p.proNum, p.proName
order by SUM(w.workHours)
--31
SELECT top 1 p.proNum, p.proName, SUM(w.workHours) AS 'Tong so gio lam'
FROM tblProject p join tblWorksOn w on p.proNum = w.proNum
GROUP BY p.proNum, p.proName
order by SUM(w.workHours) desc
--32
select l.locName, count(d.depNum) as 'So luong phong ban'
from tblDepLocation dl 
join tblLocation l on l.locNum = dl.locNum
join tblDepartment d on d.depNum = dl.depNum
group by l.locName
--33
select d.depNum, d.depName, count(e.empSSN) as 'So luong cho lam viec'
from tblDepartment d join tblEmployee e on e.depNum = d.depNum
group by d.depNum, d.depName
--34
select top 1 d.depNum, d.depName, count(e.empSSN) as 'So luong cho lam viec'
from tblDepartment d join tblEmployee e on e.depNum = d.depNum
group by d.depNum, d.depName
order by count(e.empSSN) desc
--35
select top 1 d.depNum, d.depName, count(e.empSSN) as 'So luong cho lam viec'
from tblDepartment d join tblEmployee e on e.depNum = d.depNum
group by d.depNum, d.depName
order by count(e.empSSN) 
--36
select top 1 l.locName, count(d.depNum) as 'So luong phong ban'
from tblDepLocation dl 
join tblLocation l on l.locNum = dl.locNum
join tblDepartment d on d.depNum = dl.depNum
group by l.locName
order by count(d.depNum) desc
--37
select top 1 l.locName, count(d.depNum) as 'So luong phong ban'
from tblDepLocation dl 
join tblLocation l on l.locNum = dl.locNum
join tblDepartment d on d.depNum = dl.depNum
group by l.locName
order by count(d.depNum) 
--38
select top 1 e.empSSN, e.empName, count(d.depName) as 'So luong nguoi phu thuoc'
from tblEmployee e left join tblDependent d on e.empSSN = d.empSSN
group by e.empSSN, e.empName
order by count(d.depName) desc
--39
select top 1 e.empSSN, e.empName, count(d.depName) as 'So luong nguoi phu thuoc'
from tblEmployee e left join tblDependent d on e.empSSN = d.empSSN
group by e.empSSN, e.empName
order by count(d.depName)
--40
select e.empSSN, e.empName, count(d.depName) as 'So luong nguoi phu thuoc'
from tblEmployee e left join tblDependent d on e.empSSN = d.empSSN
group by e.empSSN, e.empName
having count(d.depName) = 0
--41
select d.depNum, d.depName  from tblEmployee e 
left join tblDependent de on e.empSSN = de.empSSN
join tblDepartment d on e.depNum = d.depNum
group by d.depNum, d.depName
having count(de.depName) = 0
--42 
select e.empSSN, e.empName, d.depName
from tblEmployee e join tblDepartment d on e.depNum = d.depNum
left join tblWorksOn w on e.empSSN = w.empSSN
group by e.empSSN, e.empName, d.depName
having count(w.proNum) = 0
--43
select d.depNum, d.depName
from tblEmployee e 
left join tblDepartment d on e.depNum = d.depNum
left join tblWorksOn w on e.empSSN = w.empSSN
group by  d.depName, d.depNum
having count(w.proNum) = 0
--44
select d.depNum, d.depName, p.proName
from tblEmployee e 
left join tblDepartment d on e.depNum = d.depNum
left join tblWorksOn w on e.empSSN = w.empSSN
left join tblProject p on e.depNum = p.depNum 
group by  d.depName, d.depNum, p.proName
having not p.proName = 'ProjectA'

--45
select d.depName, d.depNum, count(p.proNum) as 'So luong du an'
from tblDepartment d 
left join tblProject p on d.depNum = p.depNum
group by d.depNum, d.depName
--46
select top 1 d.depName, d.depNum, count(p.proNum) as 'So luong du an'
from tblDepartment d 
left join tblProject p on d.depNum = p.depNum
group by d.depNum, d.depName
order by count(p.proNum)
--47
select top 1 d.depName, d.depNum, count(p.proNum) as 'So luong du an'
from tblDepartment d 
left join tblProject p on d.depNum = p.depNum
group by d.depNum, d.depName
order by count(p.proNum) desc
--48
select d.depNum, d.depName, count(e.empSSN) as 'So luong nhan vien', p.proName
from tblDepartment d join tblEmployee e on d.depNum = e.depNum
join tblProject p on d.depNum = p.depNum
group by d.depNum, d.depName, p.proName
having count(e.empSSN) >= 5
--49
Select e.empSSN, e.empName, d1.depName, d2.depName from tblEmployee e 
join tblDepartment d1 on e.depNum = d1.depNum
left join tblDependent d2 on e.empSSN = d2.empSSN
where d1.depName like N'Phòng nghiên cứu%' 
except
Select e.empSSN, e.empName, d1.depName, d2.depName from tblEmployee e 
join tblDepartment d1 on e.depNum = d1.depNum
join tblDependent d2 on e.empSSN = d2.empSSN
where d1.depName like N'Phòng nghiên cứu%' 