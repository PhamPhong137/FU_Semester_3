create table Staffs(
	StaffID int primary key,
	Name nvarchar(100)
)

create table Logins(
	username nvarchar(50) primary key,
	Password nvarchar(50),
	Role nvarchar(100),
	StaffID int foreign key(StaffID) references Staffs(StaffID)
)

create table Reports(
	ReportNumber int primary key,
	Date date,
	IssueReturn nvarchar(200),
	username nvarchar(50) foreign key(username) references Logins(username)
)