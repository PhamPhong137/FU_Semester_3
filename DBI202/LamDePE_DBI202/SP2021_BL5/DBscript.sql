USE [master]
GO

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'PE_DBI202_Sp2021_B5')
BEGIN
	ALTER DATABASE [PE_DBI202_Sp2021_B5] SET OFFLINE WITH ROLLBACK IMMEDIATE;
	ALTER DATABASE [PE_DBI202_Sp2021_B5] SET ONLINE;
	DROP DATABASE [PE_DBI202_Sp2021_B5];
END

GO

CREATE DATABASE [PE_DBI202_Sp2021_B5]
GO

USE [PE_DBI202_Sp2021_B5]
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

/****** Object:  Table [dbo].[Countries]    Script Date: 26/04/2021 10:42:11 ******/
CREATE TABLE [dbo].[Countries](
	[CountryID] [varchar](10) NOT NULL primary key,
	[CountryName] [varchar](50) NULL,
	[RegionID] [int] NULL
)
GO
/****** Object:  Table [dbo].[Departments]    Script Date: 26/04/2021 10:42:11 ******/
CREATE TABLE [dbo].[Departments](
	[DepartmentID] [int] NOT NULL primary key,
	[DepartmentName] [varchar](50) NULL,
	[ManagerID] [int] NULL,
	[LocationID] [varchar](5) NULL
)
GO
/****** Object:  Table [dbo].[Employees]    Script Date: 26/04/2021 10:42:11 ******/
CREATE TABLE [dbo].[Employees](
	[EmployeeID] [int] NOT NULL primary key,
	[FirstName] [varchar](30) NULL,
	[LastName] [varchar](30) NULL,
	[Email] [varchar](50) NULL,
	[Phone] [varchar](20) NULL,
	[HireDate] [date] NULL,
	[JobID] [varchar](20) NULL,
	[Salary] [float] NULL,
	[Commission_pct] [float] NULL,
	[ManagerID] [int] NULL,
	[DepartmentID] [int] NULL
) 
GO
/****** Object:  Table [dbo].[Jobs]    Script Date: 26/04/2021 10:42:11 ******/
CREATE TABLE [dbo].[Jobs](
	[JobID] [varchar](20) NOT NULL primary key,
	[JobTitle] [varchar](100) NULL,
	[min_salary] [int] NULL,
	[max_salary] [int] NULL,
) 
GO
/****** Object:  Table [dbo].[Locations]    Script Date: 26/04/2021 10:42:11 ******/
CREATE TABLE [dbo].[Locations](
	[LocationID] [varchar](5) NOT NULL primary key,
	[StreetAddress] [varchar](100) NULL,
	[PostalCode] [varchar](20) NULL,
	[City] [varchar](30) NULL,
	[StateProvince] [varchar](30) NULL,
	[CountryID] [varchar](10) NULL
)
GO
/****** Object:  Table [dbo].[Regions]    Script Date: 26/04/2021 10:42:11 ******/
CREATE TABLE [dbo].[Regions](
	[RegionID] [int] NOT NULL primary key,
	[RegionName] [varchar](30) NULL
) ON [PRIMARY]
GO
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'AR', N'Argentina', 2)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'AU', N'Australia', 3)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'BE', N'Belgium', 1)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'BR', N'Brazil', 2)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'CA', N'Canada', 2)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'CH', N'Switzerland', 1)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'CN', N'China', 3)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'DE', N'Germany', 1)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'DK', N'Denmark', 1)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'EG', N'Egypt', 4)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'FR', N'France', 1)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'HK', N'HongKong', 3)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'IL', N'Israel', 4)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'IN', N'India', 3)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'IT', N'Italy', 1)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'JP', N'Japan', 3)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'KW', N'Kuwait', 4)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'MX', N'Mexico', 2)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'NG', N'Nigeria', 4)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'NL', N'Netherlands', 1)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'SG', N'Singapore', 3)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'UK', N'United Kingdom', 1)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'US', N'United States of America', 2)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'VN', N'Vietnam', 3)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'ZM', N'Zambia', 4)
INSERT [dbo].[Countries] ([CountryID], [CountryName], [RegionID]) VALUES (N'ZW', N'Zimbabwe', 4)
GO
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (10, N'Administration', NULL, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (20, N'Marketing', NULL, N'1800')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (30, N'Purchasing', 114, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (40, N'Human Resources', NULL, N'2400')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (50, N'Shipping', 121, N'1500')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (60, N'IT', 103, N'1400')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (70, N'Public Relations', NULL, N'2700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (80, N'Sales', 145, N'2500')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (90, N'Executive', 100, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (100, N'Finance', 108, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (110, N'Accounting', NULL, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (120, N'Treasury', NULL, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (130, N'Corporate Tax', NULL, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (140, N'Control And Credit', NULL, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (150, N'Shareholder Services', NULL, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (160, N'Benefits', NULL, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (170, N'Manufacturing', NULL, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (180, N'Construction', NULL, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (190, N'Contracting', NULL, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (200, N'Operations', NULL, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (210, N'IT Support', NULL, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (220, N'NOC', NULL, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (230, N'IT Helpdesk', NULL, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (240, N'Government Sales', NULL, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (250, N'Retail Sales', NULL, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (260, N'Recruiting', NULL, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (270, N'Payroll', NULL, N'1700')
INSERT [dbo].[Departments] ([DepartmentID], [DepartmentName], [ManagerID], [LocationID]) VALUES (280, N'ITC support', NULL, N'1800')
GO
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (100, N'Steven', N'King', N'SKING', N'515.123.4567', CAST(N'2003-06-17' AS Date), N'AD_PRES', 24000, 0, NULL, 90)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (101, N'Neena', N'Kochhar', N'NKOCHHAR', N'515.123.4568', CAST(N'2005-09-21' AS Date), N'AD_VP', 17000, 0, 100, 90)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (102, N'Lex', N'De Haan', N'LDEHAAN', N'515.123.4569', CAST(N'2001-01-13' AS Date), N'AD_VP', 17000, 0, 100, 90)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (103, N'Alexander', N'Hunold', N'AHUNOLD', N'590.423.4567', CAST(N'2006-01-03' AS Date), N'IT_PROG', 9000, 0, 102, 60)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (104, N'Bruce', N'Ernst', N'BERNST', N'590.423.4568', CAST(N'2007-05-21' AS Date), N'IT_PROG', 6000, 0, 103, 60)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (105, N'David', N'Austin', N'DAUSTIN', N'590.423.4569', CAST(N'2005-06-25' AS Date), N'IT_PROG', 4800, 0, 103, 60)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (106, N'Valli', N'Pataballa', N'VPATABAL', N'590.423.4560', CAST(N'2006-02-05' AS Date), N'IT_PROG', 4800, 0, 103, 60)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (107, N'Diana', N'Lorentz', N'DLORENTZ', N'590.423.5567', CAST(N'2007-02-07' AS Date), N'IT_PROG', 4200, 0, 103, 60)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (108, N'Nancy', N'Greenberg', N'NGREENBE', N'515.124.4569', CAST(N'2002-08-17' AS Date), N'FI_MGR', 12000, 0, 101, 100)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (109, N'Daniel', N'Faviet', N'DFAVIET', N'515.124.4169', CAST(N'2002-08-16' AS Date), N'FI_ACCOUNT', 9000, 0, 108, 100)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (110, N'John', N'Chen', N'JCHEN', N'515.124.4269', CAST(N'2005-09-28' AS Date), N'FI_ACCOUNT', 8200, 0, 108, 100)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (111, N'Ismael', N'Sciarra', N'ISCIARRA', N'515.124.4369', CAST(N'2005-09-30' AS Date), N'FI_ACCOUNT', 7700, 0, 108, 100)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (112, N'Jose', N'Manuel	Urman', N'JMURMAN', N'515.124.4469', CAST(N'2006-03-07' AS Date), N'FI_ACCOUNT', 7800, 0, 108, 100)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (113, N'Luis', N'Popp', N'LPOPP', N'515.124.4567', CAST(N'2007-12-07' AS Date), N'FI_ACCOUNT', 6900, 0, 108, 100)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (114, N'Den', N'Raphaely', N'DRAPHEAL', N'515.127.4561', CAST(N'2002-12-07' AS Date), N'PU_MAN', 11000, 0, 100, 30)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (115, N'Alexander', N'Khoo', N'AKHOO', N'515.127.4562', CAST(N'2003-05-18' AS Date), N'PU_CLERK', 3100, 0, 114, 30)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (116, N'Shelli', N'Baida', N'SBAIDA', N'515.127.4563', CAST(N'2005-12-24' AS Date), N'PU_CLERK', 2900, 0, 114, 30)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (117, N'Sigal', N'Tobias', N'STOBIAS', N'515.127.4564', CAST(N'2005-07-24' AS Date), N'PU_CLERK', 2800, 0, 114, 30)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (118, N'Guy', N'Himuro', N'GHIMURO', N'515.127.4565', CAST(N'2006-11-15' AS Date), N'PU_CLERK', 2600, 0, 114, 30)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (119, N'Karen', N'Colmenares', N'KCOLMENA', N'515.127.4566', CAST(N'2007-08-10' AS Date), N'PU_CLERK', 2500, 0, 114, 30)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (120, N'Matthew', N'Weiss', N'MWEISS', N'650.123.1234', CAST(N'2004-07-18' AS Date), N'ST_MAN', 8000, 0, 100, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (121, N'Adam', N'Fripp', N'AFRIPP', N'650.123.2234', CAST(N'2005-04-10' AS Date), N'ST_MAN', 8200, 0, 100, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (122, N'Payam', N'Kaufling', N'PKAUFLIN', N'650.123.3234', CAST(N'2003-05-01' AS Date), N'ST_MAN', 7900, 0, 100, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (123, N'Shanta', N'Vollman', N'SVOLLMAN', N'650.123.4234', CAST(N'2005-10-10' AS Date), N'ST_MAN', 6500, 0, 100, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (124, N'Kevin', N'Mourgos', N'KMOURGOS', N'650.123.5234', CAST(N'2007-11-16' AS Date), N'ST_MAN', 5800, 0, 100, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (125, N'Julia', N'Nayer', N'JNAYER', N'650.124.1214', CAST(N'2005-07-16' AS Date), N'ST_CLERK', 3200, 0, 120, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (126, N'Irene', N'Mikkilineni', N'IMIKKILI', N'650.124.1224', CAST(N'2006-09-28' AS Date), N'ST_CLERK', 2700, 0, 120, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (127, N'James', N'Landry', N'JLANDRY', N'650.124.1334', CAST(N'2007-01-14' AS Date), N'ST_CLERK', 2400, 0, 120, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (128, N'Steven', N'Markle', N'SMARKLE', N'650.124.1434', CAST(N'2008-03-08' AS Date), N'ST_CLERK', 2200, 0, 120, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (129, N'Laura', N'Bissot', N'LBISSOT', N'650.124.5234', CAST(N'2005-08-20' AS Date), N'ST_CLERK', 3300, 0, 121, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (130, N'Mozhe', N'Atkinson', N'MATKINSO', N'650.124.6234', CAST(N'2005-10-30' AS Date), N'ST_CLERK', 2800, 0, 121, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (131, N'James', N'Marlow', N'JAMRLOW', N'650.124.7234', CAST(N'2005-02-16' AS Date), N'ST_CLERK', 2500, 0, 121, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (132, N'TJ', N'Olson', N'TJOLSON', N'650.124.8234', CAST(N'2007-04-10' AS Date), N'ST_CLERK', 2100, 0, 121, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (133, N'Jason', N'Mallin', N'JMALLIN', N'6.501.271.934', CAST(N'2004-06-14' AS Date), N'ST_CLERK', 3300, 0, 122, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (134, N'Michael', N'Rogers', N'MROGERS', N'6.501.271.834', CAST(N'2006-08-26' AS Date), N'ST_CLERK', 2900, 0, 122, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (135, N'Ki', N'Gee', N'KGEE', N'6.501.271.734', CAST(N'2007-12-12' AS Date), N'ST_CLERK', 2400, 0, 122, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (136, N'Hazel', N'Philtanker', N'HPHILTAN', N'6.501.271.634', CAST(N'2008-06-02' AS Date), N'ST_CLERK', 2200, 0, 122, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (137, N'Renske', N'Ladwig', N'RLADWIG', N'6.501.211.234', CAST(N'2003-07-14' AS Date), N'ST_CLERK', 3600, 0, 123, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (138, N'Stephen', N'Stiles', N'SSTILES', N'6.501.212.034', CAST(N'2005-10-26' AS Date), N'ST_CLERK', 3200, 0, 123, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (139, N'John', N'Seo', N'JSEO', N'6.501.212.019', CAST(N'2006-02-12' AS Date), N'ST_CLERK', 2700, 0, 123, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (140, N'Joshua', N'Patel', N'JPATEL', N'6.501.211.834', CAST(N'2006-04-06' AS Date), N'ST_CLERK', 2500, 0, 123, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (141, N'Trenna', N'Rajs', N'TRAJS', N'6.501.218.009', CAST(N'2003-10-17' AS Date), N'ST_CLERK', 3500, 0, 124, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (142, N'Curtis', N'Davies', N'CDAVIES', N'6.501.212.994', CAST(N'2005-05-19' AS Date), N'ST_CLERK', 3100, 0, 124, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (143, N'Randall', N'Matos', N'RMATOS', N'6.501.212.874', CAST(N'2006-03-15' AS Date), N'ST_CLERK', 2600, 0, 124, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (144, N'Peter', N'Vargas', N'PVARGAS', N'6.501.212.004', CAST(N'2006-07-09' AS Date), N'ST_CLERK', 2500, 0, 124, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (145, N'John', N'Russell', N'JRUSSEL', N'011.44.1344.429268', CAST(N'2004-10-01' AS Date), N'SA_MAN', 14000, 0.4, 100, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (146, N'Karen', N'Partners', N'KPARTNER', N'011.44.1344.467268', CAST(N'2005-01-05' AS Date), N'SA_MAN', 13500, 0.3, 100, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (147, N'Alberto', N'Errazuriz', N'AERRAZUR', N'011.44.1344.429278', CAST(N'2005-03-10' AS Date), N'SA_MAN', 12000, 0.3, 100, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (148, N'Gerald', N'Cambrault', N'GCAMBRAU', N'011.44.1344.619268', CAST(N'2007-10-15' AS Date), N'SA_MAN', 11000, 0.3, 100, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (149, N'Eleni', N'Zlotkey', N'EZLOTKEY', N'011.44.1344.429018', CAST(N'2008-01-29' AS Date), N'SA_MAN', 10500, 0.2, 100, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (150, N'Peter', N'Tucker', N'PTUCKER', N'011.44.1344.129268', CAST(N'2005-01-30' AS Date), N'SA_REP', 10000, 0.3, 145, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (151, N'David', N'Bernstein', N'DBERNSTE', N'011.44.1344.345268', CAST(N'2005-03-24' AS Date), N'SA_REP', 9500, 0.25, 145, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (152, N'Peter', N'Hall', N'PHALL', N'011.44.1344.478968', CAST(N'2005-08-20' AS Date), N'SA_REP', 9000, 0.25, 145, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (153, N'Christopher', N'Olsen', N'COLSEN', N'011.44.1344.498718', CAST(N'2006-03-30' AS Date), N'SA_REP', 8000, 0.2, 145, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (154, N'Nanette', N'Cambrault', N'NCAMBRAU', N'011.44.1344.987668', CAST(N'2006-12-09' AS Date), N'SA_REP', 7500, 0.2, 145, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (155, N'Oliver', N'Tuvault', N'OTUVAULT', N'011.44.1344.486508', CAST(N'2007-11-23' AS Date), N'SA_REP', 7000, 0.15, 145, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (156, N'Janette', N'King', N'JKING', N'011.44.1345.429268', CAST(N'2004-01-30' AS Date), N'SA_REP', 10000, 0.35, 146, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (157, N'Patrick', N'Sully', N'PSULLY', N'011.44.1345.929268', CAST(N'2004-03-04' AS Date), N'SA_REP', 9500, 0.35, 146, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (158, N'Allan', N'McEwen', N'AMCEWEN', N'011.44.1345.829268', CAST(N'2004-08-01' AS Date), N'SA_REP', 9000, 0.35, 146, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (159, N'Lindsey', N'Smith', N'LSMITH', N'011.44.1345.729268', CAST(N'2005-03-10' AS Date), N'SA_REP', 8000, 0.3, 146, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (160, N'Louise', N'Doran', N'LDORAN', N'011.44.1345.629268', CAST(N'2005-12-15' AS Date), N'SA_REP', 7500, 0.3, 146, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (161, N'Sarath', N'Sewall', N'SSEWALL', N'011.44.1345.529268', CAST(N'2006-11-03' AS Date), N'SA_REP', 7000, 0.25, 146, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (162, N'Clara', N'Vishney', N'CVISHNEY', N'011.44.1346.129268', CAST(N'2005-11-11' AS Date), N'SA_REP', 10500, 0.25, 147, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (163, N'Danielle', N'Greene', N'DGREENE', N'011.44.1346.229268', CAST(N'2007-03-19' AS Date), N'SA_REP', 9500, 0.15, 147, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (164, N'Mattea', N'Marvins', N'MMARVINS', N'011.44.1346.329268', CAST(N'2008-01-24' AS Date), N'SA_REP', 7200, 0.1, 147, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (165, N'David', N'Lee', N'DLEE', N'011.44.1346.529268', CAST(N'2008-02-23' AS Date), N'SA_REP', 6800, 0.1, 147, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (166, N'Sundar', N'Ande', N'SANDE', N'011.44.1346.629268', CAST(N'2008-03-24' AS Date), N'SA_REP', 6400, 0.1, 147, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (167, N'Amit', N'Banda', N'ABANDA', N'011.44.1346.729268', CAST(N'2008-04-21' AS Date), N'SA_REP', 6200, 0.1, 147, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (168, N'Lisa', N'Ozer', N'LOZER', N'011.44.1343.929268', CAST(N'2005-03-11' AS Date), N'SA_REP', 11500, 0.25, 148, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (169, N'Harrison', N'Bloom', N'HBLOOM', N'011.44.1343.829268', CAST(N'2006-03-23' AS Date), N'SA_REP', 10000, 0.2, 148, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (170, N'Tayler', N'Fox', N'TFOX', N'011.44.1343.729268', CAST(N'2006-01-24' AS Date), N'SA_REP', 9600, 0.2, 148, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (171, N'William', N'Smith', N'WSMITH', N'011.44.1343.629268', CAST(N'2007-02-23' AS Date), N'SA_REP', 7400, 0.15, 148, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (172, N'Elizabeth', N'Bates', N'EBATES', N'011.44.1343.529268', CAST(N'2007-03-24' AS Date), N'SA_REP', 7300, 0.15, 148, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (173, N'Sundita', N'Kumar', N'SKUMAR', N'011.44.1343.329268', CAST(N'2008-04-21' AS Date), N'SA_REP', 6100, 0.1, 148, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (174, N'Ellen', N'Abel', N'EABEL', N'011.44.1644.429267', CAST(N'2004-05-11' AS Date), N'SA_REP', 11000, 0.3, 149, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (175, N'Alyssa', N'Hutton', N'AHUTTON', N'011.44.1644.429266', CAST(N'2005-03-19' AS Date), N'SA_REP', 8800, 0.25, 149, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (176, N'Jonathon', N'Taylor', N'JTAYLOR', N'011.44.1644.429265', CAST(N'2006-03-24' AS Date), N'SA_REP', 8600, 0.2, 149, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (177, N'Jack', N'Livingston', N'JLIVINGS', N'011.44.1644.429264', CAST(N'2006-04-23' AS Date), N'SA_REP', 8400, 0.2, 149, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (178, N'Kimberely', N'Grant', N'KGRANT', N'011.44.1644.429263', CAST(N'2007-05-24' AS Date), N'SA_REP', 7000, 0.15, 149, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (179, N'Charles', N'Johnson', N'CJOHNSON', N'011.44.1644.429262', CAST(N'2008-01-04' AS Date), N'SA_REP', 6200, 0.1, 149, 80)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (180, N'Winston', N'Taylor', N'WTAYLOR', N'6.505.079.876', CAST(N'2006-01-24' AS Date), N'SH_CLERK', 3200, 0, 120, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (181, N'Jean', N'Fleaur', N'JFLEAUR', N'6.505.079.877', CAST(N'2006-06-23' AS Date), N'SH_CLERK', 3100, 0, 120, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (182, N'Martha', N'Sullivan', N'MSULLIVA', N'6.505.079.878', CAST(N'2007-06-21' AS Date), N'SH_CLERK', 2500, 0, 120, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (183, N'Girard', N'Geoni', N'GGEONI', N'6.505.079.879', CAST(N'2008-02-03' AS Date), N'SH_CLERK', 2800, 0, 120, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (184, N'Nandita', N'Sarchand', N'NSARCHAN', N'6.505.091.876', CAST(N'2004-01-27' AS Date), N'SH_CLERK', 4200, 0, 121, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (185, N'Alexis', N'Bull', N'ABULL', N'6.505.092.876', CAST(N'2005-02-20' AS Date), N'SH_CLERK', 4100, 0, 121, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (186, N'Julia', N'Dellinger', N'JDELLING', N'6.505.093.876', CAST(N'2006-06-24' AS Date), N'SH_CLERK', 3400, 0, 121, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (187, N'Anthony', N'Cabrio', N'ACABRIO', N'6.505.094.876', CAST(N'2007-02-07' AS Date), N'SH_CLERK', 3000, 0, 121, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (188, N'Kelly', N'Chung', N'KCHUNG', N'6.505.051.876', CAST(N'2005-06-14' AS Date), N'SH_CLERK', 3800, 0, 122, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (189, N'Jennifer', N'Dilly', N'JDILLY', N'6.505.052.876', CAST(N'2005-08-13' AS Date), N'SH_CLERK', 3600, 0, 122, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (190, N'Timothy', N'Gates', N'TGATES', N'6.505.053.876', CAST(N'2006-07-11' AS Date), N'SH_CLERK', 2900, 0, 122, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (191, N'Randall', N'Perkins', N'RPERKINS', N'6.505.054.876', CAST(N'2007-12-19' AS Date), N'SH_CLERK', 2500, 0, 122, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (192, N'Sarah', N'Bell', N'SBELL', N'6.505.011.876', CAST(N'2004-02-04' AS Date), N'SH_CLERK', 4000, 0, 123, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (193, N'Britney', N'Everett', N'BEVERETT', N'6.505.012.876', CAST(N'2005-03-03' AS Date), N'SH_CLERK', 3900, 0, 123, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (194, N'Samuel', N'McCain', N'SMCCAIN', N'6.505.013.876', CAST(N'2006-07-01' AS Date), N'SH_CLERK', 3200, 0, 123, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (195, N'Vance', N'Jones', N'VJONES', N'6.505.014.876', CAST(N'2007-03-17' AS Date), N'SH_CLERK', 2800, 0, 123, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (196, N'Alana', N'Walsh', N'AWALSH', N'6.505.079.811', CAST(N'2006-04-24' AS Date), N'SH_CLERK', 3100, 0, 124, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (197, N'Kevin', N'Feeney', N'KFEENEY', N'6.505.079.822', CAST(N'2006-05-23' AS Date), N'SH_CLERK', 3000, 0, 124, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (198, N'Donald', N'OConnell', N'DOCONNEL', N'6.505.079.833', CAST(N'2007-06-21' AS Date), N'SH_CLERK', 2600, 0, 124, 50)
INSERT [dbo].[Employees] ([EmployeeID], [FirstName], [LastName], [Email], [Phone], [HireDate], [JobID], [Salary], [Commission_pct], [ManagerID], [DepartmentID]) VALUES (199, N'Douglas', N'Grant', N'DGRANT', N'6.505.079.844', CAST(N'2008-01-13' AS Date), N'SH_CLERK', 2600, 0, 124, 50)
GO
INSERT [dbo].[Jobs] ([JobID], [JobTitle], [min_salary], [max_salary]) VALUES (N'AC_ACCOUNT', N'Public Accountant', 4200, 9000)
INSERT [dbo].[Jobs] ([JobID], [JobTitle], [min_salary], [max_salary]) VALUES (N'AC_MGR', N'Accounting Manager', 8200, 16000)
INSERT [dbo].[Jobs] ([JobID], [JobTitle], [min_salary], [max_salary]) VALUES (N'AD_ASST', N'Administration Assistant', 3000, 6000)
INSERT [dbo].[Jobs] ([JobID], [JobTitle], [min_salary], [max_salary]) VALUES (N'AD_PRES', N'President', 20000, 40000)
INSERT [dbo].[Jobs] ([JobID], [JobTitle], [min_salary], [max_salary]) VALUES (N'AD_VP', N'Administration Vice President', 15000, 30000)
INSERT [dbo].[Jobs] ([JobID], [JobTitle], [min_salary], [max_salary]) VALUES (N'FI_ACCOUNT', N'Accountant', 4200, 9000)
INSERT [dbo].[Jobs] ([JobID], [JobTitle], [min_salary], [max_salary]) VALUES (N'FI_MGR', N'Finance Manager', 8200, 16000)
INSERT [dbo].[Jobs] ([JobID], [JobTitle], [min_salary], [max_salary]) VALUES (N'HR_REP', N'Human Resources Representative', 4000, 9000)
INSERT [dbo].[Jobs] ([JobID], [JobTitle], [min_salary], [max_salary]) VALUES (N'IT_PROG', N'Programmer', 4000, 10000)
INSERT [dbo].[Jobs] ([JobID], [JobTitle], [min_salary], [max_salary]) VALUES (N'MK_MAN', N'Marketing Manager', 9000, 15000)
INSERT [dbo].[Jobs] ([JobID], [JobTitle], [min_salary], [max_salary]) VALUES (N'MK_REP', N'Marketing Representative', 4000, 9000)
INSERT [dbo].[Jobs] ([JobID], [JobTitle], [min_salary], [max_salary]) VALUES (N'PU_CLERK', N'Purchasing Clerk', 2500, 5500)
INSERT [dbo].[Jobs] ([JobID], [JobTitle], [min_salary], [max_salary]) VALUES (N'PU_MAN', N'Purchasing Manager', 8000, 15000)
INSERT [dbo].[Jobs] ([JobID], [JobTitle], [min_salary], [max_salary]) VALUES (N'SA_MAN', N'Sales Manager', 10000, 20000)
INSERT [dbo].[Jobs] ([JobID], [JobTitle], [min_salary], [max_salary]) VALUES (N'SA_REP', N'Sales Representative', 6000, 12000)
INSERT [dbo].[Jobs] ([JobID], [JobTitle], [min_salary], [max_salary]) VALUES (N'SH_CLERK', N'Shipping Clerk', 2500, 5500)
INSERT [dbo].[Jobs] ([JobID], [JobTitle], [min_salary], [max_salary]) VALUES (N'ST_CLERK', N'Stock Clerk', 2000, 5000)
INSERT [dbo].[Jobs] ([JobID], [JobTitle], [min_salary], [max_salary]) VALUES (N'ST_MAN', N'Stock Manager', 5500, 8500)
GO
INSERT [dbo].[Locations] ([LocationID], [StreetAddress], [PostalCode], [City], [StateProvince], [CountryID]) VALUES (N'1100', N'93091 Calle della Testa', N'10934', N'Venice', NULL, N'IT')
INSERT [dbo].[Locations] ([LocationID], [StreetAddress], [PostalCode], [City], [StateProvince], [CountryID]) VALUES (N'1200', N'2017 Shinjuku-ku', N'1689', N'Tokyo', N'Tokyo Prefecture', N'JP')
INSERT [dbo].[Locations] ([LocationID], [StreetAddress], [PostalCode], [City], [StateProvince], [CountryID]) VALUES (N'1300', N'9450 Kamiya-cho', N'6823', N'Hiroshima', NULL, N'JP')
INSERT [dbo].[Locations] ([LocationID], [StreetAddress], [PostalCode], [City], [StateProvince], [CountryID]) VALUES (N'1400', N'2014 Jabberwocky Rd', N'26192', N'Southlake', N'Texas', N'US')
INSERT [dbo].[Locations] ([LocationID], [StreetAddress], [PostalCode], [City], [StateProvince], [CountryID]) VALUES (N'1500', N'2011 Interiors Blvd', N'99236', N'South San Francisco', N'California', N'US')
INSERT [dbo].[Locations] ([LocationID], [StreetAddress], [PostalCode], [City], [StateProvince], [CountryID]) VALUES (N'1600', N'2007 Zagora St', N'50090', N'South Brunswick', N'New Jersey', N'US')
INSERT [dbo].[Locations] ([LocationID], [StreetAddress], [PostalCode], [City], [StateProvince], [CountryID]) VALUES (N'1700', N'2004 Charade Rd', N'98199', N'Seattle', N'Washington', N'US')
INSERT [dbo].[Locations] ([LocationID], [StreetAddress], [PostalCode], [City], [StateProvince], [CountryID]) VALUES (N'1800', N'147 Spadina Ave', N'M5V 2L7', N'Toronto', N'Ontario', N'CA')
INSERT [dbo].[Locations] ([LocationID], [StreetAddress], [PostalCode], [City], [StateProvince], [CountryID]) VALUES (N'2000', N'40-5-12 Laogianggen', N'190518', N'Beijing', NULL, N'CN')
INSERT [dbo].[Locations] ([LocationID], [StreetAddress], [PostalCode], [City], [StateProvince], [CountryID]) VALUES (N'2200', N'12-98 Victoria Street', N'2901', N'Sydney', N'New South Wales', N'AU')
INSERT [dbo].[Locations] ([LocationID], [StreetAddress], [PostalCode], [City], [StateProvince], [CountryID]) VALUES (N'2300', N'198 Clementi North', N'540198', N'Singapore', NULL, N'SG')
INSERT [dbo].[Locations] ([LocationID], [StreetAddress], [PostalCode], [City], [StateProvince], [CountryID]) VALUES (N'2400', N'8204 Arthur St', NULL, N'London', NULL, N'UK')
INSERT [dbo].[Locations] ([LocationID], [StreetAddress], [PostalCode], [City], [StateProvince], [CountryID]) VALUES (N'2500', N'Magdalen Centre', N'OX9 9ZB', N'The Oxford', N'Oxford', N'UK')
INSERT [dbo].[Locations] ([LocationID], [StreetAddress], [PostalCode], [City], [StateProvince], [CountryID]) VALUES (N'2600', N'9702 Chester Road', N'9629850293', N'Stretford', N'Manchester', N'UK')
INSERT [dbo].[Locations] ([LocationID], [StreetAddress], [PostalCode], [City], [StateProvince], [CountryID]) VALUES (N'2700', N'Schwanthalerstr. 7031', N'80925', N'Munich', N'Bavaria', N'DE')
INSERT [dbo].[Locations] ([LocationID], [StreetAddress], [PostalCode], [City], [StateProvince], [CountryID]) VALUES (N'2900', N'20 Rue des Corps-Saints', N'1730', N'Geneva', N'Geneve', N'CH')
INSERT [dbo].[Locations] ([LocationID], [StreetAddress], [PostalCode], [City], [StateProvince], [CountryID]) VALUES (N'3000', N'Murtenstrasse 921', N'3095', N'Bern', N'BE', N'CH')
INSERT [dbo].[Locations] ([LocationID], [StreetAddress], [PostalCode], [City], [StateProvince], [CountryID]) VALUES (N'3100', N'Pieter Breughelstraat 837', N'3029SK', N'Utrecht', N'Utrecht', N'NL')
GO
INSERT [dbo].[Regions] ([RegionID], [RegionName]) VALUES (1, N'Europe')
INSERT [dbo].[Regions] ([RegionID], [RegionName]) VALUES (2, N'Americas')
INSERT [dbo].[Regions] ([RegionID], [RegionName]) VALUES (3, N'Asia')
INSERT [dbo].[Regions] ([RegionID], [RegionName]) VALUES (4, N'Middle East and Africa')
INSERT [dbo].[Regions] ([RegionID], [RegionName]) VALUES (5, N'Africa')
GO
ALTER TABLE [dbo].[Countries]  WITH CHECK ADD FOREIGN KEY([RegionID])
REFERENCES [dbo].[Regions] ([RegionID])
GO
ALTER TABLE [dbo].[Departments]  WITH CHECK ADD FOREIGN KEY([LocationID])
REFERENCES [dbo].[Locations] ([LocationID])
GO
ALTER TABLE [dbo].[Departments]  WITH CHECK ADD FOREIGN KEY([ManagerID])
REFERENCES [dbo].[Employees] ([EmployeeID])
GO
ALTER TABLE [dbo].[Employees]  WITH CHECK ADD FOREIGN KEY([DepartmentID])
REFERENCES [dbo].[Departments] ([DepartmentID])
GO
ALTER TABLE [dbo].[Employees]  WITH CHECK ADD FOREIGN KEY([JobID])
REFERENCES [dbo].[Jobs] ([JobID])
GO
ALTER TABLE [dbo].[Employees]  WITH CHECK ADD FOREIGN KEY([ManagerID])
REFERENCES [dbo].[Employees] ([EmployeeID])
GO
ALTER TABLE [dbo].[Locations]  WITH CHECK ADD FOREIGN KEY([CountryID])
REFERENCES [dbo].[Countries] ([CountryID])
GO