USE [master]
GO

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'PE_DBI202')
BEGIN
	ALTER DATABASE [PE_DBI202] SET OFFLINE WITH ROLLBACK IMMEDIATE;
	ALTER DATABASE [PE_DBI202] SET ONLINE;
	DROP DATABASE [PE_DBI202];
END

GO

CREATE DATABASE [PE_DBI202]
GO

USE [PE_DBI202]
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

CREATE TABLE DEPARTMENT
( 
Dname VARCHAR(15) NOT NULL,
Dnumber INT NOT NULL,
Mgr_ssn CHAR(9) NOT NULL,
Mgr_start_date DATE,
PRIMARY KEY (Dnumber),
UNIQUE (Dname));
go
CREATE TABLE EMPLOYEE
( 
	Fname VARCHAR(15) NOT NULL,
	Minit CHAR,
	Lname VARCHAR(15) NOT NULL,
	Ssn CHAR(9) NOT NULL,
	Bdate DATE,
	Address VARCHAR(30),
	Sex CHAR,
	Salary DECIMAL(10,2),
	Super_ssn CHAR(9),
	Dno INT NOT NULL,
	PRIMARY KEY (Ssn),
	FOREIGN KEY (Super_ssn) REFERENCES EMPLOYEE(Ssn),
	FOREIGN KEY (Dno) REFERENCES DEPARTMENT(Dnumber) 
);
go
CREATE TABLE DEPT_LOCATIONS
( 
	Dnumber INT NOT NULL,
	Dlocation VARCHAR(15) NOT NULL,
	PRIMARY KEY (Dnumber, Dlocation),
	FOREIGN KEY (Dnumber) REFERENCES DEPARTMENT(Dnumber) 
);
go
CREATE TABLE PROJECT
( 
	Pname VARCHAR(15) NOT NULL,
	Pnumber INT NOT NULL,
	Plocation VARCHAR(15),
	Dnum INT NOT NULL,
	PRIMARY KEY (Pnumber),
	UNIQUE (Pname),
	FOREIGN KEY (Dnum) REFERENCES DEPARTMENT(Dnumber) 
);
go
CREATE TABLE WORKS_ON
( 
	Essn CHAR(9) NOT NULL,
	Pno INT NOT NULL,
	Hours DECIMAL(3,1),
	PRIMARY KEY (Essn, Pno),
	FOREIGN KEY (Essn) REFERENCES EMPLOYEE(Ssn),
	FOREIGN KEY (Pno) REFERENCES PROJECT(Pnumber) 
);
go
CREATE TABLE DEPENDENT
( 
	Essn CHAR(9) NOT NULL,
	Dependent_name VARCHAR(15) NOT NULL,
	Sex CHAR,
	Bdate DATE,
	Relationship VARCHAR(8),
	PRIMARY KEY (Essn, Dependent_name),
	FOREIGN KEY (Essn) REFERENCES EMPLOYEE(Ssn) 
);

go
insert into DEPARTMENT
values('Research',5,333445555,'1988-05-22')
insert into DEPARTMENT
values('Administration',4,987654321,'1995-01-01')
insert into DEPARTMENT
values('Headquaters',1,888665555,'1981-06-19')
insert into DEPARTMENT
values('Infomation',3,123123123,'1981-07-20')
insert into DEPARTMENT
values('Accounting',7,123123123,'1981-07-20')
go

insert into EMPLOYEE values('James','E','Borg',888665555,'1937-11-10','450 Stone, Houston, TX','M',55000,NULL,1)
insert into EMPLOYEE values('Franklin','T','Wong',333445555,'1955-12-08','638 Voss, Houston, TX','M',40000,888665555,5)
insert into EMPLOYEE values('Jennifer','S','Wallace',987654321,'1941-06-20','291 Berry, Bellaire, TX','F',43000,888665555,4)
insert into EMPLOYEE values('Alicia','J','Zelaya',999887777,'1968-01-19','3321 Castle, Spring, TX','F',25000,987654321,4)
insert into EMPLOYEE values('Ramesh','K','Narayan',666884444,'1962-09-15','915 Fire Oak, Humble, TX','M',38000,333445555,5)
insert into EMPLOYEE values('Joyce','A','English',453453453,'1972-07-31','5631 Rice, Houston, TX','F',30000,333445555,5)
insert into EMPLOYEE values('Ahmad','V','Jabbar',987987987,'1969-03-29','980 Dallas, Houston, TX','M',25000,987654321,4)
insert into EMPLOYEE values('John','B','Smith',123456789,'1965-01-09','731 Fondren, Houston, TX','M',35000,333445555,5)
insert into EMPLOYEE values('Mount','M','Son',456789123,'1987-12-25','780 Water, Fall, TX','M',50000,888665555,1)
insert into EMPLOYEE values('Kim','P','Possible',567890345,'1991-02-27','321 Mount, Six, TX','F',35000,987654321,4)
insert into EMPLOYEE values('Ahn','C','Seop',654321789,'1988-11-07','456 Green, Houston, TX','M',80000,333445555,5)
insert into EMPLOYEE values('Carry','I','Irsis',999955556,'2001-10-08','1890 Court, Law, TX','F',65000,888665555,1)
insert into EMPLOYEE values('Mark','U','Can',111222444,'1993-05-12','379 Loop, Metal, TX','M',45000,333445555,5)
insert into EMPLOYEE values('Ford','F','Ruibar',270320031,'1995-09-12','1879 Atlas, Aluminum, TX','M',50000,333445555,5)
insert into EMPLOYEE values('Victoria','H','Tiny',246824681,'1952-01-12','958 Cung, Gold, TX','F',85000,888665555,1)
insert into EMPLOYEE values('Bary','O','Oral',123678890,'1977-06-25','245 Gift, Super, TX','M',55000,987654321,4)
insert into EMPLOYEE values('Dan','D','Dattar',890008978,'2002-08-18','1802 Dear, Deer, TX','M',40000,987654321,4)
insert into EMPLOYEE values('Tim','R','Rock',498546213,'2001-01-15','678 Come, Well, TX','M',60000,987654321,4)
insert into EMPLOYEE values('Cross','E','Anie',141146213,'2003-11-15','678 NTT, HCM, TX','F',40000,987654321,4)
insert into EMPLOYEE values('Huynh','T','Toan',123123123,'1975-11-11','700 Blue, Houston, TX','M',40000,888665555,3)
insert into EMPLOYEE values('Ho','M','Piter',345345345,'1975-11-11','123 Blue, Houston, TX','M',35000,123123123,3)

go

insert into DEPT_LOCATIONS values(1,'Houston')
insert into DEPT_LOCATIONS values(4,'Stafford')
insert into DEPT_LOCATIONS values(5,'Bellaire')
insert into DEPT_LOCATIONS values(5,'Sugarland')
insert into DEPT_LOCATIONS values(5,'Houston')
go
insert into PROJECT values('ProductX',1,'Bellaire',5)
insert into PROJECT values('ProductY',2,'Sugarland',5)
insert into PROJECT values('ProductZ',3,'Houston',4)
insert into PROJECT values('ProductT',40,'Houston',1)
insert into PROJECT values('Computerization',10,'Stafford',4)
insert into PROJECT values('Reorganization',20,'Houston',1)
insert into PROJECT values('Newbenefits',30,'Stafford',4)
insert into PROJECT values('Vina',7,'HCM',1)

go
insert into WORKS_ON values(123456789,1,32.5)
insert into WORKS_ON values(123456789,2,7.5)
insert into WORKS_ON values(666884444,3,40.0)
insert into WORKS_ON values(453453453,1,20.0)
insert into WORKS_ON values(453453453,2,20.0)
insert into WORKS_ON values(333445555,2,10.0)
insert into WORKS_ON values(333445555,3,10.0)
insert into WORKS_ON values(333445555,10,10.0)
insert into WORKS_ON values(333445555,20,10.0)
insert into WORKS_ON values(999887777,30,30.0)
insert into WORKS_ON values(999887777,10,10.0)
insert into WORKS_ON values(987987987,10,35.0)
insert into WORKS_ON values(987987987,30,5.0)
insert into WORKS_ON values(987654321,30,20.0)
insert into WORKS_ON values(987654321,20,15.0)
insert into WORKS_ON values(888665555,20,NULL)

insert into WORKS_ON values(456789123,20,40.0)
insert into WORKS_ON values(567890345,10,13.0)
insert into WORKS_ON values(567890345,30,17.0)
insert into WORKS_ON values(654321789,1,20.0)
insert into WORKS_ON values(654321789,2,10.0)
insert into WORKS_ON values(654321789,3,10.0)
insert into WORKS_ON values(999955556,20,22.0)
insert into WORKS_ON values(111222444,1,10.0)
insert into WORKS_ON values(111222444,2,10.0)
insert into WORKS_ON values(111222444,3,10.0)
insert into WORKS_ON values(270320031,1,20.0)
insert into WORKS_ON values(270320031,2,21.0)
insert into WORKS_ON values(123678890,3,23.0)
insert into WORKS_ON values(246824681,20,NULL)
insert into WORKS_ON values(123678890,10,12.0)
insert into WORKS_ON values(123678890,30,16.0)
insert into WORKS_ON values(890008978,10,30.0)
insert into WORKS_ON values(890008978,30,19.0)
insert into WORKS_ON values(498546213,10,24.0)
insert into WORKS_ON values(498546213,30,34.0)
go
insert into DEPENDENT values(333445555,'Alice','F','1986-04-05','Daughter')
insert into DEPENDENT values(333445555,'Theodore','M','1983-10-25','Son')
insert into DEPENDENT values(333445555,'Joy','F','1958-05-03','Spouse')
insert into DEPENDENT values(987654321,'Abner','M','1942-02-28','Spouse')
insert into DEPENDENT values(123456789,'John','M','1988-01-04','Son')
insert into DEPENDENT values(123456789,'Alica','F','1988-12-30','Daughter')
insert into DEPENDENT values(123456789,'Elizabeth','F','1967-05-05','Spouse')

insert into DEPENDENT values(456789123,'Marina','F','1989-06-18','Spouse')
insert into DEPENDENT values(567890345,'Gary','M','1988-09-27','Spouse')
insert into DEPENDENT values(567890345,'Gim','M','2012-08-25','Son')
insert into DEPENDENT values(654321789,'Jin','M','2009-12-12','Son')
insert into DEPENDENT values(654321789,'Seon','F','2014-01-06','Daughter')
insert into DEPENDENT values(999955556,'Car','M','1978-11-29','Father')
insert into DEPENDENT values(999955556,'Tien','F','1980-03-11','Mother')
insert into DEPENDENT values(111222444,'Jen','F','1995-10-03','Spouse')
insert into DEPENDENT values(270320031,'Jack','M','1975-09-09','Uncle')
insert into DEPENDENT values(246824681,'Beckham','M','1954-08-07','Spouse')
insert into DEPENDENT values(246824681,'James','M','1991-07-14','Son')
insert into DEPENDENT values(246824681,'Jennie','F','1993-03-12','Daughter')
insert into DEPENDENT values(246824681,'Kai','M','1995-03-26','Son')
insert into DEPENDENT values(123678890,'Fairy','F','1985-04-10','Spouse')
insert into DEPENDENT values(123678890,'Bella','F','1994-09-07','Daughter')
insert into DEPENDENT values(890008978,'Doc','M','1976-11-11','Father')
insert into DEPENDENT values(890008978,'Dea','F','1981-09-23','Mother')
insert into DEPENDENT values(890008978,'Ty','F','1998-05-16','Elderly')
insert into DEPENDENT values(498546213,'June','M','1968-03-06','Father')
GO