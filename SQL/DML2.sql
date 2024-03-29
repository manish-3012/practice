USE temp;

SHOW tables;

CREATE TABLE Customer ( 
id integer PRIMARY KEY, 
cname varchar(225), 
Address varchar(225), 
Pincode integer,
Gender char(2),
City varchar(225)
);

INSERT INTO Customer (id, cname, Address, Gender, City, Pincode)
VALUES (1251, 'Ram Kumar', 'Dilbagh Nagar', 'M', 'Jalandhar', 144002), (1300, 'Shayam Singh', 'Ludhiana H.O', 'M', 'Ludhiana', 141001);

SELECT * FROM Customer;

-- UPDATE
UPDATE Customer SET Gender = 'M' WHERE id = 210;

-- UPDATE MULTIPLE ROWS
UPDATE Customer SET Pincode = '493885';

-- DELETE FROM Customer 
DELETE FROM Customer WHERE id = 1251;

CREATE TABLE Order_details ( 
Order_id integer PRIMARY KEY, 
delivery_date DATE, 
cust_id INT,
FOREIGN KEY (cust_id) 
 references Customer(id) 
 ON DELETE SET NULL
 );
 
 DROP TABLE order_details;

INSERT INTO order_details VALUES (888, '11-09-23', 1251);

SELECT * FROM order_details ORDER BY cust_id;

DESC order_details;

DELETE FROM customer WHERE id= 1251;

-- REPLACE
-- DATA ALREADY PRESENT REPLACE
-- DATA NOT PRESENT INSERT
REPLACE INTO Customer (id, cname, Address, Pincode, Gender, City)
VALUES (210, 'Aman', 'Shankar Nagar', 492010, 'M', 'Rajim');

REPLACE INTO Customer (id, cname, Address, Pincode, Gender, City)
VALUES (220, 'Neha', 'Vyapar Vihar', 898857, 'F', 'Kolkata');

REPLACE INTO Customer SET id = 400, cname = 'Rohit Grover', City='Utah', Gender = 'M', Address= 'Steel City', Pincode=484945;

-- REPLACE VS UPDATE
-- IF NO DATA, UPDATE WILL DO NOTHING, WHILE REPLACE WILL ADD A NEW ROW

