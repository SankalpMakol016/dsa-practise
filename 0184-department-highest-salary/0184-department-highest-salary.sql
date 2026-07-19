# Write your MySQL query statement below
select u.Department , u.Employee , u.Salary 
from 
(select d.name as Department,e.name as Employee,e.salary as Salary,dense_rank() over(partition by d.name order by e.salary desc) as ord
from Employee e
join Department d
on e.departmentId = d.id)u
where u.ord = 1

-- select d.name,e.name,e.salary
-- from Employee e
-- join Department d
-- on e.departmentId = d.id 
