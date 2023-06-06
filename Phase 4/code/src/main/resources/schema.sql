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
    `email`          varchar(100) NOT NULL,
    `account_number` varchar(100) NOT NULL,
    `created_on`     datetime(6)  NOT NULL,
    `updated_on`     datetime(6) DEFAULT NULL,
    `version`        int         DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

TRUNCATE `customers`;

DROP TABLE IF EXISTS `foods`;
CREATE TABLE `foods`
(
    `id`         int            NOT NULL AUTO_INCREMENT,
    `name`       varchar(255)   NOT NULL,
    `price`      decimal(10, 2) NOT NULL,
    `img_url`    varchar(1000)  NOT NULL,
    `created_on` datetime(6)    NOT NULL,
    `updated_on` datetime(6) DEFAULT NULL,
    `version`    int         DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

TRUNCATE `foods`;
INSERT INTO `foods` (`id`, `name`, `price`, `img_url`, `created_on`, `updated_on`, `version`)
VALUES (1, 'Spaghetti', 20.55,
        'https://www.inspiredtaste.net/wp-content/uploads/2019/03/Spaghetti-with-Meat-Sauce-Recipe-1-1200.jpg',
        '2023-06-05 21:47:05.008991', NULL, NULL),
       (2, 'Burger', 10.00,
        'https://www.allrecipes.com/thmb/5JVfA7MxfTUPfRerQMdF-nGKsLY=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/25473-the-perfect-basic-burger-DDMFS-4x3-56eaba3833fd4a26a82755bcd0be0c54.jpg',
        '2023-06-05 21:47:05.009018', NULL, NULL),
       (3, 'French Fries', 5.99,
        'https://www.seriouseats.com/thmb/Il7mv9ZSDh7n0cZz3t3V-28ImkQ=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/__opt__aboutcom__coeus__resources__content_migration__serious_eats__seriouseats.com__2018__04__20180309-french-fries-vicky-wasik-15-5a9844742c2446c7a7be9fbd41b6e27d.jpg',
        '2023-06-05 21:47:05.009026', NULL, NULL),
       (4, 'Tacos', 15.99,
        'https://static.onecms.io/wp-content/uploads/sites/43/2023/01/30/70935-taqueria-style-tacos-mfs-3x2-35.jpg',
        '2023-06-05 21:47:05.009040', NULL, NULL),
       (5, 'Biscuits', 2.77,
        'https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/Biscuits_in_Ghana.jpg/220px-Biscuits_in_Ghana.jpg',
        '2023-06-05 21:47:05.009047', NULL, NULL),
       (6, 'French Pasta', 7.50, 'https://www.sidechef.com/recipe/81372375-5170-4e31-884d-b5f7070fb924.jpg?d=1408x1120',
        '2023-06-05 21:47:05.009055', NULL, NULL),
       (7, 'Bread', 22.55,
        'https://www.allrecipes.com/thmb/CjzJwg2pACUzGODdxJL1BJDRx9Y=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/6788-amish-white-bread-DDMFS-4x3-6faa1e552bdb4f6eabdd7791e59b3c84.jpg',
        '2023-06-05 21:47:05.009059', NULL, NULL),
       (8, 'Smoked Fish', 24.50, 'https://www.charbroil.com/media/ctm//E/a/Easy_Smoked_Fish.jpg.jpeg',
        '2023-06-05 21:47:05.009065', NULL, NULL),
       (9, 'Pizza', 19.99,
        'https://www.allrecipes.com/thmb/0xH8n2D4cC97t7mcC7eT2SDZ0aE=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/6776_Pizza-Dough_ddmfs_2x1_1725-fdaa76496da045b3bdaadcec6d4c5398.jpg',
        '2023-06-05 21:47:05.009070', NULL, NULL);

DROP TABLE IF EXISTS `order_items`;
CREATE TABLE `order_items`
(
    `id`          int            NOT NULL,
    `food_name`   varchar(255)   NOT NULL,
    `unit_price`  decimal(10, 2) NOT NULL,
    `quantity`    int            NOT NULL,
    `fk_order_id` int            NOT NULL,
    KEY `order_id` (`fk_order_id`),
    CONSTRAINT `order_item_ibfk_2` FOREIGN KEY (`fk_order_id`) REFERENCES `orders` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

TRUNCATE `order_items`;

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`
(
    `id`             int          NOT NULL AUTO_INCREMENT,
    `order_number`   varchar(255) NOT NULL,
    `fk_customer_id` int          NOT NULL,
    `customer_name`  varchar(100) NOT NULL,
    `created_on`     datetime(6)  NOT NULL,
    `updated_on`     datetime(6) DEFAULT NULL,
    `version`        int         DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `order_number` (`order_number`),
    KEY `customer_id` (`fk_customer_id`),
    CONSTRAINT `order_ibfk_1` FOREIGN KEY (`fk_customer_id`) REFERENCES `customers` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

TRUNCATE `orders`;

DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`
(
    `id`         int                                                          NOT NULL AUTO_INCREMENT,
    `name`       varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `version`    int      DEFAULT NULL,
    `created_on` datetime(6)                                                  NOT NULL,
    `updated_on` datetime DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_pnvtwliis6p05pn6i3ndjrqt2` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

TRUNCATE `permissions`;
INSERT INTO `permissions` (`id`, `name`, `version`, `created_on`, `updated_on`)
VALUES (1, 'food:read:one', 0, '2023-06-05 21:47:05.058887', NULL),
       (2, 'user:change-password', 0, '2023-06-05 21:47:05.058895', NULL),
       (3, 'order:read:all', 0, '2023-06-05 21:47:05.058892', NULL),
       (4, 'food:create:one', 0, '2023-06-05 21:47:05.058877', NULL),
       (5, 'customer:read:all', 0, '2023-06-05 21:47:05.058860', NULL),
       (6, 'food:delete:one', 0, '2023-06-05 21:47:05.058890', NULL);

DROP TABLE IF EXISTS `tokens`;
CREATE TABLE `tokens`
(
    `id`          int           NOT NULL AUTO_INCREMENT,
    `value`       varchar(1000) NOT NULL,
    `username`    varchar(50)   NOT NULL,
    `invalidated` bit(1)        NOT NULL,
    `version`     int DEFAULT NULL,
    `created_on`  datetime(6)   NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

TRUNCATE `tokens`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
    `id`                     int                                                           NOT NULL AUTO_INCREMENT,
    `username`               varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `password`               varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    `is_account_locked`      bit(1)                                                        NOT NULL,
    `is_account_expired`     bit(1)                                                        NOT NULL,
    `is_credentials_expired` bit(1)                                                        NOT NULL,
    `is_enabled`             bit(1)                                                        NOT NULL,
    `version`                int      DEFAULT NULL,
    `updated_on`             datetime DEFAULT NULL,
    `created_on`             datetime(6)                                                   NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

TRUNCATE `users`;
INSERT INTO `users` (`id`, `username`, `password`, `is_account_locked`, `is_account_expired`, `is_credentials_expired`,
                     `is_enabled`, `version`, `updated_on`, `created_on`)
VALUES (1, 'admin', '{bcrypt}$2a$10$dBEc6lRCu2VQF2UQhKNQI.3j7wTq4Q6jZHR4H3RUWzftidPkLcE6y', CONV('0', 2, 10) + 0,
        CONV('0', 2, 10) + 0, CONV('0', 2, 10) + 0, CONV('1', 2, 10) + 0, 0, NULL, '2023-06-05 21:47:05.164788'),
       (2, 'manager', '{bcrypt}$2a$10$DW4xfkCMiO0BLyfuGDCKxOrk13fUnKJsi/1/.RhpLOtzSTXdjxrGS', CONV('0', 2, 10) + 0,
        CONV('0', 2, 10) + 0, CONV('0', 2, 10) + 0, CONV('1', 2, 10) + 0, 0, NULL, '2023-06-05 21:47:05.249742');

DROP TABLE IF EXISTS `users_permissions`;
CREATE TABLE `users_permissions`
(
    `fk_user_id`       int         NOT NULL,
    `fk_permission_id` int         NOT NULL,
    `created_on`       datetime(6) NOT NULL,
    `updated_on`       datetime DEFAULT NULL,
    PRIMARY KEY (`fk_user_id`, `fk_permission_id`),
    KEY `FKbvwr8podnb6u53eeiefx7agb3y6w` (`fk_permission_id`),
    CONSTRAINT `FKaeu8lc9yh8selaevs59733qluau` FOREIGN KEY (`fk_user_id`) REFERENCES `users` (`id`),
    CONSTRAINT `FKbvwr8podnb6u53eeiefx7agb3y6w` FOREIGN KEY (`fk_permission_id`) REFERENCES `permissions` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;

TRUNCATE `users_permissions`;
INSERT INTO `users_permissions` (`fk_user_id`, `fk_permission_id`, `created_on`, `updated_on`)
VALUES (1, 1, '2023-06-05 21:47:05.165348', NULL),
       (1, 2, '2023-06-05 21:47:05.165366', NULL),
       (1, 3, '2023-06-05 21:47:05.165369', NULL),
       (1, 4, '2023-06-05 21:47:05.165371', NULL),
       (1, 5, '2023-06-05 21:47:05.165373', NULL),
       (1, 6, '2023-06-05 21:47:05.165382', NULL),
       (2, 2, '2023-06-05 21:47:05.249792', NULL),
       (2, 3, '2023-06-05 21:47:05.249797', NULL);

-- 2023-06-05 18:48:21
