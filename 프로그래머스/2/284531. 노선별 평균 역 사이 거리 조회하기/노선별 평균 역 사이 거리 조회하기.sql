SELECT ROUTE
     , CONCAT(ROUND(SUM(D_BETWEEN_DIST),1),'km') AS TOTAL_DISTANCE
     , CONCAT(ROUND(AVG(D_BETWEEN_DIST),2),'km') AS AVERAGE_DISTANCE
FROM SUBWAY_DISTANCE 
GROUP BY 1
ORDER BY SUM(D_BETWEEN_DIST) DESC