-- Adminer 4.8.1 MySQL 8.0.33 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP DATABASE IF EXISTS `kitchen_stories`;
CREATE DATABASE `kitchen_stories` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION = 'N' */;
USE `kitchen_stories`;

DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers`
(
    `id`             int          NOT NULL AUTO_INCREMENT,
    `first_name`     varchar(255) NOT NULL,
    `last_name`      varchar(255) NOT NULL,
    `phone_number`   varchar(20)  NOT NULL,
    `email`          varchar(100) NOT NULL,
    `account_number` varchar(100) NOT NULL,
    `created_on`     datetime(6) DEFAULT NULL,
    `updated_on`     datetime(6) DEFAULT NULL,
    `version`        int         DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `foods`;
CREATE TABLE `foods`
(
    `id`         int            NOT NULL AUTO_INCREMENT,
    `name`       varchar(255)   NOT NULL,
    `quantity`   int            NOT NULL,
    `price`      decimal(10, 2) NOT NULL,
    `img_url`    varchar(255)   NOT NULL,
    `created_on` datetime(6) DEFAULT NULL,
    `updated_on` datetime(6) DEFAULT NULL,
    `version`    int         DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`
(
    `id`           int          NOT NULL AUTO_INCREMENT,
    `order_number` varchar(255)  NOT NULL,
    `fk_customer_id`  int          NOT NULL,
    `created_on`   datetime(6) DEFAULT NULL,
    `updated_on`   datetime(6) DEFAULT NULL,
    `version`      int         DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `order_number` (`order_number`),
    KEY `customer_id` (`fk_customer_id`),
    CONSTRAINT `order_ibfk_1` FOREIGN KEY (`fk_customer_id`) REFERENCES `customers` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `order_items`;
CREATE TABLE `order_items`
(
    `id`         int            NOT NULL AUTO_INCREMENT,
    `food_name`  varchar(255)   NOT NULL,
    `unit_price` decimal(10, 2) NOT NULL,
    `quantity`   int            NOT NULL,
    `order_id`   int            NOT NULL,
    `created_on` datetime(6) DEFAULT NULL,
    `updated_on` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `order_id` (`order_id`),
    CONSTRAINT `order_item_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`
(
    `id`         int                                    NOT NULL AUTO_INCREMENT,
    `name`       varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
    `version`    int      DEFAULT NULL,
    `created_on` datetime                               NOT NULL,
    `updated_on` datetime DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_pnvtwliis6p05pn6i3ndjrqt2` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
    `id`                     int                                     NOT NULL AUTO_INCREMENT,
    `username`               varchar(50) COLLATE utf8mb4_general_ci  NOT NULL,
    `password`               varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
    `is_account_locked`      bit(1)                                  NOT NULL,
    `is_account_expired`     bit(1)                                  NOT NULL,
    `is_credentials_expired` bit(1)                                  NOT NULL,
    `is_enabled`             bit(1)                                  NOT NULL,
    `version`                int         DEFAULT NULL,
    `updated_on`             datetime    DEFAULT NULL,
    `created_on`             datetime(6) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;


DROP TABLE IF EXISTS `users_permissions`;
CREATE TABLE `users_permissions`
(
    `fk_user_id`       int      NOT NULL,
    `fk_permission_id` int      NOT NULL,
    `created_on`       datetime NOT NULL,
    `updated_on`       datetime DEFAULT NULL,
    PRIMARY KEY (`fk_user_id`, `fk_permission_id`),
    KEY `FKbvwr8podnb6u53eeiefx7agb3y6w` (`fk_permission_id`),
    CONSTRAINT `FKaeu8lc9yh8selaevs59733qluau` FOREIGN KEY (`fk_user_id`) REFERENCES `users` (`id`),
    CONSTRAINT `FKbvwr8podnb6u53eeiefx7agb3y6w` FOREIGN KEY (`fk_permission_id`) REFERENCES `permissions` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;


DROP TABLE IF EXISTS `tokens`;
CREATE TABLE `tokens`
(
    `id`         int            NOT NULL AUTO_INCREMENT,
    `value`  varchar(255)   NOT NULL,
    `active`   bit            NOT NULL,
    `created_on` datetime(6) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- 2023-05-31 17:34:44
