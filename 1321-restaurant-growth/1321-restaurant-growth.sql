WITH daily AS(
    SELECT visited_on, SUM(amount) AS amount
    FROM Customer
    GROUP BY visited_on
),
prevdays AS(
    SELECT visited_on,
           COUNT(*) OVER(ORDER BY visited_on) AS prev_days
    FROM daily
),
calc as(SELECT d.visited_on,
       SUM(d.amount) OVER(
           ORDER BY d.visited_on
           ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
       ) AS amount,
       round(avg(d.amount) OVER(
           ORDER BY d.visited_on
           ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
       ),2) AS average_amount,
       COUNT(*) OVER(ORDER BY visited_on) as prev_days
FROM daily d
)
SELECT
    visited_on,
    amount,
    average_amount
FROM calc
WHERE prev_days >= 7;
