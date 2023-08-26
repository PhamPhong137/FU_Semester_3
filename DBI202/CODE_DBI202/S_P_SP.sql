USE [master]
GO

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'S_P_SP')
BEGIN
	ALTER DATABASE [S_P_SP] SET OFFLINE WITH ROLLBACK IMMEDIATE;
	ALTER DATABASE [S_P_SP] SET ONLINE;
	DROP DATABASE [S_P_SP];
END

GO

CREATE DATABASE [S_P_SP]
GO

USE [S_P_SP]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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



/****** Object:  Table [dbo].[S]; //Supplier; Script Date: 28/09/2022 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[S](
	[SID] char(2) Primary Key,
	[Sname] [varchar](255) NOT NULL,
	[City] [varchar](255) NULL,
	[Status] int NULL
	)
GO

/****** Object:  Table [dbo].[P]; //Products; Script Date: 28/09/2022 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[P](
	[PID] char(2) Primary Key,
	[Pname] [varchar](255) NOT NULL,
	[Weight] [decimal](10, 2) NOT NULL,
	[Color] [varchar](255) NULL
	)
GO


/****** Object:  Table [dbo].[SP]    ; Script Date: 28/09/2022 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SP](
	[SID] char(2) NOT NULL,
	[PID] char(2) NOT NULL,
	[Quantity] [int] NULL,
	[Sdate] Date
	--Primary Key(SID,PID)
)
GO

INSERT [dbo].[S] ([SID], [Sname], [City], [Status]) VALUES ('S1', 'Santa Cruz Bikes', '3700 Portola Drive', 95060)
INSERT [dbo].[S] ([SID], [Sname], [City], [Status]) VALUES ('S2', 'Baldwin Bikes', '4200 Chestnut Lane', 11432)
INSERT [dbo].[S] ([SID], [Sname], [City], [Status]) VALUES ('S3', 'Rowlett Bikes', '8000 Fairway Avenue', 75088)
GO


INSERT [dbo].[P] ([PID], [Pname], [Weight], [Color]) VALUES ('P1', 'Trek 820 - 2016', CAST(379.99 AS Decimal(10, 2)), 'Red')
INSERT [dbo].[P] ([PID], [Pname], [Weight], [Color]) VALUES ('P2', 'Ritchey Timberwolf Frameset - 2016', CAST(749.99 AS Decimal(10, 2)), 'Brown')
INSERT [dbo].[P] ([PID], [Pname], [Weight], [Color]) VALUES ('P3', 'Surly Wednesday Frameset - 2016', CAST(999.99 AS Decimal(10, 2)), 'Black')
INSERT [dbo].[P] ([PID], [Pname], [Weight], [Color]) VALUES ('P4', 'Trek Fuel EX 8 29 - 2016', CAST(2899.99 AS Decimal(10, 2)), 'Red')
INSERT [dbo].[P] ([PID], [Pname], [Weight], [Color]) VALUES ('P5', 'Heller Shagamaw Frame - 2016', CAST(1320.99 AS Decimal(10, 2)), 'Brown')
INSERT [dbo].[P] ([PID], [Pname], [Weight], [Color]) VALUES ('P6', 'Surly Ice Cream Truck Frameset - 2016', CAST(469.99 AS Decimal(10, 2)), 'Black')
INSERT [dbo].[P] ([PID], [Pname], [Weight], [Color]) VALUES ('P7', 'Trek Slash 8 27.5 - 2016', CAST(3999.99 AS Decimal(10, 2)), 'Red')
INSERT [dbo].[P] ([PID], [Pname], [Weight], [Color]) VALUES ('P8', 'Trek Remedy 29 Carbon Frameset - 2016', CAST(1799.99 AS Decimal(10, 2)), 'Red')
INSERT [dbo].[P] ([PID], [Pname], [Weight], [Color]) VALUES ('P9', 'Trek Conduit+ - 2016', CAST(2999.99 AS Decimal(10, 2)), 'Red')
INSERT [dbo].[P] ([PID], [Pname], [Weight], [Color]) VALUES ('P0', 'Surly Straggler - 2016', CAST(1549.00 AS Decimal(10, 2)), 'Black')
GO


INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S1', 'P1', 27, '2023-01-01')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S1', 'P2', 5, '2022-01-21')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S1', 'P3', 6, '2023-01-26')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S1', 'P4', 23, '2022-03-19')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S1', 'P5', 22, '2023-01-20')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S1', 'P6', 20, '2022-12-03')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S1', 'P7', 8, '2023-02-22')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S1', 'P8', 30, '2023-02-22')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S1', 'P9', 11, '2022-05-10')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S1', 'P0', 15, '2023-01-13')

INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S2', 'P1', 14, '2022-10-3')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S2', 'P2', 16, '2023-01-18')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S2', 'P3', 28, '2023-01-29')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S2', 'P4', 2, '2023-01-05')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S2', 'P5', 1, '2022-01-31')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S2', 'P6', 11, '2023-01-06')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S2', 'P7', 8, '2022-01-04')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S2', 'P8', 1, '2023-01-17')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S2', 'P9', 17, '2023-01-29')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S2', 'P0', 13, '2023-01-28')

GO
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S3', 'P1', 14, '2022-08-06')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S3', 'P2', 24, '2023-01-3')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S3', 'P3', 10, '2022-01-29')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S3', 'P4', 11, '2023-01-26')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S3', 'P5', 3, '2022-03-19')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S3', 'P6', 27, '2023-01-28')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S3', 'P7', 12, '2023-01-20')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S3', 'P8', 12, '2023-01-18')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S3', 'P9', 23, '2022-05-18')
INSERT [dbo].[SP] ([SID], [PID], [quantity], [Sdate]) VALUES ('S3', 'P0', 21, '2022-09-26')
GO

/****** Object: Constraint ******/
ALTER TABLE [S_P_SP].[dbo].[SP]  WITH CHECK ADD FOREIGN KEY([PID])
REFERENCES [S_P_SP].[dbo].[P] ([PID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [S_P_SP].[dbo].[SP]  WITH CHECK ADD FOREIGN KEY([SID])
REFERENCES [S_P_SP].[dbo].[S] ([SID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO



