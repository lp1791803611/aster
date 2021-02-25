package top.plgxs.mbg;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import top.plgxs.mbg.config.MybatisPlusConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * mybatis-plus generator自动生成代码
 * @author Stranger。
 * @date 2020/12/22
 */
public class MyBatisPlusGenerator {
    // 执行main方法自动生成代码
    public static void main(String[] args) {
        new MyBatisPlusGenerator().generate();
    }

    /**
     * 生成代码的调用方法
     */
    private void generate() {
        //配置数据源
        DataSourceConfig dataSourceConfig = getDataSourceConfig();
        // 策略配置
        StrategyConfig strategyConfig = getStrategyConfig();
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
     * 配置数据源
     * @return 数据源配置 DataSourceConfig
     */
    private DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig().setDbType(MybatisPlusConfig.DB_TYPE)
                .setUrl(MybatisPlusConfig.DB_URL)
                .setUsername(MybatisPlusConfig.DB_USERNAME)
                .setPassword(MybatisPlusConfig.DB_PASSWORD)
                .setDriverName(MybatisPlusConfig.DB_DRIVER);
    }

    /**
     * 策略配置
     * @return StrategyConfig
     */
    private StrategyConfig getStrategyConfig() {
        StrategyConfig strategy = new StrategyConfig();
        //从数据库表到文件的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel)
                // 表前缀
                .setTablePrefix(MybatisPlusConfig.STRATEGY_TABLE_PREFIX)
                // rest风格
                .setRestControllerStyle(MybatisPlusConfig.STRATEGY_REST_CONTROLLER)
                // 字段注解
                .setEntityTableFieldAnnotationEnable(MybatisPlusConfig.STRATEGY_FIELD_ANNOTATION)
                // 使用lombok
                .setEntityLombokModel(MybatisPlusConfig.STRATEGY_LOMBOK)
                // 需要生成的的表名，多个表名传数组
                .setInclude(MybatisPlusConfig.STRATEGY_TABLE_NAMES)
                // 生成序列号
                .setEntitySerialVersionUID(MybatisPlusConfig.STRATEGY_VERSION_UID)
                // 逻辑删除属性名称
                .setLogicDeleteFieldName(MybatisPlusConfig.STRATEGY_LOGIC_DELETE_FIELD_NAME)
                // 驼峰转连字符,用于controller的RequestMapping。例如: 表名sys_user，为true则转为sys-user，
                .setControllerMappingHyphenStyle(MybatisPlusConfig.STRATEGY_CONTROLLER_MAPPING_HYPHEN_STYLE);
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
     * 全局配置
     *
     * @return GlobalConfig
     */
    private GlobalConfig getGlobalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig
                // 开启swagger
                .setSwagger2(MybatisPlusConfig.SWAGGER2)
                .setActiveRecord(true)
                .setBaseColumnList(true)
                .setBaseResultMap(true)
                //作者
                .setAuthor(MybatisPlusConfig.AUTHOR)
                //设置输出路径
                .setOutputDir(MybatisPlusConfig.OUTPUTDIR)
                //是否覆盖已有文件
                .setFileOverride(MybatisPlusConfig.FILE_OVERRIDE);

        // 自定义命名方式
        globalConfig.setEntityName(MybatisPlusConfig.GLOBAL_ENTITY_NAME);
        globalConfig.setMapperName(MybatisPlusConfig.GLOBAL_MAPPER_NAME);
        globalConfig.setXmlName(MybatisPlusConfig.GLOBAL_XML_NAME);
        if(MybatisPlusConfig.CUSTOM_GENERATOR_CONTROLLER){
            globalConfig.setControllerName(MybatisPlusConfig.GLOBAL_CONTROLLER_NAME);
        }
        if (MybatisPlusConfig.CUSTOM_GENERATOR_SERVICE) {
            globalConfig.setServiceName(MybatisPlusConfig.GLOBAL_SERVICE_NAME);
            globalConfig.setServiceImplName(MybatisPlusConfig.GLOBAL_SERVICEIMPL_NAME);
        }
        return globalConfig;
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
        pathMap.put(ConstVal.ENTITY_PATH, MybatisPlusConfig.PACKAGE_ENTITY);
        pathMap.put(ConstVal.MAPPER_PATH, MybatisPlusConfig.PACKAGE_MAPPER);
        pathMap.put(ConstVal.XML_PATH, MybatisPlusConfig.PACKAGE_MAPPER_XML);
        //controller service impl放在其他模块
        if(MybatisPlusConfig.CUSTOM_GENERATOR_CONTROLLER){
            pathMap.put(ConstVal.CONTROLLER_PATH, MybatisPlusConfig.PACKAGE_CONTROLLER);
        }
        if (MybatisPlusConfig.CUSTOM_GENERATOR_SERVICE) {
            pathMap.put(ConstVal.SERVICE_PATH, MybatisPlusConfig.PACKAGE_SERVICE);
            pathMap.put(ConstVal.SERVICE_IMPL_PATH, MybatisPlusConfig.PACKAGE_SERVICE_IMPL);
        }
        pc.setPathInfo(pathMap);
        return pc;
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
                map.put("customEntityPackage", MybatisPlusConfig.CUSTOM_ENTITY_PACKAGE);
                // mapper的package
                map.put("customMapperPackage", MybatisPlusConfig.CUSTOM_MAPPER_PACKAGE);
                // 表名前缀sys
                map.put("customTableName",MybatisPlusConfig.PACKAGE_COMMON_NAME);
                if(MybatisPlusConfig.CUSTOM_GENERATOR_CONTROLLER){
                    // controller的package
                    map.put("customControllerPackage", MybatisPlusConfig.CUSTOM_CONTROLLER_PACKAGE);
                }
                if (MybatisPlusConfig.CUSTOM_GENERATOR_SERVICE) {
                    // service的package
                    map.put("customServicePackage", MybatisPlusConfig.CUSTOM_SERVICE_PACKAGE);
                    // serviceimpl的package
                    map.put("customServiceImplPackage", MybatisPlusConfig.CUSTOM_SERVICE_IMPL_PACKAGE);
                }
                map.put("swagger", MybatisPlusConfig.SWAGGER2);
                this.setMap(map);
            }
        };
        // 自定义输出配置
        if(MybatisPlusConfig.CUSTOM_HTML_TEMPLATE){
            List<FileOutConfig> focList = new ArrayList<>();
            // 自定义配置会被优先输出
            focList.add(new FileOutConfig(MybatisPlusConfig.CUSTOM_LIST_TEMPLATE + ".ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    // 去除前缀，首字母小写，例如SysUser转换后为user
                    String name =  StrUtil.lowerFirst(StrUtil.removePrefixIgnoreCase(tableInfo.getEntityName(),MybatisPlusConfig.PACKAGE_COMMON_NAME));
                    return MybatisPlusConfig.CUSTOM_HTML_OUTPUT + name + "/list.html";
                }
            });
            focList.add(new FileOutConfig(MybatisPlusConfig.CUSTOM_ADD_TEMPLATE + ".ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    String name =  StrUtil.lowerFirst(StrUtil.removePrefixIgnoreCase(tableInfo.getEntityName(),MybatisPlusConfig.PACKAGE_COMMON_NAME));
                    return MybatisPlusConfig.CUSTOM_HTML_OUTPUT + name + "/add.html";
                }
            });
            focList.add(new FileOutConfig(MybatisPlusConfig.CUSTOM_EDIT_TEMPLATE + ".ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    String name =  StrUtil.lowerFirst(StrUtil.removePrefixIgnoreCase(tableInfo.getEntityName(),MybatisPlusConfig.PACKAGE_COMMON_NAME));
                    return MybatisPlusConfig.CUSTOM_HTML_OUTPUT + name + "/edit.html";
                }
            });
            cfg.setFileOutConfigList(focList);
        }
        return cfg;
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
        tc.setEntity(MybatisPlusConfig.TEMPLATE_ENTITY);
        tc.setMapper(MybatisPlusConfig.TEMPLATE_MAPPER);
        tc.setXml(MybatisPlusConfig.TEMPLATE_MAPPER_XML);
        if(MybatisPlusConfig.CUSTOM_GENERATOR_CONTROLLER){
            tc.setController(MybatisPlusConfig.TEMPLATE_CONTROLLER);
        }
        if (MybatisPlusConfig.CUSTOM_GENERATOR_SERVICE) {
            tc.setService(MybatisPlusConfig.TEMPLATE_SERVICE);
            tc.setServiceImpl(MybatisPlusConfig.TEMPLATE_SERVICE_IMPL);
        }
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
}
