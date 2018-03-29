/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : wages

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-03-29 18:02:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('15');

-- ----------------------------
-- Table structure for salary_details
-- ----------------------------
DROP TABLE IF EXISTS `salary_details`;
CREATE TABLE `salary_details` (
  `gid` int(22) NOT NULL AUTO_INCREMENT COMMENT '全局GID',
  `salary_gid` int(22) NOT NULL COMMENT '工资表GID',
  `salary_type_gid` int(22) NOT NULL COMMENT '工资类型表GID',
  `salary_type_name` varchar(128) NOT NULL COMMENT '工资类型名称',
  `salary_type_mark` int(2) NOT NULL COMMENT '类型标志 0扣钱,1加钱',
  `money` decimal(10,2) NOT NULL COMMENT '金额',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工资详情表';

-- ----------------------------
-- Records of salary_details
-- ----------------------------

-- ----------------------------
-- Table structure for salary_info
-- ----------------------------
DROP TABLE IF EXISTS `salary_info`;
CREATE TABLE `salary_info` (
  `gid` int(22) NOT NULL AUTO_INCREMENT COMMENT '全局GID',
  `staff_gid` int(22) NOT NULL COMMENT '员工GID',
  `should_money` decimal(10,2) NOT NULL COMMENT '应发工资金额',
  `actual_money` decimal(10,2) NOT NULL COMMENT '实发工资金额',
  `status` int(2) NOT NULL COMMENT '发放状态 0未发.1已发',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工资信息表';

-- ----------------------------
-- Records of salary_info
-- ----------------------------

-- ----------------------------
-- Table structure for salary_type
-- ----------------------------
DROP TABLE IF EXISTS `salary_type`;
CREATE TABLE `salary_type` (
  `gid` int(22) NOT NULL AUTO_INCREMENT COMMENT '全局GID',
  `type_id` int(2) NOT NULL COMMENT '类型标识',
  `type_name` varchar(128) NOT NULL COMMENT '类型名称',
  `type_mark` int(2) NOT NULL COMMENT '类型标志 0扣钱,1加钱',
  `type_status` int(2) NOT NULL COMMENT '启用状态 1启用 0禁用',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='工资类型表';

-- ----------------------------
-- Records of salary_type
-- ----------------------------
INSERT INTO `salary_type` VALUES ('1', '1', '医疗保险', '0', '1', '2018-03-24 17:46:06', '2018-03-24 17:47:18');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `gid` int(22) NOT NULL AUTO_INCREMENT COMMENT '全局GID',
  `user_name` varchar(128) NOT NULL COMMENT '员工姓名',
  `user_sex` int(1) DEFAULT NULL COMMENT '员工性别 0女,1男',
  `user_tel` varchar(11) DEFAULT NULL COMMENT '员工电话',
  `bank_card` varchar(128) DEFAULT NULL COMMENT '银行卡号',
  `emergency_name` varchar(128) DEFAULT NULL,
  `emergency_tel` varchar(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='员工信息表';

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('14', '刘英杰', '1', '15215215962', '6228480470961795312', '刘老大', '1888888888', '2018-03-24 16:09:24', '2018-03-24 16:31:40');
