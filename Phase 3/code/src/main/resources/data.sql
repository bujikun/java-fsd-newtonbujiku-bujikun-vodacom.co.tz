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

INSERT INTO `categories` (`id`, `created_on`, `deleted`, `description`, `name`, `updated_on`) VALUES
(1,	'2023-04-06 19:12:55.014536',	CONV('0', 2, 10) + 0,	'Running shoes',	'Athletic',	'2023-04-06 19:12:55.014554'),
(2,	'2023-04-06 19:12:55.015916',	CONV('0', 2, 10) + 0,	'Boxing shoes',	'Boxing',	'2023-04-06 19:12:55.015926'),
(3,	'2023-04-06 19:12:55.016960',	CONV('0', 2, 10) + 0,	'Cycling shoes',	'Cycling',	'2023-04-06 19:12:55.016970'),
(4,	'2023-04-06 19:12:55.018123',	CONV('0', 2, 10) + 0,	'Just casual sportswear',	'Casual',	'2023-04-06 19:12:55.018136'),
(5,	'2023-04-06 19:12:55.019313',	CONV('0', 2, 10) + 0,	'For a wide range of sports',	'Various Sports',	'2023-04-06 19:12:55.019326'),
(6,	'2023-04-06 19:13:55.014536',	CONV('0', 2, 10) + 0,	'Football shoes',	'Football',	'2023-04-06 19:13:55.014554'),
(7,	'2023-04-06 19:14:55.014536',	CONV('0', 2, 10) + 0,	'Basketball shoes',	'Baketball',	'2023-04-06 19:14:55.014554')
ON DUPLICATE KEY UPDATE `id` = VALUES(`id`), `created_on` = VALUES(`created_on`), `deleted` = VALUES(`deleted`), `description` = VALUES(`description`), `name` = VALUES(`name`), `updated_on` = VALUES(`updated_on`);

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

INSERT INTO `line_items` (`id`, `created_on`, `line_item_count`, `line_item_price`, `product_id`, `product_name`, `total_line_price`, `updated_on`) VALUES
(1,	'2023-04-07 19:54:38.161889',	1,	150.55,	4,	'Nike AlphaFly Next%',	150.55,	'2023-04-07 19:54:38.161968'),
(2,	'2023-04-07 19:54:38.204818',	1,	123.99,	5,	'Adidas Superstar 3',	123.99,	'2023-04-07 19:54:38.204834'),
(3,	'2023-04-07 19:54:38.235829',	1,	150.55,	6,	'Nike Air Max 2023',	150.55,	'2023-04-07 19:54:38.235845'),
(4,	'2023-04-07 19:54:59.923654',	1,	150.55,	4,	'Nike AlphaFly Next%',	150.55,	'2023-04-07 19:54:59.923688'),
(5,	'2023-04-07 19:54:59.966918',	1,	150.55,	6,	'Nike Air Max 2023',	150.55,	'2023-04-07 19:54:59.966961'),
(6,	'2023-04-07 19:56:48.646018',	1,	123.99,	1,	'Nike Machomai 2022',	123.99,	'2023-04-07 19:56:48.646191'),
(7,	'2023-04-07 19:56:48.672024',	1,	150.55,	2,	'Giro Scott NZ',	150.55,	'2023-04-07 19:56:48.672039'),
(8,	'2023-04-07 20:00:04.037776',	2,	123.99,	3,	'Adidas Predator 17.1',	247.98,	'2023-04-07 20:00:04.038031'),
(9,	'2023-04-07 20:00:04.128994',	2,	123.99,	5,	'Adidas Superstar 3',	247.98,	'2023-04-07 20:00:04.129015'),
(10,	'2023-04-07 20:00:25.134302',	2,	150.55,	2,	'Giro Scott NZ',	301.10,	'2023-04-07 20:00:25.134406'),
(11,	'2023-04-07 20:00:25.168212',	1,	123.99,	3,	'Adidas Predator 17.1',	123.99,	'2023-04-07 20:00:25.168246'),
(12,	'2023-04-07 20:00:42.532700',	1,	123.99,	1,	'Nike Machomai 2022',	123.99,	'2023-04-07 20:00:42.532757'),
(13,	'2023-04-07 20:00:42.560454',	2,	150.55,	2,	'Giro Scott NZ',	301.10,	'2023-04-07 20:00:42.560488'),
(14,	'2023-04-07 20:01:36.131128',	1,	150.55,	4,	'Nike AlphaFly Next%',	150.55,	'2023-04-07 20:01:36.131238'),
(15,	'2023-04-07 20:01:36.204728',	1,	150.55,	6,	'Nike Air Max 2023',	150.55,	'2023-04-07 20:01:36.204765'),
(16,	'2023-04-07 20:01:53.866636',	1,	123.99,	1,	'Nike Machomai 2022',	123.99,	'2023-04-07 20:01:53.866671'),
(17,	'2023-04-07 20:01:53.925065',	1,	150.55,	2,	'Giro Scott NZ',	150.55,	'2023-04-07 20:01:53.925119'),
(18,	'2023-04-07 20:01:53.950045',	1,	123.99,	3,	'Adidas Predator 17.1',	123.99,	'2023-04-07 20:01:53.950070'),
(19,	'2023-04-07 20:01:53.987023',	1,	150.55,	4,	'Nike AlphaFly Next%',	150.55,	'2023-04-07 20:01:53.987064'),
(20,	'2023-04-07 20:01:54.026066',	1,	123.99,	5,	'Adidas Superstar 3',	123.99,	'2023-04-07 20:01:54.026093'),
(21,	'2023-04-07 20:01:54.077746',	1,	150.55,	6,	'Nike Air Max 2023',	150.55,	'2023-04-07 20:01:54.077845'),
(22,	'2023-04-07 20:31:02.938761',	2,	150.55,	6,	'Nike Air Max 2023',	301.10,	'2023-04-07 20:31:02.938813')
ON DUPLICATE KEY UPDATE `id` = VALUES(`id`), `created_on` = VALUES(`created_on`), `line_item_count` = VALUES(`line_item_count`), `line_item_price` = VALUES(`line_item_price`), `product_id` = VALUES(`product_id`), `product_name` = VALUES(`product_name`), `total_line_price` = VALUES(`total_line_price`), `updated_on` = VALUES(`updated_on`);

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_on` date DEFAULT NULL,
  `fk_user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKckfg68dp2m04316kkk1gj8anx` (`fk_user_id`),
  CONSTRAINT `FKckfg68dp2m04316kkk1gj8anx` FOREIGN KEY (`fk_user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `orders` (`id`, `created_on`, `fk_user_id`) VALUES
(1,	'2023-02-07',	3),
(2,	'2023-08-07',	3),
(3,	'2023-04-07',	3),
(4,	'2023-08-07',	1),
(5,	'2023-07-07',	1),
(6,	'2023-06-07',	1),
(7,	'2023-09-07',	2),
(8,	'2023-05-07',	2),
(9,	'2023-10-07',	1)
ON DUPLICATE KEY UPDATE `id` = VALUES(`id`), `created_on` = VALUES(`created_on`), `fk_user_id` = VALUES(`fk_user_id`);

DROP TABLE IF EXISTS `orders_line_items`;
CREATE TABLE `orders_line_items` (
  `fk_order_id` int NOT NULL,
  `fk_item_id` int NOT NULL,
  PRIMARY KEY (`fk_order_id`,`fk_item_id`),
  KEY `FKl8op57w5wxh7xjm00ug17af78` (`fk_item_id`),
  CONSTRAINT `FK86peu6tytcrfah0epeufnor3b` FOREIGN KEY (`fk_order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKl8op57w5wxh7xjm00ug17af78` FOREIGN KEY (`fk_item_id`) REFERENCES `line_items` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `orders_line_items` (`fk_order_id`, `fk_item_id`) VALUES
(1,	1),
(1,	2),
(1,	3),
(2,	4),
(2,	5),
(3,	6),
(3,	7),
(4,	8),
(4,	9),
(5,	10),
(5,	11),
(6,	12),
(6,	13),
(7,	14),
(7,	15),
(8,	16),
(8,	17),
(8,	18),
(8,	19),
(8,	20),
(8,	21),
(9,	22)
ON DUPLICATE KEY UPDATE `fk_order_id` = VALUES(`fk_order_id`), `fk_item_id` = VALUES(`fk_item_id`);

DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_on` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated_on` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pnvtwliis6p05pn6i3ndjrqt2` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
(23,	'2023-04-06 19:15:54.757672',	'manage:view',	'2023-04-06 19:15:54.757681'),
(24,	'2023-04-06 19:15:54.757672',	'admin:revoke',	'2023-04-06 19:15:54.757681'),
(25,	'2023-04-06 19:16:54.757672',	'category:add',	'2023-04-06 19:16:54.757681')
ON DUPLICATE KEY UPDATE `id` = VALUES(`id`), `created_on` = VALUES(`created_on`), `name` = VALUES(`name`), `updated_on` = VALUES(`updated_on`);

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `count` int DEFAULT NULL,
  `created_on` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(38,2) DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `updated_on` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `products` (`id`, `count`, `created_on`, `description`, `image_url`, `name`, `price`, `deleted`, `updated_on`) VALUES
(1,	17,	'2023-04-06 19:12:55.024122',	'Built for strong boxers. Help you keep balance well.',	'/imgs/nike-machomai.jpg',	'Nike Machomai 2022',	123.99,	CONV('0', 2, 10) + 0,	'2023-04-07 20:01:53.901521'),
(2,	14,	'2023-04-06 19:12:55.030572',	'For Road Cycling 2023',	'/imgs/giro-scott.webp',	'Giro Scott NZ',	150.55,	CONV('0', 2, 10) + 0,	'2023-04-07 20:01:53.934704'),
(3,	16,	'2023-04-06 19:12:55.035769',	'Built to last for longer than 120 minutes on the football pitch.',	'/imgs/adidas-predator-17.1.jpg',	'Adidas Predator 17.1',	123.99,	CONV('0', 2, 10) + 0,	'2023-04-07 20:01:53.968203'),
(4,	16,	'2023-04-06 19:12:55.043128',	'Comfort and stability all along. Be the next Kipchoge',	'/imgs/alphafly-athletic.webp',	'Nike AlphaFly Next%',	150.55,	CONV('0', 2, 10) + 0,	'2023-04-07 20:01:53.997265'),
(5,	16,	'2023-04-06 19:12:55.049161',	'For casual wear around town.',	'/imgs/adidas-casual-sneaker.jpg',	'Adidas Superstar 3',	123.99,	CONV('0', 2, 10) + 0,	'2023-04-07 20:01:54.044176'),
(6,	14,	'2023-04-06 19:12:55.055281',	'Can be worn for different kinds of sports',	'/imgs/airmax-variety-97.jpg',	'Nike Air Max 2023',	150.55,	CONV('0', 2, 10) + 0,	'2023-04-07 20:31:02.957787'),
(7,	3,	'2023-04-07 19:32:51.223850',	'Non slip basketball chinese super cheap shoes',	'/imgs/f4f20fd4-4d73-456b-b839-6e35e2df3744bb.jpg',	'Chinese Basketball Shoes',	50.45,	CONV('1', 2, 10) + 0,	'2023-04-07 19:32:51.224072')
ON DUPLICATE KEY UPDATE `id` = VALUES(`id`), `count` = VALUES(`count`), `created_on` = VALUES(`created_on`), `description` = VALUES(`description`), `image_url` = VALUES(`image_url`), `name` = VALUES(`name`), `price` = VALUES(`price`), `deleted` = VALUES(`deleted`), `updated_on` = VALUES(`updated_on`);

DROP TABLE IF EXISTS `products_categories`;
CREATE TABLE `products_categories` (
  `fk_product_id` int NOT NULL,
  `fk_category_id` int NOT NULL,
  PRIMARY KEY (`fk_product_id`,`fk_category_id`),
  KEY `FKaw3iu1c0jugfoftmrkeuqqaae` (`fk_category_id`),
  CONSTRAINT `FKaw3iu1c0jugfoftmrkeuqqaae` FOREIGN KEY (`fk_category_id`) REFERENCES `categories` (`id`),
  CONSTRAINT `FKg2boaomoduymgbxpd0co0navg` FOREIGN KEY (`fk_product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `products_categories` (`fk_product_id`, `fk_category_id`) VALUES
(4,	1),
(1,	2),
(2,	3),
(5,	4),
(6,	4),
(6,	5),
(3,	6)
ON DUPLICATE KEY UPDATE `fk_product_id` = VALUES(`fk_product_id`), `fk_category_id` = VALUES(`fk_category_id`);

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_on` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated_on` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `roles` (`id`, `created_on`, `name`, `updated_on`) VALUES
(1,	'2023-04-06 19:12:54.780043',	'ADMIN',	'2023-04-06 19:12:54.780055'),
(2,	'2023-04-06 19:12:54.781274',	'USER',	'2023-04-06 19:12:54.781286'),
(3,	'2023-04-06 19:13:54.781274',	'SUPERADMIN',	'2023-04-06 19:13:54.781286')
ON DUPLICATE KEY UPDATE `id` = VALUES(`id`), `created_on` = VALUES(`created_on`), `name` = VALUES(`name`), `updated_on` = VALUES(`updated_on`);

DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions` (
  `fk_role_id` int NOT NULL,
  `fk_permission_id` int NOT NULL,
  PRIMARY KEY (`fk_role_id`,`fk_permission_id`),
  KEY `FK8cbm4q9aponn60pqfawcq361i` (`fk_permission_id`),
  CONSTRAINT `FK8cbm4q9aponn60pqfawcq361i` FOREIGN KEY (`fk_permission_id`) REFERENCES `permissions` (`id`),
  CONSTRAINT `FKck8gp7wn2tkc478yct49imcjc` FOREIGN KEY (`fk_role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
(2,	21),
(3,	22),
(1,	23),
(2,	23),
(3,	24),
(1,	25)
ON DUPLICATE KEY UPDATE `fk_role_id` = VALUES(`fk_role_id`), `fk_permission_id` = VALUES(`fk_permission_id`);

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

INSERT INTO `users` (`id`, `city`, `created_on`, `email`, `is_account_expired`, `is_account_locked`, `is_credentials_expired`, `is_enabled`, `password`, `payment_account_number`, `updated_on`, `username`) VALUES
(1,	'Dodoma',	'2023-04-06 19:12:54.984509',	'admin@sportyshoes.com',	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	CONV('1', 2, 10) + 0,	'{bcrypt}$2a$10$OTk1fTRmaJwpfoxYvCsPDOSZz6Be234fEYq6wIEFys/UKx5TJk.FS',	'0057E569-B2DE-4DE0-BEC0-07EC7C9FCF18',	'2023-04-06 19:12:54.984525',	'admin'),
(2,	'Dar Es Salaam',	'2023-04-06 19:12:54.991192',	'user@sportyshoes.com',	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	CONV('1', 2, 10) + 0,	'{bcrypt}$2a$10$FyTcNt6YuT9sZPm0Bh6pw.xRokaXKTxNR1L7Urh1/rVkT6tYIqseu',	'AEE4F7A1-F2EA-4D6A-AA1E-6B947B6BB7D6',	'2023-04-06 19:12:54.991203',	'user'),
(3,	'New York',	'2023-04-06 19:39:00.213957',	'donnie@gmail.com',	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	CONV('0', 2, 10) + 0,	CONV('1', 2, 10) + 0,	'{bcrypt}$2a$10$qdteEFdd3esDpRsoiLHL9.jbetTSbkJQQuO4OeDXRFbsiC2wO8i76',	'EDF3C078-54B4-4648-8749-27360A667DAE',	'2023-04-06 19:39:00.214010',	'donnie')
ON DUPLICATE KEY UPDATE `id` = VALUES(`id`), `city` = VALUES(`city`), `created_on` = VALUES(`created_on`), `email` = VALUES(`email`), `is_account_expired` = VALUES(`is_account_expired`), `is_account_locked` = VALUES(`is_account_locked`), `is_credentials_expired` = VALUES(`is_credentials_expired`), `is_enabled` = VALUES(`is_enabled`), `password` = VALUES(`password`), `payment_account_number` = VALUES(`payment_account_number`), `updated_on` = VALUES(`updated_on`), `username` = VALUES(`username`);

DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
  `fk_user_id` int NOT NULL,
  `fk_role_id` int NOT NULL,
  PRIMARY KEY (`fk_user_id`,`fk_role_id`),
  KEY `FKaeu8lc9yh8laevs59733qluau` (`fk_role_id`),
  CONSTRAINT `FKaeu8lc9yh8laevs59733qluau` FOREIGN KEY (`fk_role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKbvwr8podnb6u5iefx7agb3y6w` FOREIGN KEY (`fk_user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `users_roles` (`fk_user_id`, `fk_role_id`) VALUES
(1,	1),
(1,	2),
(2,	2),
(3,	2),
(1,	3)
ON DUPLICATE KEY UPDATE `fk_user_id` = VALUES(`fk_user_id`), `fk_role_id` = VALUES(`fk_role_id`);

-- 2023-04-07 17:35:43
