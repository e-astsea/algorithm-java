-- 코드를 작성해주세요
select e.id, (select count(*) from ecoli_data where parent_id=e.id) as child_count
from ecoli_data e