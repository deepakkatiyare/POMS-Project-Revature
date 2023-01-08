-- DDL SCRIPT

-- Creating database for pizza order management system
CREATE DATABASE poms;
USE poms;

DROP TABLE IF EXISTS pizza;
--  Creating table pizza
CREATE TABLE pizza
(
pizza_id INT PRIMARY KEY AUTO_INCREMENT,
pizza_type VARCHAR(70),
pizza_size ENUM('regular','medium','large'),
pizza_category VARCHAR(10),
pizza_price SMALLINT UNSIGNED
);

DROP TABLE IF EXISTS beverage;

--  Creating table beverage
CREATE TABLE beverage(
b_id INT PRIMARY KEY AUTO_INCREMENT,
b_name VARCHAR(50),
b_type enum("hot","cold"),
b_price SMALLINT UNSIGNED
);

DROP TABLE IF EXISTS cookie;

--  Creating table cookie
CREATE TABLE cookie(
cookie_id INT PRIMARY KEY AUTO_INCREMENT,
cookie_name VARCHAR(30),
cookie_price SMALLINT UNSIGNED
);

