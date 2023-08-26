--1
create table Items(
ItemID int primary key,
Item_Name nvarchar(50),
Description nvarchar(50),
)
create table Staffs(
StaffID int primary key,
Staff_Name nvarchar(50),
Manager_Position nvarchar(50),
)
create table Managers(
ManagerID int primary key,
Manager_Name nvarchar(50),
)
create table Manage(
ItemID int,
ManagerID int,
Constraint PK_Manage Primary key(ItemID, ManagerID),
Constraint FK_Manage_Items Foreign Key(ItemID) References Items(ItemID),
Constraint FK_Manage_Managers Foreign Key(ManagerID) References Managers(ManagerID)
)
create table Care_for(
StaffID int,
ManagerID int,
Constraint PK_Care_for Primary key(StaffID, ManagerID),
Constraint FK_Care_for_Staffs Foreign Key(StaffID) References Staffs(StaffID),
Constraint FK_Care_for_Managers Foreign Key(ManagerID) References Managers(ManagerID)
)

--2
select *
from Assessments a
where a.[percent] = 0.02

--3
select s.id as Stu_ID,s.name as Stu_Name,d.Name as Stu_Dep
from Students s join Departments d on s.department=d.Code 
where d.Name = 'Artificial Intelligence'
order by s.name

--4
select  top 18 s.id as Stu_ID, s.name as Stu_Name 
from Students s
join enroll e on s.id=e.studentId
join Courses c on e.courseId = c.id
where c.credits > 3

--5
select s.name
from Students s
 join enroll e on s.id=e.studentId
 join Courses c on e.courseId = c.id
 join Assessments a on a.courseId=c.id
 join semesters se on e.semesterId=se.id
where se.code = 'Sp2019' and a.type= 'Final Exam'

--6
select de.Code, de.Name, count(*) as EnrollmentCount
from Departments de
join Students s on de.Code= s.department 
group by de.Code, de.Name

--7 
select s.[name] from 
(select top 5 s.name,AVG(mark) as AverageMark
from Students s 
join enroll e on s.id =e.studentId
join marks m on m.enrollId=e. enrollId
group by s.name
order by AverageMark desc) as s
union all
select s1.[name] from 
(select top 5 s.name,AVG(mark) as AverageMark
from Students s 
join enroll e on s.id = e.studentId
join marks m on m.enrollId = e. enrollId
group by s.name
order by AverageMark ) as s1


--8
CREATE TRIGGER trg_AfterInsertDepartments
ON Departments
AFTER INSERT
AS
BEGIN
    SELECT i.Code as Dep_ID, i.Name as Dep_Name
    FROM INSERTED I
END;

--9
create proc CalculateAverageStudentMark @studentId int
as
begin 
		select AVG(mark) as AverageMark
		from Students s 
		join enroll e on s.id =e.studentId
		join marks m on m.enrollId=e. enrollId
		where s.id = @studentId
end

--10
DELETE FROM Departments
WHERE Code NOT IN (
    SELECT department
    FROM Students
);




















































































