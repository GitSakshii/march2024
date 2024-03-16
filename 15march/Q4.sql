select 
d.department_id ,
d.department_name ,
d.manager_id ,
e.first_name 
from 
departments as d
inner join employees as e on d.manager_id = e.employee_id;