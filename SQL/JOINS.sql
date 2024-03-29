USE org;

SHOW TABLES;

SELECT * FROM employee;

create table project (id int primary key ,
empid int , name varchar(255), startdate date , clientid int);

insert into project values(
1 , 1 ,'A','2021-04-21',3);

insert into project values(
2 , 2 ,'B','2021-03-12',1);

insert into project values(
3 , 3 ,'C','2021-01-16',5);

insert into project values(
4 , 4 ,'D','2021-04-27',2);

insert into project values(
5 , 5 ,'E','2021-05-01',4);

SELECT * FROM project;

-- INNER JOIN ENLIST ALL EMPLOYESS ALONG WITH PROJECT ALLOCATED TO THEM
SELECT e.EMP_ID, e.FIRST_NAME, e.LAST_NAME, p.id, p.name FROM employee as e
INNER JOIN project AS p ON e.EMP_ID = p.empid;

CREATE TABLE client (
 id INT NOT NULL PRIMARY KEY,
 f_name VARCHAR(255),
 l_name VARCHAR(255),
 age INT,
 emailId VARCHAR(255),
 phone INT,
 city VARCHAR(255),
 empid INT,
 FOREIGN KEY (empid)
		REFERENCES employee(EMP_ID)
);

INSERT INTO client VALUES
 (1, 'Mac', 'Rogers', 47, 'mac@hotmail.com', 98648787, 'Kolkata', 3),
 (2, 'Max', 'George', 37, 'max@hotmail.com', 6486448, 'Delhi', 3),
 (3, 'Peter', 'Milton', 67, 'peter@hotmail.com', 68465168, 'Hyderabad', 1) ,
 (4, 'Minal', 'Gardner', 40, 'minal@hotmail.com', 989654864, 'Hyderabad', 2) ,
 (5, 'Deepak', 'Joseph', 32, 'dk@hotmail.com', 4845984, 'Kolkata', 4) ,
 (6, 'Chepra', 'Juan', 45, 'chepra@hotmail.com', 32548946, 'Delhi', 5),
 (7, 'Xi', 'Jinping', 54, 'xi@hotmail.com', 64984646, 'Hyderabad', 4) ,
 (8, 'Donald', 'Trump', 65, 'donald@hotmail.com', 1995959, 'Hyderabad', 1) ;

SELECT * FROM client;

-- Fetch out all the employee ID's and their contact detail who have been working 
-- in Admin dept with the clients name working in Hyderabad.

SELECT e.EMP_ID, e.FIRST_NAME, e.DEPARTMENT, c.id, c.f_name, c.phone, c.city FROM employee AS e
INNER JOIN client AS c ON e.EMP_ID = c.empid WHERE e.DEPARTMENT = 'Admin' AND c.city = 'Hyderabad';

-- LEFT JOIN
-- FETCH OUT EACH PROJECT ALLOCATED TO EACH EMPLPOYEE ALSO THE ONE NOT ALLOCATED
SELECT * FROM employee AS e 
LEFT JOIN project AS p ON e.EMP_ID = p.empid;

-- RIGHT JOIN
-- LIST OUT ALL PROJECTS ALONG WITH THEIR EMPLOYEE'S NAME AND THEIR RESPECTIVE ALLOCATED EMAIL ID
SELECT p.id, p.name, e.EMP_ID, e.FIRST_NAME, e.DEPARTMENT FROM employee AS e 
RIGHT JOIN project AS p
ON e.EMP_ID = p.empid;

-- CROSS JOIN CARTESIAN PRODUCT
SELECT e.FIRST_NAME, e.LAST_NAME, p.id, p.name FROM employee AS e
CROSS JOIN  project as p;

-- JOIN WITHOUT USING JOIN KEYWORD
-- INNER JOIN ENLIST ALL EMPLOYESS ALONG WITH PROJECT ALLOCATED TO THEM
SELECT e.EMP_ID, e.FIRST_NAME, e.LAST_NAME, p.id, p.name FROM employee as e,
 project AS p WHERE e.EMP_ID = p.empid;