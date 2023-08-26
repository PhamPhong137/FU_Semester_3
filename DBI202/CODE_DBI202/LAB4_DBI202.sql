CREATE DATABASE LAB4_DBI202

USE LAB4_DBI202

CREATE TABLE Departments
( DeptID Varchar(4) PRIMARY KEY,
Name Nvarchar(50) not null,
NoOfStudents int )

--EXEC sp_rename 'Department', 'Departments';

--sp_rename 'Departments.DepID', 'DeptID','COLUMN';

CREATE TABLE Students
( StudentID Varchar(4) PRIMARY KEY,
LastName Nvarchar(MAX),
FirstName Nvarchar(MAX),
Sex Varchar(1),
DateOfBirth Date,
PlaceOfBirth Nvarchar(30),
DeptID Varchar(4),
Scholarship float,
AverageScore Numeric(4,2),
check (Sex='F' OR Sex='M'))

CREATE TABLE Courses
(CourseID Varchar(4) PRIMARY KEY,
Name Nvarchar(35),
Credits tinyint)

CREATE TABlE Results
(StudentID Varchar(4),
CourseID Varchar(4),
Year int ,
Semester int,
Mark float(1),
Grade Varchar(6),
PRIMARY KEY(StudentID,CourseID,Year,Semester),
FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
)

INSERT INTO Departments(DeptID,Name) VALUES
('IS', 'Information Systems'),
('NC', 'Network and Communication'),
('SE', 'Software Engineering'),
('CE', 'Computer Engineering '),
('CS', 'Computer Science')



INSERT INTO Students(StudentID,LastName,FirstName,Sex,DateOfBirth,PlaceOfBirth,DeptID,Scholarship) VALUES
('S001',	N'Lê',	N'Kim Lan', 	'F',	'02/23/1990',	N'Hà n?i', 	'IS', 	130000),
('S002', 	N'Tr?n', 	N'Minh Chánh', 	'M', 	'12/24/1992', 	N'Bình ??nh', 	'NC',	150000 ),
('S003', 	N'Lê',	N'An Tuy?t', 	'F', 	'02/21/1991', 	N'H?i phòng', 	'IS', 	170000) ,
('S004', 	N'Tr?n', 	N'Anh Tu?n', 'M', 	'12/20/1993', 	N'TpHCM', 	'NC', 	800000),
('S005', 	N'Tr?n',	N'Th? Mai', 	'F', 	'08/12/1991', 	N'TpHCM', 	'SE', 	0 ),
('S006', 	N'Lê', 	N'Th? Thu Th?y', 	'F', 	'01/02/1991', 	N'An Giang', 	'IS', 	0 ),
('S007', 	N'Nguy?n', 	N'Kim Th?', 	'F', 	'02/02/1990', 	N'Hà N?i', 	'SE', 	180000) ,
('S008',    N'Lê',	 N'V?n Long', 	'M', 	'12/08/1992', 	N'TpHCM',	'IS', 	190000)

INSERT INTO Courses(CourseID, Name, Credits) VALUES
('DS01', 	'Database Systems', 	3 ),
('AI01', 	'Artificial Intelligence', 	3), 
('CN01',	'Computer Network', 	3 ),
('CG01',	'Computer Graphics',	4 ),
('DSA1',	'Data Structures and Algorithms', 	4 )

INSERT INTO Results(StudentID, CourseID, year, Semester, Mark) VALUES
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
UPDATE Departments
SET NoOfStudents = 4 WHERE DeptID ='IS'
UPDATE Departments 
SET NoOfStudents = 2 WHERE DeptID ='SE'
UPDATE Departments 
SET NoOfStudents = 2 WHERE DeptID ='NC'
UPDATE Departments 
SET NoOfStudents = 0 WHERE DeptID ='CE' OR DeptID='CS'

--3
WITH StudentScores AS(
	SELECT StudentID, CourseID, MAX(Mark) AS HighestMark
	FROM Results
	GROUP BY StudentID, CourseID
)
SELECT StudentID, AVG(HighestMark) as AverageScore
FROM StudentScores
GROUP BY StudentID

--4
UPDATE Results
SET Grade='Passed' WHERE Mark>=5 AND MARK <=10 
UPDATE Results
SET Grade='Failed' WHERE Mark>=0 AND MARK <5

--5
SELECT StudentID, FirstName+ ' ' + LastName as FullName, DateOfBirth, PlaceOfBirth, DeptID, Scholarship	 
FROM Students 
WHERE Scholarship < 160000 order by Scholarship DESC 

--6
SELECT Departments.DeptID, Departments.Name AS DepartmentName, Students.StudentID, Students.LastName, Students.FirstName
FROM Departments inner join Students
ON Departments.DeptID = Students.DeptID

--7
SELECT Students.StudentID, LastName, FirstName, COUNT(CourseID) AS NumberOfCourses
FROM Students JOIN Results ON Students.StudentID = Results.StudentID
GROUP BY Students.StudentID, LastName,FirstName
ORDER BY NumberOfCourses

--8
SELECT Departments.DeptID, Departments.Name as DepartmentName, 
(SELECT COUNT(*) FROM Students WHERE Sex = 'F' AND Students.DeptID = Departments.DeptID) AS NumberOfFemaleStudents,
(SELECT COUNT(*) FROM Students WHERE Sex = 'M' AND Students.DeptID = Departments.DeptID) AS NumberOfMaleStudents
FROM Departments

--9
SELECT DISTINCT Students.StudentID, Students.LastName, Students.FirstName
FROM Students
JOIN Results ON Students.StudentID = Results.StudentID
WHERE Students.DeptID <> 'IS' AND Results.CourseID = 'DS01' AND Results.Mark >(
	SELECT MIN(Mark)
	FROM Students
	JOIN Results ON Students.StudentID = Results.StudentID
	WHERE Students.DeptID = 'IS' AND Results.CourseID = 'DS01')

--10
SELECT Courses.CourseID, Courses.Name AS CourseName,  LastName +' '+ FirstName AS BestStudentFullName, Mark
FROM Results 
JOIN Courses ON Courses.CourseID = Results.CourseID	
JOIN Students ON Results.StudentID = Students.StudentID
WHERE
    Results.Mark = (
        SELECT MAX(Mark)
        FROM Results
       WHERE Results.CourseID = Courses.CourseID
    );

