select d.department_name ,count(e.employee_id) as number_of_employees
from departments d
join employees e on 
d.department_id=e.department_id
group by d.department_name;
