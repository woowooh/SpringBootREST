CREATE DATABASE `omg` DEFAULT CHARACTER SET utf8mb4;

CREATE TABLE `blog_t` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(11) DEFAULT NULL,
  `content` text,
  `author_name` varchar(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT b'0',
  `content_HTML` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `comment_t` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` text,
  `author_name` varchar(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `blog_id` bigint(20) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT b'0',
  `content_HTML` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
