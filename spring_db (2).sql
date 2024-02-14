-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Feb 14, 2024 at 08:35 PM
-- Server version: 5.6.41
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spring_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `app_user`
--

CREATE TABLE `app_user` (
  `id` bigint(20) NOT NULL,
  `sso_id` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `app_user`
--

INSERT INTO `app_user` (`id`, `sso_id`, `password`, `first_name`, `last_name`, `email`) VALUES
(3, 'User', '$2a$10$A3LIqSPKkVviJ1RmOsCrFeHNaY6/JjI9K2us6HZuoxBiat77gAV1.', 'Peter', 'Petrov', 'Peter@gmail.com'),
(4, 'DBA', '$2a$10$tP6ba.KC3Dfn9R.R1qp2Lu9JGKaQOVtVfXAt/uEZTA98d2aiEHfPu', 'Mike', 'Petrov', 'xx@gmail.com'),
(5, 'Admin', '$2a$10$nB8AGG78Ny.dWUe4OQXkv.sA6nrLKzjfQDZ7/Jm1xiDj.vZZ/bROi', 'Peter', 'Petrov', 'asd@asd'),
(6, 'MP', '$2a$10$R.mzqibRkIzTIvT2zbNvIu7IDOpy31q8hVKnHoS/RBnhwHbE.kzJ2', 'Mike', 'Petrov', 'Chaplain04@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `app_user_user_profile`
--

CREATE TABLE `app_user_user_profile` (
  `user_id` bigint(20) NOT NULL,
  `user_profile_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `app_user_user_profile`
--

INSERT INTO `app_user_user_profile` (`user_id`, `user_profile_id`) VALUES
(3, 2),
(5, 2),
(6, 2),
(4, 3);

-- --------------------------------------------------------

--
-- Table structure for table `cats`
--

CREATE TABLE `cats` (
  `id` int(11) NOT NULL,
  `name` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cats`
--

INSERT INTO `cats` (`id`, `name`) VALUES
(1, 'Barsik'),
(2, 'Murzik');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `id` int(11) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `address` varchar(1024) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `name`, `email`, `address`) VALUES
(1, 'Ivan1', 'Inab@Gmail.com', 'Minsk'),
(4, 'Addas', 'xx@gmail.com', 'Minsk, Marksa st'),
(5, 'info', 'xx@gmail.com', 'Minsk, Marksa st'),
(6, 'Ivan111', 'Inab@Gmail.com', 'Minsk'),
(7, 'Iva', 'Inab@Gmail.com', 'Minsk');

-- --------------------------------------------------------

--
-- Table structure for table `emp99`
--

CREATE TABLE `emp99` (
  `id` int(11) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `designation` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `emp99`
--

INSERT INTO `emp99` (`id`, `name`, `salary`, `designation`) VALUES
(2, 'Addas1111111', 11, 'fskljghs'),
(3, 'John', 1111, 'fskljghs');

-- --------------------------------------------------------

--
-- Table structure for table `offices`
--

CREATE TABLE `offices` (
  `id` int(11) NOT NULL,
  `title` varchar(64) NOT NULL,
  `address` varchar(256) NOT NULL,
  `postal_code` int(11) NOT NULL,
  `updated_ts` timestamp NULL DEFAULT NULL,
  `created_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `phone_1` varchar(255) DEFAULT NULL,
  `phone_2` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `offices`
--

INSERT INTO `offices` (`id`, `title`, `address`, `postal_code`, `updated_ts`, `created_ts`, `phone_1`, `phone_2`) VALUES
(1, 'MAIN', 'BLR, Minsk, K.Marksa 32', 220111, NULL, '2023-09-27 16:32:41', '+375172416974', '+375172416975'),
(2, 'DEP#1', 'BLR, Minsk, K.Marksa 34', 220111, NULL, '2023-09-27 16:32:41', '+375172417974', '+375172417975'),
(3, 'DEP#2', 'BLR, Minsk, K.Marksa 35', 220111, NULL, '2023-09-27 16:32:41', '+375179046974', '+375172404975'),
(4, 'MAIN', 'GERM', 220222, NULL, '2023-10-16 16:00:35', '123', '321'),
(5, 'MAIN', 'FR', 220222, NULL, '2023-10-15 06:20:24', NULL, NULL),
(6, 'MAIN 2', 'address', 2222222, NULL, '2023-10-11 19:41:29', NULL, NULL),
(8, 'MAIN 2', 'address', 2222222, NULL, '2023-10-12 16:42:59', NULL, NULL),
(9, 'MAIN 2', 'address', 2222222, NULL, '2023-10-14 12:36:05', NULL, NULL),
(55, 'main', 'BLR', 200220, NULL, '2023-10-14 12:40:12', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `persistent_logins`
--

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `persistent_logins`
--

INSERT INTO `persistent_logins` (`username`, `series`, `token`, `last_used`) VALUES
('User', 'PbNdiiFAJNzsaJBW0QUcog==', '8kv+phevaf/rc95twe61mw==', '2024-02-14 17:05:33');

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `id` int(11) UNSIGNED NOT NULL,
  `name` varchar(20) NOT NULL DEFAULT '',
  `country` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`id`, `name`, `country`) VALUES
(1, 'Ivan', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pizzas`
--

CREATE TABLE `pizzas` (
  `id` int(11) NOT NULL,
  `name` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `pizzas`
--

INSERT INTO `pizzas` (`id`, `name`, `size`, `price`) VALUES
(1, 'Margherita S', 25, 10.5),
(2, 'Margherita M', 30, 15.9),
(9, 'big pizza', 85, 100);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` tinyint(1) NOT NULL,
  `first_name` varchar(128) DEFAULT NULL,
  `last_name` varchar(128) DEFAULT NULL,
  `login` varchar(32) NOT NULL,
  `password` varchar(128) NOT NULL,
  `email` varchar(128) NOT NULL,
  `is_active` varchar(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `first_name`, `last_name`, `login`, `password`, `email`, `is_active`) VALUES
(4, 'Peter', '  Petrov', 'Peter', '_9oQLyzmxp0yjrzFeoaSqw', 'Peter@gmail.com', '0');

-- --------------------------------------------------------

--
-- Table structure for table `user_profile`
--

CREATE TABLE `user_profile` (
  `id` bigint(20) NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_profile`
--

INSERT INTO `user_profile` (`id`, `type`) VALUES
(2, 'ADMIN'),
(3, 'DBA'),
(1, 'USER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `app_user`
--
ALTER TABLE `app_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `sso_id` (`sso_id`);

--
-- Indexes for table `app_user_user_profile`
--
ALTER TABLE `app_user_user_profile`
  ADD PRIMARY KEY (`user_id`,`user_profile_id`),
  ADD KEY `FK_USER_PROFILE` (`user_profile_id`);

--
-- Indexes for table `cats`
--
ALTER TABLE `cats`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `emp99`
--
ALTER TABLE `emp99`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `offices`
--
ALTER TABLE `offices`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `persistent_logins`
--
ALTER TABLE `persistent_logins`
  ADD PRIMARY KEY (`series`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pizzas`
--
ALTER TABLE `pizzas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login` (`login`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `user_profile`
--
ALTER TABLE `user_profile`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `type` (`type`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `app_user`
--
ALTER TABLE `app_user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `cats`
--
ALTER TABLE `cats`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `emp99`
--
ALTER TABLE `emp99`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `offices`
--
ALTER TABLE `offices`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pizzas`
--
ALTER TABLE `pizzas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` tinyint(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user_profile`
--
ALTER TABLE `user_profile`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `app_user_user_profile`
--
ALTER TABLE `app_user_user_profile`
  ADD CONSTRAINT `FK_APP_USER` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  ADD CONSTRAINT `FK_USER_PROFILE` FOREIGN KEY (`user_profile_id`) REFERENCES `user_profile` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
