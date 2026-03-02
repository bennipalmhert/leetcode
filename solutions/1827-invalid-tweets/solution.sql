# Write your MySQL query statement below
SELECT t.tweet_id
FROM Tweets AS t
WHERE length(t.content) > 15
