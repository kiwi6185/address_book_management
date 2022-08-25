/*
 Navicat Premium Data Transfer

 Source Server         : MySQL01
 Source Server Type    : MySQL
 Source Server Version : 50715
 Source Host           : localhost:3306
 Source Schema         : 信息管理系统

 Target Server Type    : MySQL
 Target Server Version : 50715
 File Encoding         : 65001

 Date: 30/12/2021 10:08:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ip_record
-- ----------------------------
DROP TABLE IF EXISTS `ip_record`;
CREATE TABLE `ip_record`  (
  `ID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IP` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ip_record
-- ----------------------------
INSERT INTO `ip_record` VALUES ('001', '本机', '127.0.0.1');
INSERT INTO `ip_record` VALUES ('002', '李小姐', '10.213.12.10');
INSERT INTO `ip_record` VALUES ('003', '梦丹', '192.168.137.1');
INSERT INTO `ip_record` VALUES ('004', '林三', '159.75.55.71');
INSERT INTO `ip_record` VALUES ('005', '阿楚', '10.213.47.102');
INSERT INTO `ip_record` VALUES ('006', '阿蔡', '192.168.222.1');
INSERT INTO `ip_record` VALUES ('007', '冰冰', '255.255.224.0');
INSERT INTO `ip_record` VALUES ('008', '阿采', '255.255.248.0');
INSERT INTO `ip_record` VALUES ('009', '阿蒙', '192.168.137.1');
INSERT INTO `ip_record` VALUES ('010', '阿芳', '218.192.81.141');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `ID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `IsAdmin` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0001', 'kiwi', '8888', '0');
INSERT INTO `user` VALUES ('001', '李小姐', '12345', '0');
INSERT INTO `user` VALUES ('002', '林先生', '123', '1');
INSERT INTO `user` VALUES ('003', '我累了', '12', '0');
INSERT INTO `user` VALUES ('004', '林三', '123', '0');
INSERT INTO `user` VALUES ('005', 'kiwi', '1', '0');
INSERT INTO `user` VALUES ('006', '好累', '123', '0');
INSERT INTO `user` VALUES ('009', '林先生1号', '123', '0');
INSERT INTO `user` VALUES ('011', '加油', '12', '0');
INSERT INTO `user` VALUES ('test', '', '', '0');

SET FOREIGN_KEY_CHECKS = 1;
