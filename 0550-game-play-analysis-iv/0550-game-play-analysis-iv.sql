# Write your MySQL query statement below
select round(count(*)/(select count(distinct player_id) from Activity),2) as fraction
from Activity a
join (select player_id,min(event_date) as first_login 
from Activity 
group by player_id) b
on datediff(a.event_date,b.first_login)=1 and a.player_id = b.player_id