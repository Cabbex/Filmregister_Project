-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Värd: 127.0.0.1
-- Tid vid skapande: 26 okt 2016 kl 18:19
-- Serverversion: 10.1.13-MariaDB
-- PHP-version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databas: `filmregister`
--

-- --------------------------------------------------------

--
-- Tabellstruktur `film`
--

CREATE TABLE `film` (
  `ID` int(11) NOT NULL,
  `Titel` varchar(75) NOT NULL,
  `Betyg` int(2) NOT NULL DEFAULT '1',
  `Släpptes` int(4) NOT NULL,
  `Genre` int(11) NOT NULL,
  `Regissor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumpning av Data i tabell `film`
--

INSERT INTO `film` (`ID`, `Titel`, `Betyg`, `Släpptes`, `Genre`, `Regissor`) VALUES
(1, 'Star Wars: Episode IV A New Hope', 7, 1977, 1, 1),
(2, 'Star Wars: Episode V The Empire Strikes Back', 9, 1980, 1, 1),
(3, 'Star Wars: Episode VI The return of the jedi', 8, 1983, 1, 1),
(4, 'The lord of the rings: The fellowship of the Ring', 7, 2001, 2, 2),
(5, 'The lord of the rings: The two towers', 8, 2002, 2, 2),
(6, 'The lord of the rings: The return of the king', 9, 2003, 2, 2),
(7, 'The Dark knight', 7, 2008, 3, 3),
(8, 'Batman Begins', 9, 2005, 3, 3),
(9, 'The dark knight rises', 8, 2012, 3, 3),
(10, 'Interstellar', 9, 2014, 1, 3),
(11, 'Mad max: Fury Road', 8, 2015, 1, 4);

-- --------------------------------------------------------

--
-- Tabellstruktur `genre`
--

CREATE TABLE `genre` (
  `Genre_id` int(11) NOT NULL,
  `Namn_Genre` varchar(20) NOT NULL,
  `Beskrivning` varchar(75) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumpning av Data i tabell `genre`
--

INSERT INTO `genre` (`Genre_id`, `Namn_Genre`, `Beskrivning`) VALUES
(1, 'Science Fiction', 'Handlar om framtiden. Hur långt fram det än kan vara. En sorts fantasi'),
(2, 'Fantasy', 'En värld där troll och vättar finns. Riddare och drakar. Allt om fantasin'),
(3, 'Action', 'Bara pang och boom. I moderna fall eller små förändringar till verkligheten');

-- --------------------------------------------------------

--
-- Tabellstruktur `regissor`
--

CREATE TABLE `regissor` (
  `regissor_id` int(11) NOT NULL,
  `regissor_Namn` varchar(25) NOT NULL,
  `Föddes` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumpning av Data i tabell `regissor`
--

INSERT INTO `regissor` (`regissor_id`, `regissor_Namn`, `Föddes`) VALUES
(1, 'George Lucas', 1944),
(2, 'Peter Jackson', 1961),
(3, 'Christopher Nolan', 1970),
(4, 'George Miller', 1945);

--
-- Index för dumpade tabeller
--

--
-- Index för tabell `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Regissör` (`Regissor`),
  ADD KEY `Genre` (`Genre`);

--
-- Index för tabell `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`Genre_id`);

--
-- Index för tabell `regissor`
--
ALTER TABLE `regissor`
  ADD PRIMARY KEY (`regissor_id`);

--
-- AUTO_INCREMENT för dumpade tabeller
--

--
-- AUTO_INCREMENT för tabell `film`
--
ALTER TABLE `film`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT för tabell `genre`
--
ALTER TABLE `genre`
  MODIFY `Genre_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT för tabell `regissor`
--
ALTER TABLE `regissor`
  MODIFY `regissor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
