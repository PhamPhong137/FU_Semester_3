--1 
create table RentalCenters (
      	CenterCode varchar(30) primary key,
      	Phone varchar(20),
      	[Address] nvarchar(200)
)
 
create table Vehicles (
      	PlateNumber varchar(20) primary key,
      	Model nvarchar(100),
      	Producer nvarchar(100),
      	[Year] int
)
 
create table Customers (
      	customerID int primary key,
      	[Name] nvarchar (100),
      	Phone varchar(20)
)
 
create table Rent (
      	customerID int references Customers(customerID),
      	PlateNumber varchar(20) references Vehicles(PlateNumber),
      	CenterCode varchar(30) references RentalCenters(CenterCode),
      	fromTime Datetime,
      	toTime Datetime
      	primary key (customerID, PlateNumber, fromTime)
)



--2 Select all loans from the branch 1 where the DateOut are in September 2016 as follows
select *
from Loans
where year(DateOut) = 2016 and month(dateout) = 9 and BranchID=1

--3 Write a query to select LoanID, DateOut, BookID, Title, AuthorName, PublisherID  of all loans having the DateOut from 05th September 2016 to 12th September 2016 as follows:
SELECT l.LoanID, l.DateOut, b.BookID, b.Title, b.AuthorName, b.PublisherID
FROM Loans l join Books b on l.BookID = b.BookID
WHERE l.DateOut between '2016-09-05' and '2016-09-12'

--4 Write a query to display BookID, Title, AuthorName, PublisherName, BranchID, BranchName, No_Of_Copies corresponding to books in the 'Central' or 'Sharpstown' branches, display the results in desending order of BranchID then in ascending order of Title for rows of the same branch as follows:
SELECT bo.BookID, bo.Title, bo.AuthorName, p.Name as PublisherName , c.BranchID,b.BranchName, c.No_Of_Copies
FROM  Books AS bo INNER JOIN
      Copies AS c ON bo.BookID = c.BookID INNER JOIN
      Branch AS b ON c.BranchID = b.BranchID INNER JOIN
      Publisher AS p ON bo.PublisherID = p.ID

where b.BranchName='Central' or b.BranchName='Sharpstown'
order by  BranchID desc, bo.Title

--5 Write a query to display BookID, Title, AuthorName, PublisherName, TotalNumberOfCopies corresponding to each book having the TotalNumberOfCopies greater than or equal to 9; where the TotalNumberOfCopies of a book is the total number of copies of this book in all the branches.
SELECT b.BookID, b.Title, b.AuthorName,
p.[Name] as PublisherName,
sum(No_Of_Copies) as TotalNumberOfCopies
FROM Copies c join Books b on c.BookID = b.BookID
join Publisher p on b.PublisherID = p.ID
GROUP BY b.BookID, b.Title, b.AuthorName, p.[Name]
HAVING sum(No_Of_Copies) >=9




--6 Write a query to display BranchID, BranchName, Address, NumberOfLoans corresponding to the branches having the smallest and the highest number of loans in September 2016 as in the following figure. Note that NumberOfLoans of a branch is the number of loans made in September 2016 (based on DateOut) of this branch.
SELECT ba.BranchID, ba.BranchName, ba.[Address],
count(distinct l.LoanID) as NumberOfLoans
FROM Branch ba join Loans l on ba.BranchID = l.BranchID
WHERE YEAR(l.DateOut) = 2016
and MONTH(l.DateOut) = 9
GROUP BY ba.BranchID, ba.BranchName, ba.[Address]
HAVING count(distinct l.LoanID) =(SELECT top 1 count(distinct LoanID) FROM Loans
WHERE YEAR(DateOut) = 2016 and MONTH(DateOut) = 9
GROUP BY BranchID
ORDER BY count(distinct LoanID) desc)
or count(distinct l.LoanID) =(SELECT top 1 count(distinct LoanID) FROM Loans
WHERE YEAR(DateOut) = 2016
and MONTH(DateOut) = 9
GROUP BY BranchID
ORDER BY count(distinct LoanID) asc)



--7 Write a query to display, for each of the three publishers 'Singer', 'Newton' and 'GST', the total number of copies of books of the given publisher in each branch. Display the results with PublisherID, PublisherName, BranchID, BranchName, TotalNumberOfBookCopies as in the following figure. Note that in each row, the TotalNumberOfBookCopies is the total number of copies of all books of a given publisher in a given branch; TotalNumberOfBookCopies is NULL if the publisher has no book in the given branch.
with t as (
select p.ID as PublisherID, p.[Name] as PublisherName, ba.BranchID, ba.BranchName
from Publisher p, Branch ba
where p.[Name] = 'Singer'
or p.[Name] = 'Newton'
or p.[Name] = 'GST')
, t2 as (
select b.PublisherID, ba.BranchID, sum(c.No_Of_Copies) as TotalNumberOfBookCopies
from Books b, Copies c, Branch ba
where b.BookID = c.BookID and c.BranchID = ba.BranchID
group by b.PublisherID, ba.BranchID)
 
select t.PublisherID, t.PublisherName, t.BranchID, t.BranchName, t2.TotalNumberOfBookCopies
from t left join t2 on t.PublisherID = t2.PublisherID and t.BranchID = t2.BranchID



--8 Create a stored procedure named Proc2 for calculating the total number of copies of all books of a given publisher in all branches, where publisherID int is the input parameter of the procedure and TotalNumberOfCopies int is an output parameter of the procedure.
CREATE PROCEDURE Proc2
      	@publisherID int,
      	@TotalNumberOfCopies int output
AS
BEGIN
      	Select @TotalNumberOfCopies = Sum(c.No_Of_Copies)
      	FROM Books b left join Copies c on b.BookID = c.BookID
      	WHERE b.PublisherID = @publisherID
END


--9 Create a trigger named Tr2 for the delete statement on table Copies so that when we call a delete statement to remove one or more rows from the table Copies, instead of removing the rows from the table Copies, the system update the corresponding rows to set the No_Of_Copies to NULL.
create trigger Tr2 on Copies
instead of delete
as
begin
      	update Copies
      	set No_Of_Copies = NULL
      	where BookID in (select BookID from deleted)
end


--10 insert into Loans(LoanID, BookID, BranchID, CardNo, DateOut, DueDate) values (60, 13, 2, 1, '2023-03-02', '2023-03-12')
insert into Loans(LoanID, BookID, BranchID, CardNo, DateOut, DueDate)
values (60, 13, 2, 1, '2023-03-02', '2023-03-12')












