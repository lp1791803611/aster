CREATE TABLE `t_sys_user` (
  `id` varchar(32) NOT NULL COMMENT '主键uuid',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码md5',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `gender` int(1) DEFAULT '0' COMMENT '性别，0-保密，1-男，2-女',
  `realname` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `id_number` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `head_url` varchar(255) DEFAULT NULL COMMENT '头像url',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `login_number` bigint(11) DEFAULT NULL COMMENT '登录次数',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` varchar(1) DEFAULT '0' COMMENT '状态，1-冻结，0-正常',
  `mobile_verification_code` varchar(10) DEFAULT NULL COMMENT '手机验证码',
  `email_verification_code` varchar(10) DEFAULT NULL COMMENT '邮箱验证码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

