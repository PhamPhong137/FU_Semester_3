USE BookRetail;

INSERT INTO Company VALUES ('GreatReads', 'San Francisco, CA', '1980-01-01', 'John Doe');
INSERT INTO Company VALUES ('PageTurners', 'Austin, TX', '1990-01-01', 'Jane Smith');

SET IDENTITY_INSERT Store OFF;

INSERT INTO Store(Company_Name, Address, Opening_Hours, Manager)
VALUES
    ('GreatReads', '123 Market St, San Francisco, CA', '8-20', 'Manager1'),
    ('PageTurners', '123 Congress Ave, Austin, TX', '9-21', 'Manager2'),
    ('GreatReads', '456 Market St, San Francisco, CA', '8-20', 'Manager3'),
    ('PageTurners', '456 Congress Ave, Austin, TX', '9-21', 'Manager4'),
    ('GreatReads', '789 Market St, San Francisco, CA', '8-20', 'Manager5');
INSERT INTO CompanyStore (Company_Name, Store_ID)
VALUES ('GreatReads', 1),
       ('PageTurners', 2),
       ('GreatReads', 3),
       ('PageTurners', 4),
       ('GreatReads', 5);

INSERT INTO Book (ISBN, Title, Author, Publisher, Price)
VALUES ('123-456-789', 'Book 1', 'Author 1', 'Publisher 1', 10.99),
       ('234-567-890', 'Book 2', 'Author 2', 'Publisher 2', 15.99),
       ('345-678-901', 'Book 3', 'Author 3', 'Publisher 3', 20.99),
       ('456-789-012', 'Book 4', 'Author 4', 'Publisher 4', 25.99),
       ('567-890-123', 'Book 5', 'Author 5', 'Publisher 5', 30.99),
       ('678-901-234', 'Book 6', 'Author 6', 'Publisher 6', 15.99),
       ('789-012-345', 'Book 7', 'Author 7', 'Publisher 7', 22.99),
       ('890-123-456', 'Book 8', 'Author 8', 'Publisher 8', 19.99),
       ('901-234-567', 'Book 9', 'Author 9', 'Publisher 9', 27.99),
       ('012-345-678', 'Book 10', 'Author 10', 'Publisher 10', 29.99),
       ('123-456-7890', 'Book 11', 'Author 11', 'Publisher 11', 18.99),
       ('234-567-8901', 'Book 12', 'Author 12', 'Publisher 12', 24.99),
       ('345-678-9012', 'Book 13', 'Author 13', 'Publisher 13', 21.99),
       ('456-789-0123', 'Book 14', 'Author 14', 'Publisher 14', 26.99),
       ('567-890-1234', 'Book 15', 'Author 15', 'Publisher 15', 23.99);


INSERT INTO Storage (Store_ID, ISBN, Quantity)
VALUES (1, '678-901-234', 30),
       (2, '789-012-345', 30),
       (3, '890-123-456', 30),
       (4, '901-234-567', 30),
       (5, '012-345-678', 30),
       (1, '123-456-7890', 30),
       (2, '234-567-8901', 30),
       (3, '345-678-9012', 30),
       (4, '456-789-0123', 30),
       (5, '567-890-1234', 30);


SET IDENTITY_INSERT Customer OFF;
	   	   
INSERT INTO Customer (Name, Address, Phone_Number, Email)
VALUES ('Customer1', '123 Main St, City1, State1', '123-456-7890', 'customer1@email.com'),
       ('Customer2', '234 Main St, City2, State2', '234-567-8901', 'customer2@email.com'),
       ('Customer3', '345 Main St, City3, State3', '345-678-9012', 'customer3@email.com'),
       ('Customer4', '456 Main St, City4, State4', '456-789-0123', 'customer4@email.com'),
       ('Customer5', '567 Main St, City5, State5', '567-890-1234', 'customer5@email.com'),
	   ('Customer6', '678 Main St, City6, State6', '678-901-2345', 'customer6@email.com'),
	   ('Customer7', '789 Main St, City7, State7', '789-012-3456', 'customer7@email.com'),
	   ('Customer8', '890 Main St, City8, State8', '890-123-4567', 'customer8@email.com'),
	   ('Customer9', '901 Main St, City9, State9', '901-234-5678', 'customer9@email.com'),
	   ('Customer10', '012 Main St, City10, State10', '012-345-6789', 'customer10@email.com'),
	   ('Customer11', '123 Main St, City11, State11', '123-456-7890', 'customer11@email.com'),
	   ('Customer12', '234 Main St, City12, State12', '234-567-8901', 'customer12@email.com'),
	   ('Customer13', '345 Main St, City13, State13', '345-678-9012', 'customer13@email.com'),
	   ('Customer14', '456 Main St, City14, State14', '456-789-0123', 'customer14@email.com'),
	   ('Customer15', '567 Main St, City15, State15', '567-890-1234', 'customer15@email.com');

SET IDENTITY_INSERT [Order] OFF;
INSERT INTO [Order] (Order_Date, Customer_ID, Store_ID)
VALUES ('2021-01-01', 1, 1),
       ('2021-04-22', 2, 2),
       ('2022-02-15', 3, 3),
       ('2022-09-30', 4, 4),
       ('2023-01-02', 5, 5),
	   ('2023-02-15', 6, 1),
    ('2023-03-22', 7, 2),
    ('2023-04-15', 8, 3),
    ('2023-05-30', 9, 4),
    ('2023-06-12', 10, 5),
    ('2023-07-01', 11, 1),
    ('2023-07-05', 12, 2),
    ('2023-07-08', 13, 3),
    ('2023-07-12', 14, 4),
    ('2023-07-15', 15, 5),
    ('2023-07-17', 6, 1),
    ('2023-07-19', 7, 2),
    ('2023-07-22', 8, 3),
    ('2023-07-24', 9, 4),
    ('2023-07-26', 10, 5),
    ('2023-07-29', 11, 1),
    ('2023-07-31', 12, 2),
    ('2023-08-02', 13, 3),
    ('2023-08-04', 14, 4),
    ('2023-08-06', 15, 5),
    ('2023-08-09', 6, 1),
    ('2023-08-12', 7, 2),
    ('2023-08-15', 8, 3),
    ('2023-08-18', 9, 4),
    ('2023-08-21', 10, 5),
    ('2023-08-24', 11, 1),
    ('2023-08-27', 12, 2),
    ('2023-08-30', 13, 3),
    ('2023-09-02', 14, 4),
    ('2023-09-05', 15, 5);
	

INSERT INTO OrderItem (Order_ID, ISBN, Quantity)
VALUES (1, '123-456-789', 1),
       (2, '234-567-890', 2),
       (3, '345-678-901', 3),
       (4, '456-789-012', 4),
       (5, '567-890-123', 5),
	   (6, '678-901-234', 2),
    (7, '789-012-345', 3),
    (8, '890-123-456', 4),
    (9, '901-234-567', 1),
    (10, '012-345-678', 2),
    (11, '123-456-7890', 3),
    (12, '234-567-8901', 4),
    (13, '345-678-9012', 1),
    (14, '456-789-0123', 2),
    (15, '567-890-1234', 3),
    (16, '678-901-234', 4),
    (17, '789-012-345', 1),
    (18, '890-123-456', 2),
    (19, '901-234-567', 3),
    (20, '012-345-678', 4),
    (21, '123-456-7890', 1),
    (22, '234-567-8901', 2),
    (23, '345-678-9012', 3),
    (24, '456-789-0123', 4),
    (25, '567-890-1234', 1),
    (26, '678-901-234', 2),
    (27, '789-012-345', 3),
    (28, '890-123-456', 4),
    (29, '901-234-567', 1),
    (30, '012-345-678', 2);
