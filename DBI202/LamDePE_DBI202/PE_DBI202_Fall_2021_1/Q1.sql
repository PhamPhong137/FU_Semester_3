create table Employees (
	EmpID int primary key,
	name nvarchar(50),
	salary money
)

create table Projects (
	ProjectID int primary key,
	name nvarchar(200),
)

create table Managers (
	bonus money,
	ProjectID int foreign key references Projects(ProjectID),
	EmpID int foreign key references Employees(EmpID)
)

create table Works (
	hours int,
	EmpID int foreign key references Employees(EmpID),
	ProjectID int foreign key references Projects(ProjectID)
)