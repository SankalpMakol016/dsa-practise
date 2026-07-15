# Write your MySQL query statement below
select a.product_id, a.year as first_year , a.quantity , a.price
from Sales a
join (select product_id,min(year) as year from Sales group by product_id) b
on a.product_id = b.product_id
and a.year = b.year 

