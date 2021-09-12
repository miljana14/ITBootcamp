SELECT first_name, last_name 
FROM dependents
WHERE (relationship = 'Child' 
       AND employee_id IN (SELECT employee_id FROM employees 
                           WHERE salary=SELECT MAX(salary) FROM employees)))