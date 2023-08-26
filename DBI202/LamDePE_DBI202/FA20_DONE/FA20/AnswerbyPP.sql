--1
create table Branches(
BranchID int primary key,
Name nvarchar(100),
Address nvarchar(200),
)
create table Customers(
CustomerID int primary key,
FullName nvarchar(100),
Address nvarchar(200),
)
create table Vehicles(
VehicleID int  primary key,
Model nvarchar(50),
Year int,
RentalPrice float,
Maker varchar(20),
)
create table Rent(
PickupDate Date ,
DropoffDate Date,
BranchID int,
CustomerID int,
VehicleID int,
Primary key (PickupDate, BranchID, CustomerID, VehicleID),
Foreign key(BranchID) references Branches(BranchID),
Foreign key(CustomerID) references Customers(CustomerID),
Foreign key(VehicleID) references Vehicles(VehicleID)
)

--2
select *
from ranking_criteria

--3
select rs.id as ranking_system_id, rc.criteria_name
from ranking_system rs 
join ranking_criteria rc on rs.id=rc.ranking_system_id
where rs.id=1 or rs.id=2 
order by rs.id, rc.criteria_name

--4
select y.university_id, u.university_name, y.[year], y.num_students, y.pct_international_students, u.country_id
from university_year y
join university u on u.id = y.university_id
where y.[year] = 2016 and y.pct_international_students > 30
order by u.university_name;

--5
select rs.id as system_id, rs.system_name, count(rc.ranking_system_id) as numberOfCriteria
from ranking_system rs
join ranking_criteria rc on rc.ranking_system_id = rs.id
group by rs.id, rs.system_name
order by numberOfCriteria desc;

--6
select university_id, university_name, year, student_staff_ratio
from university u
join university_year uy on uy.university_id = u.id
where year = 2015 and student_staff_ratio = (select MIN(student_staff_ratio) from university_year)

--7
WITH temp AS (
    SELECT DISTINCT u.id AS university_id, u.university_name, rc.id, rc.criteria_name, ury.year, ury.score
    FROM ranking_criteria AS rc
    INNER JOIN university_ranking_year AS ury ON rc.id = ury.ranking_criteria_id
    INNER JOIN university AS u ON ury.university_id = u.id
    INNER JOIN university_year AS uy ON u.id = uy.university_id
    WHERE rc.criteria_name = 'Teaching' AND ury.year = 2016
),
temp2 AS (
    SELECT score, COUNT(score) AS score_count
    FROM temp
    GROUP BY score
    HAVING COUNT(score) > 1
)
SELECT DISTINCT u.id AS university_id, u.university_name, rc.id, rc.criteria_name, ury.year, ury.score
FROM ranking_criteria AS rc
INNER JOIN university_ranking_year AS ury ON rc.id = ury.ranking_criteria_id
INNER JOIN university AS u ON ury.university_id = u.id
INNER JOIN university_year AS uy ON u.id = uy.university_id
WHERE rc.criteria_name = 'Teaching' AND ury.year = 2016 AND ury.score IN (SELECT score FROM temp2)
ORDER BY ury.score DESC;

--8
CREATE PROCEDURE proc_university_year    
    @pct_international_students INT,
	@year INT,
    @out INT OUTPUT
AS
BEGIN
set @out = (select COUNT(pct_international_students)
			FROM university_year
		 WHERE year = @year AND pct_international_students > @pct_international_students)
END

declare @out int
exec proc_university_year 2011, 30, @out output
select @out as NumberOfUniversity
--9
create trigger tr_insert_university_ranking on university_ranking_year 
for insert
as
begin
select university_id, university_name, ranking_criteria_id, criteria_name, year, score
from inserted i
join ranking_criteria rk on rk.id = i.ranking_criteria_id
join university u on u.id = i.university_id
end

--drop trigger tr_insert_university_ranking

insert into university_ranking_year(university_id, ranking_criteria_id, year, score) 
values (1,1,2020, 99),
(12,2,2020, 67);

--10
insert into ranking_system(id, system_name) values (4, 'QS World University Rankings');
insert into ranking_criteria(id, ranking_system_id, criteria_name) 
values (22, 4, 'Acedemic Reputation'),
	(23, 4, 'Citations per faculty');































































































































