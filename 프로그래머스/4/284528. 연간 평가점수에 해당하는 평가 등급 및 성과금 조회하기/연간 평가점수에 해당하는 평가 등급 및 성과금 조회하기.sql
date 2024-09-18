WITH grades AS(
    SELECT employees.EMP_NO, employees.EMP_NAME
        , (
            CASE
                WHEN AVG(grade.SCORE) >= 96 THEN 'S'
                WHEN AVG(grade.SCORE) >= 90 THEN 'A'
                WHEN AVG(grade.SCORE) >= 80 THEN 'B'
                ELSE 'C'
            END
        ) AS GRADE , employees.SAL
    FROM HR_EMPLOYEES employees
    JOIN HR_GRADE grade
    ON grade.EMP_NO = employees.EMP_NO
    GROUP BY employees.EMP_NO
    ORDER BY employees.EMP_NO ASC
)


SELECT EMP_NO
    , EMP_NAME
    , GRADE
    ,  (
        CASE
            WHEN GRADE = 'S' THEN SAL * 0.2
            WHEN GRADE = 'A' THEN SAL * 0.15
            WHEN GRADE = 'B' THEN SAL * 0.1
            ELSE 0
        END
    ) AS BONUS
FROM grades
GROUP BY EMP_NO