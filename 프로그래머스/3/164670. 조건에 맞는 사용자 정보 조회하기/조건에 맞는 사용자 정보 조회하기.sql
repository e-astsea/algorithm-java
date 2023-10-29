-- 코드를 입력하세요
# SELECT user_id, nickname, concat(street_address1,' ',STREET_ADDRESS2)	as '전체주소' , concat(substr(tlno,1,3),'-',substr(tlno,4,4),'-',substr(tlno,7,4)) as '전화번호'
# from USED_GOODS_BOARD as a join USED_GOODS_USER as b on a.writer_id = b.user_id
# group by a.writer_id
# having count(writer_id) >=3
# order by user_id desc

SELECT B.user_id,B.nickname
,concat(B.city,' ',B.street_address1,' ',B.street_address2) AS 전체주소
,concat(LEFT(tlno,3), '-', MID(tlno,4,4),'-', RIGHT(tlno,4)) AS 전화번호
FROM used_goods_board A join used_goods_user B ON A.writer_id = B.user_id
GROUP BY writer_id
HAVING count(writer_id) >= 3
ORDER BY B.user_id DESC