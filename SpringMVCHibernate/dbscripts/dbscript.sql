USE [master]
GO

/****** Object:  Database [springmvchibernate]    Script Date: 3/29/2020 7:27:28 PM ******/
DROP DATABASE [springmvchibernate]
GO

/****** Object:  Database [springmvchibernate]    Script Date: 3/29/2020 7:27:28 PM ******/
CREATE DATABASE [springmvchibernate]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'springmvchibernate', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\springmvchibernate.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'springmvchibernate_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\springmvchibernate_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO

ALTER DATABASE [springmvchibernate] SET COMPATIBILITY_LEVEL = 120
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [springmvchibernate].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [springmvchibernate] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [springmvchibernate] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [springmvchibernate] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [springmvchibernate] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [springmvchibernate] SET ARITHABORT OFF 
GO

ALTER DATABASE [springmvchibernate] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [springmvchibernate] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [springmvchibernate] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [springmvchibernate] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [springmvchibernate] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [springmvchibernate] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [springmvchibernate] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [springmvchibernate] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [springmvchibernate] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [springmvchibernate] SET  DISABLE_BROKER 
GO

ALTER DATABASE [springmvchibernate] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [springmvchibernate] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [springmvchibernate] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [springmvchibernate] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [springmvchibernate] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [springmvchibernate] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [springmvchibernate] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [springmvchibernate] SET RECOVERY SIMPLE 
GO

ALTER DATABASE [springmvchibernate] SET  MULTI_USER 
GO

ALTER DATABASE [springmvchibernate] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [springmvchibernate] SET DB_CHAINING OFF 
GO

ALTER DATABASE [springmvchibernate] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [springmvchibernate] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO

ALTER DATABASE [springmvchibernate] SET DELAYED_DURABILITY = DISABLED 
GO

ALTER DATABASE [springmvchibernate] SET  READ_WRITE 
GO


USE [springmvchibernate]
GO

/****** Object:  Table [dbo].[customer]    Script Date: 3/29/2020 7:28:08 PM ******/
DROP TABLE [dbo].[customer]
GO

/****** Object:  Table [dbo].[customer]    Script Date: 3/29/2020 7:28:08 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[customer](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[first_name] [varchar](50) NULL,
	[last_name] [varchar](50) NULL,
	[email] [varchar](50) NULL,
 CONSTRAINT [PK_customer] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


