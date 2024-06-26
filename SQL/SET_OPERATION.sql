-- UNION
-- COMBINES TWO OR MORE tables SUCH THAT NUMBER OF ROWS INCREASES, 
-- NUMBER OF COLUMNS REMAINS THE SAME
-- DATA TYPES OF CORRESPONDING COLUMNS FROM EACH TABLE SHOULD BE SAME
-- COMBINES REESULT VERTICALLY INSTEAD OF HORIZONTALLY AS IN JOIN
SELECT * FROM table1
UNION
SELECT * FROM table2;

-- INTERSECT

-- THIS IS WRONG SO WE HAVE TO EMULATE
-- SELECT * FROM table1 
-- INTERSECT
-- SELECT * FROM table2;

SELECT DISTINCT id FROM t1 
INNER JOIN 
t2 USING(id);

-- t1 - t2
-- have to emulate this as well
SELECT id from t1 
LEFT JOIN t2 USING(id)
WHERE t2.id IS NULL;

CREATE TABLE emp2 (
id INT NOT NULL PRIMARY KEY,
name VARCHAR(255),
role VARCHAR(255)
);

INSERT INTO emp2 VALUES
(5, 'P', 'SDE-3'),
(2, 'B', 'SDM'),
(6, 'F', 'PM'),
(7, 'Q', 'CEO');

UPDATE emp1 SET role =  'TPM' WHERE id = 3;

-- UNION
SELECT * FROM emp1;
-- UNION
SELECT * FROM emp2;

-- SELECT ALL SDES FROM BOTH THE TABLES
SELECT * FROM emp1 WHERE role LIKE 'SDE%'
UNION
SELECT * FROM emp2 WHERE role LIKE 'SDE%';

-- SELECT EMP WHO ARE IN BOTH THE TABLES
-- INTERSECT
SELECT * FROM emp1 
INNER JOIN
emp2 USING(id);

-- SELECT EMP IN emp1 BUT NOT IN emp2
-- MINUS
SELECT * FROM emp1 
LEFT JOIN
emp2 USING(id)
WHERE emp2.id IS NULL;


