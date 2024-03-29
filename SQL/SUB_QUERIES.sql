SHOW TABLES;

SELECT * FROM employee;

SELECT * FROM project;

UPDATE project SET empid = 3 WHERE id = 4;

-- all employess whoe salary >= 100000
SELECT * FROM employee WHERE EMP_ID IN (SELECT EMP_ID FROM employee WHERE SALARY >=100000);

-- WHERE CLAUSE DIFFERENT TABLE
-- EMPLOYEE DETAILS WORKING IN MORE THAN ONE PROJECT
SELECT * FROM employee WHERE EMP_ID IN 
( SELECT empid FROM project GROUP BY empid HAVING COUNT(empid) >1);

-- select max salary person whose name starts with a
SELECT MAX(SALARY) FROM (SELECT * FROM employee WHERE FIRST_NAME LIKE 'V%') AS TEMP;
