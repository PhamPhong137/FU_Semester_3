IF OBJECT_ID('Prod1', 'P') is not Null
	drop procedure Prod1;
Create procedure Prod1
 @PNumber int,
 @Pname NVarchar(50)
AS Update tblProject set proName = @Pname where proNum = @PNumber
select * from tblProject
select * from tblEmployee
Exec Prod1 1, N'ProjectA'
--ex2
Create procedure NoOfEmp @From_D Datetime, @To_D Datetime
as
begin
select * from tblEmployee where
empBirthdate >= @From_D and empBirthdate <= @To_D
end
go
exec NoOfEmp '1970-01-01', '1972-12-31'
--ex3 Display number of Employees wher birthdate from @From_D to @to_D
Create procedure NoOfEmp3 @From_D Datetime, @To_D Datetime, @NumberOfEmp int Output
as
begin
select @NumberOfEmp = count(*) from tblEmployee where
empBirthdate >= @From_D and empBirthdate <= @To_D
end
go 
declare @N int
Exec NoOfEmp3 '1970-01-01', '1979-12-31',@N output
print @N
-- CQ15.1: Write Procedure with name is 'Prod4' to list of Employee where DepartmentID is @DepNum
IF OBJECT_ID('Prod4', 'P') is not Null
	drop procedure Prod4;
create procedure Prod4
@DepNum int
as
begin
select *
from tblEmployee
where tblEmployee.depNum= @DepNum
end
go
Exec Prod4 @DepNum = 3
-- CQ15.2 :Write Procedure with name is 'ProdQ15_2' to display Number of Employees where DepartmentID is @DepNum input, @NoOfEmp Output
create procedure ProdQ15_2
    @DepNum int,
    @NoOfEmp int output
as
begin
    select @NoOfEmp = COUNT(*)
    from tblEmployee e
    where e.depNum = @DepNum
end
declare @Count int
exec ProdQ15_2 @DepNum = 2, @NoOfEmp = @Count output
Print @Count
--CQ151A: Write a procedure with name s "ProdCQ15_1A" to display List of Projects wher DepartmentID is @DepNum
create procedure ProdCQ15_1A
@DepNum int
as
begin
select *
from tblProject p
where p.depNum= @DepNum
end
go
Exec ProdCQ15_1A @DepNum = 3
