USE MASTER
GO
IF EXISTS (SELECT * FROM SYS.DATABASES WHERE NAME='SendoDB')
	DROP DATABASE SendoDB
CREATE DATABASE SendoDB
ON (NAME='SendoDB_DATA',FILENAME='F:\SQL Server 2019\MSSQL15.JOHNTP\MSSQL\DATA\SendoDB.MDF')
LOG ON (NAME='SendoDB_LOG',FILENAME='F:\SQL Server 2019\MSSQL15.JOHNTP\MSSQL\DATA\SendoDB.LDF')
GO

USE SendoDB 
GO

Create table [Account]
(
	[Phone_Number] Nchar(20) NOT NULL,
	[Password] Nchar(20) NOT NULL,
	[Last_Name] Nvarchar(15) NULL,
	[Account_Type] Bit NULL,
Primary Key ([Phone_Number])
) 
go

Create table [Customer]
(
	[Customer_ID] Nchar(6) NOT NULL,
	[Customer_Name] Nvarchar(30) NULL,
	[Email] Varchar(30) NULL,
	[Gender] Bit NULL,
	[Birthday] Datetime NULL,
	[Phone_Number] Nchar(20) NOT NULL,
Primary Key ([Customer_ID])
) 
go

Create table [Category]
(
	[Category_ID] Nchar(6) NOT NULL,
	[Category_Name] Nvarchar(25) NOT NULL,
	[Description] Nvarchar(70) NULL,
Primary Key ([Category_ID])
) 
go

Create table [Product]
(
	[Product_ID] Nchar(6) NOT NULL,
	[Category_ID] Nchar(6) NOT NULL,
	[DisCode_ID] Nchar(6) NOT NULL,
	[Supplier_ID] Nchar(6) NOT NULL,
	[Product_Name] Nvarchar(50) NOT NULL,
	[Unit_Price] Integer NULL,
	[Unit_In_Stock] Integer NULL,
	[Description] Nvarchar(70) NULL,
	[Stock] Integer NULL,
	[Condition] Bit NULL,
	[Product_Image] Varchar(50) NULL,
Primary Key ([Product_ID])
) 
go

Create table [Supplier]
(
	[Supplier_ID] Nchar(6) NOT NULL,
	[Supplier_Name] Nvarchar(30) NOT NULL,
	[Address] Nvarchar(50) NULL,
Primary Key ([Supplier_ID])
) 
go

Create table [Orders]
(
	[Order_ID] Nchar(6) NOT NULL,
	[Order_Date] Datetime NULL,
	[Required_Date] Datetime NULL,
	[Ship_Name] Nvarchar(30) NULL,
	[Shipped_Date] Datetime NULL,
	[Ship_Address] Nvarchar(60) NULL,
	[Ship_City] Nvarchar(15) NULL,
	[Customer_ID] Nchar(6) NOT NULL,
	[Payment_ID] Nchar(6) NOT NULL,
	[Shipper_ID] Nchar(6) NOT NULL,
Primary Key ([Order_ID])
) 
go

Create table [Discount_Code]
(
	[DisCode_ID] Nchar(6) NOT NULL,
	[Value] Integer NULL,
Primary Key ([DisCode_ID])
) 
go

Create table [Payment]
(
	[Payment_ID] Nchar(6) NOT NULL,
	[Amount] Integer NULL,
	[Method] Bit NULL,
Primary Key ([Payment_ID])
) 
go

Create table [Cart]
(
	[Cart_ID] Nchar(6) NOT NULL,
	[Order_ID] Nchar(6) NOT NULL,
	[Product_ID] Nchar(6) NOT NULL,
	[Total_Price] Integer NULL,
	[Quantity] Smallint NULL,
Primary Key ([Cart_ID])
) 
go

Create table [Shipper]
(
	[Shipper_ID] Nchar(6) NOT NULL,
	[Company] Nvarchar(30) NULL,
Primary Key ([Shipper_ID])
) 
go


Alter table [Customer] add  foreign key([Phone_Number]) references [Account] ([Phone_Number])  on update no action on delete no action 
go
Alter table [Orders] add  foreign key([Customer_ID]) references [Customer] ([Customer_ID])  on update no action on delete no action 
go
Alter table [Product] add  foreign key([Category_ID]) references [Category] ([Category_ID])  on update no action on delete no action 
go
Alter table [Cart] add  foreign key([Product_ID]) references [Product] ([Product_ID])  on update no action on delete no action 
go
Alter table [Product] add  foreign key([Supplier_ID]) references [Supplier] ([Supplier_ID])  on update no action on delete no action 
go
Alter table [Cart] add  foreign key([Order_ID]) references [Orders] ([Order_ID])  on update no action on delete no action 
go
Alter table [Product] add  foreign key([DisCode_ID]) references [Discount_Code] ([DisCode_ID])  on update no action on delete no action 
go
Alter table [Orders] add  foreign key([Payment_ID]) references [Payment] ([Payment_ID])  on update no action on delete no action 
go
Alter table [Orders] add  foreign key([Shipper_ID]) references [Shipper] ([Shipper_ID])  on update no action on delete no action 
go


Set quoted_identifier on
go


Set quoted_identifier off
go