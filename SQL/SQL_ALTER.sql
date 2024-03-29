USE temp;

SHOW tables;

SELECT * FROM student;

create table account(
id int primary key,
name varchar(255) UNIQUE,
balance INT NOT NULL DEFAULT 0
);

-- add a columm
ALTER TABLE account ADD COLUMN interest FLOAT NOT NULL DEFAULT 0;

SELECT * FROM account;

-- TO DESCRIBE A TABLE
DESC account;

-- RENAME THE COLUMN (also data type batana pdta h)
ALTER TABLE account CHANGE COLUMN simple_interest interest DOUBLE NOT NULL DEFAULT 0;

-- CHANGE THE DATA TYPE OF A COLUMN
ALTER TABLE account MODIFY interest DOUBLE NOT NULL DEFAULT 0;

-- DROP COLUMN
ALTER TABLE account DROP COLUMN interest;

-- RENAME THE TABLE
ALTER TABLE account RENAME TO acc_details;
