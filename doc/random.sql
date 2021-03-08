/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : random

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2021-02-25 13:24:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dept`;
CREATE TABLE `t_sys_dept` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `parent_id` varchar(32) DEFAULT '0' COMMENT '父部门ID',
  `ancestors` varchar(255) DEFAULT NULL COMMENT '祖级列表',
  `dept_name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `sort` int(4) DEFAULT NULL COMMENT '排序',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` varchar(1) DEFAULT '0' COMMENT '启用状态',
  `is_deleted` varchar(1) DEFAULT '0' COMMENT '删除状态',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门';

-- ----------------------------
-- Records of t_sys_dept
-- ----------------------------

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
INSERT INTO `t_sys_dict` VALUES ('1364776452757827585', '启用', '0', 'STATUS', '1', '2021-02-25 11:17:17', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1364776505174044674', '冻结', '1', 'STATUS', '2', '2021-02-25 11:17:30', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1364776866756603905', '正常', '0', 'IS_DELETED', '1', '2021-02-25 11:18:56', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1364776918283628545', '删除', '1', 'IS_DELETED', '2', '2021-02-25 11:19:08', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1364777612055064577', '页签', '_self', 'MENU_TARGET', '1', '2021-02-25 11:21:54', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1364777672021028866', '新窗口', '_blank', 'MENU_TARGET', '2', '2021-02-25 11:22:08', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1364778169461288962', '男', 'M', 'GENDER', '1', '2021-02-25 11:24:07', '2021-02-25 11:32:30', '0', '0', '用户性别-男');
INSERT INTO `t_sys_dict` VALUES ('1364778225815957506', '女', 'F', 'GENDER', '2', '2021-02-25 11:24:20', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('3d6f426b675b11eb9b7274e6e24360ef', '按钮', '1', 'MENU_TYPE', '2', '2021-02-05 10:39:08', '2021-02-05 10:39:48', '0', '0', '菜单类型-按钮');
INSERT INTO `t_sys_dict` VALUES ('988f5005675a11eb9b7274e6e24360ef', '菜单', '0', 'MENU_TYPE', '1', '2021-02-05 10:38:33', '2021-02-05 10:39:55', '0', '0', '菜单类型-菜单');

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
INSERT INTO `t_sys_dict_type` VALUES ('1364774509180350465', '启用状态', 'STATUS', '2021-02-25 11:09:34', null, '0', '0', '');
INSERT INTO `t_sys_dict_type` VALUES ('1364776703145193474', '删除状态', 'IS_DELETED', '2021-02-25 11:18:17', null, '0', '0', '');
INSERT INTO `t_sys_dict_type` VALUES ('1364777540542181377', '菜单打开方式', 'MENU_TARGET', '2021-02-25 11:21:37', null, '0', '0', '');
INSERT INTO `t_sys_dict_type` VALUES ('1364778104139198465', '用户性别', 'GENDER', '2021-02-25 11:23:51', '2021-02-25 11:30:00', '0', '0', '用户性别');
INSERT INTO `t_sys_dict_type` VALUES ('66f8a864675a11eb9b7274e6e24360ef', '菜单类型', 'MENU_TYPE', '2021-02-05 10:33:56', '2021-02-05 10:33:56', '0', '0', null);

-- ----------------------------
-- Table structure for t_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu`;
CREATE TABLE `t_sys_menu` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `code` varchar(50) DEFAULT NULL COMMENT '菜单编码',
  `parent_code` varchar(255) DEFAULT NULL COMMENT '父菜单编码',
  `menu_name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(255) DEFAULT NULL COMMENT '菜单url',
  `menu_auth` varchar(50) DEFAULT NULL COMMENT '权限控制',
  `menu_target` varchar(50) DEFAULT '_self' COMMENT '链接打开方式',
  `menu_icon` varchar(50) DEFAULT '' COMMENT '菜单图标',
  `menu_type` varchar(2) DEFAULT '0' COMMENT '菜单类型',
  `ancestors` varchar(255) DEFAULT NULL COMMENT '祖级列表',
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
INSERT INTO `t_sys_menu` VALUES ('111812b068ed11ebbe2c74e6e24360ef', 'user-add', 'user', '用户新增', 'sysUser/add', null, '_self', 'layui-icon-add-1', '1', '[0],[system],[user],', '1', '2021-01-30 23:49:19', '2021-02-08 16:59:25', '0', '0', null);
INSERT INTO `t_sys_menu` VALUES ('1358324972823744514', 'user-edit', 'user', '用户编辑', 'sysUser/edit', '', '_self', 'layui-icon-edit', '1', '[0],[system],[user],', '2', '2021-02-07 16:01:25', '2021-02-08 16:59:34', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1358325509623353346', 'user-delete', 'user', '用户删除', 'sysUser/delete', '', '_self', 'layui-icon-delete', '1', '[0],[system],[user],', '3', '2021-02-07 16:03:33', '2021-02-08 16:59:35', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364787207246876673', 'position', 'system', '岗位管理', 'sysPosition/list', '', '_self', 'layui-icon-star-fill', '0', '[0],[system],', '5', '2021-02-25 12:00:01', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364787777584140289', 'dict', 'system', '字典管理', 'sysDictType/list', '', '_self', 'layui-icon-star-fill', '0', '[0],[system],', '6', '2021-02-25 12:02:17', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364788142161432577', 'common', '0', '常规管理', '#', '', '_self', 'layui-icon-star-fill', '0', '[0],', '2', '2021-02-25 12:03:44', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364805178648297474', 'zymb', 'common', '主页模板', '#', '', '_self', 'fa-home', '0', '[0],[common],', '1', '2021-02-25 13:11:26', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364805353974398978', 'zy1', 'zymb', '主页一', 'page/welcome-1.html', '', '_self', 'fa-tachometer', '0', '[0],[common],[zymb],', '1', '2021-02-25 13:12:08', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364805482160717825', 'zy2', 'zymb', '主页二', 'page/welcome-2.html', '', '_self', 'fa fa-star', '0', '[0],[common],[zymb],', '2', '2021-02-25 13:12:38', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364805605003493378', 'zy3', 'zymb', '主页三', 'page/welcome-3.html', '', '_self', 'fa fa-star', '0', '[0],[common],[zymb],', '3', '2021-02-25 13:13:08', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364806014795382785', 'setting', 'system', '系统设置', 'page/setting.html', '', '_self', 'fa-gears', '0', '[0],[system],', '7', '2021-02-25 13:14:45', '2021-02-25 13:14:56', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364806273512636417', 'fbbd', 'common', '分步表单', 'page/form-step.html', '', '_self', 'fa fa-star', '0', '[0],[common],', '2', '2021-02-25 13:15:47', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364806385026596865', 'dlmb', 'common', '登录模板', '#', '', '_self', 'fa fa-star', '0', '[0],[common],', '3', '2021-02-25 13:16:14', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364806502798458881', 'dl1', 'dlmb', '登录-1', 'page/login-1.html', '', '_self', 'fa fa-star', '0', '[0],[common],[dlmb],', '1', '2021-02-25 13:16:42', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364806604938149890', 'dl2', 'dlmb', '登录-2', 'page/login-2.html', '', '_self', 'fa fa-star', '0', '[0],[common],[dlmb],', '2', '2021-02-25 13:17:06', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364806722034728961', 'dl3', 'dlmb', '登录-3', 'page/login-3.html', '', '_self', 'fa fa-star', '0', '[0],[common],[dlmb],', '3', '2021-02-25 13:17:34', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364806859532402690', '404ym', 'common', '404页面', 'page/404.html', '', '_self', 'fa fa-star', '0', '[0],[common],', '4', '2021-02-25 13:18:07', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364807152957521921', 'button', 'common', '按钮示例', 'page/button.html', '', '_self', 'fa fa-star', '0', '[0],[common],', '5', '2021-02-25 13:19:17', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364807262709874690', 'tcc', 'common', '弹出层', 'page/layer.html', '', '_self', 'fa fa-star', '0', '[0],[common],', '6', '2021-02-25 13:19:43', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364807448521736194', 'assembly', '0', '组件管理', '#', '', '_self', 'fa fa-star', '0', '[0],', '4', '2021-02-25 13:20:27', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364807590075301890', 'tblb', 'assembly', '图标列表', 'page/icon.html', '', '_self', 'fa fa-star', '0', '[0],[assembly],', '1', '2021-02-25 13:21:01', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364807696040198145', 'tbxz', 'assembly', '图标选择', 'page/icon-picker.html', '', '_self', 'fa fa-star', '0', '[0],[assembly],', '2', '2021-02-25 13:21:26', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364807825627414530', 'ysxz', 'assembly', '颜色选择', 'page/color-select.html', '', '_self', 'fa fa-star', '0', '[0],[assembly],', '3', '2021-02-25 13:21:57', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364807952450584577', 'xlxz', 'assembly', '下拉选择', 'page/table-select.html', '', '_self', 'fa fa-star', '0', '[0],[assembly],', '4', '2021-02-25 13:22:27', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364808074987175938', 'wjsc', 'assembly', '文件上传', 'page/upload.html', '', '_self', 'fa fa-star', '0', '[0],[assembly],', '5', '2021-02-25 13:22:57', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364808191555272705', 'fwb', 'assembly', '富文本编辑器', 'page/editor.html', '', '_self', 'fa fa-star', '0', '[0],[assembly],', '6', '2021-02-25 13:23:24', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364808343556849665', 'ssx', 'assembly', '省市县区选择器', 'page/area.html', '', '_self', 'fa fa-star', '0', '[0],[assembly],', '7', '2021-02-25 13:24:01', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('2b689fa768eb11ebbe2c74e6e24360ef', 'role', 'system', '角色管理', 'sysRole/list', null, '_self', '', '0', '[0],[system],', '2', '2021-01-30 23:49:19', '2021-02-25 11:56:39', '0', '0', null);
INSERT INTO `t_sys_menu` VALUES ('48b617c368eb11ebbe2c74e6e24360ef', 'menu', 'system', '菜单管理', 'sysMenu/list', null, '_self', '', '0', '[0],[system],', '3', '2021-01-30 23:49:19', '2021-02-25 11:56:41', '0', '0', null);
INSERT INTO `t_sys_menu` VALUES ('5859134468eb11ebbe2c74e6e24360ef', 'dept', 'system', '部门管理', 'sysDept/list', null, '_self', '', '0', '[0],[system],', '4', '2021-01-30 23:49:19', '2021-02-25 11:56:43', '0', '0', null);
INSERT INTO `t_sys_menu` VALUES ('739151e368ec11ebbe2c74e6e24360ef', 'dashboard', '0', '系统监控', '#', '', '_self', 'layui-icon-rate-solid', '0', '[0],', '3', '2021-01-30 23:38:00', '2021-02-25 12:13:25', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('94f51875631211ebb3b600ff633443b0', 'user', 'system', '用户管理', 'sysUser/list', '', '_self', 'fa-user-o', '0', '[0],[system],', '1', '2021-01-30 23:49:19', '2021-02-25 12:51:34', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('b7bf613a631011ebb3b600ff633443b0', 'system', '0', '系统管理', '#', null, '_self', 'fa fa-address-book', '0', '[0],', '1', '2021-01-30 23:38:00', '2021-02-08 16:13:18', '0', '0', null);

-- ----------------------------
-- Table structure for t_sys_position
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_position`;
CREATE TABLE `t_sys_position` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `position_name` varchar(50) DEFAULT NULL COMMENT '职位名称',
  `position_code` varchar(50) DEFAULT NULL COMMENT '职位编码',
  `sort` int(4) DEFAULT NULL COMMENT '排序',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` varchar(1) DEFAULT '0' COMMENT '启用状态',
  `is_deleted` varchar(1) DEFAULT '0' COMMENT '删除状态',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职位';

-- ----------------------------
-- Records of t_sys_position
-- ----------------------------
INSERT INTO `t_sys_position` VALUES ('1356149090910617601', '董事长', 'chairman', '1', '2021-02-01 15:06:01', '2021-02-02 09:02:30', '0', '0', '');
INSERT INTO `t_sys_position` VALUES ('1356405221725736961', 'CTO', 'cto', '2', '2021-02-02 08:53:00', '2021-02-02 08:54:23', '0', '0', '');
INSERT INTO `t_sys_position` VALUES ('1356405705857470465', '项目经理', 'pm', '3', '2021-02-02 08:54:56', '2021-02-02 09:02:30', '0', '0', '');
INSERT INTO `t_sys_position` VALUES ('1356407538382442498', '码农', 'programmer', '4', '2021-02-02 09:02:13', '2021-02-02 09:02:37', '0', '0', '');

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(100) DEFAULT NULL COMMENT '角色代码',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
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
INSERT INTO `t_sys_role` VALUES ('1355019482119143425', 'aaa', 'aaa', '88', null, '2021-02-22 16:44:51', '0', '1', 'aaa');
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
  `dept_id` varchar(32) DEFAULT NULL COMMENT '部门id',
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
INSERT INTO `t_sys_user` VALUES ('00', null, 'admin', 'efd9d1b8bfb00e8e3647990f7d74d1d8', '123456****', 'ipcd_hz@cashq.ac.cn', 'nickname9', '1', '超级管理员', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-10-03 19:27:53', '0', '0');
INSERT INTO `t_sys_user` VALUES ('033a991e444040c98eaec85b7cf88e36', null, '杨盟', '123456', '15968101581', 'yangmeng@mail.ipc.ac.cn', 'nickname10', '2', '杨盟', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1095', null, '柏秀琴', '654321', null, null, 'nickname30', '2', '柏秀琴', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2020-12-23 22:28:35', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1098', null, '卞天兴', '123456', null, null, 'nickname32', '1', '卞天兴', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1099', null, '蔡金芝', '123456', null, null, 'nickname35', '2', '蔡金芝', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1100', null, '蔡宜权', '123456', null, null, 'nickname39', '1', '蔡宜权', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1101', null, '曹杏芝', '123456', null, null, 'nickname45', '2', '曹杏芝', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1102', null, '陈翠芝', '123456', null, null, 'nickname51', '2', '陈翠芝', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1104', null, '陈丽德', '123456', null, null, 'nickname94', '2', '陈丽德', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1106', null, '程宏钦', '123456', null, null, 'nickname56', '1', '程宏钦', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1107', null, '褚冬梅', '123456', null, null, 'nickname68', '2', '褚冬梅', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1108', null, '戴崎琛', '123456', null, null, 'nickname71', '2', '戴崎琛', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1109', null, '邓海凡', '123456', null, null, 'nickname78', '1', '邓海凡', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1113', null, '董仁英', '123456', null, null, 'nickname86', '2', '董仁英', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1179', null, '张剑平', '123456', null, null, 'nickname97', '1', '张剑平', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1193', null, '段冬云', '123456', null, null, 'nickname89', '1', '段冬云', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1203', null, '邓菲', '123456', '13871506234', 'df@wh.iov.cn', 'nickname77', '2', '邓菲', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1209', null, '崔宗强', '123456', '13006350695', 'czq@wh.iov.cn', 'nickname69', '1', '崔宗强', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1225', null, '纪昌艳', '123456', null, null, 'nickname88', '1', '纪昌艳', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1228', null, '蔡全信', '123456', '13971507496', 'qxcai@wh.iov.cn', 'nickname38', '1', '蔡全信', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1230', null, '代顺英', '123456', null, null, 'nickname73', '2', '代顺英', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1239', null, '赵淑玲', '123456', null, null, 'nickname98', '2', '赵淑玲', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1248', null, '邓教宇', '123456', '15327269382', 'dengjy@wh.iov.cn', 'nickname80', '1', '邓教宇', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1249', null, '杜涛', '123456', null, null, 'nickname93', '1', '杜涛', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1253', null, '黄江虹', '123456', null, null, 'nickname70', '1', '黄江虹', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1255', null, '刘虹', '123456', null, 'liuhong@wh.iov.cn', 'nickname95', '2', '刘虹', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1264', null, '陈宗胜', '123456', '13871394385', 'zschen@wh.iov.cn', 'nickname67', '1', '陈宗胜', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1306', null, '邓红', '123456', '13026111567', null, 'nickname79', '1', '邓红', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-1309', null, '丁清泉', '123456', '13971433066', 'qding@wh.iov.cn', 'nickname85', '1', '丁清泉', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2079', null, '杜安娜', '123456', '13296589350', 'duanna@wh.iov.cn', 'nickname90', '2', '杜安娜', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2116', null, '陈继征', '123456', null, null, 'nickname63', '1', '陈继征', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2124', null, '陈超', '123456', null, null, 'nickname49', '2', '陈超', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2125', null, '陈红贺', '123456', null, null, 'nickname60', '2', '陈红贺', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2219', null, '曹亮', '123456', null, null, 'nickname41', '1', '曹亮', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2254', null, '杜瑞坤', '123456', null, null, 'nickname92', '1', '杜瑞坤', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2396', null, '曹婷婷', '123456', '13554497206', 'caott@wh.iov.cn', 'nickname44', '2', '曹婷婷', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2429', null, '操媛', '123456', null, null, 'nickname46', '2', '操媛', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2430', null, '曹璜', '123456', null, null, 'nickname40', '1', '曹璜', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2431', null, '柴凡', '123456', null, null, 'nickname34', '1', '柴凡', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2432', null, '晁红军', '123456', null, null, 'nickname48', '1', '晁红军', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2437', null, '邓柳', '123456', null, null, 'nickname81', '2', '邓柳', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2465', null, '蔡林', '123456', '65012140', 'cl811022@hotmail.com', 'nickname37', '1', '蔡林', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2500', null, '邓雅丽', '123456', null, null, 'nickname84', '2', '邓雅丽', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2501', null, '邓成林', '123456', null, null, 'nickname76', '2', '邓成林', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2547', null, '成传刚', '123456', null, null, 'nickname54', '1', '成传刚', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2549', null, '邓阿妹', '123456', null, null, 'nickname75', '2', '邓阿妹', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2565', null, '陈军刚', '123456', '13647203546', null, 'nickname64', '1', '陈军刚', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2669', null, '程丹凝', '123456', null, null, 'nickname55', '2', '程丹凝', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2682', null, '陈振康', '123456', null, null, 'nickname65', '1', '陈振康', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2708', null, '程智逵', '123456', null, null, 'nickname59', '1', '程智逵', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2898', null, '陈卓', '123456', null, null, 'nickname66', '1', '陈卓', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-2955', null, '毕鹏', '123456', null, null, 'nickname33', '1', '毕鹏', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3117', null, '邓思思', '123456', null, null, 'nickname82', '2', '邓思思', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3129', null, '邓旭', '123456', null, null, 'nickname83', '1', '邓旭', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3150', null, '鲍凯歌', '123456', null, null, 'nickname31', '1', '鲍凯歌', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3280', null, '陈逗逗', '123456', null, null, 'nickname53', '2', '陈逗逗', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3281', null, '程爽', '123456', null, null, 'nickname58', '2', '程爽', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3300', null, '戴诗雨', '123456', null, null, 'nickname72', '2', '戴诗雨', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3317', null, '陈冬冬', '123456', null, null, 'nickname52', '1', '陈冬冬', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3318', null, '陈静', '123456', null, null, 'nickname62', '2', '陈静', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3386', null, '曹晟', '123456', null, 'caosheng@wh.iov.cn', 'nickname43', '1', '曹晟', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3407', null, '蔡丽丽', '123456', null, null, 'nickname36', '2', '蔡丽丽', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3448', null, '陈洁', '123456', '18827398658', '410391828@qq.com', 'nickname61', '2', '陈洁', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3590', null, '陈晨', '123456', null, null, 'nickname50', '1', '陈晨', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3598', null, '常猛', '123456', null, null, 'nickname47', '1', '常猛', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3614', null, '曹姗姗', '123456', null, null, 'nickname42', '2', '曹姗姗', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3634', null, '程蛟', '123456', null, null, 'nickname57', '2', '程蛟', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-3685', null, '董晓', '123456', '13297055452', null, 'nickname87', '2', '董晓', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-856', null, '闫达中', '123456', null, null, 'nickname96', '1', '闫达中', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-859', null, '镇达', '123456', null, null, 'nickname99', '1', '镇达', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-886', null, '王慧媛', '123456', null, null, 'nickname91', '2', '王慧媛', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('153B42-996', null, '梁树才', '123456', null, null, 'nickname74', '1', '梁树才', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('2339092b0e834a1a927f0083e18ffe33', null, '路浩军', '123456', '11100000000', 'luhaojun@mail.ipc.ac.cn', 'nickname5', '1', '路浩军', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('257cbbe44e8543df946a0f491dc39e35', null, '王谦', '123456', '11000000000', 'wangqian@mail.ipc.ac.cn', 'nickname4', '0', '王谦', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('2e2aa945763a4d1ebe9a51ce5c2672e9', null, '江丽雅', '123456', '18857868467', 'jiangliya@mail.ipc.ac.cn', 'nickname15', '2', '江丽雅', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('3c2e75d3bdaf49d1a3cbe1a47f8425fa', null, '刘卫卫', '123456', '18801012548', 'liuweiwei@mail.ipc.ac.cn', 'nickname0', '1', '刘卫卫', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('4c73183147994074a8e53e4185dee08d', null, '黄勇', '123456', '10000000002', 'huangyong@mail.ipc.ac.cn', 'nickname17', '0', '黄勇', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('4dc4a277d2f843e9b7b39114e98dfcbb', null, '宓群渊', '123456', '10000000001', 'miqunyuan@mail.ipc.ac.cn', 'nickname12', '1', '宓群渊', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('65d9a258285949bbbc5903baad38863d', null, '0411', '123456', '18911897013', 'wkm@cnic.cn', 'nickname24', '1', '0411', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('6a1509958bf84ba1896964a14e826d6c', null, '许慧', '123456', '15990019921', 'xuhui@mail.ipc.ac.cn', 'nickname14', '2', '许慧', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('6afb26b07aa44b3fa04aa5d47aacadb2', null, '沈崇正', '123456', '17098072638', 'shenchongzheng@mail.ipc.ac.cn', 'nickname7', '1', '沈崇正', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('7ea586b860d34a57b034cd0ee98107bd', null, '倪正', '123456', '10000000033', 'nizheng@mail.ipc.ac.cn', 'nickname2', '1', '倪正', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('8022ecf2a4ba4fe2b9d6fe875eadb966', null, '郜宇飞', '123456', '18630169964', 'yfgao@cashq.ac.cn', 'nickname20', '1', '郜宇飞', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('991608462f634e3aac6a76aa98a71a86', null, '李军民', '123456', '10000000005', 'lijunmin@mail.ipc.ac.cn', 'nickname19', '0', '李军民', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('a47532f3c87043748c57f5208e9045af', null, '热污染', '123456', '13488724223', 'wkm@cnisc.cn', 'nickname25', '1', '热污染', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('b316daf64443441f947fcfa8a54832fb', null, '吴江', '123456', '13651072453', 'jwu@mail.ipc.ac.cn', 'nickname16', '1', '吴江', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('b595526ddac74189b0b72f57fce86d2c', null, '杨柳', '123456', '10000000034', 'liuyang726@mail.ipc.ac.cn', 'nickname3', '2', '杨柳', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('bef239e75cec41df9a1109a2353aa11f', null, '郑峰', '123456', '10000000009', 'gavinzheng@mail.ipc.ac.cn', 'nickname22', '1', '郑峰', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('cc25966f9efa409e9efd5b746362f070', null, '陈文浩', '123456', '11111111111', 'chenwenhao@mail.ipc.ac.cn', 'nickname6', '0', '陈文浩', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('d5d6094e6cd846178f94c0ac96b8b5cd', null, '李浩榕', '123456', '10000000008', 'lihaorong@mail.ipc.ac.cn', 'nickname21', '0', '李浩榕', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('e8637e585cc04323ab23eba556c0aa43', null, '卢伟鹏', '123456', '10000000032', 'luweipeng@mail.ipc.ac.cn', 'nickname1', '1', '卢伟鹏', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('f026962c7a984e6bad6b684a65875b8d', null, '王磊', '123456', '10000000006', 'wanglei@mail.ipc.ac.cn', 'nickname23', '0', '王磊', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('f14b301c4b7b44d99d1ad467990ba913', null, '张晓丹', '123456', '15958165684', 'zhangxd@mail.ipc.ac.cn', 'nickname11', '2', '张晓丹', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('f74e9c3a789542a5ac01717cb73346ac', null, '李文', '123456', '13811036574', '13811036574@qq.com', 'nickname8', '2', '李文', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('fbabfc5102bb4c5e89fdfaca56737838', null, '张绍连', '123456', '15906693484', 'zhangshaolian@mail.ipc.ac.cn', 'nickname13', '2', '张绍连', null, null, '1', '2019-01-23 17:52:10', null, null, '2019-01-23 17:50:38', '2019-08-11 11:32:01', '0', '0');
INSERT INTO `t_sys_user` VALUES ('ff081bfefa674531aef73f47860430f8', null, 'lipian', '5d74d75456c3d3e6d8b58ffc5064711b', null, 'lipian1004@163.com', null, '0', null, null, null, null, null, null, null, null, null, '0', '0');

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
