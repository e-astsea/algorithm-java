-- 코드를 입력하세요
SELECT a.rest_id, a.rest_name, a.food_type, a.favorites, a.address, round(avg(review_score),2) as score
from rest_info as a join rest_review as b on a.rest_id = b.rest_id
where address like '서울%'
group by rest_id
order by score desc, favorites desc

# SELECT *
# from rest_review 
# order by rest_id;