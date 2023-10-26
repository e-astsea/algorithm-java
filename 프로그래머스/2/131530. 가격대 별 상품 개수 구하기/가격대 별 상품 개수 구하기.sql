-- 코드를 입력하세요
SELECT floor(price / 10000)*10000 as a, count(*)
from product
group by floor(price / 10000)
order by a