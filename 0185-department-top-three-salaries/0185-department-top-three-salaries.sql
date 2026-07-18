SELECT
    d.name AS Department,
    t.name AS Employee,
    t.salary AS Salary
FROM (
    SELECT
        e.*,
        DENSE_RANK() OVER(
            PARTITION BY departmentId
            ORDER BY salary DESC
        ) AS rnk
    FROM Employee e
) t
JOIN Department d
ON t.departmentId = d.id
WHERE rnk <= 3;