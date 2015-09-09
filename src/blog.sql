-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 09 Eyl 2015, 15:31:14
-- Sunucu sürümü: 5.6.17
-- PHP Sürümü: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Veritabanı: `blog`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `blog`
--

CREATE TABLE IF NOT EXISTS `blog` (
  `BlogID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `BlogTitle` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `Description` varchar(255) COLLATE utf8_turkish_ci NOT NULL,
  `CreateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`BlogID`),
  KEY `UserID` (`UserID`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci AUTO_INCREMENT=3 ;

--
-- Tablo döküm verisi `blog`
--

INSERT INTO `blog` (`BlogID`, `UserID`, `BlogTitle`, `Description`, `CreateDate`) VALUES
(1, 1, 'Merhaba', 'Sakla samanı gelir zamanı :)', '2015-02-08 15:06:46'),
(2, 1, 'Hoşgeldiniz', 'Bu yeni oluşturulmuş bir blogdur.', '2015-09-09 16:28:18');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `comments`
--

CREATE TABLE IF NOT EXISTS `comments` (
  `CommentID` int(11) NOT NULL AUTO_INCREMENT,
  `BlogID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `UserName` varchar(120) COLLATE utf8_turkish_ci NOT NULL,
  `CommentTitle` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `CommentContent` text COLLATE utf8_turkish_ci NOT NULL,
  `CommentDate` datetime DEFAULT NULL,
  PRIMARY KEY (`CommentID`),
  KEY `BlogID` (`BlogID`) USING BTREE,
  KEY `KullaniciID` (`UserID`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci AUTO_INCREMENT=2 ;

--
-- Tablo döküm verisi `comments`
--

INSERT INTO `comments` (`CommentID`, `BlogID`, `UserID`, `UserName`, `CommentTitle`, `CommentContent`, `CommentDate`) VALUES
(1, 2, 1, 'Rahman Yazgan', 'Bravo', 'Hayırlı olsun', '2015-09-09 16:29:21');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `Password` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `UserName` varchar(120) COLLATE utf8_turkish_ci NOT NULL,
  `AccessPermission` char(1) COLLATE utf8_turkish_ci NOT NULL,
  `RecordDate` datetime DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci AUTO_INCREMENT=6 ;

--
-- Tablo döküm verisi `users`
--

INSERT INTO `users` (`UserID`, `Email`, `Password`, `UserName`, `AccessPermission`, `RecordDate`) VALUES
(1, 'rahman@rahmanyazgan.com', '1234', 'Rahman Yazgan', 'A', '2015-01-16 23:37:19'),
(5, 'hizir@cosar.com', '1111', 'Hızır Coşar', 'Y', '2015-01-17 00:40:43');

--
-- Tablo kısıtlamaları `blog`
--
ALTER TABLE `blog`
  ADD CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `users` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `users` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE;
