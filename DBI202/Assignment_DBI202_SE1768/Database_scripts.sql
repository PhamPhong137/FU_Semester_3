CREATE DATABASE BookRetail

USE BookRetail;

CREATE TABLE Company(
    Company_Name VARCHAR(255) PRIMARY KEY,
    Headquarters_Location VARCHAR(255),
    Founding_Date DATE,
    CEO VARCHAR(255)
);

CREATE TABLE Store(
    Store_ID INT IDENTITY(1,1) PRIMARY KEY,
	Company_Name VARCHAR(255),
    [Address] VARCHAR(255),
    Opening_Hours VARCHAR(255),
    Manager VARCHAR(255),
	FOREIGN KEY (Company_Name) REFERENCES Company(Company_Name)
);

CREATE TABLE CompanyStore(
    Company_Name VARCHAR(255),
    Store_ID INT,
    PRIMARY KEY (Company_Name, Store_ID),
    FOREIGN KEY (Company_Name) REFERENCES Company(Company_Name),
    FOREIGN KEY (Store_ID) REFERENCES Store(Store_ID)
);

CREATE TABLE Book(
    ISBN VARCHAR(255) PRIMARY KEY,
    Title VARCHAR(255),
    Author VARCHAR(255),
    Publisher VARCHAR(255),
    Price DECIMAL(10,2)
);

CREATE TABLE Storage(
    Store_ID INT,
    ISBN VARCHAR(255),
    Quantity INT CHECK (Quantity >= 0),
    PRIMARY KEY (Store_ID, ISBN),
    FOREIGN KEY (Store_ID) REFERENCES Store(Store_ID),
    FOREIGN KEY (ISBN) REFERENCES Book(ISBN)
);

CREATE TABLE Customer(
    Customer_ID INT IDENTITY(1,1) PRIMARY KEY,
    Name VARCHAR(255),
    Address VARCHAR(255),
    Phone_Number VARCHAR(20),
    Email VARCHAR(255)
);

CREATE TABLE [Order](
    Order_ID INT IDENTITY(1,1) PRIMARY KEY,
    Order_Date DATE,
    Customer_ID INT,
    Store_ID INT,
    FOREIGN KEY (Customer_ID) REFERENCES Customer(Customer_ID),
    FOREIGN KEY (Store_ID) REFERENCES Store(Store_ID)
);

CREATE TABLE OrderItem(
    Order_ID INT,
    ISBN VARCHAR(255),
    Quantity INT,
    PRIMARY KEY (Order_ID, ISBN),
    FOREIGN KEY (Order_ID) REFERENCES [Order](Order_ID),
    FOREIGN KEY (ISBN) REFERENCES Book(ISBN)
);




