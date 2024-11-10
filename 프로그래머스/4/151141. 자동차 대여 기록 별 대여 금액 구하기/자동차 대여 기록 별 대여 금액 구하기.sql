SELECT 
    car_history.HISTORY_ID,
    ROUND(
        car_history.DAILY_FEE * (1 - IFNULL(plan.DISCOUNT_RATE, 0) / 100) * car_history.DURATION
    ) AS FEE
FROM (
    SELECT 
        history.HISTORY_ID,
        car.CAR_ID,
        car.CAR_TYPE,
        car.DAILY_FEE,
        DATEDIFF(history.END_DATE, DATE_SUB(history.START_DATE, INTERVAL 1 DAY)) AS DURATION,
        CASE
            WHEN DATEDIFF(history.END_DATE, DATE_SUB(history.START_DATE, INTERVAL 1 DAY)) >= 7 
                 AND DATEDIFF(history.END_DATE, DATE_SUB(history.START_DATE, INTERVAL 1 DAY)) < 30 THEN '7일 이상'
            WHEN DATEDIFF(history.END_DATE, DATE_SUB(history.START_DATE, INTERVAL 1 DAY)) >= 30 
                 AND DATEDIFF(history.END_DATE, DATE_SUB(history.START_DATE, INTERVAL 1 DAY)) < 90 THEN '30일 이상'
            WHEN DATEDIFF(history.END_DATE, DATE_SUB(history.START_DATE, INTERVAL 1 DAY)) >= 90 THEN '90일 이상'
            ELSE NULL
        END AS DURATION_TYPE
    FROM CAR_RENTAL_COMPANY_CAR car
    JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY history
    ON car.CAR_ID = history.CAR_ID
    WHERE car.CAR_TYPE = '트럭'
) car_history
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN plan
ON car_history.CAR_TYPE = plan.CAR_TYPE AND car_history.DURATION_TYPE = plan.DURATION_TYPE
ORDER BY FEE DESC, car_history.HISTORY_ID DESC;
