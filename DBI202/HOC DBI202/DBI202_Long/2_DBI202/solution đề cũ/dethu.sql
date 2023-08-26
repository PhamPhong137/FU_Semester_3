--Q2
select BookID,Title,AuthorName from Books
where AuthorName = 'Dan Bland'
--Q3
select l.LoanID, l.CardNo, bo.Name as BorrowerName,l.BookID,b.Title as BookTitle,l.ReturnDate
from Loans l join Borrower bo on l.CardNo = bo.CardNo
join Books b on l.BookID = b.BookID
where l.ReturnDate between '2016-10-01' and '2016-10-05'
--Q4
SELECT b.BookID, b.Title, b.AuthorName, p.ID as PublisherID, p.Name as PublisherName, br.BranchID, br.BranchName
FROM     Books AS b INNER JOIN
                  Copies AS c ON b.BookID = c.BookID INNER JOIN
                  Branch AS br ON c.BranchID = br.BranchID INNER JOIN
                  Publisher AS p ON b.PublisherID = p.ID
where br.BranchName = 'Central'
order by p.Name asc, b.AuthorName asc
--Q5
select l.BranchID, b.BranchName, count(*) as NumberOfLoans
FROM    Loans l INNER JOIN
              Branch b ON l.BranchID = b.BranchID
group by l.BranchID, b.BranchName
order by NumberOfLoans desc
--Q6
select top 1 p.ID as PublisherID, p.Name as PublisherName, count(*) as NumberOfBooks
FROM     Books AS b INNER JOIN
                  Publisher AS p ON b.PublisherID = p.ID
			group by p.ID, p.Name
				  order by count(*) desc
--Q8
create procedure Proc4_sp23
@AuthorName varchar(30),
@YearOut int,
@NumberOfLoans int output
as
begin 
select @NumberOfLoans = count(*) 
from Loans l 
join Books b on b.BookID = l.BookID
where b.AuthorName = @AuthorName and year(l.DateOut) = @YearOut 
end
drop procedure Proc4_sp23
declare @x int
exec Proc4_sp23 'Li Li', 2016, @x output
select @x as NumberOfLoans
--Q9
create trigger Tr4
on Loans
after insert
as begin
select i.LoanID,i.BookID,b.Title as 'Book Name',i.CardNo,br.Name as BorrowerName, i.DateOut
from inserted i join Books b on i.BookID = b.BookID
join Borrower br on i.CardNo = br.CardNo
end
INSERT INTO Loans (LoanID ,BookID ,BranchID ,CardNo ,DateOut ,DueDate ,ReturnDate)
VALUES (51, 20, 4, 5, '2016-09-04', NULL, NULL)
--q10
delete from Publisher where ID in(
SELECT ID
FROM     Books AS b full JOIN
                  Publisher AS p ON b.PublisherID = p.ID
				  where BookID is Null)

select * from Publisher

