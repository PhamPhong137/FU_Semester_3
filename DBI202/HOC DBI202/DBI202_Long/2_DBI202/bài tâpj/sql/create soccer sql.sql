create database FootballManage
-- Teams table
CREATE TABLE Teams (
    TeamId INT PRIMARY KEY,
    TeamName VARCHAR(20) NOT NULL,
	CityID INT NOT NULL,
    StadiumID INT NOT NULL,
    CoachID INT NOT NULL
);

--Nationnality table
CREATE TABLE Nationality (
NationalityID INT NOT NULL PRIMARY KEY,
Nationality VARCHAR(20) NOT NULL
);

-- Coach table
CREATE TABLE Coach (
    CoachId INT PRIMARY KEY,
    FirstName VARCHAR(20) NOT NULL,
    LastName VARCHAR(20) NOT NULL,
    NationalityID INT NOT NULL,
    TeamId INT NOT NULL,
    FOREIGN KEY (TeamId) REFERENCES Teams(TeamId),
	FOREIGN KEY (NationalityID) REFERENCES Nationality(NationalityID)
);

-- Players table
CREATE TABLE Players (
    PlayerId INT PRIMARY KEY,
    FirstName VARCHAR(20) NOT NULL,
    LastName VARCHAR(20) NOT NULL,
    Birthdate DATE NOT NULL,
    NationalityID INT NOT NULL,
    Position VARCHAR(20) NOT NULL,
    TeamId INT NOT NULL,
    FOREIGN KEY (TeamId) REFERENCES Teams(TeamId),
	FOREIGN KEY (NationalityID) REFERENCES Nationality(NationalityID),
	CHECK (Position = 'GK' or Position = 'DF' or Position = 'MF' or Position = 'FW')
);

-- Matches table
CREATE TABLE Matches (
    Id INT PRIMARY KEY,
    HomeTeamId INT NOT NULL,
    AwayTeamId INT NOT NULL,
    Date DATETIME NOT NULL,
    StadiumID INT NOT NULL,
    Result VARCHAR(10),
    FOREIGN KEY (HomeTeamId) REFERENCES Teams(TeamId),
    FOREIGN KEY (AwayTeamId) REFERENCES Teams(TeamId)
);

-- Transfers table
CREATE TABLE Transfers (
    TranferId INT PRIMARY KEY,
    PlayerId INT NOT NULL,
    TeamFromId INT NOT NULL,
    TeamToId INT NOT NULL,
    DateTransferred DATETIME NOT NULL,
    TransferFee DECIMAL(18,2) NOT NULL,
    FOREIGN KEY (PlayerId) REFERENCES Players(PlayerId),
    FOREIGN KEY (TeamFromId) REFERENCES Teams(TeamId),
    FOREIGN KEY (TeamToId) REFERENCES Teams(TeamId)
);

-- Contracts table
CREATE TABLE Contracts (
    Id INT PRIMARY KEY,
    PlayerId INT NOT NULL,
    TeamId INT NOT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL,
    Salary DECIMAL(18,2) NOT NULL,
    FOREIGN KEY (PlayerId) REFERENCES Players(PlayerId),
    FOREIGN KEY (TeamId) REFERENCES Teams(TeamId)
);

--Sponsors table
CREATE TABLE Sponsors (
SponsorId INT PRIMARY KEY,
Name VARCHAR(20) NOT NULL,
TeamId INT NOT NULL,
ContractStart DATE NOT NULL,
ContractEnd DATE NOT NULL,
FOREIGN KEY (TeamId) REFERENCES Teams(TeamId)
);

--Cities Table
CREATE TABLE Cities (
CityID INT NOT NULL PRIMARY KEY,
CityName VARCHAR(20) NOT NULL
);

--Stadiums table
CREATE TABLE Stadiums (
StadiumID INT NOT NULL PRIMARY KEY,
StadiumName VARCHAR(20) NOT NULL,
TeamID INT NOT NULL, 
CityID INT NOT NULL,
FOREIGN KEY (TeamId) REFERENCES Teams(TeamId),
FOREIGN KEY (CityID) REFERENCES Cities(CityID)
);


