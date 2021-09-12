SELECT country_name 
FROM countries
INNER JOIN locations ON countries.country_id = locations.country_id
INNER JOIN departments ON locations.location_id = departments.location_id
INNER JOIN employees ON employees.department_id = departments.department_id
WHERE employees.salary IN (SELECT DISTINCT SUM(salary) AS "Total salary"
							FROM employees
							GROUP BY department_id)
ORDER BY salary DESC