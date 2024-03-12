-- 코드를 입력하세요
SELECT a.product_id as PRODUCT_ID, product_name as PRODUCT_NAME, price*sum(amount) as TOTAL_SALES
from FOOD_PRODUCT a join FOOD_ORDER b on a.product_id = b.product_id
where year(produce_date) like '2022' and month(produce_date) like '5'
group by a.product_id
order by TOTAL_SALES desc, a.product_id; 