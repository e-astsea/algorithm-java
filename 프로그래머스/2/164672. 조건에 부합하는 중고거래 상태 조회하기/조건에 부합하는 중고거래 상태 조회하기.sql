-- 코드를 입력하세요
SELECT board_id, writer_id, title, price, case when status = 'Done' then '거래완료' when status = 'SALE' then '판매중' when status = 'reserved' then '예약중' end
from USED_GOODS_BOARD
where CREATED_DATE like '2022-10-05'
order by board_id desc