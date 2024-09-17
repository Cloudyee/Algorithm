-- 코드를 작성해주세요
-- 1세대, 2세대, 3세대를 차례대로 구하여 WHERE 조건에 추가
 SELECT ID 
  FROM ECOLI_DATA 
  WHERE PARENT_ID IN (
      SELECT ID 
      FROM ECOLI_DATA 
      WHERE PARENT_ID IN 
         (SELECT ID
          FROM ECOLI_DATA
         WHERE PARENT_ID IS NULL)
  )
  ORDER BY ID ASC
