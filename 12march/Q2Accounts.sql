CREATE TABLE Employee (
    empId INT PRIMARY KEY,
    name VARCHAR(255),
    supervisor INT,
    salary INT

);

CREATE TABLE Bonus (
    empId INT PRIMARY KEY,
    bonus INT
);

INSERT INTO Employee (empId, name, supervisor, salary) VALUES
(1, 'John', 3, 1000),
(2, 'Dan', 3, 2000),
(3, 'Brad', NULL, 4000),
(4, 'Thomas', 3, 4000);


INSERT INTO Bonus (empId, bonus) VALUES
(2, 500),
(4, 2000);

select e.name ,b.bonus
from Employee as e
left join bonus as b
on e.empid=b.empId 
where bonus<1000 OR b.bonus is null;