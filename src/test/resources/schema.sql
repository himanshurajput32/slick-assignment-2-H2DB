DROP TABLE IF EXISTS employee;

DROP TABLE IF EXISTS project;

CREATE TABLE IF NOT EXISTS employee(id int PRIMARY KEY ,name varchar(200));

CREATE TABLE IF NOT EXISTS project(id int,name varchar(200));
ALTER TABLE project ADD FOREIGN KEY(id) REFERENCES employee(id);