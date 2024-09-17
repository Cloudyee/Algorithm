WITH RECURSIVE Generation AS(
    SELECT ID,PARENT_ID, 1 as Gen
      FROM ECOLI_DATA 
     WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT a.ID,a.PARENT_ID, g.Gen+1
    FROM ECOLI_DATA a
    JOIN Generation g
    ON a.PARENT_ID = g.ID
)

-- 자신의 ID가 PARENT_ID에 나타나지 않는 것을 찾으면 됨
SELECT COUNT(*)  COUNT, g.Gen GENERATION
FROM Generation g
WHERE g.ID NOT IN(
    SELECT g.PARENT_ID FROM Generation g
    WHERE g.PARENT_ID IS NOT NULL
)
GROUP BY g.Gen
ORDER BY g.Gen

-- NOT EXISTS를 사용할 경우
# WHERE NOT EXISTS(
#     SELECT 1
#       FROM ECOLI_DATA e
#      WHERE g.ID = e.PARENT_ID
# )