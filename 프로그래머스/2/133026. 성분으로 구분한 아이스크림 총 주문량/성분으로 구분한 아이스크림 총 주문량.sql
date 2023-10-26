-- 코드를 입력하세요
SELECT ingredient_type,sum(TOTAL_ORDER) as s
from first_half as f join icecream_info as i on f.flavor = i.flavor
group by ingredient_type
order by s;