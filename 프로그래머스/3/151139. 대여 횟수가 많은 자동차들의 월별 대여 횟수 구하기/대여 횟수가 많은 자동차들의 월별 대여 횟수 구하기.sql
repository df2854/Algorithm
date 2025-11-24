-- 코드를 입력하세요
SELECT MONTH(h.START_DATE) as MONTH, h.CAR_ID, count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h join (
    select CAR_ID 
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where START_DATE between '2022-08-01' and '2022-10-31'
    group by CAR_ID
    having count(*) >= 5
) c
on h.CAR_ID = c.CAR_ID
where h.START_DATE between '2022-08-01' and '2022-10-31'
group by MONTH(h.START_DATE), h.CAR_ID
order by MONTH, h.CAR_ID desc
;