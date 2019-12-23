/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100408
 Source Host           : localhost:3306
 Source Schema         : gas_scale

 Target Server Type    : MySQL
 Target Server Version : 100408
 File Encoding         : 65001

 Date: 20/12/2019 14:22:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_device
-- ----------------------------
DROP TABLE IF EXISTS `config_device`;
CREATE TABLE `config_device`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `warning_percent_gas` int(3) NULL DEFAULT NULL COMMENT 'Phần trăm gas cảnh báo.',
  `warning_percent_battery` int(3) NULL DEFAULT NULL COMMENT 'Phần trăm pin cảnh báo.',
  `id_type_gas_tank` int(10) NOT NULL COMMENT 'Loại bình gas liên kết với bảng loại bình gas',
  `create_time` int(10) NULL DEFAULT NULL COMMENT 'Ngày tạo.',
  `update_time` int(10) NULL DEFAULT NULL COMMENT 'Ngày cập nhật.',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT 'Trang thái record. 0: Chưa xóa, 1: Đã xóa',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKg9mprfaawhy3p40mbxqovm2mm`(`id_type_gas_tank`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for gas_tank
-- ----------------------------
DROP TABLE IF EXISTS `gas_tank`;
CREATE TABLE `gas_tank`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `id_user` int(10) NOT NULL COMMENT 'id của user đang sử dụng bình gas',
  `id_gas_tank` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Là tên định danh của bình gas',
  `id_type_gas_tank` int(10) NOT NULL COMMENT 'Loại bình gas liên kết với bảng loại bình gas',
  `residual_gas_tank` float(6, 1) NULL DEFAULT NULL COMMENT 'Số gas còn lại trong bình theo kg',
  `residual_battery` int(3) NULL DEFAULT NULL COMMENT 'Số phần trăm pin còn lại',
  `create_time` int(10) NULL DEFAULT NULL COMMENT 'Ngay mà user bắt đầu sử dụng thiết bị đo',
  `update_time` int(10) NULL DEFAULT NULL COMMENT 'Ngay update dung lượng gas đã sử dụng',
  `replate_time` int(10) NOT NULL COMMENT 'Ngày đổi bình gas mới',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT 'Trang thái record. 0: Chưa xóa, 1: Đã xóa',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Table structure for log_gas_tank
-- ----------------------------
DROP TABLE IF EXISTS `log_gas_tank`;
CREATE TABLE `log_gas_tank`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `id_gas_tank` int(10) NOT NULL,
  `residual_gas_tank` float(6, 1) NULL DEFAULT NULL COMMENT 'Số gas còn lại trong bình theo kg',
  `create_time` int(10) NULL DEFAULT NULL COMMENT 'Ngày mà bình gas được đổi mới',
  `update_time` int(10) NULL DEFAULT NULL COMMENT 'Ngay update dung lượng gas còn lại trong bình',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT 'Trang thái record. 0: Chưa xóa, 1: Đã xóa',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for type_gas_tank
-- ----------------------------
DROP TABLE IF EXISTS `type_gas_tank`;
CREATE TABLE `type_gas_tank`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name_gas_tank` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'full name',
  `weight_crust_gas_tank` float(6, 1) NULL DEFAULT NULL COMMENT 'Trọng lượng vỏ bình gas kg',
  `weight_insides_gas_tank` float(6, 1) NULL DEFAULT NULL COMMENT 'Trọng lượng gas trong bình kg',
  `create_time` int(10) NULL DEFAULT NULL COMMENT 'Ngày tạo loại bình gas',
  `update_time` int(10) NULL DEFAULT NULL COMMENT 'Ngày update',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT 'Trang thái record. 0: Chưa xóa, 1: Đã xóa',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'The phone of user',
  `full_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'full name',
  `pwd` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'password',
  `create_time` int(10) NULL DEFAULT NULL COMMENT 'Ngày tạo',
  `update_time` int(10) NULL DEFAULT NULL COMMENT 'Ngay update',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT 'Trang thái record. 0: Chưa xóa, 1: Đã xóa',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_phone`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_customer
-- ----------------------------
DROP TABLE IF EXISTS `user_customer`;
CREATE TABLE `user_customer`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'The phone of user',
  `full_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'full name',
  `create_time` int(10) NULL DEFAULT NULL COMMENT 'Ngày tạo',
  `update_time` int(10) NULL DEFAULT NULL COMMENT 'Ngay update',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT 'Trang thái record. 0: Chưa xóa, 1: Đã xóa',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_supplier
-- ----------------------------
DROP TABLE IF EXISTS `user_supplier`;
CREATE TABLE `user_supplier`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Họ và tên',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Số điện thoại',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Dia chỉ nhà cung cấp',
  `note` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Ghi chú',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT 'Trang thái record. 0: Chưa xóa, 1: Đã xóa',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
