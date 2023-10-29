-- 코드를 입력하세요
select b.animal_id, b.name
from ANIMAL_INS as a right join ANIMAL_OUTS as b on a.animal_id=b.animal_id
where a.animal_id is null
