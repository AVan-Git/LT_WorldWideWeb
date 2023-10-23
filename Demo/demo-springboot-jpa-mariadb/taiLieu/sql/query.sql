-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.1.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for mydb_lt
CREATE DATABASE IF NOT EXISTS `mydb_lt` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `mydb_lt`;

-- Dumping structure for table mydb_lt.department
CREATE TABLE IF NOT EXISTS `department` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) NOT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table mydb_lt.department: ~0 rows (approximately)
REPLACE INTO `department` (`dept_id`, `dept_name`) VALUES
	(1, 'Khoa Cong nghe thong tin'),
	(2, 'Khoa tri tue nhan tao'),
	(3, 'Khoa he thong thon tin');

-- Dumping structure for table mydb_lt.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `dob` date DEFAULT NULL,
  `department_dept_id` bigint(20) DEFAULT NULL,
  `emp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(255) NOT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `FK73iqbdohd6qwfdaij2bxc3vxx` (`department_dept_id`),
  CONSTRAINT `FK73iqbdohd6qwfdaij2bxc3vxx` FOREIGN KEY (`department_dept_id`) REFERENCES `department` (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table mydb_lt.employee: ~0 rows (approximately)
REPLACE INTO `employee` (`dob`, `department_dept_id`, `emp_id`, `emp_name`) VALUES
	(NULL, 1, 1, 'name #0'),
	(NULL, 1, 2, 'name #1'),
	(NULL, 1, 3, 'name #2'),
	(NULL, 1, 4, 'name #3'),
	(NULL, 1, 5, 'name #4'),
	(NULL, 1, 6, 'name #5'),
	(NULL, 1, 7, 'name #6'),
	(NULL, 1, 8, 'name #7'),
	(NULL, 1, 9, 'name #8'),
	(NULL, 1, 10, 'name #9'),
	(NULL, 2, 13, 'name #10'),
	(NULL, 2, 14, 'name #11'),
	(NULL, 2, 15, 'name #12'),
	(NULL, 2, 16, 'name #13'),
	(NULL, 2, 17, 'name #14'),
	(NULL, 2, 18, 'name #15'),
	(NULL, 2, 19, 'name #16'),
	(NULL, 2, 20, 'name #17'),
	(NULL, 2, 21, 'name #18'),
	(NULL, 2, 22, 'name #19'),
	(NULL, 3, 23, 'name #20'),
	(NULL, 3, 24, 'name #21'),
	(NULL, 3, 25, 'name #22'),
	(NULL, 3, 26, 'name #23'),
	(NULL, 3, 27, 'name #24'),
	(NULL, 3, 28, 'name #25'),
	(NULL, 3, 29, 'name #26'),
	(NULL, 3, 30, 'name #27'),
	(NULL, 3, 31, 'name #28'),
	(NULL, 3, 32, 'name #29'),
	(NULL, 3, 33, 'name #30'),
	(NULL, 3, 34, 'name #31'),
	(NULL, 3, 35, 'name #32'),
	(NULL, 3, 36, 'name #33'),
	(NULL, 3, 37, 'name #34'),
	(NULL, 3, 38, 'name #35'),
	(NULL, 3, 39, 'name #36'),
	(NULL, 3, 40, 'name #37'),
	(NULL, 3, 41, 'name #38'),
	(NULL, 3, 42, 'name #39'),
	(NULL, 3, 43, 'name #40'),
	(NULL, 3, 44, 'name #41'),
	(NULL, 3, 45, 'name #42'),
	(NULL, 3, 46, 'name #43'),
	(NULL, 3, 47, 'name #44'),
	(NULL, 3, 48, 'name #45'),
	(NULL, 3, 49, 'name #46'),
	(NULL, 3, 50, 'name #47'),
	(NULL, 3, 51, 'name #48'),
	(NULL, 3, 52, 'name #49'),
	(NULL, 2, 53, 'name #200'),
	(NULL, 2, 54, 'name #201'),
	(NULL, 2, 55, 'name #202'),
	(NULL, 3, 56, 'name #203'),
	(NULL, 3, 57, 'name #204'),
	(NULL, 3, 58, 'name #205'),
	(NULL, 2, 59, 'name #206'),
	(NULL, 2, 60, 'name #207'),
	(NULL, 1, 61, 'name #208'),
	(NULL, 2, 62, 'name #209'),
	(NULL, 2, 63, 'name #210'),
	(NULL, 2, 64, 'name #211'),
	(NULL, 1, 65, 'name #212'),
	(NULL, 2, 66, 'name #213'),
	(NULL, 3, 67, 'name #214'),
	(NULL, 3, 68, 'name #215'),
	(NULL, 2, 69, 'name #216'),
	(NULL, 3, 70, 'name #217'),
	(NULL, 2, 71, 'name #218'),
	(NULL, 3, 72, 'name #219'),
	(NULL, 1, 73, 'name #200'),
	(NULL, 2, 74, 'name #201'),
	(NULL, 3, 75, 'name #202'),
	(NULL, 3, 76, 'name #203'),
	(NULL, 2, 77, 'name #204'),
	(NULL, 3, 78, 'name #205'),
	(NULL, 2, 79, 'name #206'),
	(NULL, 1, 80, 'name #207'),
	(NULL, 3, 81, 'name #208'),
	(NULL, 2, 82, 'name #209'),
	(NULL, 3, 83, 'name #210'),
	(NULL, 2, 84, 'name #211'),
	(NULL, 2, 85, 'name #212'),
	(NULL, 2, 86, 'name #213'),
	(NULL, 3, 87, 'name #214'),
	(NULL, 3, 88, 'name #215'),
	(NULL, 1, 89, 'name #216'),
	(NULL, 2, 90, 'name #217'),
	(NULL, 3, 91, 'name #218'),
	(NULL, 2, 92, 'name #219'),
	(NULL, 2, 93, 'name #200'),
	(NULL, 1, 94, 'name #201'),
	(NULL, 2, 95, 'name #202'),
	(NULL, 3, 96, 'name #203'),
	(NULL, 2, 97, 'name #204'),
	(NULL, 2, 98, 'name #205'),
	(NULL, 1, 99, 'name #206'),
	(NULL, 2, 100, 'name #207'),
	(NULL, 2, 101, 'name #208'),
	(NULL, 3, 102, 'name #209'),
	(NULL, 1, 103, 'name #210'),
	(NULL, 1, 104, 'name #211'),
	(NULL, 3, 105, 'name #212'),
	(NULL, 3, 106, 'name #213'),
	(NULL, 2, 107, 'name #214'),
	(NULL, 3, 108, 'name #215'),
	(NULL, 2, 109, 'name #216'),
	(NULL, 2, 110, 'name #217'),
	(NULL, 2, 111, 'name #218'),
	(NULL, 2, 112, 'name #219');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
