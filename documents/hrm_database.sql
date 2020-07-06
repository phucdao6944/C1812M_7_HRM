USE [master]
GO
/****** Object:  Database [hrm]    Script Date: 7/6/2020 8:02:14 PM ******/
CREATE DATABASE [hrm]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'hrm', FILENAME = N'D:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\hrm.ndf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'hrm_log', FILENAME = N'D:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\hrm_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [hrm] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [hrm].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [hrm] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [hrm] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [hrm] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [hrm] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [hrm] SET ARITHABORT OFF 
GO
ALTER DATABASE [hrm] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [hrm] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [hrm] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [hrm] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [hrm] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [hrm] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [hrm] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [hrm] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [hrm] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [hrm] SET  ENABLE_BROKER 
GO
ALTER DATABASE [hrm] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [hrm] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [hrm] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [hrm] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [hrm] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [hrm] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [hrm] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [hrm] SET RECOVERY FULL 
GO
ALTER DATABASE [hrm] SET  MULTI_USER 
GO
ALTER DATABASE [hrm] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [hrm] SET DB_CHAINING OFF 
GO
ALTER DATABASE [hrm] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [hrm] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [hrm] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'hrm', N'ON'
GO
ALTER DATABASE [hrm] SET QUERY_STORE = OFF
GO
USE [hrm]
GO
/****** Object:  Table [dbo].[insurances]    Script Date: 7/6/2020 8:02:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[insurances](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NOT NULL,
	[amount] [float] NOT NULL,
	[comment] [varchar](1000) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[log_times]    Script Date: 7/6/2020 8:02:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[log_times](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[start_date] [datetime] NOT NULL,
	[end_date] [datetime] NULL,
	[comment] [varchar](255) NULL,
	[created_at] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[permissions]    Script Date: 7/6/2020 8:02:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[permissions](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NOT NULL,
	[description] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[permissions_detail]    Script Date: 7/6/2020 8:02:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[permissions_detail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[action] [varchar](255) NOT NULL,
	[permission_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[permissions_relationship]    Script Date: 7/6/2020 8:02:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[permissions_relationship](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[permission_id] [int] NOT NULL,
	[suspended] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[positions]    Script Date: 7/6/2020 8:02:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[positions](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[position_name] [varchar](255) NOT NULL,
	[comment] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[salaries]    Script Date: 7/6/2020 8:02:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[salaries](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[salary] [float] NOT NULL,
	[comment] [varchar](1000) NULL,
	[created_at] [datetime] NOT NULL,
	[deleted_at] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[subsidize]    Script Date: 7/6/2020 8:02:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[subsidize](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[level] [int] NOT NULL,
	[comment] [varchar](255) NOT NULL,
	[amount] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UQ_level] UNIQUE NONCLUSTERED 
(
	[level] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user_insurances]    Script Date: 7/6/2020 8:02:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_insurances](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[insurance_id] [int] NOT NULL,
	[start_date] [datetime] NOT NULL,
	[end_date] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user_positions]    Script Date: 7/6/2020 8:02:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_positions](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[position_id] [int] NOT NULL,
	[created_at] [datetime] NOT NULL,
	[deleted_at] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user_subsidize]    Script Date: 7/6/2020 8:02:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_subsidize](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[subsidize_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 7/6/2020 8:02:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[first_name] [varchar](255) NOT NULL,
	[last_name] [varchar](255) NOT NULL,
	[email] [varchar](255) NOT NULL,
	[password] [varchar](255) NOT NULL,
	[phone_number] [varchar](255) NOT NULL,
	[address] [varchar](255) NOT NULL,
	[dob] [datetime] NOT NULL,
	[identity_card] [varchar](255) NOT NULL,
	[start_date] [datetime] NOT NULL,
	[end_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[permissions_relationship] ADD  DEFAULT ('FALSE') FOR [suspended]
GO
ALTER TABLE [dbo].[log_times]  WITH CHECK ADD  CONSTRAINT [FK_USER_LOG] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[log_times] CHECK CONSTRAINT [FK_USER_LOG]
GO
ALTER TABLE [dbo].[permissions_detail]  WITH CHECK ADD  CONSTRAINT [FK_per] FOREIGN KEY([permission_id])
REFERENCES [dbo].[permissions] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[permissions_detail] CHECK CONSTRAINT [FK_per]
GO
ALTER TABLE [dbo].[permissions_relationship]  WITH CHECK ADD  CONSTRAINT [FK_Per_Id] FOREIGN KEY([permission_id])
REFERENCES [dbo].[permissions] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[permissions_relationship] CHECK CONSTRAINT [FK_Per_Id]
GO
ALTER TABLE [dbo].[permissions_relationship]  WITH CHECK ADD  CONSTRAINT [FK_UserPer] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[permissions_relationship] CHECK CONSTRAINT [FK_UserPer]
GO
ALTER TABLE [dbo].[salaries]  WITH CHECK ADD  CONSTRAINT [FK_SALA_USER] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[salaries] CHECK CONSTRAINT [FK_SALA_USER]
GO
ALTER TABLE [dbo].[user_insurances]  WITH CHECK ADD  CONSTRAINT [FK_USER_INSU] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[user_insurances] CHECK CONSTRAINT [FK_USER_INSU]
GO
ALTER TABLE [dbo].[user_positions]  WITH CHECK ADD  CONSTRAINT [FK_POSI] FOREIGN KEY([position_id])
REFERENCES [dbo].[positions] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[user_positions] CHECK CONSTRAINT [FK_POSI]
GO
ALTER TABLE [dbo].[user_positions]  WITH CHECK ADD  CONSTRAINT [FK_USER_POSI] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[user_positions] CHECK CONSTRAINT [FK_USER_POSI]
GO
ALTER TABLE [dbo].[user_subsidize]  WITH CHECK ADD  CONSTRAINT [FK_SUB_U] FOREIGN KEY([subsidize_id])
REFERENCES [dbo].[subsidize] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[user_subsidize] CHECK CONSTRAINT [FK_SUB_U]
GO
ALTER TABLE [dbo].[user_subsidize]  WITH CHECK ADD  CONSTRAINT [FK_USER_SUR] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[user_subsidize] CHECK CONSTRAINT [FK_USER_SUR]
GO
USE [master]
GO
ALTER DATABASE [hrm] SET  READ_WRITE 
GO
