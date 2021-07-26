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

 Date: 06/07/2021 16:50:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `student_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `student_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `class_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', '小毛', '1');
INSERT INTO `t_student` VALUES ('2', '小华', '1');
INSERT INTO `t_student` VALUES ('3', '小江', '1');
INSERT INTO `t_student` VALUES ('4', '小习', '2');
INSERT INTO `t_student` VALUES ('5', '小胡', '2');
INSERT INTO `t_student` VALUES ('6', '小赵', '3');
INSERT INTO `t_student` VALUES ('7', '小薄', '4');
INSERT INTO `t_student` VALUES ('8', '小周', '4');
INSERT INTO `t_student` VALUES ('9', '小邓', '4');

SET FOREIGN_KEY_CHECKS = 1;
