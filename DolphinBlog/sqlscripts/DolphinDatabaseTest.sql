DROP DATABASE IF EXISTS CapstoneProjectTest;
CREATE DATABASE CapstoneProjectTest;
USE CapstoneProjectTest;

CREATE TABLE IF NOT EXISTS Categories(
category_id INT AUTO_INCREMENT NOT NULL,
category_name VARCHAR(50) UNIQUE NOT NULL,
PRIMARY KEY (category_id)
);

CREATE TABLE IF NOT EXISTS Hashtags(
hashtag_id INT AUTO_INCREMENT NOT NULL,
hashtag_name VARCHAR(50) UNIQUE NOT NULL,
PRIMARY KEY (hashtag_id)
);

CREATE TABLE IF NOT EXISTS Statuses(
status_id INT AUTO_INCREMENT NOT NULL,
status_name VARCHAR(50) NOT NULL,
PRIMARY KEY (status_id)
);

CREATE TABLE IF NOT EXISTS Posts(
post_id INT AUTO_INCREMENT NOT NULL,
title VARCHAR(65) NOT NULL,
author VARCHAR (40) NOT NULL,
pub_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
category_id INT NOT NULL,
status_id INT NOT NULL DEFAULT 1,
likes INT NOT NULL DEFAULT 0,
photo_url NVARCHAR(400) NOT NULL,
content NVARCHAR(10000) NOT NULL,
synopsis NVARCHAR(500) NOT NULL,
FOREIGN KEY (category_id) REFERENCES Categories(category_id),
FOREIGN KEY (status_id) REFERENCES Statuses(status_id),
PRIMARY KEY (post_id)
);

CREATE TABLE IF NOT EXISTS Comments(
comment_id INT AUTO_INCREMENT NOT NULL,
comment_text VARCHAR(200) NOT NULL,
post_id INT NOT NULL,
FOREIGN KEY (post_id) REFERENCES Posts (post_id),
PRIMARY KEY (comment_id)
);

-- Do we need this table?  I'm under the impression that we don't 

-- CREATE TABLE IF NOT EXISTS CategoriesPosts(
-- cat_post_id INT AUTO_INCREMENT NOT NULL,
-- post_id INT NOT NULL,
-- category_id INT NOT NULL,
-- FOREIGN KEY (post_id) REFERENCES Posts (post_id),
-- FOREIGN KEY (category_id) REFERENCES Categories (category_id),
-- PRIMARY KEY (cat_post_id)
-- );

CREATE TABLE IF NOT EXISTS HashtagsPosts(
post_id INT NOT NULL,
hashtag_id INT NOT NULL,
FOREIGN KEY (post_id) REFERENCES Posts (post_id),
FOREIGN KEY (hashtag_id) REFERENCES Hashtags (hashtag_id)
);

-- photo_url is not included because it should be stored as part of  content

CREATE TABLE IF NOT EXISTS Tabs(
tab_id INT AUTO_INCREMENT NOT NULL,
tab_name VARCHAR(20) NOT NULL,
PRIMARY KEY (tab_id)
);


CREATE TABLE IF NOT EXISTS Pages(
page_id INT AUTO_INCREMENT NOT NULL,
title VARCHAR(15) NOT NULL,
content NVARCHAR(10000) NOT NULL,
tab_id INT NOT NULL,
status_id INT NOT NULL DEFAULT 1,
PRIMARY KEY (page_id),
FOREIGN KEY (tab_id) REFERENCES Tabs (tab_id),
FOREIGN KEY (status_id) REFERENCES Statuses (status_id)
);

INSERT INTO Categories (category_id, category_name)
				VALUES  ( 1, "Training"),
						( 2, "Travels"),
                        ( 3, "Style"),
						( 4, "Personnel"),
                        ( 5, "Mission"),
                        ( 6, "Other");
                        
INSERT INTO Statuses (status_id, status_name)
				VALUES  ( 1, "Edit Mode"),
						( 2, "Awaiting Approval"),
                        ( 3, "Posted");
                        
INSERT INTO Hashtags (hashtag_id, hashtag_name)
				VALUES  ( 1, "Finning"),
						( 2, "DolphinMania"),
                        ( 3, "Cute"),
                        ( 4, "Echolocation"),
                        ( 5, "FuckSharks"),
						( 6, "StalinDidNothingWrong"),
                        ( 7, "RejectCapitalism"),
                        ( 8, "Rescue"),
                        ( 9, "ComradesForLife"),
                        ( 10, "EnemySubLocations");
                        
INSERT INTO Tabs (tab_id, tab_name)
				 VALUES (1, "Russia"),
						(2, "Dolphins"),
                        (3, "Orcas"),
                        (4, "Scott");