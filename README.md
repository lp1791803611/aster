# aster

#### 项目说明
aster项目是基于SpringBoot的快速开发框架。
* 管理端采用SpringBoot2.x,MyBatis-plus,shiro,redis,layui等框架开发的一套RBAC权限管理系统，前后端不分离。
* 支持使用代码生成器快速生成前后端代码，只需编写小部分代码，就能实现基础功能。
* 

#### 已完成部分： 
1. 整合mybatis-plus及mybatis-plus-generator
3. 整合thymeleaf+layui+layuimini
4. 整合swagger2
5. 整合redis
6. 整合shiro、shiro-redis
7. 整合Spring Security&JWT
8. 全局统一异常处理

#### 软件架构
|  | 软件架构 | 版本|
|----|----|----|
| 核心框架 | Spring Boot | 2.4.0 |
| 持久层框架 | Mybatis Plus | 3.4.0 |
| API端安全框架 | Spring Security&JWT | 0.9.0 |
| 管理端安全框架 | Shiro | 1.6.0 |
| 缓存框架 | Redis |  |
| 数据库连接池 | 阿里巴巴Druid | 1.2.3 |
| 接口文档 | Swagger-ui | 2.9.2 |
| 日志打印 | logback | |
| 简化代码 | lombok | |
| 工具 | hutool | 5.4.0 |
| 前端框架 | Thymeleaf & layui | 2.5.5 |
| 前端模板 | layuimini-iframe | |

#### 功能模块
| 模块名称 | 描述 |  |
|----|----|----|
| 用户管理 | 系统用户配置、角色分配，可按部门展示  | 已完成 |  
| 角色管理 | 系统角色配置、菜单权限分配  | 已完成 | 
| 菜单管理 | 系统菜单配置、设置菜单按钮的操作权限，树形展示  | 已完成 | 
| 部门管理 | 配置系统组织机构，父子结构展示  | 已完成 | 
| 岗位管理 | 配置系统用户所属担任职务  | 已完成 | 
| 字典管理 | 对系统中经常使用的一些较为固定的数据进行维护 | 已完成 | 
| 参数设置 | 系统参数设置，如初始密码、默认主题等 | 已完成 | 
| 通知公告 | 系统通知公告信息发布维护 | 完成50% | 
| 在线用户 | 系统中活跃用户状态监控，可强退 | 已完成 | 
| 访问日志 | 记录用户登录退出操作，包含异常信息 | 已完成 | 
| 操作日志 | 记录用户操作详情 | 已完成 | 
| 服务监控 | 监控服务器的负载情况，包括CPU、内存、磁盘等 | 已完成 | 
| 代码生成 | 高灵活配置生成前后端代码(java/xml/html) | 已完成 | 


#### 开发环境
* JDK 1.8
* IntelliJ IDEA 2017+
* Mysql 5.7+
* Maven 3.6.0 

#### 使用说明
管理端：
1.  clone到idea中
2.  修改application-local.yml的jdbc信息（doc下有sql文件）
3.  启动AsterAdminApplication.java
4.  浏览器输入http://localhost:8080/index
5.  用户名：admin，密码：123456

#### 博客文档

CSDN博客，用来记录项目的搭建过程
https://blog.csdn.net/lp1791803611/category_10672278.html 
