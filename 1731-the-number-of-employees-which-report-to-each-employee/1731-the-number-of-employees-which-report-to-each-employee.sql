# Write your MySQL query statement below
select a.employee_id , a.name , count(*) as reports_count ,round(avg(b.age)) as average_age
from Employees a 
join Employees b 
on b.reports_to = a.employee_id
group by a.employee_id
order by a.employee_id asc