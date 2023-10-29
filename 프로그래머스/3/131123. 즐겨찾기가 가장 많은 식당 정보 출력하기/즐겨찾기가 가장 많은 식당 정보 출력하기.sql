-- 코드를 입력하세요
SELECT food_type, rest_id, rest_name, favorites
from rest_info
where (food_type, favorites) in (SELECT FOOD_TYPE, MAX(FAVORITES)
FROM REST_INFO
GROUP BY FOOD_TYPE )

order by food_type desc;