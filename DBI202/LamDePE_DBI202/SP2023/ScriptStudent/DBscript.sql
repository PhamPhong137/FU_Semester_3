USE [master]
GO

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'PE_DBI202_Sp2023')
BEGIN
	ALTER DATABASE PE_DBI202_Sp2023 SET OFFLINE WITH ROLLBACK IMMEDIATE;
	ALTER DATABASE PE_DBI202_Sp2023 SET ONLINE;
	DROP DATABASE PE_DBI202_Sp2023;
END

GO

CREATE DATABASE PE_DBI202_Sp2023
GO

USE PE_DBI202_Sp2023
GO

/*******************************************************************************
	Drop tables if exists
*******************************************************************************/
DECLARE @sql nvarchar(MAX) 
SET @sql = N'' 

SELECT @sql = @sql + N'ALTER TABLE ' + QUOTENAME(KCU1.TABLE_SCHEMA) 
    + N'.' + QUOTENAME(KCU1.TABLE_NAME) 
    + N' DROP CONSTRAINT ' -- + QUOTENAME(rc.CONSTRAINT_SCHEMA)  + N'.'  -- not in MS-SQL
    + QUOTENAME(rc.CONSTRAINT_NAME) + N'; ' + CHAR(13) + CHAR(10) 
FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS AS RC 

INNER JOIN INFORMATION_SCHEMA.KEY_COLUMN_USAGE AS KCU1 
    ON KCU1.CONSTRAINT_CATALOG = RC.CONSTRAINT_CATALOG  
    AND KCU1.CONSTRAINT_SCHEMA = RC.CONSTRAINT_SCHEMA 
    AND KCU1.CONSTRAINT_NAME = RC.CONSTRAINT_NAME 

EXECUTE(@sql) 

GO
DECLARE @sql2 NVARCHAR(max)=''

SELECT @sql2 += ' Drop table ' + QUOTENAME(TABLE_SCHEMA) + '.'+ QUOTENAME(TABLE_NAME) + '; '
FROM   INFORMATION_SCHEMA.TABLES
WHERE  TABLE_TYPE = 'BASE TABLE'

Exec Sp_executesql @sql2 
GO 

/****** Object:  Table [dbo].[Books]    Script Date: 19/08/2021 00:25:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Books](
	[BookID] [int] NOT NULL primary key,
	[Title] [varchar](30) NULL,
	[AuthorName] [varchar](30) NULL,
	[PublisherID] [int] NULL
)
GO
/****** Object:  Table [dbo].[Borrower]    Script Date: 19/08/2021 00:25:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Borrower](
	[CardNo] [int] NOT NULL primary key,
	[Name] [varchar](30) NULL,
	[Address] [varchar](50) NULL,
	[Phone] [varchar](10) NULL
)
GO
/****** Object:  Table [dbo].[Branch]    Script Date: 19/08/2021 00:25:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Branch](
	[BranchID] [int] NOT NULL primary key,
	[BranchName] [varchar](30) NULL,
	[Address] [varchar](30) NULL
)
GO
/****** Object:  Table [dbo].[Copies]    Script Date: 19/08/2021 00:25:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Copies](
	[BookID] [int] NOT NULL,
	[BranchID] [int] NOT NULL,
	[No_Of_Copies] [int] NULL,
	primary key (BookID, BranchID)
)
GO
/****** Object:  Table [dbo].[Loans]    Script Date: 19/08/2021 00:25:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Loans](
	[LoanID] [int] NOT NULL primary key,
	[BookID] [int] NULL,
	[BranchID] [int] NULL,
	[CardNo] [int] NULL,
	[DateOut] [date] NULL,
	[DueDate] [date] NULL,
	[ReturnDate] [date] NULL
)
GO
/****** Object:  Table [dbo].[Publisher]    Script Date: 19/08/2021 00:25:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Publisher](
	[ID] [int] NOT NULL primary key,
	[Name] [varchar](30) NULL,
	[Address] [varchar](30) NULL
)
GO
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (1, N'The Lost Tribe', N'John Smyth', 21)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (2, N'How to Sew Buttons', N'Jane Do', 1)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (3, N'The Terrible Night', N'Eleanor Mellors', 3)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (4, N'Mindy''s Mittens', N'Heidi Holly', 2)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (5, N'Pizza and Donuts Diet', N'Chef Jeff', 4)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (6, N'101 Cat House Plans', N'Bart Brat', 5)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (7, N'Self-Help for Dummies', N'Jen Jones', 1)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (8, N'Land of Lemurs', N'Carol Sims', 7)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (9, N'Go For It!', N'Li Li', 8)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (10, N'Farming for Nerds', N'Dr. Dirt', 9)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (11, N'They Are Us', N'Mantek Klem', 10)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (12, N'Here We Go!', N'Kit Townsend', 11)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (13, N'Spanish for Nurses', N'Laura Lloras', 12)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (14, N'Tacos Everyday', N'Sara Carr', 13)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (15, N'One Minute Rule', N'Jens Kopek', 23)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (16, N'Apples to Oranges', N'Jim Jordan', 15)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (17, N'Tiger Mountain', N'Silas Lambert', 3)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (18, N'How Cookies Crumble', N'Barbara Bull', 17)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (19, N'Bridge to Yesterday', N'Dan Bland', 18)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (20, N'The Lemonade Stand', N'Stephen King', 19)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (21, N'Hello World', N'A. Nonymous', 24)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (22, N'Yoga for Moms', 'Laurie Gelman', 25)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (23, N'The Red Balloon', 'Dan Bland', 26)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (24, N'Make Art Not War', 'Huge Grant', 27)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (25, N'War of Words', 'Peter Wood', 3)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (26, N'Green Smoothies for Kids', 'Mary Janson', 29)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (27, N'History of Jars', 'David Belman', 30)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (28, N'365 Dinner Ideas', 'Davis Peterson', 31)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (29, N'Untitled Champion', 'Caroline Smith', 32)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (30, N'Running in Thailand', 'Charly Jackson', 33)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (31, N'Swimming After Dark', 'Harry Simon', 34)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (32, N'Don''t Pet the Shark', 'Sally Wood', 35)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (33, N'Is Your Dog Walking You?', 'Holly Summer', 4)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (34, N'Tips for Success', 'Autumn Pink', 37)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (35, N'Learn to Type', 'Timothy Smith', 38)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (36, N'Tennis for Seniors', 'Susan Swallow', 39)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (37, N'Zumba at the Zoo', 'Michel Peter', 41)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (38, N'Xavier and the Zebra', 'Xavier Simon', 41)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (39, N'You Can Do It!', 'Jack White', 42)
INSERT [dbo].[Books] ([BookID], [Title], [AuthorName], [PublisherID]) VALUES (40, N'The Best Day Ever', 'Micheal Black', 43)
GO
INSERT [dbo].[Borrower] ([CardNo], [Name], [Address], [Phone]) VALUES (1, N'Charlie Brown', N'27 Main St', N'555-5123')
INSERT [dbo].[Borrower] ([CardNo], [Name], [Address], [Phone]) VALUES (2, N'Rachel Rigby', N'101 Hwy 22', N'688-7711')
INSERT [dbo].[Borrower] ([CardNo], [Name], [Address], [Phone]) VALUES (3, N'Nancy Drew', N'5678 Oak St', N'555-3467')
INSERT [dbo].[Borrower] ([CardNo], [Name], [Address], [Phone]) VALUES (4, N'Derek Jones', N'6789 Ritmo Cir', N'222-1234')
INSERT [dbo].[Borrower] ([CardNo], [Name], [Address], [Phone]) VALUES (5, N'Howie Han', N'111 First Ave', N'234-5678')
INSERT [dbo].[Borrower] ([CardNo], [Name], [Address], [Phone]) VALUES (6, N'Tim Tegulpas', N'432 Nebraska Ave', N'987-6543')
INSERT [dbo].[Borrower] ([CardNo], [Name], [Address], [Phone]) VALUES (7, N'Sam Semel', N'7688 Hedge Ct', N'777-9898')
INSERT [dbo].[Borrower] ([CardNo], [Name], [Address], [Phone]) VALUES (8, N'Evan Mann', N'4545 Court St', N'899-9090')
INSERT [dbo].[Borrower] ([CardNo], [Name], [Address], [Phone]) VALUES (9, N'Sally Short', N'323 Remington St', N'767-8991')
INSERT [dbo].[Borrower] ([CardNo], [Name], [Address], [Phone]) VALUES (10, N'Bob Biggs', N'227 South St', NULL)
GO
INSERT [dbo].[Branch] ([BranchID], [BranchName], [Address]) VALUES (1, N'Central', N'10 Main St')
INSERT [dbo].[Branch] ([BranchID], [BranchName], [Address]) VALUES (2, N'Sharpstown', N'25 Pine St')
INSERT [dbo].[Branch] ([BranchID], [BranchName], [Address]) VALUES (3, N'River', N'333 River Rd')
INSERT [dbo].[Branch] ([BranchID], [BranchName], [Address]) VALUES (4, N'Field', N'45 Field St')
GO
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (1, 1, 7)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (1, 2, 2)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (2, 2, 7)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (3, 3, 5)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (4, 4, 10)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (5, 1, 9)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (6, 2, 10)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (7, 3, 5)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (8, 4, 8)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (9, 1, 8)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (10, 2, 2)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (11, 3, 5)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (12, 4, 8)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (13, 1, 10)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (14, 2, 9)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (15, 3, 7)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (16, 4, 3)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (17, 1, 5)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (18, 2, 6)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (19, 3, 8)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (20, 1, 6)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (20, 4, 10)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (21, 1, 10)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (22, 2, 8)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (23, 3, 5)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (24, 4, 6)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (25, 1, 7)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (26, 2, 2)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (27, 3, 4)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (28, 4, 5)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (29, 1, 3)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (30, 2, 7)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (31, 3, 8)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (32, 4, 9)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (33, 1, 10)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (34, 2, 10)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (35, 3, 10)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (36, 4, 8)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (37, 1, 8)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (38, 2, 9)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (39, 3, 5)
INSERT [dbo].[Copies] ([BookID], [BranchID], [No_Of_Copies]) VALUES (40, 4, 6)
GO
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (1, 1, 1, 4, CAST(N'2016-08-19' AS Date), CAST(N'2016-09-19' AS Date), CAST(N'2016-08-30' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (2, 2, 2, 4, CAST(N'2016-08-19' AS Date), CAST(N'2016-09-19' AS Date), CAST(N'2016-09-20' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (3, 3, 3, 4, CAST(N'2016-08-19' AS Date), CAST(N'2016-09-19' AS Date), CAST(N'2016-08-29' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (4, 4, 4, 4, CAST(N'2016-08-19' AS Date), CAST(N'2016-09-19' AS Date), CAST(N'2016-09-14' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (5, 5, 1, 4, CAST(N'2016-08-19' AS Date), CAST(N'2016-09-19' AS Date), CAST(N'2016-09-10' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (6, 6, 2, 2, CAST(N'2016-09-18' AS Date), CAST(N'2016-10-18' AS Date), CAST(N'2016-10-20' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (7, 7, 3, 2, CAST(N'2016-09-18' AS Date), CAST(N'2016-10-18' AS Date), CAST(N'2016-10-20' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (8, 8, 4, 2, CAST(N'2016-09-18' AS Date), CAST(N'2016-10-18' AS Date), CAST(N'2016-10-10' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (9, 9, 1, 2, CAST(N'2016-09-18' AS Date), CAST(N'2016-10-18' AS Date), CAST(N'2016-10-09' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (10, 10, 2, 2, CAST(N'2016-09-18' AS Date), CAST(N'2016-10-18' AS Date), CAST(N'2016-10-05' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (11, 11, 3, 5, CAST(N'2016-09-11' AS Date), CAST(N'2016-10-11' AS Date), CAST(N'2016-09-20' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (12, 12, 4, 5, CAST(N'2016-09-11' AS Date), CAST(N'2016-10-11' AS Date), CAST(N'2016-09-26' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (13, 13, 1, 5, CAST(N'2016-09-11' AS Date), CAST(N'2016-10-11' AS Date), CAST(N'2016-10-10' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (14, 14, 2, 3, CAST(N'2016-09-13' AS Date), CAST(N'2016-10-13' AS Date), CAST(N'2016-10-16' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (15, 15, 3, 9, CAST(N'2016-09-11' AS Date), CAST(N'2016-10-11' AS Date), CAST(N'2016-10-11' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (16, 16, 4, 1, CAST(N'2016-05-12' AS Date), CAST(N'2016-06-12' AS Date), CAST(N'2016-06-07' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (17, 17, 1, 6, CAST(N'2016-09-13' AS Date), CAST(N'2016-10-13' AS Date), CAST(N'2016-10-14' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (18, 18, 2, 6, CAST(N'2016-09-13' AS Date), CAST(N'2016-10-13' AS Date), CAST(N'2016-10-09' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (19, 19, 3, 6, CAST(N'2016-09-13' AS Date), CAST(N'2016-10-13' AS Date), CAST(N'2016-10-15' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (20, 20, 4, 7, CAST(N'2016-09-12' AS Date), CAST(N'2016-10-12' AS Date), CAST(N'2016-10-07' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (21, 21, 1, 7, CAST(N'2016-09-13' AS Date), CAST(N'2016-10-13' AS Date), CAST(N'2016-10-08' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (22, 1, 2, 7, CAST(N'2016-09-13' AS Date), CAST(N'2016-10-13' AS Date), CAST(N'2016-10-09' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (23, 2, 3, 7, CAST(N'2016-09-13' AS Date), CAST(N'2016-10-13' AS Date), CAST(N'2016-10-08' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (24, 4, 4, 9, CAST(N'2016-09-09' AS Date), CAST(N'2016-10-09' AS Date), CAST(N'2016-10-11' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (25, 5, 1, 9, CAST(N'2016-09-09' AS Date), CAST(N'2016-10-09' AS Date), CAST(N'2016-10-10' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (26, 6, 2, 9, CAST(N'2016-09-09' AS Date), CAST(N'2016-10-09' AS Date), CAST(N'2016-10-04' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (27, 7, 3, 8, CAST(N'2016-09-10' AS Date), CAST(N'2016-10-10' AS Date), CAST(N'2016-10-05' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (28, 8, 4, 8, CAST(N'2016-09-10' AS Date), CAST(N'2016-10-10' AS Date), CAST(N'2016-10-05' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (29, 9, 1, 4, CAST(N'2016-09-08' AS Date), CAST(N'2016-10-08' AS Date), CAST(N'2016-10-03' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (30, 10, 2, 4, CAST(N'2016-09-08' AS Date), CAST(N'2016-10-08' AS Date), CAST(N'2016-10-09' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (31, 11, 3, 4, CAST(N'2016-09-08' AS Date), CAST(N'2016-10-08' AS Date), CAST(N'2016-10-03' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (32, 12, 4, 4, CAST(N'2016-09-08' AS Date), CAST(N'2016-10-08' AS Date), CAST(N'2016-10-03' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (33, 13, 1, 3, CAST(N'2016-09-07' AS Date), CAST(N'2016-10-07' AS Date), CAST(N'2016-10-02' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (34, 14, 2, 3, CAST(N'2016-09-07' AS Date), CAST(N'2016-10-07' AS Date), CAST(N'2016-10-02' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (35, 15, 3, 3, CAST(N'2016-09-07' AS Date), CAST(N'2016-10-07' AS Date), CAST(N'2016-10-03' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (36, 16, 4, 2, CAST(N'2016-09-05' AS Date), CAST(N'2016-10-05' AS Date), CAST(N'2016-09-30' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (37, 17, 1, 2, CAST(N'2016-09-05' AS Date), CAST(N'2016-10-05' AS Date), CAST(N'2016-10-06' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (38, 18, 2, 2, CAST(N'2016-09-05' AS Date), CAST(N'2016-10-05' AS Date), CAST(N'2016-09-30' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (39, 19, 3, 5, CAST(N'2016-09-04' AS Date), CAST(N'2016-10-04' AS Date), CAST(N'2016-09-29' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (40, 20, 4, 5, CAST(N'2016-09-04' AS Date), CAST(N'2016-10-04' AS Date), CAST(N'2016-09-29' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (41, 21, 1, 5, CAST(N'2016-09-04' AS Date), CAST(N'2016-10-04' AS Date), CAST(N'2016-09-29' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (42, 22, 2, 5, CAST(N'2016-09-04' AS Date), CAST(N'2016-10-04' AS Date), CAST(N'2016-09-29' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (43, 23, 3, 5, CAST(N'2016-09-04' AS Date), CAST(N'2016-10-04' AS Date), CAST(N'2016-09-29' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (44, 24, 4, 8, CAST(N'2016-09-03' AS Date), CAST(N'2016-10-03' AS Date), CAST(N'2016-09-28' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (45, 25, 1, 8, CAST(N'2016-09-03' AS Date), CAST(N'2016-10-03' AS Date), CAST(N'2016-10-04' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (46, 26, 2, 8, CAST(N'2016-09-03' AS Date), CAST(N'2016-10-03' AS Date), CAST(N'2016-09-29' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (47, 27, 3, 1, CAST(N'2016-05-12' AS Date), CAST(N'2016-06-12' AS Date), CAST(N'2016-06-14' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (48, 28, 4, 1, CAST(N'2016-05-12' AS Date), CAST(N'2016-06-12' AS Date), CAST(N'2016-06-07' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (49, 29, 1, 1, CAST(N'2016-05-12' AS Date), CAST(N'2016-06-12' AS Date), CAST(N'2016-06-07' AS Date))
INSERT [dbo].[Loans] ([LoanID], [BookID], [BranchID], [CardNo], [DateOut], [DueDate], [ReturnDate]) VALUES (50, 30, 2, 1, CAST(N'2016-05-12' AS Date), CAST(N'2016-06-12' AS Date), CAST(N'2016-06-08' AS Date))
GO
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (1, N'Singer', N'Germany')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (2, N'Newton', N'Boston')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (3, N'GST', N'New York')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (4, N'Loyly', N'Boston')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (5, N'Mews', N'Berkeley')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (6, N'Manx', N'Paris')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (7, N'Barr', N'New York')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (8, N'Higham', N'London')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (9, N'Ten Ton', N'Oakland')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (10, N'Cosmo', N'Portland')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (11, N'Hello', N'San Francisco')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (12, N'ANAA', N'Los Angeles')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (13, N'Chance', N'New York')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (14, N'Biz', N'New York')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (15, N'Famous', N'Long Island')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (16, N'North', N'Hartford')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (17, N'Bibi', N'Chicago')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (18, N'1999', N'Chicago')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (19, N'Yaya', N'Berkeley')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (20, N'Sunshine', N'Palo Alto')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (21, N'Jungle', N'New York')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (22, N'Dada', N'Chicago')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (23, N'BizBooks', N'Long Island')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (24, N'OOL', N'Los Angeles')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (25, N'Hatha', N'Hartford')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (26, N'JKL', N'New York')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (27, N'Phantom', N'Hartford')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (28, N'Trope', N'Long Island')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (29, N'Pops', N'Chicago')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (30, N'Glass', N'France')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (31, N'Grub', N'New York')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (32, N'Hart', N'Oakland')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (33, N'Bangkok', N'Los Angeles')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (34, N'Pullen', N'Oakland')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (35, N'Ocean', N'Portland')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (36, N'Pup', N'New York')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (37, N'Combs', N'France')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (38, N'HDT', N'Chicago')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (39, N'Whitehead', N'Long Island')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (40, N'Daily', N'Oakland')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (41, N'Park', N'New York')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (42, N'Best', N'Los Angeles')
INSERT [dbo].[Publisher] ([ID], [Name], [Address]) VALUES (43, N'Wolfe', N'Chicago')
GO
ALTER TABLE [dbo].[Books]  WITH CHECK ADD  CONSTRAINT [FK__Books__Publisher__2D27B809] FOREIGN KEY([PublisherID])
REFERENCES [dbo].[Publisher] ([ID])
GO
ALTER TABLE [dbo].[Books] CHECK CONSTRAINT [FK__Books__Publisher__2D27B809]
GO
ALTER TABLE [dbo].[Copies]  WITH CHECK ADD FOREIGN KEY([BookID])
REFERENCES [dbo].[Books] ([BookID])
GO
ALTER TABLE [dbo].[Copies]  WITH CHECK ADD FOREIGN KEY([BranchID])
REFERENCES [dbo].[Branch] ([BranchID])
GO
ALTER TABLE [dbo].[Loans]  WITH CHECK ADD  CONSTRAINT [FK__Loans__BookID__31EC6D26] FOREIGN KEY([BookID])
REFERENCES [dbo].[Books] ([BookID])
GO
ALTER TABLE [dbo].[Loans] CHECK CONSTRAINT [FK__Loans__BookID__31EC6D26]
GO
ALTER TABLE [dbo].[Loans]  WITH CHECK ADD  CONSTRAINT [FK__Loans__BranchID__32E0915F] FOREIGN KEY([BranchID])
REFERENCES [dbo].[Branch] ([BranchID])
GO
ALTER TABLE [dbo].[Loans] CHECK CONSTRAINT [FK__Loans__BranchID__32E0915F]
GO
ALTER TABLE [dbo].[Loans]  WITH CHECK ADD  CONSTRAINT [FK__Loans__CardNo__33D4B598] FOREIGN KEY([CardNo])
REFERENCES [dbo].[Borrower] ([CardNo])
GO
ALTER TABLE [dbo].[Loans] CHECK CONSTRAINT [FK__Loans__CardNo__33D4B598]
GO
USE [master]
GO

