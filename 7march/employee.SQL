SELECT * FROM avisoft.employee_table;

select max(Salary) as SecondHighestSalary
from avisoft.employee_table 
where Salary < (SELECT max(Salary)from avisoft.employee_table);
