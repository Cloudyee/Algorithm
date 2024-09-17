-- 코드를 작성해주세요

-- 다른분의 좋은 코드 **재귀 RECURSIVE**를 적용해본다.
-- 이런 풀이법도 기억해둘 것!!!
WITH RECURSIVE Generation AS (
    -- 초기 조건: 첫 번째 세대 (PARENT_ID가 NULL인 개체)
    SELECT ID, PARENT_ID, 1 AS Gen
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL

    UNION ALL

    -- 재귀적 조건: 다음 세대 찾기
    SELECT e.ID, e.PARENT_ID, g.Gen + 1 AS Gen
    FROM ECOLI_DATA e
    INNER JOIN Generation g ON e.PARENT_ID = g.ID
)
-- 최종 결과 선택: 3세대 개체의 ID
SELECT ID
FROM Generation
WHERE Gen = 3
ORDER BY ID

-- 기존에 작성했던 이너쿼리 노가다
 # SELECT ID 
 #  FROM ECOLI_DATA 
 #  WHERE PARENT_ID IN (
 #      SELECT ID 
 #      FROM ECOLI_DATA 
 #      WHERE PARENT_ID IN 
 #         (SELECT ID
 #          FROM ECOLI_DATA
 #         WHERE PARENT_ID IS NULL)
 #  )
 #  ORDER BY ID ASC