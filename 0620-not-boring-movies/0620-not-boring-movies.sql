select id, movie, description,rating 
from Cinema c
where c.id % 2=1 and c.description != "boring"
order by rating desc