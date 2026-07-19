# Write your MySQL query statement below
with test as (select id, visit_date , people , id - row_number() over(order by id) as grp
from Stadium 
where people >= 100)

select id, visit_date , people
from test 
where grp in (Select grp 
from test 
group by grp 
having count(grp) >=3)



-- select grp 
-- from test 
-- group by grp 
-- having count(grp) >=3