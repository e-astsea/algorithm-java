-- 코드를 입력하세요
SELECT f.flavor
from july as j join first_half as f on j.flavor = f.flavor
group by f.flavor
order by sum(j.total_order + f.total_order) desc
limit 3