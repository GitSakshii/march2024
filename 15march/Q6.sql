SELECT j.JOB_TITLE, AVG(e.SALARY) AS avg_salary
FROM employees e
JOIN jobs j ON e.JOB_ID = j.JOB_ID
GROUP BY j.JOB_TITLE;
