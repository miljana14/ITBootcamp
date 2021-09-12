SELECT email, phone_number 
FROM employees 
WHERE (phone_number IS NOT NULL AND department_id IN (SELECT department_id FROM departments WHERE location_id
                           IN (SELECT location_id FROM locations WHERE country_id
                               IN (SELECT country_id FROM countries WHERE region_id
                                  IN (SELECT region_id FROM regions WHERE region_name = 'Europe')))))
