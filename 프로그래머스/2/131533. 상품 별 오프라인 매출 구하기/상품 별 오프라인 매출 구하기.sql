-- 코드를 입력하세요
SELECT PRODUCT_CODE, (os.AMOUNT * p.PRICE) as SALES
from PRODUCT p join 
(select PRODUCT_ID, sum(SALES_AMOUNT) as AMOUNT
from OFFLINE_SALE
group by PRODUCT_ID) os
on p.PRODUCT_ID = os.PRODUCT_ID
order by SALES desc, PRODUCT_CODE;

