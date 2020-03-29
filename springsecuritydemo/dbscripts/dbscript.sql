USE [master]
GO

/****** Object:  Database [springsecurity]    Script Date: 1/21/2020 11:22:13 PM ******/
DROP DATABASE [springsecurity]
GO

/****** Object:  Database [springsecurity]    Script Date: 1/21/2020 11:22:13 PM ******/
CREATE DATABASE [springsecurity]
 CONTAINMENT = NONE
 ON  PRIMARY
( NAME = N'springsecurity', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\springsecurity.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON
( NAME = N'springsecurity_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\springsecurity_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO

ALTER DATABASE [springsecurity] SET COMPATIBILITY_LEVEL = 120
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [springsecurity].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [springsecurity] SET ANSI_NULL_DEFAULT OFF
GO

ALTER DATABASE [springsecurity] SET ANSI_NULLS OFF
GO

ALTER DATABASE [springsecurity] SET ANSI_PADDING OFF
GO

ALTER DATABASE [springsecurity] SET ANSI_WARNINGS OFF
GO

ALTER DATABASE [springsecurity] SET ARITHABORT OFF
GO

ALTER DATABASE [springsecurity] SET AUTO_CLOSE OFF
GO

ALTER DATABASE [springsecurity] SET AUTO_SHRINK OFF
GO

ALTER DATABASE [springsecurity] SET AUTO_UPDATE_STATISTICS ON
GO

ALTER DATABASE [springsecurity] SET CURSOR_CLOSE_ON_COMMIT OFF
GO

ALTER DATABASE [springsecurity] SET CURSOR_DEFAULT  GLOBAL
GO

ALTER DATABASE [springsecurity] SET CONCAT_NULL_YIELDS_NULL OFF
GO

ALTER DATABASE [springsecurity] SET NUMERIC_ROUNDABORT OFF
GO

ALTER DATABASE [springsecurity] SET QUOTED_IDENTIFIER OFF
GO

ALTER DATABASE [springsecurity] SET RECURSIVE_TRIGGERS OFF
GO

ALTER DATABASE [springsecurity] SET  DISABLE_BROKER
GO

ALTER DATABASE [springsecurity] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO

ALTER DATABASE [springsecurity] SET DATE_CORRELATION_OPTIMIZATION OFF
GO

ALTER DATABASE [springsecurity] SET TRUSTWORTHY OFF
GO

ALTER DATABASE [springsecurity] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO

ALTER DATABASE [springsecurity] SET PARAMETERIZATION SIMPLE
GO

ALTER DATABASE [springsecurity] SET READ_COMMITTED_SNAPSHOT OFF
GO

ALTER DATABASE [springsecurity] SET HONOR_BROKER_PRIORITY OFF
GO

ALTER DATABASE [springsecurity] SET RECOVERY SIMPLE
GO

ALTER DATABASE [springsecurity] SET  MULTI_USER
GO

ALTER DATABASE [springsecurity] SET PAGE_VERIFY CHECKSUM
GO

ALTER DATABASE [springsecurity] SET DB_CHAINING OFF
GO

ALTER DATABASE [springsecurity] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF )
GO

ALTER DATABASE [springsecurity] SET TARGET_RECOVERY_TIME = 0 SECONDS
GO

ALTER DATABASE [springsecurity] SET DELAYED_DURABILITY = DISABLED
GO

ALTER DATABASE [springsecurity] SET  READ_WRITE
GO

USE [springsecurity]
GO

/****** Object:  Table [dbo].[users]    Script Date: 1/21/2020 11:23:30 PM ******/
DROP TABLE [dbo].[users]
GO

/****** Object:  Table [dbo].[users]    Script Date: 1/21/2020 11:23:30 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[users](
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NULL,
	[enabled] [tinyint] NULL,
 CONSTRAINT [PK_users] PRIMARY KEY CLUSTERED
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


USE [springsecurity]
GO

ALTER TABLE [dbo].[authorities] DROP CONSTRAINT [FK_authorities_users]
GO

/****** Object:  Table [dbo].[authorities]    Script Date: 1/21/2020 11:24:05 PM ******/
DROP TABLE [dbo].[authorities]
GO

/****** Object:  Table [dbo].[authorities]    Script Date: 1/21/2020 11:24:05 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[authorities](
	[username] [varchar](50) NOT NULL,
	[authority] [varchar](50) NOT NULL,
 CONSTRAINT [IX_authorities] UNIQUE NONCLUSTERED
(
	[authority] ASC,
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[authorities]  WITH CHECK ADD  CONSTRAINT [FK_authorities_users] FOREIGN KEY([username])
REFERENCES [dbo].[users] ([username])
GO

ALTER TABLE [dbo].[authorities] CHECK CONSTRAINT [FK_authorities_users]
GO

USE [springsecurity]
GO

/****** sudip : test123, rimi : manager123, priyanka : admin123 ******/
INSERT INTO [dbo].[users]
           ([username]
           ,[password]
           ,[enabled])
     VALUES
           ('sudip'
           ,'{bcrypt}$2a$10$mRqnPAQJ/nJdS6ti0jR/FuTMS9HLETo9qQTn7j5OpWO0Gsx4D/fpC'
           ,1)
GO

INSERT INTO [dbo].[users]
           ([username]
           ,[password]
           ,[enabled])
     VALUES
           ('rimi'
           ,'{bcrypt}$2a$10$02Y78..kRX7la6pJiHxEw.71007lsviQqHBxaareFfeGJcKPkaOiC'
           ,1)
GO

INSERT INTO [dbo].[users]
           ([username]
           ,[password]
           ,[enabled])
     VALUES
           ('priyanka'
           ,'{bcrypt}$2a$10$6vpFJwfB7myc.yfIXMXr2eKp1ng9hIdqasZtTBcwN.4/mJWScUhKK'
           ,1)
GO

INSERT INTO [dbo].[authorities]
           ([username]
           ,[authority])
     VALUES
           ('SUDIP','ROLE_EMPLOYEE')
GO

INSERT INTO [dbo].[authorities]
           ([username]
           ,[authority])
     VALUES
           ('RIMI','ROLE_EMPLOYEE')
GO

INSERT INTO [dbo].[authorities]
           ([username]
           ,[authority])
     VALUES
           ('RIMI','ROLE_MANAGER')
GO

INSERT INTO [dbo].[authorities]
           ([username]
           ,[authority])
     VALUES
           ('Priyanka','ROLE_EMPLOYEE')
GO

INSERT INTO [dbo].[authorities]
           ([username]
           ,[authority])
     VALUES
           ('Priyanka','ROLE_ADMIN')
GO

