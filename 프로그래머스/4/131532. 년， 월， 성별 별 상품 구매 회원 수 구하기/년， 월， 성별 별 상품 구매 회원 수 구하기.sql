-- 코드를 입력하세요
SELECT year(sales_date) as year, month(sales_date) as month, gender, count(distinct us.user_id) as users
from user_info as us join online_sale as onl on us.user_id = onl.user_id
where gender not like 'null'
group by year(sales_date), month(sales_date), gender
order by year(sales_date), month(sales_date), gender