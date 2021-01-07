-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 07, 2021 at 08:48 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestion_clinique`
--

-- --------------------------------------------------------

--
-- Table structure for table `consultation`
--

DROP TABLE IF EXISTS `consultation`;
CREATE TABLE IF NOT EXISTS `consultation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_cons` varchar(20) NOT NULL,
  `Description` varchar(500) NOT NULL,
  `prix` float NOT NULL,
  `cin` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `consultation`
--

INSERT INTO `consultation` (`id`, `date_cons`, `Description`, `prix`, `cin`) VALUES
(1, '2020/12/02', 'ostéogenèse imparfaite', 150, 'A521753'),
(2, '2020-05-16', 'consultation de suivi', 200, 'A159357'),
(6, '2020-05-14', 'Urgence', 250, 'A147852');

-- --------------------------------------------------------

--
-- Table structure for table `dossier_medical`
--

DROP TABLE IF EXISTS `dossier_medical`;
CREATE TABLE IF NOT EXISTS `dossier_medical` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cin` varchar(7) NOT NULL,
  `nom` varchar(12) NOT NULL,
  `prenom` varchar(12) NOT NULL,
  `telephone` int(20) NOT NULL,
  `maladie` varchar(255) NOT NULL,
  `mediceaux` varchar(255) NOT NULL,
  `medcin_nom` varchar(255) NOT NULL,
  `specialite` varchar(255) NOT NULL,
  `date_creation` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dossier_medical`
--

INSERT INTO `dossier_medical` (`id`, `cin`, `nom`, `prenom`, `telephone`, `maladie`, `mediceaux`, `medcin_nom`, `specialite`, `date_creation`) VALUES
(1, 'A521753', 'Shimi', 'Oumayma', 641824452, 'ostéogenèse imparfaite', 'vitamine D5', 'Kaddir', 'Traumatologue', '2020-05-15 18:28:16'),
(2, 'A159357', 'absike', 'Idriss', 652418597, 'L\'épilepsie', 'MP850', 'Benani', 'Neurologue', '2020-05-17 06:14:31');

-- --------------------------------------------------------

--
-- Table structure for table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `cin` varchar(255) NOT NULL,
  `telephone` varchar(12) NOT NULL,
  `description` varchar(30) NOT NULL,
  `prix` varchar(30) NOT NULL,
  `cart_umber` varchar(30) NOT NULL,
  `cvv` int(3) NOT NULL,
  `expires` varchar(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `facture`
--

INSERT INTO `facture` (`id`, `nom`, `prenom`, `cin`, `telephone`, `description`, `prix`, `cart_umber`, `cvv`, `expires`) VALUES
(6, 'Shimi', 'Oumayma', 'A521753', '641824452', 'Consulter suivi', '150.0', '5404 3772 8364 1853', 125, '12/21'),
(8, 'Shimi', 'Oumayma', 'A521753', '641824452', 'ostÃ©ogenÃ¨se imparfaite', '150.0', '5404 3772 8364 1878', 174, '02/20'),
(9, 'Shimi', 'Oumayma', 'A521753', '641824452', 'ostÃ©ogenÃ¨se imparfaite', '150.0', '5404 3772 8364 1878', 158, '20/20');

-- --------------------------------------------------------

--
-- Table structure for table `medcin`
--

DROP TABLE IF EXISTS `medcin`;
CREATE TABLE IF NOT EXISTS `medcin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cin` varchar(10) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `address` varchar(100) NOT NULL,
  `telephone` int(11) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `specialite` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `medcin`
--

INSERT INTO `medcin` (`id`, `cin`, `nom`, `prenom`, `address`, `telephone`, `mail`, `specialite`) VALUES
(4, 'A852741', 'Essabahi', 'Mohamed', 'Rabat', 652874197, 'Essabahi@gmail.com', 'Pédiatere'),
(6, 'A852763', 'Benani', 'Taha', 'sale', 653214587, 'Benani@gmail.com', 'Neurologue'),
(7, 'A951475', 'Chakir ', 'Ayoub', 'rabat', 653278903, 'Chakir@gmail.com', 'Cardiologue'),
(8, 'A7419863', 'Kaddir', 'Mohamed', 'Kenitra', 695274185, 'Kaddir@gmail.com', 'Traumatologue');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cin` varchar(10) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `telephone` int(20) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `sexe` varchar(10) NOT NULL,
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`id`, `cin`, `nom`, `prenom`, `telephone`, `mail`, `sexe`, `date_create`) VALUES
(1, 'A521753', 'Shimi', 'Oumayma', 641824452, 'oumaya@gmail.com', 'F', '2020-05-13 18:24:35'),
(9, 'A159357', 'absike', 'Idriss', 652418597, 'absike@gmail.com', 'M', '2020-05-16 00:13:17'),
(10, 'A147852', 'Bekri', 'Ayoub', 236523654, 'Bekri@gmail.com', 'M', '2020-05-17 05:36:55'),
(13, 'Nawal', 'Shimi', 'kenitra', 12593, 'Nawal@gmail.com', 'F', '2020-05-18 08:29:08');

-- --------------------------------------------------------

--
-- Table structure for table `receptionniste`
--

DROP TABLE IF EXISTS `receptionniste`;
CREATE TABLE IF NOT EXISTS `receptionniste` (
  `cin` varchar(10) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `telephone` int(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `receptionniste`
--

INSERT INTO `receptionniste` (`cin`, `nom`, `prenom`, `telephone`, `address`, `mail`, `id`) VALUES
('A789456', 'Kadiri', 'Fatima', 69741528, 'Rabat', 'Kadiri@gmail.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `rendezvous`
--

DROP TABLE IF EXISTS `rendezvous`;
CREATE TABLE IF NOT EXISTS `rendezvous` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cin` varchar(10) NOT NULL,
  `nom_prenom` varchar(255) NOT NULL,
  `description` varchar(500) NOT NULL,
  `date_rdv` varchar(12) NOT NULL,
  `activate` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rendezvous`
--

INSERT INTO `rendezvous` (`id`, `cin`, `nom_prenom`, `description`, `date_rdv`, `activate`) VALUES
(2, 'A521753', 'Shimi Oumayma', 'Malade d\'ostyogenese', '2020/02/02', 1),
(4, 'A159357', 'Absike Driss', 'Malade d\'épilepsie', '2020/11/12', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
