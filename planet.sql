-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Май 11 2015 г., 20:14
-- Версия сервера: 5.5.25
-- Версия PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `planet`
--

-- --------------------------------------------------------

--
-- Структура таблицы `galactics`
--

CREATE TABLE IF NOT EXISTS `galactics` (
  `idgalactic` int(10) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`idgalactic`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `galactics`
--

INSERT INTO `galactics` (`idgalactic`, `name`) VALUES
(2222, 'galaxy2'),
(1111, 'galaxy1'),
(3333, 'galactic3');

-- --------------------------------------------------------

--
-- Структура таблицы `planets`
--

CREATE TABLE IF NOT EXISTS `planets` (
  `idplanet` int(10) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `radius` int(10) NOT NULL,
  `temperature` int(10) NOT NULL,
  `atmosphere` varchar(3) COLLATE utf8mb4_unicode_ci NOT NULL,
  `existence` varchar(3) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idgalactic` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idplanet`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `planets`
--

INSERT INTO `planets` (`idplanet`, `name`, `radius`, `temperature`, `atmosphere`, `existence`, `idgalactic`) VALUES
(1, 'planetname1', 11, 111, 'yes', 'yes', 1111),
(2, 'planetname2', 22, 222, 'no', 'no', 2222),
(3, 'planetname3', 33, 333, 'yes', 'yes', 3333),
(4, 'planetname4', 44, 444, 'no', 'no', 1111);

-- --------------------------------------------------------

--
-- Структура таблицы `satellites`
--

CREATE TABLE IF NOT EXISTS `satellites` (
  `idsatellite` int(10) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `radius` int(10) NOT NULL,
  `distance` int(10) NOT NULL,
  `idplanet` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idsatellite`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `satellites`
--

INSERT INTO `satellites` (`idsatellite`, `name`, `radius`, `distance`, `idplanet`) VALUES
(11, 'nameset1', 1, 111, 1),
(22, 'nameset2', 22, 222, 3),
(33, 'nameset3', 33, 333, 3),
(44, 'nameset4', 44, 4444, 1),
(55, 'nameset5', 55, 555, 2),
(66, 'nameset6', 66, 666, 4);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
