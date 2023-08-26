Locations (
	LocationID varchar(20) primary key,
	Name nvarchar(100),
	Address nvarchar(255)
)

Events(
	eventID int primary key,
	Name nvarchar(255),
	StartTime DateTime,
	EndTime DateTime,
	LocationID varchar(20) foreign key(LocationID) references Locations(LocationID)
)

Staffs (
	staffID int primary key,
	Name nvarchar(255),
	Phone varchar(15)
)

workFor (
	role nvarchar(30),
	eventID int foreign key(eventID) references Events(eventID),
	staffID int foreign key(staffID) references Staffs(staffID),
	primary key(role, eventID, staffID)
)