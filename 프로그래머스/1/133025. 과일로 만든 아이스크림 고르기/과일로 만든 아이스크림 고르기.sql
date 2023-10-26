-- 코드를 입력하세요
SELECT a.flavor
from FIRST_HALF as a join ICECREAM_INFO as b on a.flavor = b.flavor
where TOTAL_ORDER>3000 and INGREDIENT_TYPE = 'fruit_based'
order by total_order desc