/*
 Navicat Premium Data Transfer

 Source Server         : Notebook
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : Admin_moi

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 06/03/2020 18:59:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for reg_users
-- ----------------------------
DROP TABLE IF EXISTS `reg_users`;
CREATE TABLE `reg_users` (
                             `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                             `email` varchar(255) NOT NULL,
                             `role` varchar(255) NOT NULL,
                             `password` varchar(255) DEFAULT NULL,
                             `reg_time` datetime DEFAULT NULL,
                             `id` int NOT NULL AUTO_INCREMENT,
                             PRIMARY KEY (`id`,`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reg_users
-- ----------------------------
BEGIN;
INSERT INTO `reg_users` VALUES ('allodaisy', 'allodaisyy@gmail.com', 'admin', '111', NULL, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
