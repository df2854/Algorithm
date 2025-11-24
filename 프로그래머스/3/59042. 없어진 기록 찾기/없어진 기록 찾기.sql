-- 코드를 입력하세요
SELECT ao.ANIMAL_ID, ao.NAME
from ANIMAL_OUTS ao left join ANIMAL_INS ai
on ao.ANIMAL_ID = ai.ANIMAL_ID
where ai.ANIMAL_ID is null;