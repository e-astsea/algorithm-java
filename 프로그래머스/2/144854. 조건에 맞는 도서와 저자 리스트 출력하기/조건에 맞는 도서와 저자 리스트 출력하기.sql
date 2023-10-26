-- 코드를 입력하세
SELECT book_id, author_name, date_format(published_date, '%Y-%m-%d') as published_date
from book b join author a on b.author_id=a.author_id
where category like '경제'
order by published_date