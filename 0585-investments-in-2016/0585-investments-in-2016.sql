with dup2015 as(
    select tiv_2015 from Insurance
    group by tiv_2015
    having count(*)>1
),
unicity as (
    select lat,lon from Insurance
    group by lat,lon
    having count(*)=1
)
select round(sum(tiv_2016),2) as tiv_2016
from Insurance i
join dup2015 d
on i.tiv_2015=d.tiv_2015
join unicity u
on i.lat=u.lat and i.lon=u.lon
