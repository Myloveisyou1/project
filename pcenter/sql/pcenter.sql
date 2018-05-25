/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : pcenter

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-05-25 18:32:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `gid` int(22) NOT NULL AUTO_INCREMENT,
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `menu_name` varchar(32) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(64) DEFAULT NULL COMMENT '请求路径',
  `parent_code` int(2) DEFAULT NULL COMMENT '父类编码',
  `code` int(2) DEFAULT NULL COMMENT '本身编码',
  `belong` int(2) DEFAULT NULL COMMENT '所属项目',
  `version` bigint(20) DEFAULT NULL COMMENT '版本',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(2) DEFAULT NULL COMMENT '0.启用 1.禁用',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', 'fa-tachometer', '总控制台', 'index.html', '0', '1', '1', '1', '2018-05-25 14:32:03', '2018-05-25 14:32:06', '0');
INSERT INTO `menu` VALUES ('2', 'fa-tachometer', '邮件管理', 'email.html', '0', '2', '2', '1', '2018-05-25 15:05:30', '2018-05-25 15:05:33', '0');
INSERT INTO `menu` VALUES ('3', 'fa-tachometer', '商品管理', 'goods.html', '0', '3', '3', '1', '2018-05-25 15:12:46', '2018-05-25 15:12:49', '0');
INSERT INTO `menu` VALUES ('4', 'fa-tachometer', '历史管理', 'history.html', '0', '4', '1', '1', '2018-05-25 15:14:47', '2018-05-25 15:14:31', '0');
INSERT INTO `menu` VALUES ('5', 'fa-tachometer', '工资管理', 'salary.html', '0', '5', '4', '1', '2018-05-25 15:14:44', '2018-05-25 15:14:35', '0');
INSERT INTO `menu` VALUES ('6', 'fa-tachometer', '系统设置', 'setting.html', '0', '6', '1', '1', '2018-05-25 15:14:42', '2018-05-25 15:14:40', '0');
INSERT INTO `menu` VALUES ('7', 'fa-tachometer', '邮件模板', 'setting.html', '2', '7', '2', '1', '2018-05-25 15:14:42', '2018-05-25 15:14:40', '0');
INSERT INTO `menu` VALUES ('8', 'fa-tachometer', '邮件列表', 'setting.html', '2', '8', '2', '1', '2018-05-25 14:32:03', '2018-05-25 14:32:06', '0');
INSERT INTO `menu` VALUES ('9', 'fa-tachometer', '商品列表', 'setting.html', '3', '9', '3', '1', '2018-05-25 15:05:30', '2018-05-25 15:05:33', '0');
INSERT INTO `menu` VALUES ('10', 'fa-tachometer', '历史列表', 'setting.html', '4', '10', '1', '1', '2018-05-25 15:12:46', '2018-05-25 15:12:49', '0');
INSERT INTO `menu` VALUES ('11', 'fa-tachometer', '工资列表', 'setting.html', '5', '11', '4', '1', '2018-05-25 15:14:47', '2018-05-25 15:14:31', '0');
INSERT INTO `menu` VALUES ('12', 'fa-tachometer', '项目配置', 'setting.html', '6', '12', '1', '1', '2018-05-25 15:14:44', '2018-05-25 15:14:35', '0');
INSERT INTO `menu` VALUES ('13', 'fa-tachometer', '用户配置', 'setting.html', '6', '13', '1', '1', '2018-05-25 15:14:42', '2018-05-25 15:14:40', '0');
INSERT INTO `menu` VALUES ('14', 'fa-tachometer', '角色配置', 'setting.html', '6', '14', '1', '1', '2018-05-25 15:14:42', '2018-05-25 15:14:40', '0');
INSERT INTO `menu` VALUES ('15', 'fa-tachometer', '工资配置', 'setting.html', '6', '15', '1', '1', '2018-05-25 15:14:42', '2018-05-25 15:14:40', '0');
INSERT INTO `menu` VALUES ('16', 'fa-tachometer', '日志记录', 'setting.html', '6', '16', '1', '1', '2018-05-25 15:14:42', '2018-05-25 15:14:40', '0');

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role` (
  `gid` bigint(22) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(22) DEFAULT NULL,
  `menu_id` bigint(22) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL COMMENT '版本',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(2) DEFAULT NULL COMMENT '0.启用 1.禁用',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES ('1', '1', '1', '1', '2018-05-25 15:26:38', '2018-05-25 15:26:40', '0');
INSERT INTO `menu_role` VALUES ('2', '1', '2', '1', '2018-05-25 15:26:38', '2018-05-25 15:26:40', '0');
INSERT INTO `menu_role` VALUES ('3', '1', '3', '1', '2018-05-25 15:26:38', '2018-05-25 15:26:40', '0');
INSERT INTO `menu_role` VALUES ('4', '1', '4', '1', '2018-05-25 15:26:38', '2018-05-25 15:26:40', '0');
INSERT INTO `menu_role` VALUES ('5', '1', '5', '1', '2018-05-25 15:26:38', '2018-05-25 15:26:40', '0');
INSERT INTO `menu_role` VALUES ('6', '1', '6', '1', '2018-05-25 15:26:38', '2018-05-25 15:26:40', '0');
INSERT INTO `menu_role` VALUES ('7', '1', '7', '1', '2018-05-25 15:26:38', '2018-05-25 15:26:40', '0');
INSERT INTO `menu_role` VALUES ('8', '1', '8', '1', '2018-05-25 15:26:38', '2018-05-25 15:26:40', '0');
INSERT INTO `menu_role` VALUES ('9', '1', '9', '1', '2018-05-25 15:26:38', '2018-05-25 15:26:40', '0');
INSERT INTO `menu_role` VALUES ('10', '1', '10', '1', '2018-05-25 15:26:38', '2018-05-25 15:26:40', '0');
INSERT INTO `menu_role` VALUES ('11', '1', '11', '1', '2018-05-25 15:26:38', '2018-05-25 15:26:40', '0');
INSERT INTO `menu_role` VALUES ('12', '1', '12', '1', '2018-05-25 15:26:38', '2018-05-25 15:26:40', '0');
INSERT INTO `menu_role` VALUES ('13', '1', '13', '1', '2018-05-25 15:26:38', '2018-05-25 15:26:40', '0');
INSERT INTO `menu_role` VALUES ('14', '1', '14', '1', '2018-05-25 15:26:38', '2018-05-25 15:26:40', '0');
INSERT INTO `menu_role` VALUES ('15', '1', '15', '1', '2018-05-25 15:26:38', '2018-05-25 15:26:40', '0');
INSERT INTO `menu_role` VALUES ('16', '1', '16', '1', '2018-05-25 15:26:38', '2018-05-25 15:26:40', '0');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `gid` bigint(22) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(32) DEFAULT NULL COMMENT '项目名称',
  `name_en` varchar(32) DEFAULT NULL COMMENT '英文名称',
  `version` bigint(20) DEFAULT NULL COMMENT '版本',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(2) DEFAULT NULL COMMENT '0.启用 1.禁用',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '个人管理中心系统', 'person_center', '1', '2018-05-25 14:22:38', '2018-05-25 14:22:41', '0');
INSERT INTO `project` VALUES ('2', '邮件管理系统', 'email', '1', '2018-05-25 14:23:01', '2018-05-25 14:23:04', '0');
INSERT INTO `project` VALUES ('3', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `gid` bigint(22) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) DEFAULT NULL COMMENT '角色名称(中文)',
  `role_name_en` varchar(32) DEFAULT NULL COMMENT '角色名称(英文)',
  `version` bigint(20) DEFAULT NULL COMMENT '版本',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(2) DEFAULT NULL COMMENT '0.启用 1.禁用',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', 'admin', '1', '2018-05-25 14:19:27', '2018-05-25 14:19:30', '0');
INSERT INTO `role` VALUES ('9', '游客', 'visitor', '1', '2018-05-25 14:20:16', '2018-05-25 14:20:19', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `gid` bigint(22) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `role_id` bigint(22) DEFAULT NULL COMMENT '所属角色',
  `role_name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '0.启用 1.禁用',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '98F6FAD709E28617CF0421CC885C484F', '1193418905@qq.com', '1', '超级管理员', '2018-05-24 17:49:26', '2018-05-24 17:49:30', '2018-05-25 18:31:45', '0');
