/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : aster

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2021-08-03 19:20:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for c_child_info_0
-- ----------------------------
DROP TABLE IF EXISTS `c_child_info_0`;
CREATE TABLE `c_child_info_0` (
  `child_id` varchar(40) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(18) DEFAULT NULL,
  `idcard_type` int(3) DEFAULT NULL,
  `idcard_no` varchar(18) DEFAULT NULL,
  `birth_card_no` varchar(30) DEFAULT NULL,
  `gender` varchar(12) DEFAULT NULL,
  `country_code` varchar(5) DEFAULT NULL,
  `birth_date` char(10) DEFAULT NULL,
  `birth_time` char(8) DEFAULT NULL,
  `birth_hospital` varchar(200) DEFAULT NULL,
  `parity` decimal(2,0) DEFAULT NULL,
  `race` varchar(12) DEFAULT NULL,
  `birth_weight` decimal(4,2) DEFAULT NULL,
  `live_address` varchar(200) DEFAULT NULL,
  `nationality_code` varchar(10) DEFAULT NULL,
  `household_property` varchar(12) DEFAULT NULL,
  `household_type` varchar(12) DEFAULT NULL,
  `family_phone` varchar(80) DEFAULT NULL,
  `shot_message_mark` varchar(12) DEFAULT NULL,
  `shot_message_time` char(19) DEFAULT NULL,
  `father_name` varchar(90) DEFAULT NULL,
  `father_card_type` varchar(3) DEFAULT NULL,
  `father_idcard` varchar(18) DEFAULT NULL,
  `father_phone` varchar(30) DEFAULT NULL,
  `father_workplace` varchar(150) DEFAULT NULL,
  `mother_name` varchar(90) DEFAULT NULL,
  `mother_card_type` varchar(3) DEFAULT NULL,
  `mother_idcard` varchar(18) DEFAULT NULL,
  `mother_phone` varchar(30) DEFAULT NULL,
  `mother_workplace` varchar(150) DEFAULT NULL,
  `mother_hb` varchar(12) DEFAULT NULL,
  `contraindication_mark` varchar(12) DEFAULT NULL,
  `contraindication` varchar(100) DEFAULT NULL,
  `infectious_his_mark` varchar(12) DEFAULT NULL,
  `infectious_his` varchar(100) DEFAULT NULL,
  `allergy_his_mark` varchar(12) DEFAULT NULL,
  `allergy_his` varchar(100) DEFAULT NULL,
  `aefi_his_mark` varchar(12) DEFAULT NULL,
  `aefi_his` varchar(100) DEFAULT NULL,
  `record_status` varchar(12) DEFAULT NULL,
  `record_date` char(10) DEFAULT NULL,
  `record_area_id` varchar(10) DEFAULT NULL,
  `record_organ_code` varchar(50) DEFAULT NULL,
  `record_organ_name` varchar(100) DEFAULT NULL,
  `create_date` char(10) DEFAULT NULL,
  `create_area_code` varchar(10) DEFAULT NULL,
  `create_org_code` varchar(50) DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `bar_code` varchar(50) DEFAULT NULL,
  `insurcode` varchar(50) DEFAULT NULL,
  `healthc_code` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `info_integrity_mark` varchar(12) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `last_update_person` varchar(32) DEFAULT NULL,
  `last_update_person_name` varchar(50) DEFAULT NULL,
  `last_update_org` varchar(50) DEFAULT NULL,
  `input_time` datetime DEFAULT NULL,
  `inputer` varchar(32) DEFAULT NULL,
  `inputer_name` varchar(50) DEFAULT NULL,
  `input_org_code` varchar(50) DEFAULT NULL,
  `status` varchar(12) DEFAULT NULL,
  `data_source` varchar(12) DEFAULT NULL,
  `province_id` decimal(4,0) DEFAULT NULL,
  `guardian` varchar(100) DEFAULT NULL,
  `all_integrity_mark` varchar(12) DEFAULT NULL,
  `merge_child_id` varchar(32) DEFAULT NULL,
  `create_organ` varchar(20) DEFAULT NULL,
  `client_mark` char(10) DEFAULT NULL,
  `family_mobile` varchar(90) DEFAULT NULL,
  `case_version` varchar(20) DEFAULT NULL,
  `live_areaid` varchar(8) DEFAULT NULL,
  `live_town` varchar(40) DEFAULT NULL,
  `last_vaccination_time` varchar(20) DEFAULT NULL,
  `remark` text,
  `case_type` varchar(12) DEFAULT NULL,
  `is_should_vacc` varchar(12) DEFAULT NULL,
  `relation_ship` varchar(12) DEFAULT NULL,
  `whether_merge` varchar(12) DEFAULT NULL,
  `is_migrate` varchar(12) DEFAULT NULL,
  `wechat_id` varchar(100) DEFAULT NULL,
  `school_id` varchar(32) DEFAULT NULL,
  `kindergarten_id` varchar(32) DEFAULT NULL,
  `hiv_mark` varchar(12) DEFAULT NULL,
  `avoid_vaccine` text,
  `avoid_vaccine_reason` text,
  `app_id` varchar(50) DEFAULT NULL,
  `mun_barcode_decrypt` varchar(50) DEFAULT NULL,
  `mun_barcode_encryption` varchar(50) DEFAULT NULL,
  `wechat_id2` varchar(100) DEFAULT NULL,
  `wechat_id3` varchar(100) DEFAULT NULL,
  `wechat_id4` varchar(100) DEFAULT NULL,
  `is_abortion` varchar(12) DEFAULT NULL,
  `nationality_address` varchar(200) DEFAULT NULL,
  `mother_race` varchar(12) DEFAULT NULL,
  `father_race` varchar(12) DEFAULT NULL,
  `father_hb` varchar(12) DEFAULT NULL,
  `junior_school_id` varchar(32) DEFAULT NULL,
  `school_year` varchar(4) DEFAULT NULL,
  `kindergarten_year` varchar(4) DEFAULT NULL,
  `junior_year` varchar(4) DEFAULT NULL,
  `school_class` varchar(40) DEFAULT NULL,
  `kindergarten_class` varchar(40) DEFAULT NULL,
  `junior_class` varchar(40) DEFAULT NULL,
  `data_type` varchar(2) DEFAULT NULL,
  `obstetric_code` varchar(25) DEFAULT NULL,
  `quik_short_name` varchar(60) DEFAULT NULL,
  `immu_record` varchar(1) DEFAULT NULL,
  `father_hbega` varchar(12) DEFAULT NULL,
  `mother_hbega` varchar(12) DEFAULT NULL,
  `gestation_age` varchar(20) DEFAULT NULL,
  `work_space` varchar(300) DEFAULT NULL,
  `occupation` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`child_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_child_info_0
-- ----------------------------

-- ----------------------------
-- Table structure for c_child_info_1
-- ----------------------------
DROP TABLE IF EXISTS `c_child_info_1`;
CREATE TABLE `c_child_info_1` (
  `child_id` varchar(40) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(18) DEFAULT NULL,
  `idcard_type` int(3) DEFAULT NULL,
  `idcard_no` varchar(18) DEFAULT NULL,
  `birth_card_no` varchar(30) DEFAULT NULL,
  `gender` varchar(12) DEFAULT NULL,
  `country_code` varchar(5) DEFAULT NULL,
  `birth_date` char(10) DEFAULT NULL,
  `birth_time` char(8) DEFAULT NULL,
  `birth_hospital` varchar(200) DEFAULT NULL,
  `parity` decimal(2,0) DEFAULT NULL,
  `race` varchar(12) DEFAULT NULL,
  `birth_weight` decimal(4,2) DEFAULT NULL,
  `live_address` varchar(200) DEFAULT NULL,
  `nationality_code` varchar(10) DEFAULT NULL,
  `household_property` varchar(12) DEFAULT NULL,
  `household_type` varchar(12) DEFAULT NULL,
  `family_phone` varchar(80) DEFAULT NULL,
  `shot_message_mark` varchar(12) DEFAULT NULL,
  `shot_message_time` char(19) DEFAULT NULL,
  `father_name` varchar(90) DEFAULT NULL,
  `father_card_type` varchar(3) DEFAULT NULL,
  `father_idcard` varchar(18) DEFAULT NULL,
  `father_phone` varchar(30) DEFAULT NULL,
  `father_workplace` varchar(150) DEFAULT NULL,
  `mother_name` varchar(90) DEFAULT NULL,
  `mother_card_type` varchar(3) DEFAULT NULL,
  `mother_idcard` varchar(18) DEFAULT NULL,
  `mother_phone` varchar(30) DEFAULT NULL,
  `mother_workplace` varchar(150) DEFAULT NULL,
  `mother_hb` varchar(12) DEFAULT NULL,
  `contraindication_mark` varchar(12) DEFAULT NULL,
  `contraindication` varchar(100) DEFAULT NULL,
  `infectious_his_mark` varchar(12) DEFAULT NULL,
  `infectious_his` varchar(100) DEFAULT NULL,
  `allergy_his_mark` varchar(12) DEFAULT NULL,
  `allergy_his` varchar(100) DEFAULT NULL,
  `aefi_his_mark` varchar(12) DEFAULT NULL,
  `aefi_his` varchar(100) DEFAULT NULL,
  `record_status` varchar(12) DEFAULT NULL,
  `record_date` char(10) DEFAULT NULL,
  `record_area_id` varchar(10) DEFAULT NULL,
  `record_organ_code` varchar(50) DEFAULT NULL,
  `record_organ_name` varchar(100) DEFAULT NULL,
  `create_date` char(10) DEFAULT NULL,
  `create_area_code` varchar(10) DEFAULT NULL,
  `create_org_code` varchar(50) DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `bar_code` varchar(50) DEFAULT NULL,
  `insurcode` varchar(50) DEFAULT NULL,
  `healthc_code` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `info_integrity_mark` varchar(12) DEFAULT NULL,
  `last_update_time` datetime DEFAULT NULL,
  `last_update_person` varchar(32) DEFAULT NULL,
  `last_update_person_name` varchar(50) DEFAULT NULL,
  `last_update_org` varchar(50) DEFAULT NULL,
  `input_time` datetime DEFAULT NULL,
  `inputer` varchar(32) DEFAULT NULL,
  `inputer_name` varchar(50) DEFAULT NULL,
  `input_org_code` varchar(50) DEFAULT NULL,
  `status` varchar(12) DEFAULT NULL,
  `data_source` varchar(12) DEFAULT NULL,
  `province_id` decimal(4,0) DEFAULT NULL,
  `guardian` varchar(100) DEFAULT NULL,
  `all_integrity_mark` varchar(12) DEFAULT NULL,
  `merge_child_id` varchar(32) DEFAULT NULL,
  `create_organ` varchar(20) DEFAULT NULL,
  `client_mark` char(10) DEFAULT NULL,
  `family_mobile` varchar(90) DEFAULT NULL,
  `case_version` varchar(20) DEFAULT NULL,
  `live_areaid` varchar(8) DEFAULT NULL,
  `live_town` varchar(40) DEFAULT NULL,
  `last_vaccination_time` varchar(20) DEFAULT NULL,
  `remark` text,
  `case_type` varchar(12) DEFAULT NULL,
  `is_should_vacc` varchar(12) DEFAULT NULL,
  `relation_ship` varchar(12) DEFAULT NULL,
  `whether_merge` varchar(12) DEFAULT NULL,
  `is_migrate` varchar(12) DEFAULT NULL,
  `wechat_id` varchar(100) DEFAULT NULL,
  `school_id` varchar(32) DEFAULT NULL,
  `kindergarten_id` varchar(32) DEFAULT NULL,
  `hiv_mark` varchar(12) DEFAULT NULL,
  `avoid_vaccine` text,
  `avoid_vaccine_reason` text,
  `app_id` varchar(50) DEFAULT NULL,
  `mun_barcode_decrypt` varchar(50) DEFAULT NULL,
  `mun_barcode_encryption` varchar(50) DEFAULT NULL,
  `wechat_id2` varchar(100) DEFAULT NULL,
  `wechat_id3` varchar(100) DEFAULT NULL,
  `wechat_id4` varchar(100) DEFAULT NULL,
  `is_abortion` varchar(12) DEFAULT NULL,
  `nationality_address` varchar(200) DEFAULT NULL,
  `mother_race` varchar(12) DEFAULT NULL,
  `father_race` varchar(12) DEFAULT NULL,
  `father_hb` varchar(12) DEFAULT NULL,
  `junior_school_id` varchar(32) DEFAULT NULL,
  `school_year` varchar(4) DEFAULT NULL,
  `kindergarten_year` varchar(4) DEFAULT NULL,
  `junior_year` varchar(4) DEFAULT NULL,
  `school_class` varchar(40) DEFAULT NULL,
  `kindergarten_class` varchar(40) DEFAULT NULL,
  `junior_class` varchar(40) DEFAULT NULL,
  `data_type` varchar(2) DEFAULT NULL,
  `obstetric_code` varchar(25) DEFAULT NULL,
  `quik_short_name` varchar(60) DEFAULT NULL,
  `immu_record` varchar(1) DEFAULT NULL,
  `father_hbega` varchar(12) DEFAULT NULL,
  `mother_hbega` varchar(12) DEFAULT NULL,
  `gestation_age` varchar(20) DEFAULT NULL,
  `work_space` varchar(300) DEFAULT NULL,
  `occupation` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`child_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_child_info_1
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_config
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_config`;
CREATE TABLE `t_sys_config` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `config_name` varchar(50) DEFAULT NULL COMMENT '参数名称',
  `config_key` varchar(50) DEFAULT NULL COMMENT '参数键名',
  `config_value` varchar(50) DEFAULT NULL COMMENT '参数键值',
  `config_type` varchar(10) DEFAULT NULL COMMENT '系统内置,''0''-''是'',''1''-‘否’',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` varchar(1) DEFAULT '0' COMMENT '启用状态',
  `is_deleted` varchar(1) DEFAULT '0' COMMENT '删除状态',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_config
-- ----------------------------
INSERT INTO `t_sys_config` VALUES ('1409078174394880002', '默认主题', 'sys-theme', '2', '0', '2021-06-27 17:16:31', '2021-07-21 11:29:21', '0', '0', '系统框架主题颜色配置');
INSERT INTO `t_sys_config` VALUES ('1410170950712868866', '是否开启用户注册', 'sys-register', 'false', '0', '2021-06-30 17:38:49', null, '0', '0', '系统是否开放用户注册');
INSERT INTO `t_sys_config` VALUES ('1410207253139603457', '账号初始密码', 'sys-password', '123456', '0', '2021-06-30 20:03:04', null, '0', '0', '');

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
INSERT INTO `t_sys_dept` VALUES ('1408326414655111170', '0', null, '财务部', '2', '2021-06-25 15:29:17', null, '0', '0', '');
INSERT INTO `t_sys_dept` VALUES ('1408326462235295746', '0', null, '人力资源部', '1', '2021-06-25 15:29:29', '2021-06-25 16:55:20', '0', '0', '');
INSERT INTO `t_sys_dept` VALUES ('1408326537388834817', '0', null, '技术部', '3', '2021-06-25 15:29:47', null, '0', '0', '');
INSERT INTO `t_sys_dept` VALUES ('1408326766762737665', '0', null, '企划部', '4', '2021-06-25 15:30:41', null, '0', '0', '');
INSERT INTO `t_sys_dept` VALUES ('1408326808974213122', '0', null, '质管部', '5', '2021-06-25 15:30:51', null, '0', '0', '');
INSERT INTO `t_sys_dept` VALUES ('1408326888640823297', '0', null, '营销部', '6', '2021-06-25 15:31:10', null, '0', '0', '');
INSERT INTO `t_sys_dept` VALUES ('1408327998952783873', '1408326537388834817', null, '测试', '2', '2021-06-25 15:35:35', '2021-06-25 15:37:17', '0', '0', '');
INSERT INTO `t_sys_dept` VALUES ('1408328040354758658', '1408326537388834817', null, '运营', '3', '2021-06-25 15:35:45', '2021-06-25 15:37:24', '0', '0', '');
INSERT INTO `t_sys_dept` VALUES ('1408328232504213505', '1408326537388834817', null, '产品', '4', '2021-06-25 15:36:31', '2021-06-25 15:37:32', '0', '0', '');
INSERT INTO `t_sys_dept` VALUES ('1408328558242250754', '1408326537388834817', null, '开发', '1', '2021-06-25 15:37:48', '2021-06-24 15:42:56', '0', '0', '');

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
INSERT INTO `t_sys_dict` VALUES ('1410974667813003266', '目录', '0', 'MENU_TYPE', '1', '2021-07-02 22:52:30', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1411225704821964801', '其它', '0', 'OPERATOR_TYPE', '1', '2021-07-03 15:30:02', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1411225783892983810', '后台用户', '1', 'OPERATOR_TYPE', '2', '2021-07-03 15:30:21', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1411225855565250562', '手机端用户', '2', 'OPERATOR_TYPE', '3', '2021-07-03 15:30:38', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1411226281010282498', '其它', '0', 'BUSINESS_TYPE', '1', '2021-07-03 15:32:19', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1411226340628119553', '新增', '1', 'BUSINESS_TYPE', '2', '2021-07-03 15:32:34', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1411226396911484929', '修改', '2', 'BUSINESS_TYPE', '3', '2021-07-03 15:32:47', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1411226452993523714', '删除', '3', 'BUSINESS_TYPE', '4', '2021-07-03 15:33:00', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1411226548502020098', '授权', '4', 'BUSINESS_TYPE', '5', '2021-07-03 15:33:23', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1411226602931503106', '导出', '5', 'BUSINESS_TYPE', '6', '2021-07-03 15:33:36', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1411226661794365441', '导入', '6', 'BUSINESS_TYPE', '7', '2021-07-03 15:33:50', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1411226859186700290', '强退', '7', 'BUSINESS_TYPE', '8', '2021-07-03 15:34:37', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1411226919182024706', '切换状态', '8', 'BUSINESS_TYPE', '9', '2021-07-03 15:34:52', '2021-07-03 21:55:46', '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1411226998580199425', '清空', '9', 'BUSINESS_TYPE', '10', '2021-07-03 15:35:10', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1413493863552659457', '>', 'gt', 'SEARCH_TYPE', '3', '2021-07-09 21:42:53', '2021-07-12 17:16:03', '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1413493994616270850', '=', 'eq', 'SEARCH_TYPE', '1', '2021-07-09 21:43:24', '2021-07-12 17:14:52', '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1413494038694211586', '!=', 'ne', 'SEARCH_TYPE', '2', '2021-07-09 21:43:35', '2021-07-12 17:16:21', '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1413494081614524417', '>=', 'ge', 'SEARCH_TYPE', '4', '2021-07-09 21:43:45', '2021-07-12 17:16:28', '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1413494135528108033', '<', 'lt', 'SEARCH_TYPE', '5', '2021-07-09 21:43:58', '2021-07-12 17:16:33', '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1413494173583028225', '<=', 'le', 'SEARCH_TYPE', '6', '2021-07-09 21:44:07', '2021-07-12 17:16:36', '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1413494403288281089', 'like', 'like', 'SEARCH_TYPE', '7', '2021-07-09 21:45:02', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1413506815169146881', '文本框', 'input', 'SHOW_TYPE', '1', '2021-07-09 22:34:21', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1413506894105948162', '文本域', 'textarea', 'SHOW_TYPE', '2', '2021-07-09 22:34:40', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1413507095575146497', '单选框', 'radio', 'SHOW_TYPE', '3', '2021-07-09 22:35:28', '2021-07-09 22:35:33', '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1413507221140025345', '下拉框', 'select', 'SHOW_TYPE', '4', '2021-07-09 22:35:58', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1413507299808391169', '日期控件', 'date', 'SHOW_TYPE', '5', '2021-07-09 22:36:17', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1414605011370921985', '通知', '0', 'NOTICE_TYPE', '1', '2021-07-12 23:18:11', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('1414605768702840834', '公告', '1', 'NOTICE_TYPE', '2', '2021-07-12 23:21:12', null, '0', '0', '');
INSERT INTO `t_sys_dict` VALUES ('3d6f426b675b11eb9b7274e6e24360ef', '按钮', '2', 'MENU_TYPE', '3', '2021-02-05 10:39:08', '2021-07-02 22:52:52', '0', '0', '菜单类型-按钮');
INSERT INTO `t_sys_dict` VALUES ('988f5005675a11eb9b7274e6e24360ef', '菜单', '1', 'MENU_TYPE', '2', '2021-02-05 10:38:33', '2021-07-02 22:52:59', '0', '0', '菜单类型-菜单');

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
INSERT INTO `t_sys_dict_type` VALUES ('1411225287882981378', '操作人类别', 'OPERATOR_TYPE', '2021-07-03 15:28:23', '2021-07-03 15:28:44', '0', '0', '操作日志，操作人类别');
INSERT INTO `t_sys_dict_type` VALUES ('1411226157110542338', '操作类型', 'BUSINESS_TYPE', '2021-07-03 15:31:50', '2021-07-03 22:05:01', '0', '0', '操作日志，操作类型');
INSERT INTO `t_sys_dict_type` VALUES ('1413493789447696386', '查询方式', 'SEARCH_TYPE', '2021-07-09 21:42:36', null, '0', '0', '');
INSERT INTO `t_sys_dict_type` VALUES ('1413506555780804610', '显示方式', 'SHOW_TYPE', '2021-07-09 22:33:19', null, '0', '0', '');
INSERT INTO `t_sys_dict_type` VALUES ('1414604927367401473', '公告类型', 'NOTICE_TYPE', '2021-07-12 23:17:51', null, '0', '0', '');
INSERT INTO `t_sys_dict_type` VALUES ('66f8a864675a11eb9b7274e6e24360ef', '菜单类型', 'MENU_TYPE', '2021-02-05 10:33:56', '2021-02-05 10:33:56', '0', '0', null);

-- ----------------------------
-- Table structure for t_sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_login_log`;
CREATE TABLE `t_sys_login_log` (
  `id` varchar(32) NOT NULL COMMENT '访问ID',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `ip_address` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` varchar(1) DEFAULT '0' COMMENT '登录状态',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统访问记录';

-- ----------------------------
-- Records of t_sys_login_log
-- ----------------------------
INSERT INTO `t_sys_login_log` VALUES ('1411610297920200706', 'admin', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-04 16:58:16');
INSERT INTO `t_sys_login_log` VALUES ('1411610632344641537', 'admin', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-04 16:59:36');
INSERT INTO `t_sys_login_log` VALUES ('1411614310732517377', 'admin', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-04 17:14:13');
INSERT INTO `t_sys_login_log` VALUES ('1411614469390454786', 'admin', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-04 17:14:51');
INSERT INTO `t_sys_login_log` VALUES ('1411617492061720578', 'stranger', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-04 17:26:51');
INSERT INTO `t_sys_login_log` VALUES ('1411621217207590913', 'admin', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-04 17:41:39');
INSERT INTO `t_sys_login_log` VALUES ('1411621467368464385', 'admin', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-04 17:42:39');
INSERT INTO `t_sys_login_log` VALUES ('1411635142972264449', 'admin', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-04 18:37:00');
INSERT INTO `t_sys_login_log` VALUES ('1411635315765006337', 'admin', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-04 18:37:41');
INSERT INTO `t_sys_login_log` VALUES ('1411638615268716545', 'admin', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-04 18:50:48');
INSERT INTO `t_sys_login_log` VALUES ('1411638661775159298', 'admin', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '0', '退出成功', '2021-07-04 18:50:59');
INSERT INTO `t_sys_login_log` VALUES ('1411638754490249217', 'admin', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-04 18:51:21');
INSERT INTO `t_sys_login_log` VALUES ('1411670395707195394', 'admin', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-04 20:57:05');
INSERT INTO `t_sys_login_log` VALUES ('1411673130317905921', 'admin', '192.168.1.135', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-04 21:07:57');
INSERT INTO `t_sys_login_log` VALUES ('1411679463037468674', 'admin', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '0', '退出成功', '2021-07-04 21:33:06');
INSERT INTO `t_sys_login_log` VALUES ('1411679520168083457', 'yuangong01', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '1', '密码错误', '2021-07-04 21:33:20');
INSERT INTO `t_sys_login_log` VALUES ('1411679546197934081', 'yuangong01', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '1', '密码错误', '2021-07-04 21:33:26');
INSERT INTO `t_sys_login_log` VALUES ('1411679596198232066', 'yuangong01', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '1', '密码错误', '2021-07-04 21:33:38');
INSERT INTO `t_sys_login_log` VALUES ('1411679626929897473', 'yuangong01', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-04 21:33:45');
INSERT INTO `t_sys_login_log` VALUES ('1411679662514372610', 'yuangong01', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '0', '退出成功', '2021-07-04 21:33:54');
INSERT INTO `t_sys_login_log` VALUES ('1411679724409716737', 'admin', '192.168.202.70', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-04 21:34:09');
INSERT INTO `t_sys_login_log` VALUES ('1411884582479962113', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-05 11:08:11');
INSERT INTO `t_sys_login_log` VALUES ('1411884684347023362', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-05 11:08:35');
INSERT INTO `t_sys_login_log` VALUES ('1411886378787119106', 'admin', '192.168.1.135', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-05 11:15:19');
INSERT INTO `t_sys_login_log` VALUES ('1411887520984162305', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-05 11:19:51');
INSERT INTO `t_sys_login_log` VALUES ('1411888130001285122', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-05 11:22:16');
INSERT INTO `t_sys_login_log` VALUES ('1411888381563056130', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-05 11:23:16');
INSERT INTO `t_sys_login_log` VALUES ('1411895041492852738', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-05 11:49:44');
INSERT INTO `t_sys_login_log` VALUES ('1411895134509932545', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '退出成功', '2021-07-05 11:50:06');
INSERT INTO `t_sys_login_log` VALUES ('1411897936078553089', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-05 12:01:14');
INSERT INTO `t_sys_login_log` VALUES ('1411898081293746178', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-05 12:01:49');
INSERT INTO `t_sys_login_log` VALUES ('1411960212532785154', 'admin', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-05 16:08:42');
INSERT INTO `t_sys_login_log` VALUES ('1411961705285664769', 'admin', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-05 16:14:38');
INSERT INTO `t_sys_login_log` VALUES ('1411964345780326401', 'yuangong01', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '1', '密码错误', '2021-07-05 16:25:08');
INSERT INTO `t_sys_login_log` VALUES ('1411964747066167298', 'yuangong01', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '1', '密码错误', '2021-07-05 16:26:43');
INSERT INTO `t_sys_login_log` VALUES ('1411964841115045890', 'yuangong01', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '1', '密码错误', '2021-07-05 16:27:06');
INSERT INTO `t_sys_login_log` VALUES ('1411964894571450370', 'yuangong01', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '1', '密码错误', '2021-07-05 16:27:19');
INSERT INTO `t_sys_login_log` VALUES ('1411964911491272706', 'yuangong01', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '1', '密码错误', '2021-07-05 16:27:23');
INSERT INTO `t_sys_login_log` VALUES ('1411964931598766082', 'yuangong01', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '1', '密码错误', '2021-07-05 16:27:27');
INSERT INTO `t_sys_login_log` VALUES ('1411964994840481793', 'yuangong01', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '1', '密码错误5次，账户锁定', '2021-07-05 16:27:42');
INSERT INTO `t_sys_login_log` VALUES ('1411974421795692546', 'stranger', '192.168.202.78', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-05 17:05:10');
INSERT INTO `t_sys_login_log` VALUES ('1411974652897648641', 'yuangong01', '192.168.202.78', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-05 17:06:05');
INSERT INTO `t_sys_login_log` VALUES ('1411974759751737346', 'yuangong01', '192.168.202.78', '内网IP', 'Chrome 9', 'Windows 10', '0', '退出成功', '2021-07-05 17:06:31');
INSERT INTO `t_sys_login_log` VALUES ('1411974791053828097', 'admin', '192.168.1.135', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-05 17:06:38');
INSERT INTO `t_sys_login_log` VALUES ('1411976591521734657', 'stranger', '192.168.202.78', '内网IP', 'Chrome 9', 'Windows 10', '0', '退出成功', '2021-07-05 17:13:47');
INSERT INTO `t_sys_login_log` VALUES ('1411977088961941505', 'stranger', '192.168.202.78', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-05 17:15:46');
INSERT INTO `t_sys_login_log` VALUES ('1411977365911834626', 'stranger', '192.168.202.78', '内网IP', 'Chrome 9', 'Windows 10', '0', '退出成功', '2021-07-05 17:16:38');
INSERT INTO `t_sys_login_log` VALUES ('1411981209722945538', 'admin', '192.168.202.78', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-05 17:32:08');
INSERT INTO `t_sys_login_log` VALUES ('1411981337112346626', 'admin', '192.168.202.78', '内网IP', 'Chrome 9', 'Windows 10', '0', '退出成功', '2021-07-05 17:32:39');
INSERT INTO `t_sys_login_log` VALUES ('1411981406318362625', 'admin', '192.168.202.78', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-05 17:32:55');
INSERT INTO `t_sys_login_log` VALUES ('1412281997383962625', 'admin', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-06 13:27:22');
INSERT INTO `t_sys_login_log` VALUES ('1412287115873599490', 'stranger', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-06 13:47:42');
INSERT INTO `t_sys_login_log` VALUES ('1412287254914777090', 'stranger', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '退出成功', '2021-07-06 13:48:15');
INSERT INTO `t_sys_login_log` VALUES ('1412287323143520258', 'yuangong01', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-06 13:48:32');
INSERT INTO `t_sys_login_log` VALUES ('1412309470373052417', 'admin', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-06 15:16:32');
INSERT INTO `t_sys_login_log` VALUES ('1412314575902101506', 'stranger', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-06 15:36:49');
INSERT INTO `t_sys_login_log` VALUES ('1412379662076715009', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-06 19:55:27');
INSERT INTO `t_sys_login_log` VALUES ('1412390926584750082', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-06 20:40:13');
INSERT INTO `t_sys_login_log` VALUES ('1412595810131087361', 'admin', '192.168.202.73', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-07 10:14:21');
INSERT INTO `t_sys_login_log` VALUES ('1412660871398785026', 'admin', '192.168.202.73', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-07 14:32:52');
INSERT INTO `t_sys_login_log` VALUES ('1412676571236499458', 'admin', '192.168.202.73', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-07 15:35:16');
INSERT INTO `t_sys_login_log` VALUES ('1412964966013718529', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-08 10:41:14');
INSERT INTO `t_sys_login_log` VALUES ('1412971103094050817', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-08 11:05:37');
INSERT INTO `t_sys_login_log` VALUES ('1412995175635050498', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-08 12:41:17');
INSERT INTO `t_sys_login_log` VALUES ('1413027862961827841', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-08 14:51:10');
INSERT INTO `t_sys_login_log` VALUES ('1413419707184205826', 'admin', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-09 16:48:13');
INSERT INTO `t_sys_login_log` VALUES ('1413436884390006786', 'admin', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-09 17:56:28');
INSERT INTO `t_sys_login_log` VALUES ('1413460767595933698', 'admin', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-09 19:31:22');
INSERT INTO `t_sys_login_log` VALUES ('1413489595844145154', 'admin', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-09 21:25:56');
INSERT INTO `t_sys_login_log` VALUES ('1414127958221672450', 'admin', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-11 15:42:33');
INSERT INTO `t_sys_login_log` VALUES ('1414202722940407809', 'admin', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-11 20:39:38');
INSERT INTO `t_sys_login_log` VALUES ('1414237571885617154', 'admin', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-11 22:58:07');
INSERT INTO `t_sys_login_log` VALUES ('1414407963879256066', 'admin', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-12 10:15:12');
INSERT INTO `t_sys_login_log` VALUES ('1414422624322232321', 'admin', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-12 11:13:27');
INSERT INTO `t_sys_login_log` VALUES ('1414512684166021122', 'admin', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-12 17:11:19');
INSERT INTO `t_sys_login_log` VALUES ('1414601544682196993', 'admin', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-12 23:04:25');
INSERT INTO `t_sys_login_log` VALUES ('1415953341838524417', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-16 16:35:58');
INSERT INTO `t_sys_login_log` VALUES ('1415985270172508161', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-16 18:42:51');
INSERT INTO `t_sys_login_log` VALUES ('1415985340179636225', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-16 18:43:07');
INSERT INTO `t_sys_login_log` VALUES ('1415991565080420354', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-16 19:07:52');
INSERT INTO `t_sys_login_log` VALUES ('1415992994297896961', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-16 19:13:32');
INSERT INTO `t_sys_login_log` VALUES ('1416006087929323522', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-16 20:05:34');
INSERT INTO `t_sys_login_log` VALUES ('1416021945598681089', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-16 21:08:35');
INSERT INTO `t_sys_login_log` VALUES ('1416049702986674178', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-16 22:58:53');
INSERT INTO `t_sys_login_log` VALUES ('1416357352584638466', 'admin', '192.168.202.68', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-17 19:21:22');
INSERT INTO `t_sys_login_log` VALUES ('1417073152109903873', 'admin', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-19 18:45:42');
INSERT INTO `t_sys_login_log` VALUES ('1417687144835649538', 'admin', '192.168.202.77', '内网IP', 'Chrome 9', 'Windows 10', '1', '密码错误', '2021-07-21 11:25:29');
INSERT INTO `t_sys_login_log` VALUES ('1417687180273324034', 'admin', '192.168.202.77', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-21 11:25:38');
INSERT INTO `t_sys_login_log` VALUES ('1417736238643875842', 'admin', '192.168.202.77', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-21 14:40:34');
INSERT INTO `t_sys_login_log` VALUES ('1417759162000019458', 'admin', '192.168.202.77', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-21 16:11:40');
INSERT INTO `t_sys_login_log` VALUES ('1418389794484920321', 'admin', '192.168.202.68', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-23 09:57:34');
INSERT INTO `t_sys_login_log` VALUES ('1418421256445861890', 'admin', '192.168.202.68', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-23 12:02:35');
INSERT INTO `t_sys_login_log` VALUES ('1418453069728886786', 'admin', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-23 14:09:00');
INSERT INTO `t_sys_login_log` VALUES ('1418468834842550274', 'admin', '192.168.202.65', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-23 15:11:39');
INSERT INTO `t_sys_login_log` VALUES ('1418522974546399233', 'admin', '192.168.202.65', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-23 18:46:47');
INSERT INTO `t_sys_login_log` VALUES ('1418870104347648001', 'admin', '192.168.202.72', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-24 17:46:09');
INSERT INTO `t_sys_login_log` VALUES ('1418936473927917570', 'admin', '192.168.202.72', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-24 22:09:53');
INSERT INTO `t_sys_login_log` VALUES ('1419541704193609730', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-26 14:14:51');
INSERT INTO `t_sys_login_log` VALUES ('1419568079483039745', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-26 15:59:39');
INSERT INTO `t_sys_login_log` VALUES ('1419568307644788737', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-26 16:00:34');
INSERT INTO `t_sys_login_log` VALUES ('1419573204268191746', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-26 16:20:01');
INSERT INTO `t_sys_login_log` VALUES ('1419575871019274242', 'admin', '192.168.202.75', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-07-26 16:30:37');
INSERT INTO `t_sys_login_log` VALUES ('1422041807851667457', 'admin', '192.168.1.140', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-08-02 11:49:22');
INSERT INTO `t_sys_login_log` VALUES ('1422098693629153282', 'admin', '192.168.202.81', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-08-02 15:35:25');
INSERT INTO `t_sys_login_log` VALUES ('1422446212905181186', 'admin', '192.168.202.80', '内网IP', 'Chrome 9', 'Windows 10', '0', '登录成功', '2021-08-03 14:36:20');

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
INSERT INTO `t_sys_menu` VALUES ('111812b068ed11ebbe2c74e6e24360ef', 'user-add', 'user', '用户新增', 'sysUser/add', 'system:user:add', '_self', 'layui-icon-add-1', '2', '[0],[system],[user],', '1', '2021-01-30 23:49:19', '2021-07-06 15:24:09', '0', '0', null);
INSERT INTO `t_sys_menu` VALUES ('1358324972823744514', 'user-edit', 'user', '用户编辑', 'sysUser/edit', 'system:user:edit', '_self', 'layui-icon-edit', '2', '[0],[system],[user],', '2', '2021-02-07 16:01:25', '2021-07-06 15:24:15', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1358325509623353346', 'user-delete', 'user', '用户删除', 'sysUser/delete', 'system:user:del', '_self', 'layui-icon-delete', '2', '[0],[system],[user],', '3', '2021-02-07 16:03:33', '2021-07-06 15:24:18', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364787207246876673', 'position', 'system', '岗位管理', 'sysPosition/list', 'system:position:view', '_self', 'fa fa-address-card', '1', '[0],[system],', '6', '2021-02-25 12:00:01', '2021-07-06 15:24:20', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364787777584140289', 'dict', 'system', '字典管理', 'sysDictType/list', 'system:dicttype:view', '_self', 'fa fa-bookmark-o', '1', '[0],[system],', '7', '2021-02-25 12:02:17', '2021-07-06 15:24:22', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364788142161432577', 'tool', '0', '系统工具', '', '', '_self', 'layui-icon-star-fill', '0', '[0],', '3', '2021-02-25 12:03:44', '2021-07-09 16:51:01', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364805353974398978', 'zy1', 'system', '主页', 'page/welcome-1.html', '', '_self', 'fa fa-tachometer', '1', '[0],[system],', '1', '2021-02-25 13:12:08', '2021-07-02 22:37:38', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364806014795382785', 'setting', 'system', '系统设置', 'sysConfig/list', 'system:config:view', '_self', 'fa fa fa-gears', '1', '[0],[system],', '8', '2021-02-25 13:14:45', '2021-07-06 15:24:26', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364806273512636417', 'fbbd', 'assembly', '分步表单', 'page/form-step.html', '', '_self', 'fa fa-star', '1', '[0],[assembly],', '8', '2021-02-25 13:15:47', '2021-07-08 16:36:11', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364807152957521921', 'button', 'assembly', '按钮示例', 'page/button.html', '', '_self', 'fa fa-star', '1', '[0],[assembly],', '9', '2021-02-25 13:19:17', '2021-07-08 16:36:13', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364807262709874690', 'tcc', 'assembly', '弹出层', 'page/layer.html', '', '_self', 'fa fa-star', '1', '[0],[assembly],', '10', '2021-02-25 13:19:43', '2021-07-08 16:36:16', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364807448521736194', 'assembly', '0', '组件管理', '', '', '_self', 'fa fa-star', '0', '[0],', '4', '2021-02-25 13:20:27', '2021-06-10 19:23:10', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364807590075301890', 'tblb', 'assembly', '图标列表', 'page/icon.html', '', '_self', 'fa fa-star', '1', '[0],[assembly],', '1', '2021-02-25 13:21:01', '2021-07-02 22:38:05', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364807696040198145', 'tbxz', 'assembly', '图标选择', 'page/icon-picker.html', '', '_self', 'fa fa-star', '1', '[0],[assembly],', '2', '2021-02-25 13:21:26', '2021-07-02 22:38:06', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364807825627414530', 'ysxz', 'assembly', '颜色选择', 'page/color-select.html', '', '_self', 'fa fa-star', '1', '[0],[assembly],', '3', '2021-02-25 13:21:57', '2021-07-02 22:38:07', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364807952450584577', 'xlxz', 'assembly', '下拉选择', 'page/table-select.html', '', '_self', 'fa fa-star', '1', '[0],[assembly],', '4', '2021-02-25 13:22:27', '2021-07-02 22:38:08', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364808074987175938', 'wjsc', 'assembly', '文件上传', 'page/upload.html', '', '_self', 'fa fa-star', '1', '[0],[assembly],', '5', '2021-02-25 13:22:57', '2021-07-02 22:38:09', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364808191555272705', 'fwb', 'assembly', '富文本编辑器', 'page/editor.html', '', '_self', 'fa fa-star', '1', '[0],[assembly],', '6', '2021-02-25 13:23:24', '2021-07-02 22:38:11', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1364808343556849665', 'ssx', 'assembly', '省市县区选择器', 'page/area.html', '', '_self', 'fa fa-star', '1', '[0],[assembly],', '7', '2021-02-25 13:24:01', '2021-07-02 22:38:12', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1410966128553984001', 'log', 'monitor', '日志管理', '', '', '_self', 'fa fa fa fa fa-edit', '0', '[0],[monitor],', '2', '2021-07-02 22:18:34', '2021-07-06 15:18:16', '0', '0', '系统日志');
INSERT INTO `t_sys_menu` VALUES ('1410966742772056066', 'login-log', 'log', '访问日志', 'sysLoginLog/list', 'monitor:login:view', '_self', 'fa fa fa-user-circle', '1', '[0],[monitor],[log],', '1', '2021-07-02 22:21:01', '2021-07-06 15:18:40', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1410967795282313218', 'oper-log', 'log', '操作日志', 'sysOperLog/list', 'monitor:oper:view', '_self', 'fa fa fa-cog', '1', '[0],[monitor],[log],', '2', '2021-07-02 22:25:12', '2021-07-06 15:19:12', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1412282923771498498', 'online', 'monitor', '在线用户', 'online/list', 'monitor:online:view', '_self', 'fa fa fa fa-camera-retro', '1', '[0],[monitor],', '1', '2021-07-06 13:31:03', '2021-07-06 15:18:54', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1412309808123576321', 'server', 'monitor', '服务监控', 'server/list', 'monitor:server:view', '_self', 'fa fa-server', '1', '[0],[monitor],', '3', '2021-07-06 15:17:52', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1413420306000793601', 'gen-code', 'tool', '代码生成', 'gen/code', 'tool:gen:code', '_self', 'fa fa-code', '1', '[0],[tool],', '1', '2021-07-09 16:50:36', '2021-07-09 16:51:20', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1416057921129680897', 'notice', 'system', '通知公告', 'sysNotice/list', 'system:notice:view', '_self', 'fa fa fa-star', '1', '[0],[system],', '9', '2021-07-16 23:31:32', null, '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('1419548734061019138', 'data', 'monitor', '数据监控', 'data/list', 'monitor:data:view', '_self', 'fa fa fa-database', '1', '[0],[monitor],', '4', '2021-07-26 14:42:47', '2021-07-26 14:43:10', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('2b689fa768eb11ebbe2c74e6e24360ef', 'role', 'system', '角色管理', 'sysRole/list', 'system:role:view', '_self', 'fa fa-user-secret', '1', '[0],[system],', '3', '2021-01-30 23:49:19', '2021-07-06 15:24:32', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('48b617c368eb11ebbe2c74e6e24360ef', 'menu', 'system', '菜单管理', 'sysMenu/list', 'system:menu:view', '_self', 'fa fa-list', '1', '[0],[system],', '4', '2021-01-30 23:49:19', '2021-07-06 15:24:34', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('5859134468eb11ebbe2c74e6e24360ef', 'dept', 'system', '部门管理', 'sysDept/list', 'system:dept:view', '_self', 'fa fa-outdent', '1', '[0],[system],', '5', '2021-01-30 23:49:19', '2021-07-06 15:24:36', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('739151e368ec11ebbe2c74e6e24360ef', 'monitor', '0', '系统监控', '', '', '_self', 'layui-icon-rate-solid', '0', '[0],', '2', '2021-01-30 23:38:00', '2021-07-06 14:14:05', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('94f51875631211ebb3b600ff633443b0', 'user', 'system', '用户管理', 'sysUser/list', 'system:user:view', '_self', 'fa fa-user-o', '1', '[0],[system],', '2', '2021-01-30 23:49:19', '2021-07-06 15:24:38', '0', '0', '');
INSERT INTO `t_sys_menu` VALUES ('b7bf613a631011ebb3b600ff633443b0', 'system', '0', '系统管理', '', null, '_self', 'fa fa-address-book', '0', '[0],', '1', '2021-01-30 23:38:00', '2021-06-10 19:23:14', '0', '0', null);

-- ----------------------------
-- Table structure for t_sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_notice`;
CREATE TABLE `t_sys_notice` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(1) NOT NULL COMMENT '公告类型',
  `notice_content` varchar(2000) DEFAULT NULL COMMENT '公告内容',
  `create_by` varchar(32) DEFAULT '' COMMENT '创建者',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_by` varchar(32) DEFAULT '' COMMENT '更新者',
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` varchar(1) DEFAULT '0' COMMENT '启用状态',
  `is_deleted` varchar(1) DEFAULT '0' COMMENT '删除状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通知公告';

-- ----------------------------
-- Records of t_sys_notice
-- ----------------------------
INSERT INTO `t_sys_notice` VALUES ('1416062091194892290', '11', '0', '11', '', '2021-07-16 23:48:06', '', '2021-07-16 23:48:20', '1', '0', '11');
INSERT INTO `t_sys_notice` VALUES ('1416362712041123841', '年假通知', '0', '<h1 style=\"text-align: center;\">年假通知</h1><p><span style=\"background-color: rgb(194, 79, 74);\">各位同事：</span></p><p>&nbsp; &nbsp; 放假时间起始时间为2021年8月15日，截至时间为2021年8月31日，共计17天，望周知。<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\"><br></p><p>人事部</p><p><span style=\"color: rgb(70, 172, 200);\">2021年7月17日</span></p><p><img src=\"http://localhost:8080/profile/upload/2021-07-19/a5dcd83d8e8e4a609d418543b22b1543.jpg\" style=\"max-width:100%;\"><span style=\"color: rgb(70, 172, 200);\"><br></span></p><p><span style=\"color: rgb(70, 172, 200);\"><br></span></p>', '', '2021-07-17 19:42:39', '', '2021-07-19 19:17:49', '1', '0', null);

-- ----------------------------
-- Table structure for t_sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_oper_log`;
CREATE TABLE `t_sys_oper_log` (
  `id` varchar(32) NOT NULL COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` varchar(2) DEFAULT '0' COMMENT '业务类型',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operator_type` varchar(1) DEFAULT '0' COMMENT '操作类别',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(50) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` varchar(1) DEFAULT '0' COMMENT '操作状态',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志记录';

-- ----------------------------
-- Records of t_sys_oper_log
-- ----------------------------
INSERT INTO `t_sys_oper_log` VALUES ('1411325102843338753', '字典类型管理', '8', 'top.plgxs.admin.controller.sys.SysDictTypeController.switchStatus()', 'POST', '1', 'admin', '/sysDictType/switchStatus', '0:0:0:0:0:0:0:1', '', '{\"id\":[\"1411226157110542338\"],\"status\":[\"1\"]}', '{\"msg\":\"切换成功\",\"code\":200,\"success\":true,\"timestamp\":1625321100242}', '0', '', '2021-07-03 22:05:00');
INSERT INTO `t_sys_oper_log` VALUES ('1411325107415130113', '字典类型管理', '8', 'top.plgxs.admin.controller.sys.SysDictTypeController.switchStatus()', 'POST', '1', 'admin', '/sysDictType/switchStatus', '0:0:0:0:0:0:0:1', '', '{\"id\":[\"1411226157110542338\"],\"status\":[\"0\"]}', '{\"msg\":\"切换成功\",\"code\":200,\"success\":true,\"timestamp\":1625321101416}', '0', '', '2021-07-03 22:05:01');
INSERT INTO `t_sys_oper_log` VALUES ('1411673230184284162', '系统配置', '2', 'top.plgxs.admin.controller.sys.SysConfigController.switchTheme()', 'POST', '1', 'admin', '/sysConfig/switchTheme/0', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"切换主题\",\"code\":200,\"success\":true,\"timestamp\":1625404100319}', '0', '', '2021-07-04 21:08:20');
INSERT INTO `t_sys_oper_log` VALUES ('1412282923930882049', '菜单管理', '1', 'top.plgxs.admin.controller.sys.SysMenuController.insert()', 'POST', '1', 'admin', '/sysMenu/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625549462636}', '0', '', '2021-07-06 13:31:03');
INSERT INTO `t_sys_oper_log` VALUES ('1412282998040039426', '菜单管理', '2', 'top.plgxs.admin.controller.sys.SysMenuController.update()', 'POST', '1', 'admin', '/sysMenu/update/log', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625549480337}', '0', '', '2021-07-06 13:31:20');
INSERT INTO `t_sys_oper_log` VALUES ('1412283037567160321', '菜单管理', '2', 'top.plgxs.admin.controller.sys.SysMenuController.update()', 'POST', '1', 'admin', '/sysMenu/update/online', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625549489761}', '0', '', '2021-07-06 13:31:30');
INSERT INTO `t_sys_oper_log` VALUES ('1412309808324902914', '菜单管理', '1', 'top.plgxs.admin.controller.sys.SysMenuController.insert()', 'POST', '1', 'admin', '/sysMenu/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625555872371}', '0', '', '2021-07-06 15:17:52');
INSERT INTO `t_sys_oper_log` VALUES ('1412309908539408385', '菜单管理', '2', 'top.plgxs.admin.controller.sys.SysMenuController.update()', 'POST', '1', 'admin', '/sysMenu/update/log', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625555896301}', '0', '', '2021-07-06 15:18:16');
INSERT INTO `t_sys_oper_log` VALUES ('1412310010683293697', '菜单管理', '2', 'top.plgxs.admin.controller.sys.SysMenuController.update()', 'POST', '1', 'admin', '/sysMenu/update/login-log', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625555920655}', '0', '', '2021-07-06 15:18:41');
INSERT INTO `t_sys_oper_log` VALUES ('1412310067713245185', '菜单管理', '2', 'top.plgxs.admin.controller.sys.SysMenuController.update()', 'POST', '1', 'admin', '/sysMenu/update/online', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625555934251}', '0', '', '2021-07-06 15:18:54');
INSERT INTO `t_sys_oper_log` VALUES ('1412310143898583042', '菜单管理', '2', 'top.plgxs.admin.controller.sys.SysMenuController.update()', 'POST', '1', 'admin', '/sysMenu/update/oper-log', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625555952415}', '0', '', '2021-07-06 15:19:12');
INSERT INTO `t_sys_oper_log` VALUES ('1412314678989705218', '在线用户', '7', 'top.plgxs.admin.controller.monitor.OnlineController.batchForceLogout()', 'POST', '1', 'admin', '/online/batchForceLogout', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625557033637}', '0', '', '2021-07-06 15:37:14');
INSERT INTO `t_sys_oper_log` VALUES ('1413420306160177153', '菜单管理', '1', 'top.plgxs.admin.controller.sys.SysMenuController.insert()', 'POST', '1', 'admin', '/sysMenu/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625820635690}', '0', '', '2021-07-09 16:50:36');
INSERT INTO `t_sys_oper_log` VALUES ('1413493789602885633', '字典类型管理', '1', 'top.plgxs.admin.controller.sys.SysDictTypeController.insert()', 'POST', '1', 'admin', '/sysDictType/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625838155513}', '0', '', '2021-07-09 21:42:36');
INSERT INTO `t_sys_oper_log` VALUES ('1413493863569436673', '字典数据管理', '1', 'top.plgxs.admin.controller.sys.SysDictController.insert()', 'POST', '1', 'admin', '/sysDict/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625838173177}', '0', '', '2021-07-09 21:42:53');
INSERT INTO `t_sys_oper_log` VALUES ('1413493959417671681', '字典数据管理', '2', 'top.plgxs.admin.controller.sys.SysDictController.update()', 'POST', '1', 'admin', '/sysDict/update', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625838196030}', '0', '', '2021-07-09 21:43:16');
INSERT INTO `t_sys_oper_log` VALUES ('1413493994633048065', '字典数据管理', '1', 'top.plgxs.admin.controller.sys.SysDictController.insert()', 'POST', '1', 'admin', '/sysDict/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625838204424}', '0', '', '2021-07-09 21:43:24');
INSERT INTO `t_sys_oper_log` VALUES ('1413494038727766017', '字典数据管理', '1', 'top.plgxs.admin.controller.sys.SysDictController.insert()', 'POST', '1', 'admin', '/sysDict/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625838214938}', '0', '', '2021-07-09 21:43:35');
INSERT INTO `t_sys_oper_log` VALUES ('1413494081664856066', '字典数据管理', '1', 'top.plgxs.admin.controller.sys.SysDictController.insert()', 'POST', '1', 'admin', '/sysDict/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625838225173}', '0', '', '2021-07-09 21:43:45');
INSERT INTO `t_sys_oper_log` VALUES ('1413494135553273857', '字典数据管理', '1', 'top.plgxs.admin.controller.sys.SysDictController.insert()', 'POST', '1', 'admin', '/sysDict/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625838238023}', '0', '', '2021-07-09 21:43:58');
INSERT INTO `t_sys_oper_log` VALUES ('1413494173612388354', '字典数据管理', '1', 'top.plgxs.admin.controller.sys.SysDictController.insert()', 'POST', '1', 'admin', '/sysDict/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625838247097}', '0', '', '2021-07-09 21:44:07');
INSERT INTO `t_sys_oper_log` VALUES ('1413494403326029826', '字典数据管理', '1', 'top.plgxs.admin.controller.sys.SysDictController.insert()', 'POST', '1', 'admin', '/sysDict/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625838301865}', '0', '', '2021-07-09 21:45:02');
INSERT INTO `t_sys_oper_log` VALUES ('1413506555810164738', '字典类型管理', '1', 'top.plgxs.admin.controller.sys.SysDictTypeController.insert()', 'POST', '1', 'admin', '/sysDictType/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625841199244}', '0', '', '2021-07-09 22:33:19');
INSERT INTO `t_sys_oper_log` VALUES ('1413506815206895617', '字典数据管理', '1', 'top.plgxs.admin.controller.sys.SysDictController.insert()', 'POST', '1', 'admin', '/sysDict/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625841261088}', '0', '', '2021-07-09 22:34:21');
INSERT INTO `t_sys_oper_log` VALUES ('1413506894126919681', '字典数据管理', '1', 'top.plgxs.admin.controller.sys.SysDictController.insert()', 'POST', '1', 'admin', '/sysDict/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625841279904}', '0', '', '2021-07-09 22:34:40');
INSERT INTO `t_sys_oper_log` VALUES ('1413507095604506625', '字典数据管理', '1', 'top.plgxs.admin.controller.sys.SysDictController.insert()', 'POST', '1', 'admin', '/sysDict/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625841327941}', '0', '', '2021-07-09 22:35:28');
INSERT INTO `t_sys_oper_log` VALUES ('1413507119415570434', '字典数据管理', '2', 'top.plgxs.admin.controller.sys.SysDictController.update()', 'POST', '1', 'admin', '/sysDict/update', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625841333618}', '0', '', '2021-07-09 22:35:34');
INSERT INTO `t_sys_oper_log` VALUES ('1413507221173579778', '字典数据管理', '1', 'top.plgxs.admin.controller.sys.SysDictController.insert()', 'POST', '1', 'admin', '/sysDict/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625841357879}', '0', '', '2021-07-09 22:35:58');
INSERT INTO `t_sys_oper_log` VALUES ('1413507299841945602', '字典数据管理', '1', 'top.plgxs.admin.controller.sys.SysDictController.insert()', 'POST', '1', 'admin', '/sysDict/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1625841376634}', '0', '', '2021-07-09 22:36:17');
INSERT INTO `t_sys_oper_log` VALUES ('1414604927556145153', '字典类型管理', '1', 'top.plgxs.admin.controller.sys.SysDictTypeController.insert()', 'POST', '1', 'admin', '/sysDictType/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1626103071432}', '0', '', '2021-07-12 23:17:51');
INSERT INTO `t_sys_oper_log` VALUES ('1414605011400282114', '字典数据管理', '1', 'top.plgxs.admin.controller.sys.SysDictController.insert()', 'POST', '1', 'admin', '/sysDict/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1626103091465}', '0', '', '2021-07-12 23:18:11');
INSERT INTO `t_sys_oper_log` VALUES ('1414605768782532610', '字典数据管理', '1', 'top.plgxs.admin.controller.sys.SysDictController.insert()', 'POST', '1', 'admin', '/sysDict/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1626103272030}', '0', '', '2021-07-12 23:21:12');
INSERT INTO `t_sys_oper_log` VALUES ('1416057921318424578', '菜单管理', '1', 'top.plgxs.admin.controller.sys.SysMenuController.insert()', 'POST', '1', 'admin', '/sysMenu/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1626449492149}', '0', '', '2021-07-16 23:31:32');
INSERT INTO `t_sys_oper_log` VALUES ('1416062091417190401', '通知公告', '1', 'top.plgxs.admin.controller.sys.SysNoticeController.insert()', 'POST', '1', 'admin', '/sysNotice/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1626450486369}', '0', '', '2021-07-16 23:48:06');
INSERT INTO `t_sys_oper_log` VALUES ('1416062119821017090', '通知公告', '8', 'top.plgxs.admin.controller.sys.SysNoticeController.switchStatus()', 'POST', '1', 'admin', '/sysNotice/switchStatus', '0:0:0:0:0:0:0:1', '', '{\"id\":[\"1416062091194892290\"],\"status\":[\"0\"]}', '{\"msg\":\"切换成功\",\"code\":200,\"success\":true,\"timestamp\":1626450493122}', '0', '', '2021-07-16 23:48:13');
INSERT INTO `t_sys_oper_log` VALUES ('1416062149671878657', '通知公告', '8', 'top.plgxs.admin.controller.sys.SysNoticeController.switchStatus()', 'POST', '1', 'admin', '/sysNotice/switchStatus', '0:0:0:0:0:0:0:1', '', '{\"id\":[\"1416062091194892290\"],\"status\":[\"1\"]}', '{\"msg\":\"切换成功\",\"code\":200,\"success\":true,\"timestamp\":1626450500301}', '0', '', '2021-07-16 23:48:20');
INSERT INTO `t_sys_oper_log` VALUES ('1416359449912799234', '通知公告', '1', 'top.plgxs.admin.controller.sys.SysNoticeController.insert()', 'POST', '1', 'admin', '/sysNotice/insert', '0:0:0:0:0:0:0:1', '', '', '', '1', '\r\n### Error updating database.  Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'notice_content\' at row 1\r\n### The error may exist in top/plgxs/mbg/mapper/sys/SysNoticeMapper.java (best guess)\r\n### The error may involve top.plgxs.mbg.mapper.sys.SysNoticeMapper.insert-Inline\r\n### The error occurred while setting parameters\r\n### SQL: INSERT INTO t_sys_notice  ( id, notice_title, notice_type, notice_content,  gmt_create,   status )  VALUES  ( ?, ?, ?, ?,  ?,   ? )\r\n### Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'notice_content\' at row 1\n; Data truncation: Data too long for column \'notice_content\' at row 1; nested exception is com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'notice_content\' at row 1', '2021-07-17 19:29:42');
INSERT INTO `t_sys_oper_log` VALUES ('1416359525049561090', '通知公告', '1', 'top.plgxs.admin.controller.sys.SysNoticeController.insert()', 'POST', '1', 'admin', '/sysNotice/insert', '0:0:0:0:0:0:0:1', '', '', '', '1', '\r\n### Error updating database.  Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'notice_content\' at row 1\r\n### The error may exist in top/plgxs/mbg/mapper/sys/SysNoticeMapper.java (best guess)\r\n### The error may involve top.plgxs.mbg.mapper.sys.SysNoticeMapper.insert-Inline\r\n### The error occurred while setting parameters\r\n### SQL: INSERT INTO t_sys_notice  ( id, notice_title, notice_type, notice_content,  gmt_create,   status )  VALUES  ( ?, ?, ?, ?,  ?,   ? )\r\n### Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'notice_content\' at row 1\n; Data truncation: Data too long for column \'notice_content\' at row 1; nested exception is com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Data too long for column \'notice_content\' at row 1', '2021-07-17 19:30:00');
INSERT INTO `t_sys_oper_log` VALUES ('1416362734199631874', '通知公告', '1', 'top.plgxs.admin.controller.sys.SysNoticeController.insert()', 'POST', '1', 'admin', '/sysNotice/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1626522165189}', '0', '', '2021-07-17 19:42:45');
INSERT INTO `t_sys_oper_log` VALUES ('1416364019279851522', '通知公告', '2', 'top.plgxs.admin.controller.sys.SysNoticeController.update()', 'POST', '1', 'admin', '/sysNotice/update', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1626522471623}', '0', '', '2021-07-17 19:47:52');
INSERT INTO `t_sys_oper_log` VALUES ('1416364490115641345', '通知公告', '2', 'top.plgxs.admin.controller.sys.SysNoticeController.update()', 'POST', '1', 'admin', '/sysNotice/update', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1626522583879}', '0', '', '2021-07-17 19:49:44');
INSERT INTO `t_sys_oper_log` VALUES ('1417080424991055874', '通知公告', '2', 'top.plgxs.admin.controller.sys.SysNoticeController.update()', 'POST', '1', 'admin', '/sysNotice/update', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1626693276023}', '0', '', '2021-07-19 19:14:36');
INSERT INTO `t_sys_oper_log` VALUES ('1417081006413877250', '通知公告', '2', 'top.plgxs.admin.controller.sys.SysNoticeController.update()', 'POST', '1', 'admin', '/sysNotice/update', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1626693414650}', '0', '', '2021-07-19 19:16:55');
INSERT INTO `t_sys_oper_log` VALUES ('1417081234575626241', '通知公告', '8', 'top.plgxs.admin.controller.sys.SysNoticeController.switchStatus()', 'POST', '1', 'admin', '/sysNotice/switchStatus', '0:0:0:0:0:0:0:1', '', '{\"id\":[\"1416362712041123841\"],\"status\":[\"1\"]}', '{\"msg\":\"切换成功\",\"code\":200,\"success\":true,\"timestamp\":1626693469023}', '0', '', '2021-07-19 19:17:49');
INSERT INTO `t_sys_oper_log` VALUES ('1417688117184368641', '系统配置', '2', 'top.plgxs.admin.controller.sys.SysConfigController.switchTheme()', 'POST', '1', 'admin', '/sysConfig/switchTheme/2', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"切换主题\",\"code\":200,\"success\":true,\"timestamp\":1626838161124}', '0', '', '2021-07-21 11:29:21');
INSERT INTO `t_sys_oper_log` VALUES ('1418421300855152642', '用户管理', '5', 'top.plgxs.admin.controller.sys.SysUserController.export()', 'GET', '1', 'admin', '/sysUser/export', '0:0:0:0:0:0:0:1', '', '{\"deptId\":[\"\"],\"name\":[\"\"]}', '', '1', '\r\n### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column \'u.is_deleted\' in \'where clause\'\r\n### The error may exist in top/plgxs/mbg/mapper/sys/SysUserMapper.java (best guess)\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: SELECT  id,dept_id,username,password,salt,mobile,email,nickname,gender,realname,id_number,head_url,login_number,last_login_time,mobile_verification_code,email_verification_code,gmt_create,gmt_modified,status,is_deleted  FROM t_sys_user   WHERE  is_deleted=\'0\'  AND (u.is_deleted = ?) ORDER BY u.gmt_create DESC\r\n### Cause: java.sql.SQLSyntaxErrorException: Unknown column \'u.is_deleted\' in \'where clause\'\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: Unknown column \'u.is_deleted\' in \'where clause\'', '2021-07-23 12:02:46');
INSERT INTO `t_sys_oper_log` VALUES ('1418423016107290626', '用户管理', '5', 'top.plgxs.admin.controller.sys.SysUserController.export()', 'GET', '1', 'admin', '/sysUser/export', '0:0:0:0:0:0:0:1', '', '{\"deptId\":[\"\"],\"name\":[\"\"]}', '', '0', '', '2021-07-23 12:09:35');
INSERT INTO `t_sys_oper_log` VALUES ('1418423866203615233', '用户管理', '5', 'top.plgxs.admin.controller.sys.SysUserController.export()', 'GET', '1', 'admin', '/sysUser/export', '0:0:0:0:0:0:0:1', '', '{\"deptId\":[\"\"],\"name\":[\"\"]}', '', '0', '', '2021-07-23 12:12:57');
INSERT INTO `t_sys_oper_log` VALUES ('1418453258900385793', '用户管理', '2', 'top.plgxs.admin.controller.sys.SysUserController.update()', 'POST', '1', 'admin', '/sysUser/update', '127.0.0.1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1627020585153}', '0', '', '2021-07-23 14:09:45');
INSERT INTO `t_sys_oper_log` VALUES ('1418459593272553473', '用户管理', '5', 'top.plgxs.admin.controller.sys.SysUserController.export()', 'GET', '1', 'admin', '/sysUser/export', '127.0.0.1', '', '{\"deptId\":[\"\"],\"name\":[\"\"]}', '', '0', '', '2021-07-23 14:34:55');
INSERT INTO `t_sys_oper_log` VALUES ('1418468861820313601', '用户管理', '5', 'top.plgxs.admin.controller.sys.SysUserController.export()', 'GET', '1', 'admin', '/sysUser/export', '0:0:0:0:0:0:0:1', '', '{\"deptId\":[\"\"],\"name\":[\"\"]}', '', '1', 'java.lang.NoClassDefFoundError: org/apache/poi/POIXMLTypeLoader', '2021-07-23 15:11:45');
INSERT INTO `t_sys_oper_log` VALUES ('1418472169919291394', '用户管理', '5', 'top.plgxs.admin.controller.sys.SysUserController.export()', 'GET', '1', 'admin', '/sysUser/export', '0:0:0:0:0:0:0:1', '', '{\"deptId\":[\"\"],\"name\":[\"\"]}', '', '1', 'java.lang.NoClassDefFoundError: org/apache/poi/POIXMLTypeLoader', '2021-07-23 15:24:54');
INSERT INTO `t_sys_oper_log` VALUES ('1418475556626866178', '用户管理', '5', 'top.plgxs.admin.controller.sys.SysUserController.export()', 'GET', '1', 'admin', '/sysUser/export', '0:0:0:0:0:0:0:1', '', '{\"deptId\":[\"\"],\"name\":[\"\"]}', '', '1', 'Convert data:2 error,at row:1', '2021-07-23 15:38:21');
INSERT INTO `t_sys_oper_log` VALUES ('1418476731178786817', '用户管理', '5', 'top.plgxs.admin.controller.sys.SysUserController.export()', 'GET', '1', 'admin', '/sysUser/export', '0:0:0:0:0:0:0:1', '', '{\"deptId\":[\"\"],\"name\":[\"\"]}', '', '1', 'Convert data:2 error,at row:1', '2021-07-23 15:43:01');
INSERT INTO `t_sys_oper_log` VALUES ('1418479476732346370', '用户管理', '5', 'top.plgxs.admin.controller.sys.SysUserController.export()', 'GET', '1', 'admin', '/sysUser/export', '0:0:0:0:0:0:0:1', '', '{\"deptId\":[\"\"],\"name\":[\"\"]}', '', '1', 'Convert data:2 error,at row:1', '2021-07-23 15:53:56');
INSERT INTO `t_sys_oper_log` VALUES ('1418482266003283970', '用户管理', '5', 'top.plgxs.admin.controller.sys.SysUserController.export()', 'GET', '1', 'admin', '/sysUser/export', '0:0:0:0:0:0:0:1', '', '{\"deptId\":[\"\"],\"name\":[\"\"]}', '', '1', 'Convert data:2 error,at row:1', '2021-07-23 16:05:01');
INSERT INTO `t_sys_oper_log` VALUES ('1418483136740831233', '用户管理', '5', 'top.plgxs.admin.controller.sys.SysUserController.export()', 'GET', '1', 'admin', '/sysUser/export', '0:0:0:0:0:0:0:1', '', '{\"deptId\":[\"\"],\"name\":[\"\"]}', '', '1', 'Can not find \'Converter\' support class LocalDateTime.', '2021-07-23 16:08:29');
INSERT INTO `t_sys_oper_log` VALUES ('1418483839265767425', '用户管理', '5', 'top.plgxs.admin.controller.sys.SysUserController.export()', 'GET', '1', 'admin', '/sysUser/export', '0:0:0:0:0:0:0:1', '', '{\"deptId\":[\"\"],\"name\":[\"\"]}', '', '0', '', '2021-07-23 16:11:16');
INSERT INTO `t_sys_oper_log` VALUES ('1418523003591954434', '用户管理', '5', 'top.plgxs.admin.controller.sys.SysUserController.export()', 'GET', '1', 'admin', '/sysUser/export', '0:0:0:0:0:0:0:1', '', '{\"deptId\":[\"\"],\"name\":[\"\"]}', '', '0', '', '2021-07-23 18:46:54');
INSERT INTO `t_sys_oper_log` VALUES ('1418524547855007746', '用户管理', '5', 'top.plgxs.admin.controller.sys.SysUserController.export()', 'GET', '1', 'admin', '/sysUser/export', '0:0:0:0:0:0:0:1', '', '{\"deptId\":[\"\"],\"name\":[\"\"]}', '', '0', '', '2021-07-23 18:53:02');
INSERT INTO `t_sys_oper_log` VALUES ('1418870137038053378', '用户管理', '5', 'top.plgxs.admin.controller.sys.SysUserController.export()', 'GET', '1', 'admin', '/sysUser/export', '0:0:0:0:0:0:0:1', '', '{\"deptId\":[\"\"],\"name\":[\"\"]}', '', '1', '\r\n### Error querying database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Column \'is_deleted\' in where clause is ambiguous\r\n### The error may exist in file [C:\\Users\\Strangers\\IdeaProjects\\aster\\aster-mbg\\target\\classes\\mapper\\sys\\SysUserMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: select             u.id, u.username, u.nickname, u.mobile, u.email, u.status,             u.gmt_create as `gmtCreate`, d.dept_name as `deptName`,             u.gender, u.realname, u.id_number as `idNumber`         from t_sys_user u         left join t_sys_dept d on u.dept_id = d.id         WHERE (is_deleted = ?) ORDER BY gmt_create DESC\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Column \'is_deleted\' in where clause is ambiguous\n; Column \'is_deleted\' in where clause is ambiguous; nested exception is java.sql.SQLIntegrityConstraintViolationException: Column \'is_deleted\' in where clause is ambiguous', '2021-07-24 17:46:17');
INSERT INTO `t_sys_oper_log` VALUES ('1418870680317861890', '用户管理', '5', 'top.plgxs.admin.controller.sys.SysUserController.export()', 'GET', '1', 'admin', '/sysUser/export', '0:0:0:0:0:0:0:1', '', '{\"deptId\":[\"\"],\"name\":[\"\"]}', '', '0', '', '2021-07-24 17:48:26');
INSERT INTO `t_sys_oper_log` VALUES ('1418871248637665281', '用户管理', '5', 'top.plgxs.admin.controller.sys.SysUserController.export()', 'GET', '1', 'admin', '/sysUser/export', '0:0:0:0:0:0:0:1', '', '{\"deptId\":[\"\"],\"name\":[\"\"]}', '', '0', '', '2021-07-24 17:50:42');
INSERT INTO `t_sys_oper_log` VALUES ('1419548734279122946', '菜单管理', '1', 'top.plgxs.admin.controller.sys.SysMenuController.insert()', 'POST', '1', 'admin', '/sysMenu/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1627281766813}', '0', '', '2021-07-26 14:42:47');
INSERT INTO `t_sys_oper_log` VALUES ('1419548831826051073', '菜单管理', '2', 'top.plgxs.admin.controller.sys.SysMenuController.update()', 'POST', '1', 'admin', '/sysMenu/update/data', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1627281790104}', '0', '', '2021-07-26 14:43:10');
INSERT INTO `t_sys_oper_log` VALUES ('1419575953227632642', '系统配置', '2', 'top.plgxs.admin.controller.sys.SysConfigController.switchTheme()', 'POST', '1', 'admin', '/sysConfig/switchTheme/3', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"切换主题\",\"code\":200,\"success\":true,\"timestamp\":1627288256320}', '0', '', '2021-07-26 16:30:56');
INSERT INTO `t_sys_oper_log` VALUES ('1422446641680490497', '菜单管理', '1', 'top.plgxs.admin.controller.sys.SysMenuController.insert()', 'POST', '1', 'admin', '/sysMenu/insert', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1627972681784}', '0', '', '2021-08-03 14:38:02');
INSERT INTO `t_sys_oper_log` VALUES ('1422446765500538881', '菜单管理', '2', 'top.plgxs.admin.controller.sys.SysMenuController.update()', 'POST', '1', 'admin', '/sysMenu/update/sharding', '0:0:0:0:0:0:0:1', '', '', '{\"msg\":\"操作成功\",\"code\":200,\"success\":true,\"timestamp\":1627972711334}', '0', '', '2021-08-03 14:38:31');

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
INSERT INTO `t_sys_position` VALUES ('1356407538382442498', '码农', 'programmer', '4', '2021-02-02 09:02:13', '2021-06-25 16:55:18', '0', '0', '');

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
INSERT INTO `t_sys_role` VALUES ('1', 'admin', 'super_admin', '1', null, '2021-06-25 15:14:11', '0', '0', '超级管理员');
INSERT INTO `t_sys_role` VALUES ('4be20af409d741bfb9a855e0ed88234a', '项目组长', 'corp_group_leader', '9', null, null, '0', '0', '');
INSERT INTO `t_sys_role` VALUES ('848f167a379a4185908416627f5ac710', '读者', 'user_reader', '10', null, '2019-03-12 10:02:06', '0', '0', null);
INSERT INTO `t_sys_role` VALUES ('95942830b50346ecadb339cd915750e1', '部门经理', 'corp_manager', '7', null, null, '0', '0', '');
INSERT INTO `t_sys_role` VALUES ('a6068ae9cd97464fb5ff1a7bd4f7394d', '普通员工', 'corp_user', '10', null, null, '0', '0', '');
INSERT INTO `t_sys_role` VALUES ('ae8b1c470c124de39ef67d3d742c820b', '部门副经理', 'corp_assistant_manager', '8', null, '2019-03-12 10:28:09', '0', '0', '');
INSERT INTO `t_sys_role` VALUES ('b497f2d107bf44d09a64631de2ebe84f', '文字编辑', 'text_editor', '9', null, '2019-03-12 10:21:56', '0', '0', '文字编辑');
INSERT INTO `t_sys_role` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '普通管理员', 'sys_admin', '2', null, '2021-06-25 16:55:24', '0', '0', '');
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
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '111812b068ed11ebbe2c74e6e24360ef');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1358324972823744514');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1358325509623353346');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364788142161432577');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364805178648297474');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364805353974398978');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364805482160717825');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364805605003493378');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364806273512636417');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364806385026596865');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364806502798458881');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364806604938149890');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364806722034728961');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364806859532402690');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364807152957521921');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364807262709874690');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364807448521736194');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364807590075301890');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364807696040198145');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364807825627414530');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364807952450584577');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364808074987175938');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364808191555272705');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '1364808343556849665');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '2b689fa768eb11ebbe2c74e6e24360ef');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '48b617c368eb11ebbe2c74e6e24360ef');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '5859134468eb11ebbe2c74e6e24360ef');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', '94f51875631211ebb3b600ff633443b0');
INSERT INTO `t_sys_role_menu` VALUES ('b4e2c5987e0f4d438d86f3887196596b', 'b7bf613a631011ebb3b600ff633443b0');

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `dept_id` varchar(32) DEFAULT NULL COMMENT '部门id',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '密钥',
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
INSERT INTO `t_sys_user` VALUES ('1', null, 'admin', '93d3cb7d5b9c75bd24a0942050aec835', '20382d', '17600007587', 'admin@163.com', null, 'F', null, null, null, null, null, null, null, '2021-06-07 21:36:33', '2021-07-24 17:51:13', '0', '0');
INSERT INTO `t_sys_user` VALUES ('2', '1408326537388834817', 'stranger', 'c9a03944d7f12619ba5a82ced1b919d4', '1df0ee', '11111111111', '111111@111.com', 'stranger', 'M', '', '', '', null, null, null, null, '2021-06-07 22:25:52', '2021-07-23 14:09:45', '0', '0');

-- ----------------------------
-- Table structure for t_sys_user_position
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_position`;
CREATE TABLE `t_sys_user_position` (
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `position_id` varchar(32) NOT NULL COMMENT '职位ID',
  PRIMARY KEY (`user_id`,`position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户职位';

-- ----------------------------
-- Records of t_sys_user_position
-- ----------------------------
INSERT INTO `t_sys_user_position` VALUES ('1408330346634756098', '1356407538382442498');
INSERT INTO `t_sys_user_position` VALUES ('2', '1356405705857470465');

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
INSERT INTO `t_sys_user_role` VALUES ('1', '1');
INSERT INTO `t_sys_user_role` VALUES ('1408330346634756098', 'b4e2c5987e0f4d438d86f3887196596b');
INSERT INTO `t_sys_user_role` VALUES ('2', '1');
