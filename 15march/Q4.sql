-- Tables have already been created in the Previous Questions
select e1.employee_id,e1.Last_name as Employee,e1.Manager_id,e2.Last_name as Manager
from employees e1 
inner join employees e2 on e1.Manager_id=e2.employee_id
order by e1.employee_id;
