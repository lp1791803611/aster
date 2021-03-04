# random

#### 项目说明
random项目是基于SpringBoot的快速开发框架。
* 管理端采用SpringBoot2.x,MyBatis-plus,Spring Security&JWT,redis,layui等框架开发的一套RBAC权限管理系统，前后端不分离。
* 支持使用代码生成器快速生成前后端代码，只需编写小部分代码，就能实现基础功能。
* 

#### 已完成部分： 
1. 集成mybatis-plus
2. 集成mybatis-plus-generator,可生成controller、service、serviceimpl、entity、mapper、xml和list.html、add.html、edit.html等文件。
3. 集成thymeleaf+layui+layuimini
4. 集成swagger2
5. 完成用户管理/角色管理/菜单管理/部门管理/岗位管理/字典管理
6. 集成redis

#### 软件架构
* 核心框架：Spring Boot 2.4.0
* 持久层框架：Mybatis Plus 3.4.0
* 安全框架：Spring Security&JWT 
* 缓存框架：Redis
* 数据库连接池：阿里巴巴Druid 1.2.3
* 接口文档：Swagger-ui 2.9.2
* 日志打印：logback
* 简化代码：lombok
* 工具：hutool 5.4.0
* 前端框架：Thymeleaf & layui 2.5.5 
* 前端模板：layuimini-iframe

#### 开发环境
* JDK 1.8
* IntelliJ IDEA 2017+
* Mysql 5.7+
* Maven 3.6.0 

#### 使用说明

1.  clone到idea中
2.  修改application-local.yml的jdbc信息（doc下有sql文件）
3.  启动RandomAdminApplication.java
4.  浏览器输入http://localhost:8080/random/index
5.  管理端用户名：admin，密码：123456

#### 博客文档

CSDN博客，用来记录项目的搭建过程
https://blog.csdn.net/lp1791803611/category_10672278.html 
