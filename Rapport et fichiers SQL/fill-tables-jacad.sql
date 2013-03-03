-- phpMyAdmin SQL Dump
-- version 3.5.7
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Dim 03 Mars 2013 à 17:53
-- Version du serveur: 5.5.25
-- Version de PHP: 5.4.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `projetJacad`
--

--
-- Contenu de la table `PLAYER`
--

INSERT INTO `PLAYER` (`ID`, `FIRST_NAME`, `LAST_NAME`, `BIRTH_DATE`, `POSITION`, `WEIGHT`, `HEIGHT`, `TEAM_ID`) VALUES
(6, 'ZLATAN', 'IBRAHIMOVIC', '1981-10-01', 'Attaquant', 95, 1.95, 3),
(7, 'PIERRE-EMERICK', 'AUBAMEYANG', '1989-06-18', 'Attaquant', 74, 1.85, 4),
(8, 'BAFETIMBI', 'GOMIS', '1985-08-06', 'Attaquant', 77, 1.84, 5),
(9, 'DARIO', 'CVITANICH', '1984-05-16', 'Attaquant', 72, 1.74, 7),
(10, 'JEREMIE', 'ALIADIÈRE', '1983-03-30', 'Attaquant', 70, 1.83, 11),
(11, 'DIMITRI', 'PAYET', '1987-03-29', 'Attaquant', 77, 1.75, 10),
(12, 'ROMAIN', 'ALESSANDRINI', '1989-04-03', 'Milieu', 70, 1.73, 9),
(13, 'MEVLUT', 'ERDING', '1987-02-25', 'Attaquant', 85, 1.81, 9),
(14, 'BRANDAO', '-', '1980-06-15', 'Attaquant', 78, 1.89, 4);

--
-- Contenu de la table `TEAM`
--

INSERT INTO `TEAM` (`ID`, `NAME`, `COLORS`, `STADIUM_NAME`, `CREATION_YEAR`) VALUES
(3, 'Paris Saint Germain', 'Bleu, rouge', 'Parc des Princes', 1970),
(4, 'ASSE', 'Vert', 'Geoffroy Guichard', 1920),
(5, 'OL', 'Blanc, bleu', 'Gerland', 1950),
(6, 'OM', 'Blanc, bleu ciel', 'Vélodrome', 1899),
(7, 'OGC Nice', 'Noir, rouge', 'Stade du Ray', 1904),
(8, 'MHSC', 'Bleu, orange', 'La Mosson', 1974),
(9, 'Rennes', 'Rouge, noir', 'Stade de la route de Lorient', 1901),
(10, 'LOSC Lille', 'Rouge, blanc', 'Grand stade de Lille Métropole', 1944),
(11, 'FC Lorient', 'Orange', 'Yves-Allainmat', 1926),
(12, 'Bordeaux', 'Bleu', 'Jacques Chaban-Delmas', 1881);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
