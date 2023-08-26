use FootballManage
INSERT INTO Cities (CityID, CityName)
VALUES
(1,'London'),
(2,'Liverpool'),
(3,'Manchester'),
(4,'Newcastle'),
(5,'Brighton');

INSERT INTO Stadiums (StadiumID, StadiumName, TeamID, CityID)
VALUES
(1,'Old Trafford',1,3),
(2,'Anfield',2,2),
(3,'Stamford Bridge',3,1),
(4,'Etihad Stadium',4,3),
(5,'Tottenham Hotspur',5,1),
(6,'Emirates Stadium',6,1),
(7,'St James Park',7,4),
(8,'Craven Cottage',8,1),
(9,'Falmer Stadium',9,5),
(10,'Brentford Community',10,1);
-- Insert data into Teams table
INSERT INTO Teams (TeamID,TeamName, CityID, StadiumID, CoachID)
VALUES 
    (1,'Manchester United', 3, 1, 1),
    (2,'Liverpool', 2, 2, 2),
    (3,'Chelsea', 1, 3, 3),
    (4,'Manchester City', 3, 4, 4),
    (5,'Tottenham Hotspur', 1, 5, 5),
    (6,'Arsenal', 1, 6, 6),
    (7,'Newcastle United', 4, 7, 7),
    (8,'Fulham', 1, 8, 8),
    (9,'Brighton and Hove', 5, 9, 9),
    (10,'Brentford', 1, 10, 10);
]
INSERT INTO Nationality (NationalityID, Nationality)
VALUES
(1,'Dutch'),
(2,'German'),
(3,'English'),
(4,'Spanish'),
(5,'Italian'),
(6,'Portuguese'),
(7,'Danish'),
(8,'French'),
(9,'Brazilian'),
(10,'Belgian'),
(11,'Argentine');
-- Insert data into Coach table
INSERT INTO Coach (CoachID, FirstName, LastName, NationalityID, TeamId)
VALUES 
    (1,'Erik Ten', 'Hag', 1, 1),
    (2,'Jurgen', 'Klopp', 2, 2),
    (3,'Graham', 'Potter', 3, 3),
    (4,'Pep', 'Guardiola', 4, 4),
    (5,'Antonio', 'Conte', 5, 5),
    (6,'Mikel', 'Arteta', 4, 6),
    (7,'Eddie', 'Howe', 3, 7),
    (8,'Marco', 'Silva', 6, 8),
    (9,'Roberto De', 'Zerbi', 5, 9),
    (10,'Thomas', 'Frank', 7, 10);

-- Insert data into Players table
INSERT INTO Players (PlayerID, FirstName, LastName, Birthdate, NationalityID, Position, TeamId)
VALUES 
    (1,'Marcus', 'Rashford', '1997-10-31', 3, 'FW', 1),
    (2,'Ibrahima', 'Konate', '1999-05-25', 8, 'FW', 2),
    (3,'Thiago', 'Silva', '1984-09-22', 9, 'DF', 3),
    (4,'Kevin', 'De Bruyne', '1991-06-28', 10, 'MF', 4),
    (5,'Harry', 'Kane', '1993-07-28', 3, 'FW', 5),
    (6,'Bukayo', 'Saka', '2001-09-05', 3, 'MF', 6),
    (7,'Allan', 'Saint-Maximin', '1997-03-12', 8, 'FW', 7),
    (8,'Joao', 'Palhinha', '1995-07-09', 6, 'MF', 8),
    (9,'Soly', 'March', '1994-07-20', 3, 'MF', 9),
    (10,'David', 'Raya', '1995-09-15', 4, 'GK', 10),
	(11,'Bruno', 'Fernandes', '1994-09-08', 6, 'MF', 1),
	(12,'Virgil', 'van Dijk', '1991-08-07', 1, 'DF', 2),
	(13,'Enzo', 'Fernandez', '2001-01-17', 11, 'MF', 3),
	(14,'Ederson', 'Moraes', '1993-08-17', 9, 'GK', 4),
	(15,'Oliver', 'Skipp', '2000-09-16', 3, 'MF', 5),
	(16,'Leandro', 'Trossard', '1994-04-12', 10, 'FW', 6),
	(17,'Kieran', 'Trippier', '1990-09-19', 3, 'DF', 7),
	(18,'Layin', 'Kurzawa', '1992-09-04', 8, 'DF', 8),
	(19,'Mac', 'Allister', '1998-12-24', 11, 'MF', 9),
	(20,'Mikel', 'Damsgaard', '2000-07-03', 7, 'FW', 10);

-- Insert data into Matches table
INSERT INTO Matches (Id,HomeTeamId, AwayTeamId, Date, StadiumID, Result)
VALUES
(1,1, 2, '2022-01-01 15:00:00', 1,'3-1'),
(2,3, 4, '2022-01-01 17:30:00', 3, '1-1'),
(3,5, 6, '2022-01-02 14:00:00', 5, '0-1'),
(4,7, 8, '2022-01-02 16:30:00', 7, '2-0'),
(5,9, 10, '2022-01-03 20:00:00', 10, '5-2'),
(6,1, 3, '2022-01-08 15:00:00', 1, '3-3'),
(7,2, 4, '2022-01-08 17:30:00', 2, '1-0'),
(8,5, 7, '2022-01-09 14:00:00', 5, '4-1'),
(9,6, 8, '2022-01-09 16:30:00', 6, '1-2'),
(10,9, 1, '2022-01-10 20:00:00', 9, '0-0');

-- Insert data into Transfer table
INSERT INTO Transfers(TranferId,PlayerId, TeamFromId, TeamToId, DateTransferred, TransferFee)
VALUES
(1,1, 1, 2,'2022-02-01', 60000000),
(2,2, 2, 1, '2022-02-05', 50000000),
(3,3, 3, 4,'2022-02-10', 45000000),
(4,4, 4, 3,'2022-02-15', 80000000),
(5,5, 5, 6,'2022-02-20', 90000000),
(6,6, 6, 5,'2022-02-25', 70000000),
(7,7, 7, 8,'2022-03-01', 25000000),
(8,8, 8, 7,'2022-03-02', 28000000),
(9,9, 9, 10,'2022-03-03', 32000000),
(10,10, 10, 9,'2022-03-04', 35000000);

-- Insert data into Contract table
INSERT INTO Contracts(Id,PlayerId, TeamId, StartDate, EndDate, Salary)
VALUES
(1,1, 1, '2020-01-01', '2025-01-01', 200000),
(2,2, 2, '2018-07-01', '2023-07-01', 250000),
(3,3, 3, '2019-08-01', '2024-08-01', 180000),
(4,4, 4, '2020-06-01', '2025-06-01', 300000),
(5,5, 5, '2019-10-01', '2024-10-01', 220000),
(6,6, 6, '2020-02-01', '2025-02-01', 240000),
(7,7, 7, '2021-01-01', '2024-01-01', 120000),
(8,8, 8, '2021-02-01', '2024-02-01', 80000),
(9,9, 9, '2020-07-01', '2025-07-01', 170000),
(10,10, 10, '2021-01-01', '2026-01-01', 210000)