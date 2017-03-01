-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 01, 2017 at 10:29 AM
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
-- Table structure for table `approve_map_flow`
--

CREATE TABLE IF NOT EXISTS `approve_map_flow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) DEFAULT NULL,
  `account_emp` bigint(20) DEFAULT NULL,
  `apv1emp` bigint(20) DEFAULT NULL,
  `apv2emp` bigint(20) DEFAULT NULL,
  `employee` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgjwc5wyvsxsg52li1sq1tpsgn` (`account_emp`),
  KEY `FKsqvll54oorcyyixepxocr79st` (`apv1emp`),
  KEY `FKj0kkdsdpfxkhtgub84r0kus54` (`apv2emp`),
  KEY `FK74tblk1f0osrjy70a3r60u04` (`employee`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Dumping data for table `approve_map_flow`
--

INSERT INTO `approve_map_flow` (`id`, `version`, `account_emp`, `apv1emp`, `apv2emp`, `employee`) VALUES
(1, 0, 3, 4, 1, 2),
(2, 0, 4, 2, 3, 1),
(3, 0, 4, 2, 1, 3),
(4, 0, 3, 1, 2, 4);

-- --------------------------------------------------------

--
-- Table structure for table `app_menu`
--

CREATE TABLE IF NOT EXISTS `app_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `menu_type` int(11) DEFAULT NULL,
  `url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `app_role`
--

CREATE TABLE IF NOT EXISTS `app_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `app_role_menu`
--

CREATE TABLE IF NOT EXISTS `app_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `app_menu` bigint(20) DEFAULT NULL,
  `app_role` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl4vrdvb00lll6ee5haoq9m9ev` (`app_menu`),
  KEY `FK61wsx9r5pm673sp9ru5frqkgt` (`app_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `app_user`
--

CREATE TABLE IF NOT EXISTS `app_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `emp_address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `emp_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `emp_last_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `emp_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ldap_user_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `personal_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tel` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `company` bigint(20) DEFAULT NULL,
  `department` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2x7xik812g9fy1f4x9i7uccyj` (`company`),
  KEY `FKhx2h8kit0c1bl6lwaeua5gn1o` (`department`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Dumping data for table `app_user`
--

INSERT INTO `app_user` (`id`, `email`, `emp_address`, `emp_code`, `emp_last_name`, `emp_name`, `ldap_user_name`, `password`, `personal_id`, `tel`, `version`, `company`, `department`) VALUES
(1, '่jo@hmail.com', 'นครราชสีมา', 'emp0001', 'ขอน้อมกลาง', 'สุทธิวัส', 'jo1234', '1234', '1354487996364', '081-6658788', 0, 1, 3),
(2, 'nut@gmail.com', 'อุบลราชธานี', 'emp0002', 'เขมะโยธิน', 'ณัฐพล', 'nut1234', '1234', '1349900669563', '087-5466189', 0, 1, 1),
(3, 'baze1234@gmai.com', 'สกลนคร', 'emp0003', 'ต้นศรี', 'วัจน์กร', 'baze1234', '12345', '1354477889631', '081-9543611', 0, 1, 4),
(4, 'jen@gmail.com', 'ชลบุรี', 'emp0004', 'มารมย์', 'เจนจิรา', 'biw1234', '12344', '1340400184759', '085-3130836', 0, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `app_user_role`
--

CREATE TABLE IF NOT EXISTS `app_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `app_role` bigint(20) DEFAULT NULL,
  `app_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcprhx6mpypdwshju5p7pi971y` (`app_role`),
  KEY `FK3xcgg4e44bx37j6oa7p1lfgp8` (`app_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE IF NOT EXISTS `bank` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`id`, `active`, `code`, `name`, `version`) VALUES
(1, 1, 'bank0001', 'ธนาคารไทยพาณิชย์', 0),
(2, 1, 'bank0002', 'ธนาคารกรุงไทย', 0);

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE IF NOT EXISTS `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`id`, `active`, `code`, `name`, `version`) VALUES
(1, 1, 'company001', 'Soft Plus Technology', 0);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `active`, `code`, `name`, `version`, `address`) VALUES
(1, 1, 'customer0001', 'BigC', 0, 'กรุงเทพมหานคร'),
(2, 1, 'customer0002', 'Future Park', 0, 'ปทุมธานี');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE IF NOT EXISTS `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `company` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKacyft44u7h6gnqp25riu5mcba` (`company`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id`, `active`, `code`, `name`, `version`, `company`) VALUES
(1, 1, 'department001', 'Engineer', 0, 1),
(2, 1, 'department002', 'Human Resource', 0, 1),
(3, 1, 'department003', 'Manager', 0, 1),
(4, 1, 'department004', 'Project Manager', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `document_approve`
--

CREATE TABLE IF NOT EXISTS `document_approve` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sequence` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `approver` bigint(20) DEFAULT NULL,
  `travel_expense_doc_approve` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7wf0xdvu30jixtf0ltfv42r6x` (`approver`),
  KEY `FKsat12feq7m9pq7elw99rkmhfo` (`travel_expense_doc_approve`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Dumping data for table `document_approve`
--

INSERT INTO `document_approve` (`id`, `sequence`, `version`, `approver`, `travel_expense_doc_approve`) VALUES
(1, 1, 0, 1, 1),
(2, 0, 0, 4, 1),
(3, 2, 0, 3, 1),
(4, 0, 0, 2, 2),
(5, 1, 0, 3, 2),
(6, 2, 0, 4, 2);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `travel_expense`
--

INSERT INTO `travel_expense` (`id`, `approve_seq`, `document_date`, `document_number`, `document_status`, `version`, `approvel_date`, `cash`, `cheque_number`, `comment`, `expense_date`, `expense_summary`, `pay_date`, `approve_map_flow`, `bank`, `company`, `department`, `app_user`) VALUES
(1, 0, '2017-02-24 18:12:36', 'TE000000', NULL, 1, NULL, NULL, NULL, 'เดินทาง', '2017-02-24 18:12:36', '1300.00', NULL, 1, NULL, 1, 1, 2),
(2, 0, '2017-03-01 16:24:19', 'TE000001', NULL, 1, NULL, NULL, NULL, 'เดินทาง', '2017-03-01 16:24:19', '2500.00', NULL, 2, NULL, 1, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `travel_expense_detail`
--

CREATE TABLE IF NOT EXISTS `travel_expense_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attach_file1` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `attach_file2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `attach_file3` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `exp_way_expense` decimal(19,2) DEFAULT NULL,
  `expense` decimal(19,2) DEFAULT NULL,
  `expense_sub_summary` decimal(19,2) DEFAULT NULL,
  `travel_date` datetime DEFAULT NULL,
  `travel_from` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `travel_to` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `customer` bigint(20) DEFAULT NULL,
  `travel_expense` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsvm2jhe9q6ev6kd7ckp1s515w` (`customer`),
  KEY `FKjkrk9hfkxi34vhnsff6difbdn` (`travel_expense`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `travel_expense_detail`
--

INSERT INTO `travel_expense_detail` (`id`, `attach_file1`, `attach_file2`, `attach_file3`, `comment`, `exp_way_expense`, `expense`, `expense_sub_summary`, `travel_date`, `travel_from`, `travel_to`, `version`, `customer`, `travel_expense`) VALUES
(1, 'radio.png', 'squirrel.png', '', '-', '900.00', '400.00', '1300.00', '2017-02-03 00:00:00', 'หอพัก', 'ฟิวเจอร์', 0, 2, 1),
(2, 'q.png', 'radio.png', '', '', '1000.00', '400.00', '1400.00', '2017-03-10 00:00:00', 'ที่ทำงาน', 'ที่ทำงานบิ๊กซีนะ', 1, 2, 2),
(3, '', '', '', '', '500.00', '600.00', '1100.00', '2017-03-21 00:00:00', 'test', 'test', 0, 1, 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `approve_map_flow`
--
ALTER TABLE `approve_map_flow`
  ADD CONSTRAINT `FK74tblk1f0osrjy70a3r60u04` FOREIGN KEY (`employee`) REFERENCES `app_user` (`id`),
  ADD CONSTRAINT `FKgjwc5wyvsxsg52li1sq1tpsgn` FOREIGN KEY (`account_emp`) REFERENCES `app_user` (`id`),
  ADD CONSTRAINT `FKj0kkdsdpfxkhtgub84r0kus54` FOREIGN KEY (`apv2emp`) REFERENCES `app_user` (`id`),
  ADD CONSTRAINT `FKsqvll54oorcyyixepxocr79st` FOREIGN KEY (`apv1emp`) REFERENCES `app_user` (`id`);

--
-- Constraints for table `app_role_menu`
--
ALTER TABLE `app_role_menu`
  ADD CONSTRAINT `FK61wsx9r5pm673sp9ru5frqkgt` FOREIGN KEY (`app_role`) REFERENCES `app_role` (`id`),
  ADD CONSTRAINT `FKl4vrdvb00lll6ee5haoq9m9ev` FOREIGN KEY (`app_menu`) REFERENCES `app_menu` (`id`);

--
-- Constraints for table `app_user`
--
ALTER TABLE `app_user`
  ADD CONSTRAINT `FK2x7xik812g9fy1f4x9i7uccyj` FOREIGN KEY (`company`) REFERENCES `company` (`id`),
  ADD CONSTRAINT `FKhx2h8kit0c1bl6lwaeua5gn1o` FOREIGN KEY (`department`) REFERENCES `department` (`id`);

--
-- Constraints for table `app_user_role`
--
ALTER TABLE `app_user_role`
  ADD CONSTRAINT `FK3xcgg4e44bx37j6oa7p1lfgp8` FOREIGN KEY (`app_user`) REFERENCES `app_user` (`id`),
  ADD CONSTRAINT `FKcprhx6mpypdwshju5p7pi971y` FOREIGN KEY (`app_role`) REFERENCES `app_role` (`id`);

--
-- Constraints for table `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `FKacyft44u7h6gnqp25riu5mcba` FOREIGN KEY (`company`) REFERENCES `company` (`id`);

--
-- Constraints for table `document_approve`
--
ALTER TABLE `document_approve`
  ADD CONSTRAINT `FK7wf0xdvu30jixtf0ltfv42r6x` FOREIGN KEY (`approver`) REFERENCES `app_user` (`id`),
  ADD CONSTRAINT `FKsat12feq7m9pq7elw99rkmhfo` FOREIGN KEY (`travel_expense_doc_approve`) REFERENCES `travel_expense` (`id`);

--
-- Constraints for table `travel_expense`
--
ALTER TABLE `travel_expense`
  ADD CONSTRAINT `FK9m829qm4dv3rotgivys89pac9` FOREIGN KEY (`approve_map_flow`) REFERENCES `approve_map_flow` (`id`),
  ADD CONSTRAINT `FKdm555jonejte4kf84kbbivpvo` FOREIGN KEY (`department`) REFERENCES `department` (`id`),
  ADD CONSTRAINT `FKg5547ws47u2w8lb3xkkhqcsb8` FOREIGN KEY (`app_user`) REFERENCES `app_user` (`id`),
  ADD CONSTRAINT `FKgmeh2iamfi69dvnokjj1uhbow` FOREIGN KEY (`company`) REFERENCES `company` (`id`),
  ADD CONSTRAINT `FKn9g1lx8xm7bl4dxgpbl4n4b74` FOREIGN KEY (`bank`) REFERENCES `bank` (`id`);

--
-- Constraints for table `travel_expense_detail`
--
ALTER TABLE `travel_expense_detail`
  ADD CONSTRAINT `FKjkrk9hfkxi34vhnsff6difbdn` FOREIGN KEY (`travel_expense`) REFERENCES `travel_expense` (`id`),
  ADD CONSTRAINT `FKsvm2jhe9q6ev6kd7ckp1s515w` FOREIGN KEY (`customer`) REFERENCES `customer` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
