SELECT e1.name
FROM Employee e1
JOIN Employee e2
ON e2.managerId = e1.id
GROUP BY e1.id, e1.name
HAVING COUNT(*) >= 5;