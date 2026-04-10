# Write your MySQL query statement below
SELECT player_id, event_date as first_login
FROM Activity a
WHERE event_date = (
        SELECT MIN(event_date)
        FROM Activity
        WHERE player_id = a.player_id
);



