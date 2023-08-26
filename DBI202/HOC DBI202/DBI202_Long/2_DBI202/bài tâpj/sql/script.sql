USE [master]
GO
/****** Object:  Database [football club]    Script Date: 27/02/2023 9:05:17 SA ******/
CREATE DATABASE [football club]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'football club', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.N1NE\MSSQL\DATA\football club.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'football club_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.N1NE\MSSQL\DATA\football club_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [football club] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [football club].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [football club] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [football club] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [football club] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [football club] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [football club] SET ARITHABORT OFF 
GO
ALTER DATABASE [football club] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [football club] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [football club] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [football club] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [football club] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [football club] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [football club] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [football club] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [football club] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [football club] SET  DISABLE_BROKER 
GO
ALTER DATABASE [football club] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [football club] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [football club] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [football club] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [football club] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [football club] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [football club] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [football club] SET RECOVERY FULL 
GO
ALTER DATABASE [football club] SET  MULTI_USER 
GO
ALTER DATABASE [football club] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [football club] SET DB_CHAINING OFF 
GO
ALTER DATABASE [football club] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [football club] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [football club] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [football club] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'football club', N'ON'
GO
ALTER DATABASE [football club] SET QUERY_STORE = OFF
GO
USE [football club]
GO
/****** Object:  Table [dbo].[Club]    Script Date: 27/02/2023 9:05:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Club](
	[Name] [nchar](10) NULL,
	[CLub_id] [int] NOT NULL,
	[Stadium] [nchar](10) NULL,
	[Financial] [int] NULL,
	[Schedule] [date] NOT NULL,
	[League_id] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Club] PRIMARY KEY CLUSTERED 
(
	[CLub_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Contract]    Script Date: 27/02/2023 9:05:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contract](
	[Player_number] [int] NULL,
	[Wage] [int] NULL,
	[Value] [int] NULL,
	[Expire_date] [date] NULL,
	[Player_id] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Player_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[League]    Script Date: 27/02/2023 9:05:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[League](
	[Name] [nchar](10) NULL,
	[League_id] [nchar](10) NOT NULL,
	[Nation] [nchar](10) NULL,
 CONSTRAINT [PK_League] PRIMARY KEY CLUSTERED 
(
	[League_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Manager]    Script Date: 27/02/2023 9:05:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Manager](
	[Name] [nchar](10) NULL,
	[Role] [nchar](10) NULL,
	[Manager_id] [int] NOT NULL,
	[Nation] [nchar](10) NULL,
	[Club_id] [int] NOT NULL,
 CONSTRAINT [PK_Manager] PRIMARY KEY CLUSTERED 
(
	[Manager_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Player]    Script Date: 27/02/2023 9:05:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Player](
	[Name] [nchar](10) NOT NULL,
	[Number] [int] NULL,
	[Nation] [nchar](10) NULL,
	[Fitness] [nchar](10) NULL,
	[Foot] [nchar](10) NULL,
	[Player_id] [varchar](20) NOT NULL,
	[Club_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Player_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Schedule]    Script Date: 27/02/2023 9:05:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Schedule](
	[Date] [date] NOT NULL,
	[VsClub] [varchar](20) NOT NULL,
	[Stadium] [varchar](20) NOT NULL,
	[League_id] [nchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Date] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tranfer]    Script Date: 27/02/2023 9:05:17 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tranfer](
	[Value] [int] NULL,
	[From_club] [nchar](10) NULL,
	[Date_sign] [date] NULL,
	[Tranfer_id] [nchar](10) NOT NULL,
	[Player_name] [nchar](10) NULL,
	[Club_id] [int] NOT NULL,
	[Player_id] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Tranfer] PRIMARY KEY CLUSTERED 
(
	[Tranfer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Club]  WITH CHECK ADD FOREIGN KEY([League_id])
REFERENCES [dbo].[League] ([League_id])
GO
ALTER TABLE [dbo].[Manager]  WITH CHECK ADD FOREIGN KEY([Club_id])
REFERENCES [dbo].[Club] ([CLub_id])
GO
ALTER TABLE [dbo].[Player]  WITH CHECK ADD FOREIGN KEY([Club_id])
REFERENCES [dbo].[Club] ([CLub_id])
GO
ALTER TABLE [dbo].[Player]  WITH CHECK ADD FOREIGN KEY([Player_id])
REFERENCES [dbo].[Contract] ([Player_id])
GO
ALTER TABLE [dbo].[Schedule]  WITH CHECK ADD FOREIGN KEY([League_id])
REFERENCES [dbo].[League] ([League_id])
GO
ALTER TABLE [dbo].[Tranfer]  WITH CHECK ADD FOREIGN KEY([Club_id])
REFERENCES [dbo].[Club] ([CLub_id])
GO
ALTER TABLE [dbo].[Tranfer]  WITH CHECK ADD FOREIGN KEY([Club_id])
REFERENCES [dbo].[Club] ([CLub_id])
GO
ALTER TABLE [dbo].[Tranfer]  WITH CHECK ADD FOREIGN KEY([Player_id])
REFERENCES [dbo].[Player] ([Player_id])
GO
USE [master]
GO
ALTER DATABASE [football club] SET  READ_WRITE 
GO
