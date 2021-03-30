USE CapstoneProject;

SELECT Hashtags.hashtag_name, HashtagsPosts.* FROM HashtagsPosts
JOIN Hashtags ON HashtagsPosts.hashtag_id = Hashtags.hashtag_id
JOIN Posts ON HashtagsPosts.post_id = Posts.post_id
WHERE HashtagsPosts.post_id = 2;

SELECT Posts.post_id, Posts.title, Posts.author, Posts.pub_date,
Posts.likes, Posts.status_id, Posts.photo_url, Posts.content, Posts.synopsis
FROM HashtagsPosts
JOIN Posts ON HashtagsPosts.post_id = Posts.post_id
JOIN Hashtags ON HashtagsPosts.hashtag_id = Hashtags.hashtag_id
WHERE HashtagsPosts.hashtag_id = 3 AND Posts.status_id = 3;

SELECT * FROM Pages;

SELECT * FROM Categories;

SELECT * FROM Hashtags;

