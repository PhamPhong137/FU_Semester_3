

use AI1708
create table Department
(DeptID varchar(4) primary key,
Name Nvarchar(50) not null,
NoofStudents int )

create table Students
(StudentID varchar(4) primary key,
LastName Nvarchar(10),
FirstName Nvarchar(30),
Sex varchar(1),
DateOfBirth Date,
PlaceOfBirth Nvarchar(30),
DeptID Varchar(4),
Scholarship float,
AverageScore float,
check (Sex = 'F' or Sex = 'M'))

create table Courses(
CourseID varchar(4) primary key,
Name Nvarchar(35),
Credits tinyint
)

CREATE TABLE Results (
StudentID varchar(4),
CourseID varchar(4),
Year int,
Semester int,
Mark float,
Grade varchar(6),
PRIMARY KEY (StudentID, CourseID, Year, Semester),
FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);

INSERT INTO Department(deptid, name) VALUES
('IS', 'Information Systems'),
('NC', 'Network and Communication'),
('SE', 'Software Engineering'),
('CE', 'Computer Engineering '),
('CS', 'Computer Science')

INSERT INTO Students(studentid, lastname, firstname, sex, dateofbirth, placeofbirth, deptid, scholarship) VALUES
('S001', 	'Lê',	'Kim Lan', 	'F',	'02/23/1990',	'Hà nội', 	'IS', 	130000),
('S002', 	'Trần', 	'Minh Chánh', 	'M', 	'12/24/1992', 	'Bình Định', 	'NC',	150000 ),
('S003', 	'Lê',	'An Tuyết', 	'F', 	'02/21/1991', 	'Hải phòng', 	'IS', 	170000) ,
('S004', 	'Trần', 	'Anh Tuấn', 'M', 	'12/20/1993', 	'TpHCM', 	'NC', 	800000),
('S005', 	'Trần',	'Thị Mai', 	'F', 	'08/12/1991', 	'TpHCM', 	'SE', 	0 ),
('S006', 	'Lê', 	'Thị Thu Thủy', 	'F', 	'01/02/1991', 	'An Giang', 	'IS', 	0 ),
('S007', 	'Nguyễn', 	'Kim Thư', 	'F', 	'02/02/1990', 	'Hà Nội', 	'SE', 	180000) ,
('S008',    'Lê',	 'Văn Long', 	'M', 	'12/08/1992', 	'TpHCM',	'IS', 	190000)

INSERT Into Courses(courseid, name, credits) VALUES
('DS01', 	'Database Systems', 	3 ),
('AI01', 	'Artificial Intelligence', 	3), 
('CN01',	'Computer Network', 	3 ),
('CG01',	'Computer Graphics',	4 ),
('DSA1',	'Data Structures and Algorithms', 	4 )

INSERT INTO Results(studentid, courseid, year, semester, mark) VALUES
('S001', 'DS01', 2017, 1,	3),
('S001', 'DS01', 2017, 2,	6 ),
('S001', 'AI01', 2017, 1,	4.5),
('S001', 'AI01', 2017, 2,	6 ),
('S001', 'CN01', 2017, 3,	5 ),
('S002', 'DS01', 2016, 1,	4.5),
('S002', 'DS01', 2017, 1,	7 ),
('S002', 'CN01', 2016, 3,	10 ),
('S002', 'DSA1', 2016, 3,	9 ),
('S003', 'DS01', 2017, 1,	2 ),
('S003', 'DS01', 2017, 3,	5 ),
('S003', 'CN01', 2017, 2,	2.5 ),
('S003', 'CN01', 2017, 3,	4 ),
('S004', 'DS01', 2017, 3,	4.5 ),
('S004', 'DSA1', 2018, 1,	10 ),
('S005', 'DS01', 2017, 2,	7 ),
('S005', 'CN01', 2017, 2,	2.5 ),
('S005', 'CN01', 2018, 1,	5 ),
('S006', 'AI01', 2018, 1,	6 ),
('S006', 'CN01', 2018, 2, 10 )

--2
UPDATE Department
SET noofstudents = 4 WHERE deptid = 'IS';
UPDATE Department
SET noofstudents = 2 WHERE deptid = 'NC';
UPDATE Department
SET noofstudents = 2 WHERE deptid = 'SE';
UPDATE Department
SET noofstudents = 0 WHERE deptid = 'CE' OR deptid = 'CS';

--3
WITH StudentScores AS (
  SELECT
    studentid,
    courseid,
    MAX(mark) AS highest_mark
  FROM
    Results
  GROUP BY
    studentid,
    courseid
)
SELECT
  studentid,
  AVG(highest_mark) AS AverageScore
FROM
  StudentScores
GROUP BY
  studentid;
--4
UPDATE Results
Set grade = 'Passed' WHERE 5 <= mark and mark <= 10;
UPDATE Results
Set grade = 'Failed' WHERE 0 <= mark and mark < 5
--5
SELECT studentid, firstname+ ' ' + lastname as FullName, dateofbirth, placeofbirth, deptid, scholarship from Students 
WHERE scholarship < 160000 order by scholarship DESC 
--6 
select Department.deptid, Department.name as DepartmentName, Students.studentid, Students.firstname, Students.lastname 
from Department inner join Students on Department.DeptID = Students.DeptID
--7
SELECT Results.StudentID, LastName, FirstName, COUNT(courseid) as NumberOfCourses FROM Students
JOIN Results ON Students.StudentID = Results.StudentID
GROUP BY Results.StudentID, LastName, FirstName
ORDER BY NumberOfCourses;
--8
SELECT D.DeptID, D.Name as DepartmentName, 
(SELECT COUNT(*) FROM Students WHERE Sex = 'F' AND DeptID = D.DeptID) AS NumberOfFemaleStudents,
(SELECT COUNT(*) FROM Students WHERE Sex = 'M' AND DeptID = D.DeptID) AS NumberOfMaleStudents
FROM Department D
--9

--10
SELECT Courses.CourseID, Courses.Name as CourseName, 
Students.LastName + ' ' + Students.FirstName AS BestStudentFullName, MAX(R.Mark) AS Mark
FROM Results R
JOIN Courses ON R.CourseID = Courses.CourseID 
JOIN Students ON R.StudentID = Students.StudentID
GROUP BY Courses.CourseID, Courses.Name, Students.LastName + ' ' + Students.FirstName
