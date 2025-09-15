WITH first_login AS (
    -- Step 1: Get the first login date for each player
    SELECT 
        player_id, 
        MIN(event_date) AS first_day
    FROM Activity
    GROUP BY player_id
)

-- Step 2 & 3: Count players who logged in the next day and divide by total players
SELECT 
    ROUND(
        COUNT(DISTINCT f.player_id) * 1.0 / (SELECT COUNT(DISTINCT player_id) FROM Activity),
        2
    ) AS fraction
FROM first_login f
JOIN Activity a
    ON f.player_id = a.player_id
    AND a.event_date = DATE_ADD(f.first_day, INTERVAL 1 DAY);
