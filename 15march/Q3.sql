-- Tables have already been created in the previous questions
SELECT CONCAT(e.first_name, ' ', e.last_name) AS name, e.job_id, e.department_id, d.department_name
FROM employees e
JOIN departments d ON e.department_id = d.department_id
JOIN locations l ON d.location_id = l.location_id
WHERE l.city = 'London';
