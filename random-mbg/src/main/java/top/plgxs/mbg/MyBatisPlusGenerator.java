package top.plgxs.mbg;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * mybatis-plus generator自动生成代码
 * @author Stranger。
 * @date 2020/12/22
 */
public class MyBatisPlusGenerator {
    /**
     * 数据库类型
     */
    private DbType dbType = DbType.MYSQL;

    /**
     * 数据库连接信息
     */
    private String dbUrl = "jdbc:mysql://localhost:3306/random?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=GMT%2b8";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String userName = "random";
    private String password = "random";

    /**
     * 指定生成的表名。如果想生成整个库的，这里设为null即可
     */
    /*private String[] tableNames = new String[]{
            "tb_resource",
            "t_order"
    };*/


    private String[] tableNames = new String[]{
    };

    /**
     * 输出路径（当前为项目根目录下）
     * 例如：F:\ideaProject\random
     */
    private String outputDir = System.getProperty("user.dir");

    /**
     * 公共包名
     */
    private String packageName = "top.plgxs";

    /**
     * 公共包名路径
     */
    private String packagePath = "/top/plgxs";

    /**
     * 实体分类存放，如以sys_开头的表统一放在sys包下
     */
    private String commonPackageName = "sys";

    /**
     * controller基础类
     */
    private String superControllerClass = packageName + ".common.BaseController";

    /**
     * entity基础类
     */
    private String superEntityClass = packageName + ".common.BaseEntity";

    /**
     * mbg模块包名
     */
    private String mbgPackageName = packageName + ".mbg";

    /**
     * mbg模块路径
     */
    private String mbgModulePath = "/random-mbg";

    /**
     * mbg模块的包名路径
     */
    private String mbgModulePackagePath = packagePath + "/mbg";

    /**
     * admin模块包名
     */
    private String adminPackageName = packageName + ".admin";

    /**
     * admin模块路径
     */
    private String adminModulePath = "/random-admin";

    /**
     * admin模块的包名路径
     */
    private String adminModulePackagePath = packagePath + "/admin";

    /**
     * 作者名
     */
    private String author = "Stranger。";

    /**
     * 逻辑删除属性名称,数据库表中的
     * 0-正常，1-逻辑删除
     */
    private String deleteFieldName = "status";

    /**
     * 生成代码的调用方法
     */
    public void generateCode() {
        generateByTables(tableNames);
    }

    /**
     * 根据表自动生成
     *
     * @param tableNames 表名
     */
    private void generateByTables(String... tableNames) {
        //配置数据源
        DataSourceConfig dataSourceConfig = getDataSourceConfig();
        // 策略配置
        StrategyConfig strategyConfig = getStrategyConfig(tableNames);
        //全局变量配置
        GlobalConfig globalConfig = getGlobalConfig();
        //包名配置
        PackageConfig packageConfig = getPackageConfig();
        //自主配置
        InjectionConfig injectionConfig = getInjectionConfig();
        //自动生成
        atuoGenerator(dataSourceConfig, strategyConfig, globalConfig, packageConfig,injectionConfig);
    }

    /**
     * 集成
     *
     * @param dataSourceConfig 配置数据源
     * @param strategyConfig   策略配置
     * @param config           全局变量配置
     * @param packageConfig    包名配置
     */
    private void atuoGenerator(DataSourceConfig dataSourceConfig, StrategyConfig strategyConfig,
                               GlobalConfig config, PackageConfig packageConfig, InjectionConfig injectionConfig) {
        TemplateConfig tc = new TemplateConfig();

        // 配置自定义输出模板
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        String templatePathController = "/templates/controller.java";
        String templatePathService = "/templates/service.java";
        String templatePathServiceImpl = "/templates/serviceImpl.java";
        String templatePathEntity = "/templates/entity.java";
        String templatePathMapper = "/templates/mapper.java";
        String templatePathMapperXML = "/templates/mapper.xml";

        tc.setController(templatePathController);
        tc.setService(templatePathService);
        tc.setServiceImpl(templatePathServiceImpl);
        tc.setEntity(templatePathEntity);
        tc.setMapper(templatePathMapper);
        tc.setXml(templatePathMapperXML);

        new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setTemplateEngine(new FreemarkerTemplateEngine())
                //.setTemplateEngine(new VelocityTemplateEngine()).setTemplate(tc)
                .setCfg(injectionConfig)
                .execute();
    }

    /**
     * 设置包名
     *
     * @return PackageConfig 包名配置
     */
    private PackageConfig getPackageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null); //模块名
        pc.setParent(null); //具体包,类似：top.plgxs
        //entity mapper层统一放在mbg模块下
        HashMap<String, String> pathMap = CollectionUtils.newHashMapWithExpectedSize(6);
        pathMap.put(ConstVal.ENTITY_PATH, outputDir + mbgModulePath + "/src/main/java" +
                mbgModulePackagePath + "/entity/" + commonPackageName);

        pathMap.put(ConstVal.MAPPER_PATH, outputDir + mbgModulePath + "/src/main/java" +
                mbgModulePackagePath + "/mapper/" + commonPackageName);

        pathMap.put(ConstVal.XML_PATH, outputDir + mbgModulePath + "/src/main/resources/mapper/"+commonPackageName);

        //controller service impl放在其他模块
        pathMap.put(ConstVal.CONTROLLER_PATH, outputDir + adminModulePath + "/src/main/java" +
                adminModulePackagePath + "/controller/" + commonPackageName);


        pathMap.put(ConstVal.SERVICE_PATH, outputDir + adminModulePath + "/src/main/java" +
                adminModulePackagePath + "/service/" + commonPackageName);

        pathMap.put(ConstVal.SERVICE_IMPL_PATH, outputDir + adminModulePath + "/src/main/java" +
                adminModulePackagePath + "/service/impl/" + commonPackageName);

        pc.setPathInfo(pathMap);
        return pc;
    }

    /**
     * 全局配置
     *
     * @return GlobalConfig
     */
    private GlobalConfig getGlobalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig
                // 开启swagger
                .setSwagger2(true)
                .setActiveRecord(true)
                .setBaseColumnList(true)
                .setBaseResultMap(true)
                //作者
                .setAuthor(author)
                //设置输出路径
                .setOutputDir(outputDir)
                //是否覆盖已有文件
                .setFileOverride(true);

        // 自定义命名方式
        globalConfig.setEntityName("%s");
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");

        return globalConfig;
    }

    /**
     * 策略配置
     *
     * @param tableNames 表名
     * @return StrategyConfig
     */
    private StrategyConfig getStrategyConfig(String... tableNames) {
        StrategyConfig strategy = new StrategyConfig();
        //从数据库表到文件的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel)
                // 表前缀
                .setTablePrefix(new String[] {"t_","T_"})
                // rest风格
                .setRestControllerStyle(false)
                // 字段注解
                .setEntityTableFieldAnnotationEnable(true)
                // 使用lombok
                .setEntityLombokModel(true)
                // 需要生成的的表名，多个表名传数组
                .setInclude(tableNames)
                // 生成序列号
                .setEntitySerialVersionUID(true)
                // 逻辑删除属性名称
                .setLogicDeleteFieldName(deleteFieldName)
                // 驼峰转连字符,用于controller的RequestMapping。例如: 表名sys_user，为true则转为sys-user，
                .setControllerMappingHyphenStyle(false);

        // 自定义实体父类
        // strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "create_time", "create_username" });
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 还有自定义service/mapper等
        return strategy;
    }

    /**
     * 配置数据源
     *
     * @return 数据源配置 DataSourceConfig
     */
    private DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig().setDbType(dbType)
                .setUrl(dbUrl)
                .setUsername(userName)
                .setPassword(password)
                .setDriverName(driver);
    }

    // 自定义配置
    private InjectionConfig getInjectionConfig(){
        InjectionConfig cfg = new InjectionConfig() {
            //自定义属性注入:abc
            //在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                // 实体类的package
                map.put("customEntityPackage", mbgPackageName
                        + ".entity." + commonPackageName);
                // mapper的package
                map.put("customMapperPackage", mbgPackageName
                        + ".mapper." + commonPackageName);
                // controller的package
                map.put("customControllerPackage", adminPackageName
                        + ".controller." + commonPackageName);
                // service的package
                map.put("customServicePackage", adminPackageName
                        + ".service." + commonPackageName);
                // serviceimpl的package
                map.put("customServiceImplPackage", adminPackageName
                        + ".service.impl." + commonPackageName);

                this.setMap(map);
            }
        };
        return cfg;
    }

    // 执行main方法自动生成代码
    public static void main(String[] args) {
        new MyBatisPlusGenerator().generateCode();
    }
}
