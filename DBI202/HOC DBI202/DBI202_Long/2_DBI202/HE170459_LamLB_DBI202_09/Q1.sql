Create Table Students(
StudentID int not Null Primary Key,
[Name] Nvarchar(200),
Gender char(1) check(Gender in ('F','M')),
)

Create Table Teachers(
TeacherID int not null Primary key,
[Name] Nvarchar(50),
[Address] Nvarchar(200),
Gender char(1)
)

Create Table Classes(
ClassID int not Null Primary key,
[Year] int,
Semester char(10),
GroupID char(6),
NoCredits int, 
TeacherID int,
foreign key (TeacherID) references Teachers(TeacherID)
)

Create Table Attend(
StudentID int not Null,
ClassID int not Null,
Attend bit,
[Date] date,
Slot int,
primary key (StudentID, ClassID, [Date], Slot),
foreign key (StudentID) references Students(StudentID),
foreign key (ClassID) references Classes(ClassID)
)
