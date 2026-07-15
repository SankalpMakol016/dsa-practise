# Write your MySQL query statement below
select max(a.num) as num
from MyNumbers a 
join (select num
from MyNumbers
group by num
having count(*)=1) b
on a.num = b.num 
