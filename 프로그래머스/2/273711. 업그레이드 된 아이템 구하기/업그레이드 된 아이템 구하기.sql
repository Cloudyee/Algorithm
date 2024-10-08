WITH ID AS (
    SELECT b.ITEM_ID AS ITEM_ID 
    FROM ITEM_INFO a
    JOIN ITEM_TREE b
    ON a.ITEM_ID = b.PARENT_ITEM_ID
    WHERE b.PARENT_ITEM_ID IS NOT NULL
    AND a.RARITY = 'RARE'
    ORDER BY b.ITEM_ID DESC
) 
SELECT a.ITEM_ID, a.ITEM_NAME , a.RARITY
FROM ITEM_INFO a
JOIN ID
ON a.ITEM_ID= ID.ITEM_ID
ORDER BY a.ITEM_ID  DESC
