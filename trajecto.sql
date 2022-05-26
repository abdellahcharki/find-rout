-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               5.7.24 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for trajecto
DROP DATABASE IF EXISTS `trajecto`;
CREATE DATABASE IF NOT EXISTS `trajecto` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `trajecto`;

-- Dumping structure for table trajecto.cities
DROP TABLE IF EXISTS `cities`;
CREATE TABLE IF NOT EXISTS `cities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `x` double DEFAULT NULL,
  `y` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

-- Dumping data for table trajecto.cities: ~16 rows (approximately)
DELETE FROM `cities`;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` (`id`, `name`, `x`, `y`) VALUES
	(1, 'FES', 34.03980575, -5.0977733),
	(2, 'KARIAT BA MOHAMED', 34.3670576, -5.2188379),
	(3, 'MEKNES', 33.87128193, -5.540786),
	(4, 'SEFROU', 33.83044515, -4.83698324),
	(5, 'TAOUNATE', 34.54063208, -4.63893058),
	(22, 'EL HAJEB', 33.68869412, -5.3695652),
	(23, 'IFRANE', 33.52677869, -5.11813176),
	(24, 'TAZA', 34.21651861, -4.00844414),
	(26, 'JOREF EL MELHA', 34.4911723, -5.50731735),
	(27, 'GHAFSAI', 34.23207902, -3.34354752),
	(28, 'IMOUZZAR', 33.73127141, -5.01340874),
	(30, 'AZRO', 33.44266503, -5.22485013),
	(31, 'BOULEMAN', 33.36532946, -4.7295958),
	(32, 'GUERCIF', 34.25078312, -3.33371603),
	(33, 'OUEZZAN', 34.79813009, -5.5739081),
	(34, 'TARGEST', 34.93855989, -4.31690084);
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;

-- Dumping structure for table trajecto.routes
DROP TABLE IF EXISTS `routes`;
CREATE TABLE IF NOT EXISTS `routes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city1` int(11) DEFAULT NULL,
  `city2` int(11) DEFAULT NULL,
  `dist` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `city1` (`city1`,`city2`),
  KEY `FK_disrances_cities_2` (`city2`),
  CONSTRAINT `FK_disrances_cities` FOREIGN KEY (`city1`) REFERENCES `cities` (`id`),
  CONSTRAINT `FK_disrances_cities_2` FOREIGN KEY (`city2`) REFERENCES `cities` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

-- Dumping data for table trajecto.routes: ~22 rows (approximately)
DELETE FROM `routes`;
/*!40000 ALTER TABLE `routes` DISABLE KEYS */;
INSERT INTO `routes` (`id`, `city1`, `city2`, `dist`) VALUES
	(1, 1, 2, 63.8),
	(3, 1, 5, 87.1),
	(4, 1, 3, 63.9),
	(5, 1, 24, 118.9),
	(6, 2, 5, 86.7),
	(7, 2, 27, 66.3),
	(8, 2, 26, 42.5),
	(9, 26, 33, 43.2),
	(10, 27, 5, 56.5),
	(11, 1, 28, 44),
	(12, 1, 4, 28),
	(13, 4, 24, 120.2),
	(14, 24, 32, 76.8),
	(15, 4, 31, 74.6),
	(16, 28, 4, 32.7),
	(17, 28, 22, 61.7),
	(18, 3, 22, 31.6),
	(19, 30, 22, 39.6),
	(20, 30, 23, 18.6),
	(21, 23, 31, 55),
	(22, 5, 34, 100.1),
	(23, 22, 23, 36),
	(24, 28, 23, 27.7);
/*!40000 ALTER TABLE `routes` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
