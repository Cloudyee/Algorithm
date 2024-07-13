-- 0부터 24까지 수를 세는 임시 테이블 작성
WITH RECURSIVE  HOURS AS (
    SELECT 0 AS NUM
    UNION ALL
    SELECT NUM + 1 FROM HOURS -- 재귀적으로 값을 계산
    WHERE NUM < 23 
)

SELECT H.NUM AS HOUR, COUNT(AO.DATETIME) AS COUNT
FROM HOURS H
LEFT JOIN ANIMAL_OUTS AO
ON H.NUM = HOUR(AO.DATETIME)
GROUP BY H.NUM
ORDER BY H.NUM ASC;
