select a1.id 
from Weather a1
join Weather a2
on datediff(a1.recordDate, a2.recordDate)=1
where a1.temperature>a2.temperature