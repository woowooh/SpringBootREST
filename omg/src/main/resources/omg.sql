CREATE DATABASE `omg` DEFAULT CHARACTER SET utf8mb4;
CREATE TABLE `blog_t` (
  `blog_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(11) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `author_name` varchar(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
