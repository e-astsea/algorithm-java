-- 코드를 입력하세요
SELECT a.author_id, author_name, category, sum(price*sales) as total_sales
from book as b join author as a on b.author_id = a.author_id join book_sales as c on b.book_id = c.book_id
where sales_date like '2022-01%'
group by a.author_name, b.category
order by author_id, category desc;