-- 코드를 입력하세요
SELECT a.product_id, product_name, sum(price*amount)as total_sales
from food_product as a join food_order as b on a.product_id = b.product_id
where date_format(produce_date,'%Y-%m') like '2022-05'
group by product_name
order by total_sales desc, product_id