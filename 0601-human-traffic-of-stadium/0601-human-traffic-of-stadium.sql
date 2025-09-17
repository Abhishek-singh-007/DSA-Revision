WITH filtered AS (
    SELECT *
    FROM Stadium
    WHERE people >= 100
),
chains AS (
    SELECT *,
           id - ROW_NUMBER() OVER (ORDER BY id) AS grp
    FROM filtered
),
valid AS (
    SELECT grp
    FROM chains
    GROUP BY grp
    HAVING COUNT(*) >= 3
)
SELECT c.id, c.visit_date, c.people
FROM chains c
JOIN valid v ON c.grp = v.grp
ORDER BY c.visit_date;
