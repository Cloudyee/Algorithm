SELECT ORDER_ID
    , PRODUCT_ID
    , DATE_FORMAT(OUT_DATE, '%Y-%m-%d') AS OUT_DATE
    , (CASE
            WHEN DATE(OUT_DATE) > '20220501' THEN '출고대기'
            WHEN DATE(OUT_DATE) <= '20220501' THEN '출고완료'
            ELSE '출고미정' 
      END) AS 출고여부
FROM FOOD_ORDER 
ORDER BY ORDER_ID