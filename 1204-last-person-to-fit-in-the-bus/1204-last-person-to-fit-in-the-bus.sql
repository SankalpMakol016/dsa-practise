select person_name from Queue 
where turn = (select max(u.turn) from
(select turn,person_name,sum(weight) over(order by turn) as total_weight
from Queue)u
where total_weight <=1000)


