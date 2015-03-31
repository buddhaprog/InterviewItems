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
-- Database: `capstone_list_test`
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
  KEY `blog_id` (`blog_id`),
  KEY `user_id` (`user_id`)
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `first_name`, `last_name`, `email`, `username`, `password`, `enabled`) VALUES
(1, 'Jim', 'Jones', 'JJones@Yahoo.com', 'JonesJ', 'password', 0),
(2, 'Tom', 'Smith', 'TSmith@Yahoo.com', 'SmithT', 'drowssap', 0),
(3, 'Tom', 'Sullivan', 'TSullivan@Yahoo.com', 'SullivanT', 'meKinda', 0),
(4, 'John', 'Sullivan', 'JExpo@Yahoo.com', 'ExpoJ', 'bottle', 0);

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
