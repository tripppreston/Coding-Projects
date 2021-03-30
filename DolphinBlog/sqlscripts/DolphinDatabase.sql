DROP DATABASE IF EXISTS CapstoneProject;
CREATE DATABASE CapstoneProject;
USE CapstoneProject;

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
title VARCHAR(65) NOT NULL UNIQUE,
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
comment_text VARCHAR(200) UNIQUE NOT NULL,
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

INSERT INTO Statuses (status_id, status_name)
				VALUES  ( 1, "Edit Mode"),
						( 2, "Awaiting Approval"),
                        ( 3, "Posted");

-- pub_date (timestamp) is omitted from this because it is set automatically 
INSERT INTO Posts (post_id, title, author, category_id, status_id, likes, photo_url, content, synopsis)
			VALUES  ( 1, "Why Dolphins Prefer Communism", "Anastasia Romanov", 6, 3, 15, "https://www.extremetech.com/wp-content/uploads/2015/12/DolphinJump-640x353.jpg", "<p><img style='display: block; margin-left: auto; margin-right: auto;' src='https://www.extremetech.com/wp-content/uploads/2015/12/DolphinJump-640x353.jpg' alt='' width='640' height='353' /></p><p>&nbsp;</p><div class='col-md-6 col-md-offset-1'><h2>Why Dolphins Prefer Communism</h2></div><div class='col-md-4'><h4>11/23/2016</h4></div><div id='text-div1' class='col-md-8 col-md-offset-1'><h2>I am often asked, upon meeting a new face in America 'Anastasia, what do you do for a living?'. I do not hold this question against them. After all, when you spend your whole life under Capitalism, it is hard to see other human beings as anything other than exploitable labor.<br /><br />To this question I respond honestly, and in turn their faces respond in honest amazement. 'Wow! You really train dolphins for a living? Thats so Cool!' It is here that the inqusition begins. <br /><br />'Can you talk to dolphins?!' no.<br /><br />'Can you teach a dolphin to play fetch?!' yes.<br /><br />'Can you perform at my 5 year olds birthday party?!' maybe.<br /><br />'Are they really as rapey as people say?!' All my dolphins are subject to rigorous background checks. <br /><br />'Are they really smarter than people?!'<br /><br />This is the question that I ask my self every night. Could it be that a lack of thumbs are the only thing holding back this hyper intellegent species from ruling our world?<br /><br />What have humans built with their thumbs? They've built weapons to subjugate their fellow man. They've built factories to exploit their fellow mans labor. They created money, so that the few could rule the many simply by changing a number.<br /><br />Yet while man struggles amongst the rocks and the dust, the dolphin lives in harmony beneath the waves. The dolphin cannot build weapons, but when they fight, it is not amongst them selves, but against predatory sharks and squids. A dolphin cannot build a factory, but when they require food, they hunt in unity and share their bounty. A dolphin has no need for money, but if they had it, they would swollow it and choke to death. (STOP THROWING COINS IN MY FUCKING DOLPHIN TANK). <br /><br />Pure and simple, dolphins have chosen to live under communism. And for that their intellegence is without question. <br /><br />-Anastasia Romanov</h2></div>", "Dolphin, Dolphin, BLAHBLAHBLAH Dolphin, Dolphin, BLAHBLAHBLAH Dolphin, Dolphin, BLAHBLAHBLAH Dolphin, Dolphin, BLAHBLAHBLAH "),
					( 2, "My Escape from Russia on Dolphinback", "Anastasia Romanov", 2, 3, 12, "http://www.freakingnews.com/pictures/125500/Vladimir-Putin-Riding-a-Dolphin-125674.jpg", "<p><img style='display: block; margin-left: auto; margin-right: auto;' src='http://www.freakingnews.com/pictures/125500/Vladimir-Putin-Riding-a-Dolphin-125674.jpg' width='403' height='322' /></p><p style='text-align: center;'>&nbsp;</p><h1 style='text-align: center;'>Многие думают, что Lorem Ipsum - взятый с потолка псевдо-латинский набор слов, но это не совсем так. Его корни уходят в один фрагмент классической латыни 45 года н.э., то есть более двух тысячелетий назад. Ричард МакКлинток, профессор латыни из колледжа Hampden-Sydney, штат Вирджиния, взял одно из самых странных слов в Lorem Ipsum, 'consectetur', и занялся его <span style='text-decoration: underline;'><strong>поисками в классической</strong></span> латинской литературе. В результате он нашёл неоспоримый первоисточник Lorem Ipsum в разделах 1.10.32 и 1.10.33 книги 'de Finibus Bonorum et Malorum' ('О пределах добра и зла'), написанной Цицероном в 45 году н.э. Этот трактат по теории этики был очень популярен в эпоху Возрождения. Первая строка Lorem Ipsum, 'Lorem ipsum dolor sit amet..', происходит от одной из строк в разделе 1.10.32</h1>", "Dolphin, Dolphin, BLAHBLAHBLAH Dolphin, Dolphin, BLAHBLAHBLAH Dolphin, Dolphin, BLAHBLAHBLAH Dolphin, Dolphin, BLAHBLAHBLAH "),
					( 3, "Operation D.O.L.P.H.I.N.", "Anastasia Romanov", 4, 3, 1, "http://i340.photobucket.com/albums/o359/Demonicraze/girls%20with%20weapons/Russian-1-2.jpg", "<p>&nbsp;</p><p style='text-align: center;'><a href='http://i340.photobucket.com/albums/o359/Demonicraze/girls%20with%20weapons/Russian-1-2.jpg'><img src='http://i340.photobucket.com/albums/o359/Demonicraze/girls%20with%20weapons/Russian-1-2.jpg' /></a></p><h1 style=text-align: center;'><span style='background-color: #993300; color: #ffffff;'>Love and Dolphins... &nbsp; and&nbsp;GUNS</span></h1>", "Dolphin, Dolphin, BLAHBLAHBLAH Dolphin, Dolphin, BLAHBLAHBLAH Dolphin, Dolphin, BLAHBLAHBLAH Dolphin, Dolphin, BLAHBLAHBLAH "),
                    ( 4, "Meet My New Assistant, Svetlana Aleksandrovna Valova", "Anastasia Romanov", 5, 3, 22, "http://girlswithguns.org/wp-content/uploads/2015/04/RozaSharina.jpg", "<p>&nbsp;</p><p style='text-align: center;'><img src='http://girlswithguns.org/wp-content/uploads/2015/04/RozaSharina.jpg' width='482' height='325' /></p><p style='text-align: center;'>&nbsp;</p><p style='text-align: center;'>Hi, I'm Lana, long time dolphin lover and now a proud member of Team Classified Dolphin Training. &nbsp;</p><p style='text-align: center;'>I look forward to working closely with the community Americanski in 'training' these marvelous animals to 'build a better world'.&nbsp;</p>", "Dolphin, Dolphin, BLAHBLAHBLAH Dolphin, Dolphin, BLAHBLAHBLAH Dolphin, Dolphin, BLAHBLAHBLAH Dolphin, Dolphin, BLAHBLAHBLAH "),
                    ( 5, "Why Swedish Dolphins Resent MIT alum Dolph Lundgren", "Svetlana Aleksandrovna Valova", 6, 1, 0, "https://upload.wikimedia.org/wikipedia/en/3/33/Lundgren_Ivan_Drago.jpg", "<p>&nbsp;</p><p style='text-align: center;'><img src='https://upload.wikimedia.org/wikipedia/en/3/33/Lundgren_Ivan_Drago.jpg' alt='' width='225' height='280' />&nbsp;</p><h1 style='text-align: center;'>DOLPH LUNDGREN CONTENT</h1>", "Dolphin, Dolphin, BLAHBLAHBLAH Dolphin, Dolphin, BLAHBLAHBLAH Dolphin, Dolphin, BLAHBLAHBLAH Dolphin, Dolphin, BLAHBLAHBLAH "),
                    ( 6, "That Time I Took A Bunch of LSD and Could Speak Dolphinese", "Svetlana Aleksandrovna Valova", 1, 2, 0, "http://www.smithsonianchannel.com/site/image-bin/images/0_0_3415122/0_0_3415122_01_640x333.jpg", "<p>&nbsp;</p><p style='text-align: center;'><img src='http://www.smithsonianchannel.com/site/image-bin/images/0_0_3415122/0_0_3415122_01_640x333.jpg' /></p><h1 style='text-align: center;'>Love and Dolphins... &nbsp; and DRUGS</h1>", "Dolphin, Dolphin, BLAHBLAHBLAH Dolphin, Dolphin, BLAHBLAHBLAH Dolphin, Dolphin, BLAHBLAHBLAH Dolphin, Dolphin, BLAHBLAHBLAH ");

INSERT IGNORE INTO Comments  (comment_id, comment_text, post_id)
			       VALUES (1, "Wow who would have guessed someone who works around so many blowholes would become one themselves. Get a job, you useless HIPPIE!!", 1),
						  (2, "So true! I guess you need more than thumbs to seize the means of production", 1),
						  (3, "Coins sink in water, but if you give enough to a dolphin he will just float there...  Can't explain that!", 1),
                          (4, "AMAZING!!  I'm crying!!  You are a hero to women and sea creatures everywhere!!!!!", 2),
                          (5, "Comment Removed.", 3),
                          (6, "Comment will be declassified 16 May 2042", 3),
                          (7, "Comment has been Removed.", 3),
                          (8, "Comment will be declassified on 1 January 2110", 3),
                          (9, "What a Baaaaaaaaaaaaaaaaaabe!", 4),
                          (10, "What year was that picture taken!?!  Do the Russians already have time travel technology, or just really bad photography equipment? U-S-A! U-S-A!", 4),
                          (11, "Cuz he's a loser. Duh.", 5),
                          (12, "The guy speaks like 8 languages and looks like that.  It would be an act of god if he WASN'T a loser", 5),
                          (13, "Those dolphins clearly don't understand who they're dealing with.", 5),
                          (14, "Is that legal?", 6),
                          (15, "Did you take the LSD straight-up?", 6);
                          
INSERT INTO HashtagsPosts(post_id, hashtag_id)
								VALUES (1, 7), 
									   (1, 8), 
									   (2, 9), 
									   (2, 1), 
									   (2, 8), 
									   (3, 10), 
									   (3, 9), 
									   (4, 3), 
									   (4, 2), 
									   (4, 9), 
									   (5, 1), 
									   (6, 1), 
									   (6, 2), 
									   (6, 9);
     
INSERT INTO Tabs (tab_id, tab_name)
				 VALUES (1, "Russia"),
						(2, "Dolphins"),
                        (3, "Orcas"),
                        (4, "Scott");

INSERT INTO Pages (page_id, title, content, tab_id, status_id)
				VALUES	(1, "Popinov", "<h2><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"http://i.imgur.com/YuCTY0n.jpg?fb\" alt=\"\" width=\"480\" height=\"270\" /></h2>\n<h2 style=\"text-align: center;\"><strong>Dolphin 119c3B-2r: Activated 2011</strong></h2>\n<p>&nbsp; &nbsp; &nbsp; <strong>Многие думают,</strong> что Lorem Ipsum - взятый с потолка псевдо-латинский набор слов, но это не совсем так. Его корни уходят в один фрагмент классической латыни 45 года н.э., то есть более двух тысячелетий назад. Ричард МакКлинток, профессор латыни из колледжа Hampden-Sydney, штат Вирджиния, взял одно из самых странных слов в Lorem Ipsum, 'consectetur', и занялся его поисками в классической латинской литературе. В результате он нашёл неоспоримый первоисточник Lorem Ipsum в разделах 1.10.32 и 1.10.33 книги 'de Finibus Bonorum et Malorum' ('О пределах добра и зла'), написанной Цицероном в 45 году н.э. Этот трактат по теории этики был очень популярен в эпоху Возрождения. Первая строка Lorem Ipsum, 'Lorem ipsum dolor sit amet..', происходит от одной из строк в разделе 1.10.32 Многие думают, что Lorem Ipsum - взятый с потолка псевдо-латинский набор слов, но это не совсем так. Его корни уходят в один фрагмент классической латыни 45 года н.э., то есть более двух тысячелетий назад. Ричард МакКлинток, профессор латыни из колледжа Hampden-Sydney, штат Вирджиния, взял одно из самых странных слов в Lorem Ipsum, 'consectetur', и занялся его поисками в классической латинской литературе. В результате он нашёл неоспоримый первоисточник Lorem Ipsum в разделах 1.10.32 и 1.10.33 книги 'de Finibus Bonorum et Malorum' ('О пределах добра и зла'), написанной Цицероном в 45 году н.э. Этот трактат по теории этики был очень популярен в эпоху Возрождения. Первая строка Lorem Ipsum, 'Lorem ipsum dolor sit amet..', происходит от одной из строк в разделе 1.10.32</p>", 2, 1),
						(2, "Vladimir", "<h2><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://i.ytimg.com/vi/UXaf3DZEpus/maxresdefault.jpg\" alt=\"\" width=\"756\" height=\"425\" /></h2>\n<h2 style=\"text-align: center;\">Dolphin 208A: Activated 2014</h2>\n<p>Многие думают, что Lorem Ipsum - взятый с потолка псевдо-латинский набор слов, но это не совсем так. Его корни уходят в один фрагмент классической латыни 45 года н.э., то есть более двух тысячелетий назад. Ричард МакКлинток, профессор латыни из колледжа Hampden-Sydney, штат Вирджиния, взял одно из самых странных слов в Lorem Ipsum, 'consectetur', и занялся его поисками в классической латинской литературе. В результате он нашёл неоспоримый первоисточник Lorem Ipsum в разделах 1.10.32 и 1.10.33 книги 'de Finibus Bonorum et Malorum' ('О пределах добра и зла'), написанной Цицероном в 45 году н.э. Этот трактат по теории этики был очень популярен в эпоху Возрождения. Первая строка Lorem Ipsum, 'Lorem ipsum dolor sit amet..', происходит от одной из строк в разделе 1.10.32 Многие думают, что Lorem Ipsum - взятый с потолка псевдо-латинский набор слов, но это не совсем так. Его корни уходят в один фрагмент классической латыни 45 года н.э., то есть более двух тысячелетий назад. Ричард МакКлинток, профессор латыни из колледжа Hampden-Sydney, штат Вирджиния, взял одно из самых странных слов в Lorem Ipsum, 'consectetur', и занялся его поисками в классической латинской литературе. В результате он нашёл неоспоримый первоисточник Lorem Ipsum в разделах 1.10.32 и 1.10.33 книги 'de Finibus Bonorum et Malorum' ('О пределах добра и зла'), написанной Цицероном в 45 году н.э. Этот трактат по теории этики был очень популярен в эпоху Возрождения. Первая строка Lorem Ipsum, 'Lorem ipsum dolor sit amet..', происходит от одной из строк в разделе 1.10.32</p>\n<p>&nbsp;</p>\n<p>&nbsp;</p>\n<p>&nbsp;</p>", 2, 1),
						(3, "Russia1", "YUUGE", 1, 3),
						(4, "Russia2", "YUUGE", 1, 1),
						(5, "Orcas1", "YUUGE", 3, 1),
						(6, "Scott1", "YUUGE", 4, 3);   





CREATE TABLE IF NOT EXISTS `users` (
 `user_id` int(11) NOT NULL AUTO_INCREMENT,
 `username` varchar(20) NOT NULL,
 `password` varchar(20) NOT NULL,
 `enabled` tinyint(1) NOT NULL,
 PRIMARY KEY (`user_id`),
 KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;
--
-- Dumping data for table `users`
--
INSERT INTO `users` (`user_id`, `username`, `password`, `enabled`) VALUES
(1, 'admin', 'password', 1),
(2, 'employee', 'password', 1)
;
--
-- Table structure for table `authorities`
--
CREATE TABLE IF NOT EXISTS `authorities` (
 `username` varchar(20) NOT NULL,
 `authority` varchar(20) NOT NULL,
 KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Dumping data for table `authorities`
--
INSERT INTO `authorities` (`username`, `authority`) VALUES
('admin', 'ROLE_ADMIN'),
('employee', 'ROLE_USER');

;
--
-- Constraints for table `authorities`
--
ALTER TABLE `authorities`
 ADD CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users`(`username`);
 