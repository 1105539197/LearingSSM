/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : mybatisplus

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 09/08/2021 16:51:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `dept_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `dept_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('GS', '公司');
INSERT INTO `dept` VALUES ('GS01', '行政部');
INSERT INTO `dept` VALUES ('GS0101', '行政部-A');
INSERT INTO `dept` VALUES ('GS0102', '行政部-B');
INSERT INTO `dept` VALUES ('GS02', '人力部');
INSERT INTO `dept` VALUES ('GS0201', '人力部-入职');
INSERT INTO `dept` VALUES ('GS0202', '人力部-离职');
INSERT INTO `dept` VALUES ('GS0203', '人力部-考勤');
INSERT INTO `dept` VALUES ('GS03', '研发部');
INSERT INTO `dept` VALUES ('GS0301', '研发部-前端');
INSERT INTO `dept` VALUES ('GS0302', '研发部-后端');
INSERT INTO `dept` VALUES ('GS030201', '研发部-后端-Java');
INSERT INTO `dept` VALUES ('GS030202', '研发部-后端-Python');
INSERT INTO `dept` VALUES ('GS0303', '研发部-测试');

SET FOREIGN_KEY_CHECKS = 1;
