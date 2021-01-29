/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : random

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2021-01-29 16:27:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dict`;
CREATE TABLE `t_sys_dict` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `dict_label` varchar(100) DEFAULT NULL COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT NULL COMMENT '字典键值',
  `dict_type_code` varchar(100) DEFAULT NULL COMMENT '字典类型编码',
  `sort` int(4) DEFAULT NULL COMMENT '字典排序',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` varchar(1) DEFAULT '0' COMMENT '启用状态',
  `is_deleted` varchar(1) DEFAULT '0' COMMENT '删除状态',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典数据';

-- ----------------------------
-- Records of t_sys_dict
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dict_type`;
CREATE TABLE `t_sys_dict_type` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `dict_type_name` varchar(100) DEFAULT NULL COMMENT '字典类型名称',
  `dict_type_code` varchar(100) DEFAULT NULL COMMENT '字典类型编码',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` varchar(1) DEFAULT '0' COMMENT '启用状态',
  `is_deleted` varchar(1) DEFAULT '0' COMMENT '删除状态',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典类型';

-- ----------------------------
-- Records of t_sys_dict_type
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu`;
CREATE TABLE `t_sys_menu` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父菜单ID',
  `menu_name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(255) DEFAULT NULL COMMENT '菜单url',
  `menu_auth` varchar(50) DEFAULT NULL COMMENT '权限控制',
  `menu_target` varchar(50) DEFAULT '_self' COMMENT '链接打开方式',
  `menu_icon` varchar(50) DEFAULT '' COMMENT '菜单图标',
  `menu_type` varchar(2) DEFAULT '0' COMMENT '菜单类型',
  `sort` int(4) DEFAULT NULL COMMENT '菜单排序',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` varchar(1) DEFAULT '0' COMMENT '启用状态',
  `is_deleted` varchar(1) DEFAULT '0' COMMENT '删除状态',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Records of t_sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(100) DEFAULT NULL COMMENT '角色代码',
  `priority` int(11) DEFAULT NULL COMMENT '优先级',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` varchar(1) DEFAULT '0' COMMENT '启用状态',
  `is_deleted` varchar(1) DEFAULT '0' COMMENT '删除状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', 'admin', 'super_admin', '1', null, '2019-06-05 20:32:55', '0', '0', '超级管理员');
INSERT INTO `t_sys_role` VALUES ('1355019482119143425', 'aaa', 'aaa', '2', null, '2021-01-29 13:16:27', '0', '0', 'aaa');
INSERT INTO `t_sys_role` VALUES ('4be20af409d741bfb9a855e0ed88234a', '项目组长', 'corp_group_leader', '9', null, null, '0', '0', '');
INSERT INTO `t_sys_role` VALUES ('848f167a379a4185908416627f5ac710', '读者', 'user_reader', '10', null, '2019-03-12 10:02:06', '0', '0', null);
INSERT INTO `t_sys_role` VALUES ('95942830b50346ecadb339cd915750e1', '部门经理', 'corp_manager', '7', null, null, '0', '0', '');
INSERT INTO `t_sys_role` VALUES ('a6068ae9cd97464fb5ff1a7bd4f7394d', '普通员工', 'corp_user', '10', null, null, '0', '0', '');
INSERT INTO `t_sys_role` VALUES ('ae8b1c470c124de39ef67d3d742c820b', '部门副经理', 'corp_assistant_manager', '8', null, '2019-03-12 10:28:09', '0', '0', '');
INSERT INTO `t_sys_role` VALUES ('b497f2d107bf44d09a64631de2ebe84f', '文字编辑', 'text_editor', '9', null, '2019-03-12 10:21:56', '0', '0', '文字编辑');
INSERT INTO `t_sys_role` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '普通管理员', 'admin', '2', null, null, '0', '0', '');
INSERT INTO `t_sys_role` VALUES ('baab4bebfe50403e90f8cb23733686e7', '作家', 'user_writer', '10', null, null, '0', '0', null);
INSERT INTO `t_sys_role` VALUES ('bf657974c55c43a791f429b88da93a3e', '文字审核', 'text_auditor', '8', null, '2019-03-12 10:23:04', '0', '0', '审核作品');

-- ----------------------------
-- Table structure for t_sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_menu`;
CREATE TABLE `t_sys_role_menu` (
  `role_id` varchar(32) NOT NULL COMMENT '角色主键',
  `menu_id` varchar(32) NOT NULL COMMENT '菜单主键',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单';

-- ----------------------------
-- Records of t_sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `gender` varchar(1) DEFAULT '0' COMMENT '性别',
  `realname` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `id_number` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `head_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `login_number` bigint(11) DEFAULT NULL COMMENT '登录次数',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `mobile_verification_code` varchar(10) DEFAULT NULL COMMENT '手机验证码',
  `email_verification_code` varchar(10) DEFAULT NULL COMMENT '邮箱验证码',
  `gmt_create` datetime DEFAULT NULL COMMENT '注册时间',
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` varchar(1) DEFAULT '0' COMMENT '启用状态',
  `is_deleted` varchar(1) DEFAULT '0' COMMENT '删除状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('00', 'admin', 'efd9d1b8bfb00e8e3647990f7d74d1d8', '123456****', 'ipcd_hz@cashq.ac.cn', 'nickname9', '1', '超级管理员', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-10-03 19:27:53', '0', '0');
INSERT INTO `t_sys_user` VALUES ('033a991e444040c98eaec85b7cf88e36', '杨盟', '123456', '15968101581', 'yangmeng@mail.ipc.ac.cn', 'nickname10', '2', '杨盟', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1095', '柏秀琴', '654321', null, null, 'nickname30', '2', '柏秀琴', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2020-12-23 22:28:35', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1098', '卞天兴', '123456', null, null, 'nickname32', '1', '卞天兴', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1099', '蔡金芝', '123456', null, null, 'nickname35', '2', '蔡金芝', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1100', '蔡宜权', '123456', null, null, 'nickname39', '1', '蔡宜权', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1101', '曹杏芝', '123456', null, null, 'nickname45', '2', '曹杏芝', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1102', '陈翠芝', '123456', null, null, 'nickname51', '2', '陈翠芝', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1104', '陈丽德', '123456', null, null, 'nickname94', '2', '陈丽德', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1106', '程宏钦', '123456', null, null, 'nickname56', '1', '程宏钦', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1107', '褚冬梅', '123456', null, null, 'nickname68', '2', '褚冬梅', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1108', '戴崎琛', '123456', null, null, 'nickname71', '2', '戴崎琛', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1109', '邓海凡', '123456', null, null, 'nickname78', '1', '邓海凡', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1113', '董仁英', '123456', null, null, 'nickname86', '2', '董仁英', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1179', '张剑平', '123456', null, null, 'nickname97', '1', '张剑平', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1193', '段冬云', '123456', null, null, 'nickname89', '1', '段冬云', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1203', '邓菲', '123456', '13871506234', 'df@wh.iov.cn', 'nickname77', '2', '邓菲', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1209', '崔宗强', '123456', '13006350695', 'czq@wh.iov.cn', 'nickname69', '1', '崔宗强', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1225', '纪昌艳', '123456', null, null, 'nickname88', '1', '纪昌艳', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1228', '蔡全信', '123456', '13971507496', 'qxcai@wh.iov.cn', 'nickname38', '1', '蔡全信', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1230', '代顺英', '123456', null, null, 'nickname73', '2', '代顺英', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1239', '赵淑玲', '123456', null, null, 'nickname98', '2', '赵淑玲', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1248', '邓教宇', '123456', '15327269382', 'dengjy@wh.iov.cn', 'nickname80', '1', '邓教宇', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1249', '杜涛', '123456', null, null, 'nickname93', '1', '杜涛', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1253', '黄江虹', '123456', null, null, 'nickname70', '1', '黄江虹', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1255', '刘虹', '123456', null, 'liuhong@wh.iov.cn', 'nickname95', '2', '刘虹', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1264', '陈宗胜', '123456', '13871394385', 'zschen@wh.iov.cn', 'nickname67', '1', '陈宗胜', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1306', '邓红', '123456', '13026111567', null, 'nickname79', '1', '邓红', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1309', '丁清泉', '123456', '13971433066', 'qding@wh.iov.cn', 'nickname85', '1', '丁清泉', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2079', '杜安娜', '123456', '13296589350', 'duanna@wh.iov.cn', 'nickname90', '2', '杜安娜', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2116', '陈继征', '123456', null, null, 'nickname63', '1', '陈继征', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2124', '陈超', '123456', null, null, 'nickname49', '2', '陈超', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2125', '陈红贺', '123456', null, null, 'nickname60', '2', '陈红贺', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2219', '曹亮', '123456', null, null, 'nickname41', '1', '曹亮', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2254', '杜瑞坤', '123456', null, null, 'nickname92', '1', '杜瑞坤', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2396', '曹婷婷', '123456', '13554497206', 'caott@wh.iov.cn', 'nickname44', '2', '曹婷婷', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2429', '操媛', '123456', null, null, 'nickname46', '2', '操媛', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2430', '曹璜', '123456', null, null, 'nickname40', '1', '曹璜', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2431', '柴凡', '123456', null, null, 'nickname34', '1', '柴凡', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2432', '晁红军', '123456', null, null, 'nickname48', '1', '晁红军', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2437', '邓柳', '123456', null, null, 'nickname81', '2', '邓柳', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2465', '蔡林', '123456', '65012140', 'cl811022@hotmail.com', 'nickname37', '1', '蔡林', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2500', '邓雅丽', '123456', null, null, 'nickname84', '2', '邓雅丽', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2501', '邓成林', '123456', null, null, 'nickname76', '2', '邓成林', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2547', '成传刚', '123456', null, null, 'nickname54', '1', '成传刚', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2549', '邓阿妹', '123456', null, null, 'nickname75', '2', '邓阿妹', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2565', '陈军刚', '123456', '13647203546', null, 'nickname64', '1', '陈军刚', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2669', '程丹凝', '123456', null, null, 'nickname55', '2', '程丹凝', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2682', '陈振康', '123456', null, null, 'nickname65', '1', '陈振康', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2708', '程智逵', '123456', null, null, 'nickname59', '1', '程智逵', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2898', '陈卓', '123456', null, null, 'nickname66', '1', '陈卓', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2955', '毕鹏', '123456', null, null, 'nickname33', '1', '毕鹏', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3117', '邓思思', '123456', null, null, 'nickname82', '2', '邓思思', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3129', '邓旭', '123456', null, null, 'nickname83', '1', '邓旭', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3150', '鲍凯歌', '123456', null, null, 'nickname31', '1', '鲍凯歌', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3280', '陈逗逗', '123456', null, null, 'nickname53', '2', '陈逗逗', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3281', '程爽', '123456', null, null, 'nickname58', '2', '程爽', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3300', '戴诗雨', '123456', null, null, 'nickname72', '2', '戴诗雨', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3317', '陈冬冬', '123456', null, null, 'nickname52', '1', '陈冬冬', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3318', '陈静', '123456', null, null, 'nickname62', '2', '陈静', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3386', '曹晟', '123456', null, 'caosheng@wh.iov.cn', 'nickname43', '1', '曹晟', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3407', '蔡丽丽', '123456', null, null, 'nickname36', '2', '蔡丽丽', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3448', '陈洁', '123456', '18827398658', '410391828@qq.com', 'nickname61', '2', '陈洁', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3590', '陈晨', '123456', null, null, 'nickname50', '1', '陈晨', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3598', '常猛', '123456', null, null, 'nickname47', '1', '常猛', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3614', '曹姗姗', '123456', null, null, 'nickname42', '2', '曹姗姗', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3634', '程蛟', '123456', null, null, 'nickname57', '2', '程蛟', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3685', '董晓', '123456', '13297055452', null, 'nickname87', '2', '董晓', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-856', '闫达中', '123456', null, null, 'nickname96', '1', '闫达中', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-859', '镇达', '123456', null, null, 'nickname99', '1', '镇达', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-886', '王慧媛', '123456', null, null, 'nickname91', '2', '王慧媛', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-996', '梁树才', '123456', null, null, 'nickname74', '1', '梁树才', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('2339092b0e834a1a927f0083e18ffe33', '路浩军', '123456', '11100000000', 'luhaojun@mail.ipc.ac.cn', 'nickname5', '1', '路浩军', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('257cbbe44e8543df946a0f491dc39e35', '王谦', '123456', '11000000000', 'wangqian@mail.ipc.ac.cn', 'nickname4', '0', '王谦', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('2e2aa945763a4d1ebe9a51ce5c2672e9', '江丽雅', '123456', '18857868467', 'jiangliya@mail.ipc.ac.cn', 'nickname15', '2', '江丽雅', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('3c2e75d3bdaf49d1a3cbe1a47f8425fa', '刘卫卫', '123456', '18801012548', 'liuweiwei@mail.ipc.ac.cn', 'nickname0', '1', '刘卫卫', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('4c73183147994074a8e53e4185dee08d', '黄勇', '123456', '10000000002', 'huangyong@mail.ipc.ac.cn', 'nickname17', '0', '黄勇', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('4dc4a277d2f843e9b7b39114e98dfcbb', '宓群渊', '123456', '10000000001', 'miqunyuan@mail.ipc.ac.cn', 'nickname12', '1', '宓群渊', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('65d9a258285949bbbc5903baad38863d', '0411', '123456', '18911897013', 'wkm@cnic.cn', 'nickname24', '1', '0411', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('6a1509958bf84ba1896964a14e826d6c', '许慧', '123456', '15990019921', 'xuhui@mail.ipc.ac.cn', 'nickname14', '2', '许慧', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('6afb26b07aa44b3fa04aa5d47aacadb2', '沈崇正', '123456', '17098072638', 'shenchongzheng@mail.ipc.ac.cn', 'nickname7', '1', '沈崇正', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('7ea586b860d34a57b034cd0ee98107bd', '倪正', '123456', '10000000033', 'nizheng@mail.ipc.ac.cn', 'nickname2', '1', '倪正', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('8022ecf2a4ba4fe2b9d6fe875eadb966', '郜宇飞', '123456', '18630169964', 'yfgao@cashq.ac.cn', 'nickname20', '1', '郜宇飞', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('991608462f634e3aac6a76aa98a71a86', '李军民', '123456', '10000000005', 'lijunmin@mail.ipc.ac.cn', 'nickname19', '0', '李军民', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('a47532f3c87043748c57f5208e9045af', '热污染', '123456', '13488724223', 'wkm@cnisc.cn', 'nickname25', '1', '热污染', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('b316daf64443441f947fcfa8a54832fb', '吴江', '123456', '13651072453', 'jwu@mail.ipc.ac.cn', 'nickname16', '1', '吴江', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('b595526ddac74189b0b72f57fce86d2c', '杨柳', '123456', '10000000034', 'liuyang726@mail.ipc.ac.cn', 'nickname3', '2', '杨柳', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('bef239e75cec41df9a1109a2353aa11f', '郑峰', '123456', '10000000009', 'gavinzheng@mail.ipc.ac.cn', 'nickname22', '1', '郑峰', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('cc25966f9efa409e9efd5b746362f070', '陈文浩', '123456', '11111111111', 'chenwenhao@mail.ipc.ac.cn', 'nickname6', '0', '陈文浩', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('d5d6094e6cd846178f94c0ac96b8b5cd', '李浩榕', '123456', '10000000008', 'lihaorong@mail.ipc.ac.cn', 'nickname21', '0', '李浩榕', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('e8637e585cc04323ab23eba556c0aa43', '卢伟鹏', '123456', '10000000032', 'luweipeng@mail.ipc.ac.cn', 'nickname1', '1', '卢伟鹏', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('f026962c7a984e6bad6b684a65875b8d', '王磊', '123456', '10000000006', 'wanglei@mail.ipc.ac.cn', 'nickname23', '0', '王磊', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('f14b301c4b7b44d99d1ad467990ba913', '张晓丹', '123456', '15958165684', 'zhangxd@mail.ipc.ac.cn', 'nickname11', '2', '张晓丹', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('f74e9c3a789542a5ac01717cb73346ac', '李文', '123456', '13811036574', '13811036574@qq.com', 'nickname8', '2', '李文', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('fbabfc5102bb4c5e89fdfaca56737838', '张绍连', '123456', '15906693484', 'zhangshaolian@mail.ipc.ac.cn', 'nickname13', '2', '张绍连', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('ff081bfefa674531aef73f47860430f8', 'lipian', '5d74d75456c3d3e6d8b58ffc5064711b', null, 'lipian1004@163.com', null, '0', null, null, null, null, null, null, null, null, null, '0', '0');

-- ----------------------------
-- Table structure for t_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role` (
  `user_id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Records of t_sys_user_role
-- ----------------------------
