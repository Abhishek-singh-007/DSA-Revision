select Email as email
from Person
group by email
having count(*)>1