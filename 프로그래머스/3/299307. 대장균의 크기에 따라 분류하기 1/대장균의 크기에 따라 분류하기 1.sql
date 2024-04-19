-- 코드를 작성해주세요
select id, case when e.size_of_colony<100 then 'LOW' when e.size_of_colony>1000 then 'HIGH' else 'MEDIUM' end as size
from ecoli_data e