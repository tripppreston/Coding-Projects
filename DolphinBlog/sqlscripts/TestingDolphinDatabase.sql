USE CapstoneProject;

SELECT Posts.post_id, Posts.author, Posts.content, Posts.likes, Posts.pub_date, Posts.title, Posts.status_id,
Categories.category_name,
Statuses.status_name,
Categories.category_id
FROM Posts
JOIN Categories ON Posts.category_id = Categories.category_id
JOIN Statuses ON Posts.status_id = Statuses.status_id
WHERE Categories.category_id = 4 AND Posts.status_id = 2;

SELECT * FROM Comments
WHERE Comments.post_id = 1;

SELECT Posts.*, Hashtags.hashtag_name
FROM HashtagsPosts
JOIN Hashtags ON HashtagsPosts.hashtag_id = Hashtags.hashtag_id
JOIN Posts ON HashtagsPosts.post_id = Posts.post_id
WHERE Posts.title LIKE '%Dolphin%' OR Hashtags.hashtag_name LIKE 'T%';

SELECT * FROM Pages;

SELECT Posts.*, Comments.*
FROM Posts
JOIN Comments ON Posts.post_id = Comments.post_id
WHERE Posts.post_id = 1;

SELECT Posts.post_id, Posts.author, Posts.content, Posts.likes, Posts.pub_date, Posts.title, Posts.status_id,
Categories.category_name,
Statuses.status_name,
Categories.category_id
FROM Posts
JOIN Categories ON Posts.category_id = Categories.category_id
JOIN Statuses ON Posts.status_id = Statuses.status_id
WHERE Posts.status_id = 3
LIMIT 3 OFFSET 3;

