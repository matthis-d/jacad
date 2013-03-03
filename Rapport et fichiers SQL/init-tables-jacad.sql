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

-- --------------------------------------------------------

--
-- Structure de la table `PLAYER`
--

DROP TABLE IF EXISTS `PLAYER`;
CREATE TABLE IF NOT EXISTS `PLAYER` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(80) NOT NULL,
  `LAST_NAME` varchar(80) NOT NULL,
  `BIRTH_DATE` date NOT NULL,
  `POSITION` varchar(80) NOT NULL,
  `WEIGHT` float DEFAULT NULL,
  `HEIGHT` float DEFAULT NULL,
  `TEAM_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK8CD18EE1315889BD` (`TEAM_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

-- --------------------------------------------------------

--
-- Structure de la table `TEAM`
--

DROP TABLE IF EXISTS `TEAM`;
CREATE TABLE IF NOT EXISTS `TEAM` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `COLORS` varchar(255) NOT NULL,
  `STADIUM_NAME` varchar(255) NOT NULL,
  `CREATION_YEAR` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `PLAYER`
--
ALTER TABLE `PLAYER`
  ADD CONSTRAINT `FK8CD18EE1315889BD` FOREIGN KEY (`TEAM_ID`) REFERENCES `TEAM` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
