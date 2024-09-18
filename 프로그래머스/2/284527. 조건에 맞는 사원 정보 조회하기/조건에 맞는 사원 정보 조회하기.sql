WITH MAX_SCORE AS(
    SELECT SUM(SCORE) AS SCORE , EMP_NO
    FROM HR_GRADE
    GROUP BY EMP_NO
    ORDER BY SCORE DESC
)

SELECT score.SCORE, employees.EMP_NO 
     , employees.EMP_NAME
     , employees.POSITION
     , employees.EMAIL
FROM MAX_SCORE score
JOIN HR_EMPLOYEES employees
ON score.EMP_NO = employees.EMP_NO
WHERE score.SCORE = (
    SELECT MAX(SCORE)
      FROM MAX_SCORE
)
