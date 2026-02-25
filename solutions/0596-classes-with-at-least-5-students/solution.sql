# Write your MySQL query statement below
SELECT DISTINCT class
FROM Courses
GROUP BY class
HAVING COUNT(*) >= 5;
