-- /*
--  Navicat Premium Data Transfer
--
--  Source Server         : Notebook
--  Source Server Type    : MySQL
--  Source Server Version : 80019
--  Source Host           : localhost:3306
--  Source Schema         : Admin_moi
--
--  Target Server Type    : MySQL
--  Target Server Version : 80019
--  File Encoding         : 65001
--
--  Date: 03/03/2020 19:12:28
-- */
--
-- SET NAMES utf8mb4;
-- SET FOREIGN_KEY_CHECKS = 0;
--
-- -- ----------------------------
-- -- Table structure for Ad_profil
-- -- ----------------------------
-- DROP TABLE IF EXISTS `Ad_profil`;
-- CREATE TABLE `Ad_profil` (
--   `id` int NOT NULL AUTO_INCREMENT COMMENT 'Admin_ID',
--   `email` varchar(255) NOT NULL COMMENT 'Admin_addr',
--   `adminname` varchar(255) NOT NULL COMMENT 'Admin_realname',
--   `institute` varchar(255) NOT NULL COMMENT 'Admin_institute',
--   `mobile` varchar(50) DEFAULT '' COMMENT 'Tele',
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
--
-- -- ----------------------------
-- -- Records of Ad_profil
-- -- ----------------------------
-- BEGIN;
-- INSERT INTO `Ad_profil` VALUES (1, 'allodaisyy@gmail.com', 'Daisy', 'information', '110');
-- COMMIT;
--
-- SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `email` varchar(255) NOT NULL COMMENT '用户邮箱',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `username` varchar(255) NOT NULL COMMENT '用户昵称',
  `role` varchar(255) NOT NULL COMMENT '用户身份',
  `status` int(1) NOT NULL COMMENT '用户状态',
  `regTime` datetime NOT NULL COMMENT '注册时间',
  `regIp` varchar(255) NOT NULL COMMENT '注册IP',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
INSERT INTO `user` VALUES ('1', 'xxx', 'xxxxx', 'xxxxx', 'root', '0', '2017-03-28 09:40:31', '127.0.0.1');
SET FOREIGN_KEY_CHECKS=1;

