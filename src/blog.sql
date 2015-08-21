/*
Source Server         : mysql
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-08-21 16:31:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
`BlogID`  int(11) NOT NULL AUTO_INCREMENT ,
`UserID`  int(11) NOT NULL ,
`BlogTitle`  varchar(100) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL ,
`Description`  varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL ,
`CreateDate`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`BlogID`),
FOREIGN KEY (`UserID`) REFERENCES `users` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_turkish_ci
AUTO_INCREMENT=2

;

-- ----------------------------
-- Records of blog
-- ----------------------------
BEGIN;
INSERT INTO `blog` VALUES ('1', '1', 'Merhaba', 'Sakla samanı gelir zamanı :(', '2015-02-08 15:06:46');
COMMIT;

-- ----------------------------
-- Table structure for `comments`
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
`CommentID`  int(11) NOT NULL AUTO_INCREMENT ,
`BlogID`  int(11) NOT NULL ,
`UserID`  int(11) NOT NULL ,
`UserName`  varchar(120) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL ,
`CommentTitle`  varchar(100) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL ,
`CommentContent`  text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL ,
`CommentDate`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`CommentID`),
FOREIGN KEY (`UserID`) REFERENCES `users` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_turkish_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of comments
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
`UserID`  int(11) NOT NULL AUTO_INCREMENT ,
`Email`  varchar(100) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL ,
`Password`  varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL ,
`UserName`  varchar(120) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL ,
`AccessPermission`  char(1) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL ,
`RecordDate`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`UserID`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_turkish_ci
AUTO_INCREMENT=6

;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('1', 'rahman@rahmanyazgan.com', '1234', 'Rahman Yazgan', 'A', '2015-01-16 23:37:19'), ('5', 'hizir@cosar.com', '1111', 'Hızır Coşar', 'Y', '2015-01-17 00:40:43');
COMMIT;

-- ----------------------------
-- Indexes structure for table `blog`
-- ----------------------------
CREATE INDEX `UserID` ON `blog`(`UserID`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `blog`
-- ----------------------------
ALTER TABLE `blog` AUTO_INCREMENT=2;

-- ----------------------------
-- Indexes structure for table `comments`
-- ----------------------------
CREATE INDEX `BlogID` ON `comments`(`BlogID`) USING BTREE ;
CREATE INDEX `KullaniciID` ON `comments`(`UserID`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `comments`
-- ----------------------------
ALTER TABLE `comments` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `users`
-- ----------------------------
ALTER TABLE `users` AUTO_INCREMENT=6;
