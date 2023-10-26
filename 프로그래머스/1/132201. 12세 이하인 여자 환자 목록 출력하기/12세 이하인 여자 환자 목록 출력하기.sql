-- 코드를 입력하세요
SELECT PT_NAME, PT_NO, GEND_CD, AGE, ifnull(TLNO, 'NONE') 
from PATIENT 
where age<=12 and GEND_CD='W'
ORDER BY AGE DESC, PT_NAME;