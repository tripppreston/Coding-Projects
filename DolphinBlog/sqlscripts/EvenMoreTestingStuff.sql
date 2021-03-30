USE CapstoneProject;

SELECT *
FROM Posts
JOIN Categories ON Posts.category_id = Categories.category_id
JOIN Statuses ON Posts.status_id = Statuses.status_id
WHERE Posts.status_id = 3 AND Posts.post_id >= 0
GROUP BY Posts.post_id
ORDER BY Posts.post_id ASC
LIMIT 4;

SELECT *
FROM Posts
JOIN Categories ON Posts.category_id = Categories.category_id
JOIN Statuses ON Posts.status_id = Statuses.status_id
WHERE Posts.post_id <= 4
GROUP BY Posts.post_id
ORDER BY Posts.post_id DESC
LIMIT 4;

SELECT Posts.*,
COUNT(Comments.post_id) AS c
FROM Posts
JOIN Comments ON Posts.post_id = Comments.post_id
WHERE Posts.status_id = 3
GROUP BY Posts.post_id
ORDER BY c DESC
LIMIT 5;



