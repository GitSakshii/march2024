SELECT d.DEPARTMENT_NAME, e.FIRST_NAME AS manager_name, l.CITY
FROM departments d
JOIN employees e ON d.MANAGER_ID = e.EMPLOYEE_ID
JOIN locations l ON d.LOCATION_ID = l.LOCATION_ID;
