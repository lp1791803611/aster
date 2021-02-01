package top.plgxs.mbg.config;

import com.baomidou.mybatisplus.annotation.DbType;

/**
 * <p>mybatis-plus generator config</p>
 * @author Stranger。
 * @version 1.0
 * @since 2021/1/14 21:46
 */
public class MybatisPlusConfig {
    /**
     * 数据库连接信息
     */
    public static final DbType DB_TYPE = DbType.MYSQL;
    public static final String DB_URL = "jdbc:mysql://localhost:3306/random?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=GMT%2b8";
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_USERNAME = "random";
    public static final String DB_PASSWORD = "random";

    /**
     * 全局配置
     */
    // 设置文件名
    public static final String GLOBAL_ENTITY_NAME = "%s";
    public static final String GLOBAL_MAPPER_NAME = "%sMapper";
    public static final String GLOBAL_XML_NAME = "%sMapper";
    public static final String GLOBAL_SERVICE_NAME = "%sService";
    public static final String GLOBAL_SERVICEIMPL_NAME = "%sServiceImpl";
    public static final String GLOBAL_CONTROLLER_NAME = "%sController";
    // 作者名
    public static final String AUTHOR = "Stranger。";
    // 开启swagger
    public static final boolean SWAGGER2 = true;
    //设置输出路径
    public static final String OUTPUTDIR = System.getProperty("user.dir");
    //是否覆盖已有文件
    public static final boolean FILE_OVERRIDE = true;

    /**
     * 策略配置
     */
    // 表前缀
    public static final String[] STRATEGY_TABLE_PREFIX = new String[] {"t_","T_"};
    // rest风格
    public static final boolean STRATEGY_REST_CONTROLLER = false;
    // 字段注解
    public static final boolean STRATEGY_FIELD_ANNOTATION = true;
    // 使用lombok
    public static final boolean STRATEGY_LOMBOK = true;
    // 需要生成的的表名，多个表名传数组。如果想生成整个库的，这里设为null即可
    public static final String[] STRATEGY_TABLE_NAMES = new String[] {
//            "t_sys_user", "t_sys_role", "t_sys_menu",
//            "t_sys_dict","t_sys_dict_type",
//            "t_sys_position","t_sys_dept"
            "t_sys_position"
    };
    // 生成序列号
    public static final boolean STRATEGY_VERSION_UID = true;
    // 逻辑删除属性名称
    public static final String STRATEGY_LOGIC_DELETE_FIELD_NAME = "is_deleted";
    // 驼峰转连字符,用于controller的RequestMapping。例如: 表名sys_user，为true则转为sys-user，
    public static final boolean STRATEGY_CONTROLLER_MAPPING_HYPHEN_STYLE = false;

    /**
     * 设置包名
     */
    public static final String PACKAGE_COMMON_NAME = "sys";
    public static final String PACKAGE_ENTITY = OUTPUTDIR + "/random-mbg/src/main/java/top/plgxs/mbg/entity/"+PACKAGE_COMMON_NAME;
    public static final String PACKAGE_MAPPER = OUTPUTDIR + "/random-mbg/src/main/java/top/plgxs/mbg/mapper/"+PACKAGE_COMMON_NAME;
    public static final String PACKAGE_MAPPER_XML = OUTPUTDIR + "/random-mbg/src/main/resources/mapper/"+PACKAGE_COMMON_NAME;
    public static final String PACKAGE_CONTROLLER = OUTPUTDIR + "/random-admin/src/main/java/top/plgxs/admin/controller/"+PACKAGE_COMMON_NAME;
    public static final String PACKAGE_SERVICE = OUTPUTDIR + "/random-admin/src/main/java/top/plgxs/admin/service/"+PACKAGE_COMMON_NAME;
    public static final String PACKAGE_SERVICE_IMPL = OUTPUTDIR + "/random-admin/src/main/java/top/plgxs/admin/service/impl/"+PACKAGE_COMMON_NAME;

    /**
     * 配置自定义输出模板
     */
    //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
    public static final String TEMPLATE_CONTROLLER = "/templates/controller.java";
    public static final String TEMPLATE_SERVICE = "/templates/service.java";
    public static final String TEMPLATE_SERVICE_IMPL = "/templates/serviceImpl.java";
    public static final String TEMPLATE_ENTITY = "/templates/entity.java";
    public static final String TEMPLATE_MAPPER = "/templates/mapper.java";
    public static final String TEMPLATE_MAPPER_XML = "/templates/mapper.xml";

    // 配置ftl模板中的自定义属性
    public static final String CUSTOM_ENTITY_PACKAGE = "top.plgxs.mbg.entity."+PACKAGE_COMMON_NAME;
    public static final String CUSTOM_MAPPER_PACKAGE = "top.plgxs.mbg.mapper."+PACKAGE_COMMON_NAME;
    public static final String CUSTOM_CONTROLLER_PACKAGE = "top.plgxs.admin.controller."+PACKAGE_COMMON_NAME;
    public static final String CUSTOM_SERVICE_PACKAGE = "top.plgxs.admin.service."+PACKAGE_COMMON_NAME;
    public static final String CUSTOM_SERVICE_IMPL_PACKAGE = "top.plgxs.admin.service.impl."+PACKAGE_COMMON_NAME;

    // 配置list,add,edit自定义模板
    public static final Boolean CUSTOM_HTML_TEMPLATE = true;
    public static final String CUSTOM_LIST_TEMPLATE = "/templates/list.html";
    public static final String CUSTOM_ADD_TEMPLATE = "/templates/add.html";
    public static final String CUSTOM_EDIT_TEMPLATE = "/templates/edit.html";
    // list,add,edit自定义模板输出位置
    public static final String CUSTOM_HTML_OUTPUT = OUTPUTDIR + "/random-admin/src/main/resources/templates/" + PACKAGE_COMMON_NAME + "/";

}
