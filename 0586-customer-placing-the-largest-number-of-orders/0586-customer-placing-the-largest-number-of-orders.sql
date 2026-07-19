# Write your MySQL query statement below
select customer_number 
from Orders
group by customer_number
having count(*) = (select max(cnt) from (select customer_number ,count(*) as cnt
from Orders
group by customer_number) u)