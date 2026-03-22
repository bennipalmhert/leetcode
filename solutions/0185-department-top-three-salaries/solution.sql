# Write your MySQL query statement below
SElECT d.name AS Department, e.name AS Employee, e.salary AS Salary 
FROM Employee AS e JOIN Department AS d ON e.departmentId = d.id
WHERE (
        SELECT COUNT(DISTINCT e2.salary)
        FROM Employee AS e2
        WHERE e2.departmentId = e.departmentId AND e2.salary > e.salary
        ORDER BY e2.salary 
    ) < 3
ORDER BY e.salary;
