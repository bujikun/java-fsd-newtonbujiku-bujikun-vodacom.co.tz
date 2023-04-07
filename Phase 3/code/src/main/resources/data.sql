-- Adminer 4.8.1 MySQL 8.0.32 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP DATABASE IF EXISTS `sporty_shoes`;
CREATE DATABASE `sporty_shoes` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sporty_shoes`;

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_on` datetime(6) DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated_on` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `categories`;
INSERT INTO `categories` (`id`, `created_on`, `deleted`, `description`, `name`, `updated_on`) VALUES
(1,	'2023-04-06 19:12:55.014536',	CONV('0', 2, 10) + 0,	'Running shoes',	'Athletic',	'2023-04-06 19:12:55.014554'),
(2,	'2023-04-06 19:12:55.015916',	CONV('0', 2, 10) + 0,	'Boxing shoes',	'Boxing',	'2023-04-06 19:12:55.015926'),
(3,	'2023-04-06 19:12:55.016960',	CONV('0', 2, 10) + 0,	'Cycling shoes',	'Cycling',	'2023-04-06 19:12:55.016970'),
(4,	'2023-04-06 19:12:55.018123',	CONV('0', 2, 10) + 0,	'Just casual sportswear',	'Casual',	'2023-04-06 19:12:55.018136'),
(5,	'2023-04-06 19:12:55.019313',	CONV('0', 2, 10) + 0,	'For a wide range of sports',	'All Sports',	'2023-04-06 19:12:55.019326');

DROP TABLE IF EXISTS `line_items`;
CREATE TABLE `line_items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_on` datetime(6) DEFAULT NULL,
  `line_item_count` int DEFAULT NULL,
  `line_item_price` decimal(38,2) DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `total_line_price` decimal(38,2) DEFAULT NULL,
  `updated_on` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `line_items`;
INSERT INTO `line_items` (`id`, `created_on`, `line_item_count`, `line_item_price`, `product_id`, `product_name`, `total_line_price`, `updated_on`) VALUES
(1,	'2023-04-06 19:35:15.235734',	1,	123.99,	1,	'Nike Air Max',	123.99,	'2023-04-06 19:35:15.235828'),
(2,	'2023-04-06 19:35:15.284349',	1,	123.99,	3,	'Nike Air Max',	123.99,	'2023-04-06 19:35:15.284365'),
(3,	'2023-04-06 19:35:57.014826',	1,	123.99,	3,	'Nike Air Max',	123.99,	'2023-04-06 19:35:57.014938'),
(4,	'2023-04-06 19:35:57.089648',	1,	123.99,	5,	'Nike Air Max',	123.99,	'2023-04-06 19:35:57.089727'),
(5,	'2023-04-06 19:36:41.248300',	1,	150.55,	4,	'Specialized S-Works',	150.55,	'2023-04-06 19:36:41.248349'),
(6,	'2023-04-06 19:36:41.293076',	1,	150.55,	6,	'Specialized S-Works',	150.55,	'2023-04-06 19:36:41.293095'),
(7,	'2023-04-06 19:37:55.824661',	3,	150.55,	2,	'Specialized S-Works',	451.65,	'2023-04-06 19:37:55.824731'),
(8,	'2023-04-06 19:37:55.874434',	1,	123.99,	5,	'Nike Air Max',	123.99,	'2023-04-06 19:37:55.874495'),
(9,	'2023-04-06 19:37:55.908873',	1,	150.55,	6,	'Specialized S-Works',	150.55,	'2023-04-06 19:37:55.908904'),
(10,	'2023-04-06 19:38:17.897859',	3,	123.99,	3,	'Nike Air Max',	371.97,	'2023-04-06 19:38:17.897938'),
(11,	'2023-04-06 19:38:17.921922',	2,	123.99,	5,	'Nike Air Max',	247.98,	'2023-04-06 19:38:17.921963'),
(12,	'2023-04-06 19:39:11.529587',	1,	123.99,	1,	'Nike Air Max',	123.99,	'2023-04-06 19:39:11.529698'),
(13,	'2023-04-06 19:39:11.583363',	1,	123.99,	3,	'Nike Air Max',	123.99,	'2023-04-06 19:39:11.583447'),
(14,	'2023-04-06 19:39:39.317408',	4,	150.55,	2,	'Specialized S-Works',	602.20,	'2023-04-06 19:39:39.317430');

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_on` date DEFAULT NULL,
  `fk_user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKckfg68dp2m04316kkk1gj8anx` (`fk_user_id`),
  CONSTRAINT `FKckfg68dp2m04316kkk1gj8anx` FOREIGN KEY (`fk_user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `orders`;
INSERT INTO `orders` (`id`, `created_on`, `fk_user_id`) VALUES
(1,	'2023-04-06',	1),
(2,	'2023-05-07',	1),
(3,	'2023-06-07',	1),
(4,	'2023-08-07',	2),
(5,	'2023-09-07',	2),
(6,	'2023-04-06',	3),
(7,	'2023-04-06',	3);

DROP TABLE IF EXISTS `orders_line_items`;
CREATE TABLE `orders_line_items` (
  `fk_order_id` int NOT NULL,
  `fk_item_id` int NOT NULL,
  PRIMARY KEY (`fk_order_id`,`fk_item_id`),
  KEY `FKl8op57w5wxh7xjm00ug17af78` (`fk_item_id`),
  CONSTRAINT `FK86peu6tytcrfah0epeufnor3b` FOREIGN KEY (`fk_order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKl8op57w5wxh7xjm00ug17af78` FOREIGN KEY (`fk_item_id`) REFERENCES `line_items` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `orders_line_items`;
INSERT INTO `orders_line_items` (`fk_order_id`, `fk_item_id`) VALUES
(1,	1),
(1,	2),
(2,	3),
(2,	4),
(3,	5),
(3,	6),
(4,	7),
(4,	8),
(4,	9),
(5,	10),
(5,	11),
(6,	12),
(6,	13),
(7,	14);

DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_on` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated_on` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pnvtwliis6p05pn6i3ndjrqt2` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `permissions`;
INSERT INTO `permissions` (`id`, `created_on`, `name`, `updated_on`) VALUES
(1,	'2023-04-06 19:12:54.629502',	'category:view',	'2023-04-06 19:12:54.763432'),
(2,	'2023-04-06 19:12:54.646888',	'order:create',	'2023-04-06 19:12:54.772054'),
(3,	'2023-04-06 19:12:54.649623',	'user:edit',	'2023-04-06 19:12:54.768058'),
(4,	'2023-04-06 19:12:54.651893',	'user:view',	'2023-04-06 19:12:54.769180'),
(5,	'2023-04-06 19:12:54.656468',	'product:view',	'2023-04-06 19:12:54.770139'),
(6,	'2023-04-06 19:12:54.658398',	'order:view',	'2023-04-06 19:12:54.772767'),
(7,	'2023-04-06 19:12:54.660261',	'cart:view',	'2023-04-06 19:12:54.771146'),
(8,	'2023-04-06 19:12:54.685571',	'category:edit',	'2023-04-06 19:12:54.685596'),
(9,	'2023-04-06 19:12:54.740765',	'user:delete',	'2023-04-06 19:12:54.740785'),
(10,	'2023-04-06 19:12:54.744669',	'category:view:all',	'2023-04-06 19:12:54.744680'),
(11,	'2023-04-06 19:12:54.745654',	'order:view:all',	'2023-04-06 19:12:54.745664'),
(12,	'2023-04-06 19:12:54.746730',	'stock:view',	'2023-04-06 19:12:54.746747'),
(13,	'2023-04-06 19:12:54.748702',	'category:delete',	'2023-04-06 19:12:54.748713'),
(14,	'2023-04-06 19:12:54.749653',	'product:link:category',	'2023-04-06 19:12:54.749663'),
(15,	'2023-04-06 19:12:54.750597',	'report:view',	'2023-04-06 19:12:54.750610'),
(16,	'2023-04-06 19:12:54.754173',	'product:delete',	'2023-04-06 19:12:54.754187'),
(17,	'2023-04-06 19:12:54.755153',	'product:add',	'2023-04-06 19:12:54.755163'),
(18,	'2023-04-06 19:12:54.755995',	'category:link:product',	'2023-04-06 19:12:54.756005'),
(19,	'2023-04-06 19:12:54.756844',	'user:view:all',	'2023-04-06 19:12:54.756854'),
(20,	'2023-04-06 19:12:54.757672',	'product:edit',	'2023-04-06 19:12:54.757681'),
(21,	'2023-04-06 19:13:54.757672',	'user:change-password',	'2023-04-06 19:13:54.757681'),
(22,	'2023-04-06 19:14:54.757672',	'admin:add',	'2023-04-06 19:14:54.757681'),
(23,	'2023-04-06 19:15:54.757672',	'manage:view',	'2023-04-06 19:15:54.757681');




DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `count` int DEFAULT NULL,
  `created_on` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(38,2) DEFAULT NULL,
  `updated_on` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `products`;
INSERT INTO `products` (`id`, `count`, `created_on`, `description`, `image_url`, `name`, `price`, `updated_on`) VALUES
(1,	20,	'2023-04-06 19:12:55.024122',	'Nike Air 2020 Model',	'/imgs/nike-air.png',	'Nike Air Max',	123.99,	'2023-04-06 19:12:55.024133'),
(2,	20,	'2023-04-06 19:12:55.030572',	'For Road Cycling 2023',	'/imgs/s-works.jpg',	'Specialized S-Works',	150.55,	'2023-04-06 19:12:55.030590'),
(3,	20,	'2023-04-06 19:12:55.035769',	'Nike Air 2020 Model',	'/imgs/nike-air.png',	'Nike Air Max',	123.99,	'2023-04-06 19:12:55.035787'),
(4,	20,	'2023-04-06 19:12:55.043128',	'For Road Cycling 2023',	'/imgs/s-works.jpg',	'Specialized S-Works',	150.55,	'2023-04-06 19:12:55.043142'),
(5,	20,	'2023-04-06 19:12:55.049161',	'Nike Air 2020 Model',	'/imgs/nike-air.png',	'Nike Air Max',	123.99,	'2023-04-06 19:12:55.049173'),
(6,	20,	'2023-04-06 19:12:55.055281',	'Specialized S-Works For Road Cycling 2023',	'/imgs/s-works.jpg',	'Specialized S-Works',	150.55,	'2023-04-06 19:12:55.055294');

DROP TABLE IF EXISTS `products_categories`;
CREATE TABLE `products_categories` (
  `fk_product_id` int NOT NULL,
  `fk_category_id` int NOT NULL,
  PRIMARY KEY (`fk_product_id`,`fk_category_id`),
  KEY `FKaw3iu1c0jugfoftmrkeuqqaae` (`fk_category_id`),
  CONSTRAINT `FKaw3iu1c0jugfoftmrkeuqqaae` FOREIGN KEY (`fk_category_id`) REFERENCES `categories` (`id`),
  CONSTRAINT `FKg2boaomoduymgbxpd0co0navg` FOREIGN KEY (`fk_product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `products_categories`;
INSERT INTO `products_categories` (`fk_product_id`, `fk_category_id`) VALUES
(2,	1),
(4,	1),
(6,	1),
(1,	3),
(3,	3),
(5,	3),
(1,	4),
(3,	4),
(5,	4),
(1,	5),
(2,	5),
(3,	5),
(4,	5),
(5,	5),
(6,	5);

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_on` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated_on` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `roles`;
INSERT INTO `roles` (`id`, `created_on`, `name`, `updated_on`) VALUES
(1,	'2023-04-06 19:12:54.780043',	'ADMIN',	'2023-04-06 19:12:54.780055'),
(2,	'2023-04-06 19:12:54.781274',	'USER',	'2023-04-06 19:12:54.781286');

DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions` (
  `fk_role_id` int NOT NULL,
  `fk_permission_id` int NOT NULL,
  PRIMARY KEY (`fk_role_id`,`fk_permission_id`),
  KEY `FK8cbm4q9aponn60pqfawcq361i` (`fk_permission_id`),
  CONSTRAINT `FK8cbm4q9aponn60pqfawcq361i` FOREIGN KEY (`fk_permission_id`) REFERENCES `permissions` (`id`),
  CONSTRAINT `FKck8gp7wn2tkc478yct49imcjc` FOREIGN KEY (`fk_role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `roles_permissions`;
INSERT INTO `roles_permissions` (`fk_role_id`, `fk_permission_id`) VALUES
(1,	1),
(2,	1),
(1,	2),
(2,	2),
(1,	3),
(2,	3),
(1,	4),
(2,	4),
(1,	5),
(2,	5),
(1,	6),
(2,	6),
(1,	7),
(2,	7),
(1,	8),
(1,	9),
(1,	10),
(1,	11),
(1,	12),
(1,	13),
(1,	14),
(1,	15),
(1,	16),
(1,	17),
(1,	18),
(1,	19),
(1,	20),
(1,	21),
(1,	22),
(2,	21),
(1,	23),
(2,	23);




DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `created_on` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `is_account_expired` bit(1) DEFAULT NULL,
  `is_account_locked` bit(1) DEFAULT NULL,
  `is_credentials_expired` bit(1) DEFAULT NULL,
  `is_enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `payment_account_number` varchar(255) DEFAULT NULL,
  `updated_on` datetime(6) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `users`;
INSERT INTO `users` (`id`, `city`, `created_on`, `email`, `is_account_expired`, `is_account_locked`, `is_credentials_expired`, `is_enabled`, `password`, `payment_account_number`, `updated_on`, `username`) VALUES
(1,	'Dodoma',	'2023-04-06 19:12:54.984509',	'admin@sportyshoes.com',	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	CONV('1', 2, 10) + 0,	'{bcrypt}$2a$10$OTk1fTRmaJwpfoxYvCsPDOSZz6Be234fEYq6wIEFys/UKx5TJk.FS',	'0057E569-B2DE-4DE0-BEC0-07EC7C9FCF18',	'2023-04-06 19:12:54.984525',	'admin'),
(2,	'Dar Es Salaam',	'2023-04-06 19:12:54.991192',	'user@sportyshoes.com',	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	CONV('1', 2, 10) + 0,	'{bcrypt}$2a$10$FyTcNt6YuT9sZPm0Bh6pw.xRokaXKTxNR1L7Urh1/rVkT6tYIqseu',	'AEE4F7A1-F2EA-4D6A-AA1E-6B947B6BB7D6',	'2023-04-06 19:12:54.991203',	'user'),
(3,	'New York',	'2023-04-06 19:39:00.213957',	'donnie@gmail.com',	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	CONV('1', 2, 10) + 0,	'{bcrypt}$2a$10$qdteEFdd3esDpRsoiLHL9.jbetTSbkJQQuO4OeDXRFbsiC2wO8i76',	'EDF3C078-54B4-4648-8749-27360A667DAE',	'2023-04-06 19:39:00.214010',	'donnie');

DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
  `fk_user_id` int NOT NULL,
  `fk_role_id` int NOT NULL,
  PRIMARY KEY (`fk_user_id`,`fk_role_id`),
  KEY `FKaeu8lc9yh8laevs59733qluau` (`fk_role_id`),
  CONSTRAINT `FKaeu8lc9yh8laevs59733qluau` FOREIGN KEY (`fk_role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKbvwr8podnb6u5iefx7agb3y6w` FOREIGN KEY (`fk_user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `users_roles`;
INSERT INTO `users_roles` (`fk_user_id`, `fk_role_id`) VALUES
(1,	1),
(1,	2),
(2,	2),
(3,	2);

-- 2023-04-06 17:53:02
