-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 24, 2017 at 12:15 PM
-- Server version: 5.6.14
-- PHP Version: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `TravelExpense`
--

-- --------------------------------------------------------

--
-- Table structure for table `travel_expense`
--

CREATE TABLE IF NOT EXISTS `travel_expense` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `approve_seq` int(11) DEFAULT NULL,
  `document_date` datetime DEFAULT NULL,
  `document_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `document_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `approvel_date` datetime DEFAULT NULL,
  `cash` int(11) DEFAULT NULL,
  `cheque_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `expense_date` datetime DEFAULT NULL,
  `expense_summary` decimal(19,2) DEFAULT NULL,
  `pay_date` datetime DEFAULT NULL,
  `approve_map_flow` bigint(20) DEFAULT NULL,
  `bank` bigint(20) DEFAULT NULL,
  `company` bigint(20) DEFAULT NULL,
  `department` bigint(20) DEFAULT NULL,
  `app_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9m829qm4dv3rotgivys89pac9` (`approve_map_flow`),
  KEY `FKn9g1lx8xm7bl4dxgpbl4n4b74` (`bank`),
  KEY `FKgmeh2iamfi69dvnokjj1uhbow` (`company`),
  KEY `FKdm555jonejte4kf84kbbivpvo` (`department`),
  KEY `FKg5547ws47u2w8lb3xkkhqcsb8` (`app_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `travel_expense`
--

INSERT INTO `travel_expense` (`id`, `approve_seq`, `document_date`, `document_number`, `document_status`, `version`, `approvel_date`, `cash`, `cheque_number`, `comment`, `expense_date`, `expense_summary`, `pay_date`, `approve_map_flow`, `bank`, `company`, `department`, `app_user`) VALUES
(1, 0, '2017-02-24 18:12:36', 'TE000000', NULL, 1, NULL, NULL, NULL, 'เดินทาง', '2017-02-24 18:12:36', '1300.00', NULL, 1, NULL, 1, 1, 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `travel_expense`
--
ALTER TABLE `travel_expense`
  ADD CONSTRAINT `FKg5547ws47u2w8lb3xkkhqcsb8` FOREIGN KEY (`app_user`) REFERENCES `app_user` (`id`),
  ADD CONSTRAINT `FK9m829qm4dv3rotgivys89pac9` FOREIGN KEY (`approve_map_flow`) REFERENCES `approve_map_flow` (`id`),
  ADD CONSTRAINT `FKdm555jonejte4kf84kbbivpvo` FOREIGN KEY (`department`) REFERENCES `department` (`id`),
  ADD CONSTRAINT `FKgmeh2iamfi69dvnokjj1uhbow` FOREIGN KEY (`company`) REFERENCES `company` (`id`),
  ADD CONSTRAINT `FKn9g1lx8xm7bl4dxgpbl4n4b74` FOREIGN KEY (`bank`) REFERENCES `bank` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
