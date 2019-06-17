/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80016
Source Host           : 127.0.0.1:3306
Source Database       : short_rental

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-06-17 10:15:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) DEFAULT NULL,
  `file_url` varchar(255) DEFAULT NULL,
  `file_cre_tim` datetime DEFAULT NULL,
  `file_room` int(11) DEFAULT NULL,
  `file_order` int(11) DEFAULT NULL,
  `file_use` int(11) DEFAULT NULL COMMENT '0.文件 1.图片',
  `file_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_file
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_url` varchar(255) DEFAULT NULL,
  `menu_father` int(11) DEFAULT NULL COMMENT '父类',
  `menu_level` int(11) DEFAULT NULL COMMENT '标识',
  `menu_other` varchar(255) DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '房屋信息', 'templates/room', '0', '0', 'menu_room');
INSERT INTO `sys_menu` VALUES ('2', '订单信息', 'templates/order', '0', '0', 'menu_order');
INSERT INTO `sys_menu` VALUES ('3', '后台管理', 'templates/admin', '0', '0', 'menu_admin');
INSERT INTO `sys_menu` VALUES ('4', '我要看房', 'templates/findRoom', '1', '1', 'menu_room_look');
INSERT INTO `sys_menu` VALUES ('5', '我要租房', 'templates/publishRoom', '1', '1', 'menu_room_rental');
INSERT INTO `sys_menu` VALUES ('6', '角色管理', 'templates/role', '3', '1', 'menu_admin_room');
INSERT INTO `sys_menu` VALUES ('7', '查询所有用户', null, null, null, 'user_find_all');
INSERT INTO `sys_menu` VALUES ('8', '控制台', null, null, null, 'kzt');

-- ----------------------------
-- Table structure for sys_order
-- ----------------------------
DROP TABLE IF EXISTS `sys_order`;
CREATE TABLE `sys_order` (
  `order_id` int(255) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(255) DEFAULT NULL,
  `order_cre_tim` datetime DEFAULT NULL,
  `order_sta_tim` date DEFAULT NULL,
  `order_end_tim` date DEFAULT NULL,
  `order_rental` int(10) DEFAULT NULL COMMENT '租金',
  `order_room` int(11) DEFAULT NULL,
  `order_use` int(11) DEFAULT NULL,
  `order_type` int(11) DEFAULT NULL COMMENT '0.完成 1.未完成',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_order
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '1', '2');
INSERT INTO `sys_role_menu` VALUES ('3', '1', '3');
INSERT INTO `sys_role_menu` VALUES ('4', '1', '4');
INSERT INTO `sys_role_menu` VALUES ('5', '1', '5');
INSERT INTO `sys_role_menu` VALUES ('6', '1', '6');

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('1', '18', '1');

-- ----------------------------
-- Table structure for sys_room
-- ----------------------------
DROP TABLE IF EXISTS `sys_room`;
CREATE TABLE `sys_room` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_addr` varchar(255) DEFAULT NULL,
  `room_hold` int(1) DEFAULT NULL COMMENT '0可租， 1在租',
  `room_use` int(11) DEFAULT NULL COMMENT '房东',
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_room
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(255) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_idc` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `user_sex` int(10) DEFAULT NULL COMMENT '0 女 1 男',
  `user_age` varchar(3) DEFAULT NULL,
  `user_tel` varchar(11) DEFAULT NULL,
  `user_account` varchar(255) DEFAULT NULL COMMENT '账号',
  `user_password` varchar(255) DEFAULT NULL,
  `user_cre_tim` datetime DEFAULT NULL,
  `use_upd_tim` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('18', 'yyz', '132456', '1', '1', '123456', 'admin', 'a66abb5684c45962d887564f08346e8d', '2018-09-12 17:04:08', null);
