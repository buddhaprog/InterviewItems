-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 25, 2015 at 01:40 PM
-- Server version: 5.5.41
-- PHP Version: 5.3.10-1ubuntu3.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `capstone_list`
--

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE IF NOT EXISTS `authorities` (
  `username` varchar(40) NOT NULL,
  `authority` varchar(40) NOT NULL,
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('test', 'ROLE_ADMIN'),
('test', 'ROLE_USER'),
('test2', 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `blogs`
--

CREATE TABLE IF NOT EXISTS `blogs` (
  `blog_id` int(11) NOT NULL AUTO_INCREMENT,
  `blog_title` varchar(250) DEFAULT NULL,
  `date` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  `blog` text,
  `posted` tinyint(1) NOT NULL,
  PRIMARY KEY (`blog_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=36 ;

--
-- Dumping data for table `blogs`
--

INSERT INTO `blogs` (`blog_id`, `blog_title`, `date`, `user_id`, `blog`, `posted`) VALUES
(18, 'Test', '2015-03-17 00:00:00', 1, '<p>Test</p>', 0),
(19, 'Stuff', '2012-01-01 00:00:00', 1, '<p>Here is a sample, New year''s eve was amazing.</p>', 0),
(21, 'up', '2015-03-17 00:00:00', 1, '<p>hi</p>', 0),
(23, 'Metallica', '2015-03-17 00:00:00', 1, '<p style="margin: 0.5em 0px; line-height: 22.3999996185303px; color: #252525; font-family: sans-serif; font-size: 14px;"><em><strong>And Justice for All</strong></em>&nbsp;is the fourth studio album by American&nbsp;<a style="text-decoration: none; color: #0b0080; background: none;" title="Heavy metal music" href="http://en.wikipedia.org/wiki/Heavy_metal_music">heavy metal</a>&nbsp;band&nbsp;<a style="text-decoration: none; color: #0b0080; background: none;" title="Metallica" href="http://en.wikipedia.org/wiki/Metallica">Metallica</a>, released on August 25, 1988 by&nbsp;<a style="text-decoration: none; color: #0b0080; background: none;" title="Elektra Records" href="http://en.wikipedia.org/wiki/Elektra_Records">Elektra Records</a>. It was the band''s first studio album to feature bassist&nbsp;<a style="text-decoration: none; color: #0b0080; background: none;" title="Jason Newsted" href="http://en.wikipedia.org/wiki/Jason_Newsted">Jason Newsted</a>&nbsp;after the death of&nbsp;<a style="text-decoration: none; color: #0b0080; background: none;" title="Cliff Burton" href="http://en.wikipedia.org/wiki/Cliff_Burton">Cliff Burton</a>&nbsp;in 1986.&nbsp;<em>...And Justice for All</em>&nbsp;is musically progressive, with long and complex songs, fast tempos, and few verse-chorus structures. The album is noted for its sterile production, which producer&nbsp;<a style="text-decoration: none; color: #0b0080; background: none;" title="Flemming Rasmussen" href="http://en.wikipedia.org/wiki/Flemming_Rasmussen">Flemming Rasmussen</a>&nbsp;attributed to his absence during the mixing process. The lyrics feature themes of political and legal injustice seen through the prisms of censorship, war, and nuclear brinkmanship.</p>\n<p style="margin: 0.5em 0px; line-height: 22.3999996185303px; color: #252525; font-family: sans-serif; font-size: 14px;">The album''s front cover, designed by Stephen Gorman on a scheme by&nbsp;<a style="text-decoration: none; color: #0b0080; background: none;" title="James Hetfield" href="http://en.wikipedia.org/wiki/James_Hetfield">James Hetfield</a>&nbsp;and&nbsp;<a style="text-decoration: none; color: #0b0080; background: none;" title="Lars Ulrich" href="http://en.wikipedia.org/wiki/Lars_Ulrich">Lars Ulrich</a>, features a representation of<a style="text-decoration: none; color: #0b0080; background: none;" title="Lady Justice" href="http://en.wikipedia.org/wiki/Lady_Justice">Lady Justice</a>. The phrase "...And Justice for All" appears spray-painted in the lower right corner. The album title is derived from the American&nbsp;<a style="text-decoration: none; color: #0b0080; background: none;" title="Pledge of Allegiance" href="http://en.wikipedia.org/wiki/Pledge_of_Allegiance">Pledge of Allegiance</a>. Originally released on one vinyl disc, the album was quickly re-released as a double album without additional tracks. Three songs from the album were released as singles: "<a style="text-decoration: none; color: #0b0080; background: none;" title="Harvester of Sorrow" href="http://en.wikipedia.org/wiki/Harvester_of_Sorrow">Harvester of Sorrow</a>", "<a style="text-decoration: none; color: #0b0080; background: none;" title="Eye of the Beholder (song)" href="http://en.wikipedia.org/wiki/Eye_of_the_Beholder_(song)">Eye of the Beholder</a>", and "<a style="text-decoration: none; color: #0b0080; background: none;" title="One (Metallica song)" href="http://en.wikipedia.org/wiki/One_(Metallica_song)">One</a>", while the title track was released as a promotional single.</p>\n<p style="margin: 0.5em 0px; line-height: 22.3999996185303px; color: #252525; font-family: sans-serif; font-size: 14px;"><em>...And Justice for All</em>&nbsp;was acclaimed by&nbsp;<a style="text-decoration: none; color: #0b0080; background: none;" title="Music journalism" href="http://en.wikipedia.org/wiki/Music_journalism">music critics</a>. It was included in&nbsp;<em><a style="text-decoration: none; color: #0b0080; background: none;" title="The Village Voice" href="http://en.wikipedia.org/wiki/The_Village_Voice">The Village Voice</a></em>?''?s annual&nbsp;<a style="text-decoration: none; color: #0b0080; background: none;" title="Pazz &amp; Jop" href="http://en.wikipedia.org/wiki/Pazz_%26_Jop">Pazz &amp; Jop</a>&nbsp;critics'' poll of the year''s best albums, and the single "One" earned Metallica its first&nbsp;<a style="text-decoration: none; color: #0b0080; background: none;" title="Grammy Award for Best Metal Performance" href="http://en.wikipedia.org/wiki/Grammy_Award_for_Best_Metal_Performance">Grammy Award for Best Metal Performance</a>&nbsp;in 1990. The group''s best-selling album at the time, it was the first underground metal album to achieve chart success in the United States. The album was certified&nbsp;<a style="text-decoration: none; color: #0b0080; background: none;" title="RIAA certification" href="http://en.wikipedia.org/wiki/RIAA_certification">8&times; platinum</a>&nbsp;by the&nbsp;<a style="text-decoration: none; color: #0b0080; background: none;" title="Recording Industry Association of America" href="http://en.wikipedia.org/wiki/Recording_Industry_Association_of_America">Recording Industry Association of America</a>&nbsp;(RIAA) in 2003 for shipping eight million copies in the US, making it Metallica''s second-best-selling album.</p>', 1),
(30, 'Monday 10:55', '2015-03-23 00:00:00', 1, '<p>Monday 10:55</p>\n<p><canvas id="netbeans_glasspane" style="position: fixed; top: 0px; left: 0px; z-index: 50000; pointer-events: none;" width="615" height="100"></canvas></p>', 0),
(33, 'Testing', '2015-03-25 00:00:00', 1, '<p>New</p>\n<p>&nbsp;</p>', 1),
(35, 'Testing Wednesday', '2015-03-25 00:00:00', 1, '<p>Wednesday Testing</p>', 0);

-- --------------------------------------------------------

--
-- Table structure for table `blogs_images`
--

CREATE TABLE IF NOT EXISTS `blogs_images` (
  `blog_id` int(11) NOT NULL,
  `image_id` int(11) NOT NULL,
  KEY `blog_id` (`blog_id`),
  KEY `image_id` (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(25) NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `category_name` (`category_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `categories_blogs`
--

CREATE TABLE IF NOT EXISTS `categories_blogs` (
  `blog_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  KEY `blog_id` (`blog_id`),
  KEY `category_id` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) NOT NULL,
  `blog_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `user_id` (`user_id`),
  KEY `blog_id` (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `hash_tags`
--

CREATE TABLE IF NOT EXISTS `hash_tags` (
  `hash_tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `hash_tag` varchar(20) NOT NULL,
  PRIMARY KEY (`hash_tag_id`),
  UNIQUE KEY `hash_tag` (`hash_tag`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `hash_tags_blogs`
--

CREATE TABLE IF NOT EXISTS `hash_tags_blogs` (
  `hash_tag_id` int(11) NOT NULL,
  `blog_id` int(11) NOT NULL,
  KEY `hash_tag_id` (`hash_tag_id`),
  KEY `blog_id` (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE IF NOT EXISTS `images` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `image` text NOT NULL,
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `pages`
--

CREATE TABLE IF NOT EXISTS `pages` (
  `page_id` int(11) NOT NULL AUTO_INCREMENT,
  `page` text NOT NULL,
  `page_title` varchar(50) NOT NULL,
  `posted` tinyint(1) NOT NULL,
  PRIMARY KEY (`page_id`),
  UNIQUE KEY `page_title` (`page_title`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Dumping data for table `pages`
--

INSERT INTO `pages` (`page_id`, `page`, `page_title`, `posted`) VALUES
(12, '<p>We post old pictures of ourselves because we weren''t able to post them at the time the picture was taken.</p>', 'Throwback Thursday', 1),
(16, '<p>All these icecream trucks show up, but they don''t sell icecream, they sell food. Like legit, good food.</p>', 'Foodtruck Friday', 1),
(17, '<p>We eat tacos on Tuesday. It''s awesome.&nbsp;</p>', 'Taco Tuesday', 1),
(18, '<p>Can''t sue me anymore!</p>', 'Disclaimer', 1),
(19, '<p>Alliteration. How do you worship the dark prince?</p>\n<p>&nbsp;</p>', 'Satanic Saturday', 1),
(20, '<p>Garfield was right, Monday''s suck and they suck hard.</p>\n<p>&nbsp;</p>', 'Manic Monday', 0),
(21, '<p>If you and someone else order the same meal from a food truck(see Foodtruck Friday page) then you and that person switch souls.</p>', 'Freaky Friday', 0);

-- --------------------------------------------------------

--
-- Table structure for table `pages_images`
--

CREATE TABLE IF NOT EXISTS `pages_images` (
  `page_id` int(11) NOT NULL,
  `image_id` int(11) NOT NULL,
  KEY `page_id` (`page_id`),
  KEY `image_id` (`image_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=34 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `first_name`, `last_name`, `email`, `username`, `password`, `enabled`) VALUES
(1, '', '', '', 'test', 'password', 1),
(2, '', '', '', 'test2', 'password', 1),
(19, 'Robert', 'Noetzel', 'robert.noetzel@gmail.com', 'RNoetzel', 'password', 0),
(26, 'Zach', 'Sullivan', 'Zach.Sullivan83@gmail.com', 'ZSullivan2', 'Pass1', 0),
(27, 'Zach', 'Sullivan', 'Zach.Sullivan83@gmail.com', 'Sullivan2', 'Sullivan1', 0),
(28, 'Zach', 'Sullivan', 'Poop', 'PoopKing', 'Ppppp2', 1),
(29, 'Zach', 'Sullivan', 'asdfsdafsda;#@adsflkj.com', 'now', 'Jjjjj2', 0),
(30, 'Zach', 'Sullivan', 'Monday@Test.com', 'DDDD', 'Three3', 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `authorities_ibfk_2` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE NO ACTION;

--
-- Constraints for table `blogs`
--
ALTER TABLE `blogs`
  ADD CONSTRAINT `blogs_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION;

--
-- Constraints for table `blogs_images`
--
ALTER TABLE `blogs_images`
  ADD CONSTRAINT `blogs_images_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `blogs` (`blog_id`) ON DELETE NO ACTION,
  ADD CONSTRAINT `blogs_images_ibfk_2` FOREIGN KEY (`image_id`) REFERENCES `images` (`image_id`) ON DELETE NO ACTION;

--
-- Constraints for table `categories_blogs`
--
ALTER TABLE `categories_blogs`
  ADD CONSTRAINT `categories_blogs_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `blogs` (`blog_id`) ON DELETE NO ACTION,
  ADD CONSTRAINT `categories_blogs_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`) ON DELETE NO ACTION;

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `blogs` (`blog_id`) ON DELETE NO ACTION,
  ADD CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION;

--
-- Constraints for table `hash_tags_blogs`
--
ALTER TABLE `hash_tags_blogs`
  ADD CONSTRAINT `hash_tags_blogs_ibfk_1` FOREIGN KEY (`hash_tag_id`) REFERENCES `hash_tags` (`hash_tag_id`) ON DELETE NO ACTION,
  ADD CONSTRAINT `hash_tags_blogs_ibfk_2` FOREIGN KEY (`blog_id`) REFERENCES `blogs` (`blog_id`) ON DELETE NO ACTION;

--
-- Constraints for table `pages_images`
--
ALTER TABLE `pages_images`
  ADD CONSTRAINT `pages_images_ibfk_1` FOREIGN KEY (`page_id`) REFERENCES `pages` (`page_id`) ON DELETE NO ACTION,
  ADD CONSTRAINT `pages_images_ibfk_2` FOREIGN KEY (`image_id`) REFERENCES `images` (`image_id`) ON DELETE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
