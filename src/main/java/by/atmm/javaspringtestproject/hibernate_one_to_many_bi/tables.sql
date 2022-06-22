DROP TABLE my_db.staff;
DROP TABLE my_db.department;
CREATE TABLE my_db.department
(
    department_id         int NOT NULL AUTO_INCREMENT,
    name       varchar(15),
    max_salary int,
    min_salary int,
    PRIMARY KEY (department_id)
);

CREATE TABLE my_db.staff
(
    employee_id            int NOT NULL AUTO_INCREMENT,
    name          varchar(15),
    surname       varchar(25),
    salary        int,
    department_id int,
    PRIMARY KEY (employee_id),
    FOREIGN KEY (department_id) REFERENCES my_db.department (department_id)
);