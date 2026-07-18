with ids as (
    select requester_id as id
    from RequestAccepted
    union all 
    select accepter_id as id 
    from RequestAccepted
)
select id , count(*) as num
from ids 
group by id
having count(*) = (select max(cnt) from
(
    select count(*) as cnt from ids group by id
)u)