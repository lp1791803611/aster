package top.plgxs.mbg.utils;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import top.plgxs.common.core.constants.enums.IsNotEnum;
import top.plgxs.mbg.config.MybatisPlusConfig;
import top.plgxs.mbg.dto.gen.TableBasic;
import top.plgxs.mbg.dto.gen.TableColumn;
import top.plgxs.mbg.dto.gen.TableOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/8 21:21
 */
public class GenUtils {
    /**
     * 配置数据源
     *
     * @param basic 基础信息
     * @return 数据源配置 DataSourceConfig
     * @author Stranger。
     * @since 2021/7/8
     */
    public static DataSourceConfig getDataSourceConfig(TableBasic basic) {
        return new DataSourceConfig().setDbType(DbType.getDbType(basic.getDbType()))
                .setUrl(basic.getDbUrl())
                .setUsername(basic.getDbUsername())
                .setPassword(basic.getDbPassword())
                .setDriverName(basic.getDbDriver());
    }

    /**
     * 策略配置
     *
     * @param basic 基础信息
     * @return StrategyConfig
     * @author Stranger。
     * @since 2021/7/8
     */
    public static StrategyConfig getStrategyConfig(TableBasic basic) {
        StrategyConfig strategy = new StrategyConfig();
        //从数据库表到文件的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel)
                // 表前缀
                .setTablePrefix(basic.getTablePrefix())
                // rest风格
                .setRestControllerStyle(MybatisPlusConfig.STRATEGY_REST_CONTROLLER)
                // 字段注解
                .setEntityTableFieldAnnotationEnable(MybatisPlusConfig.STRATEGY_FIELD_ANNOTATION)
                // 使用lombok
                .setEntityLombokModel(MybatisPlusConfig.STRATEGY_LOMBOK)
                // 需要生成的的表名，多个表名传数组
                .setInclude(new String[]{basic.getTableName()})
                // 生成序列号
                .setEntitySerialVersionUID(MybatisPlusConfig.STRATEGY_VERSION_UID)
                // 逻辑删除属性名称
                .setLogicDeleteFieldName(basic.getDeleteColumn())
                // 驼峰转连字符,用于controller的RequestMapping。例如: 表名sys_user，为true则转为sys-user，
                .setControllerMappingHyphenStyle(MybatisPlusConfig.STRATEGY_CONTROLLER_MAPPING_HYPHEN_STYLE);
        return strategy;
    }

    /**
     * 全局配置
     *
     * @param basic     基础信息
     * @param outputdir 输出路径             如：D:/aster/outputdir
     * @return
     */
    public static GlobalConfig getGlobalConfig(TableBasic basic, String outputdir) {
        boolean fileOverride = StrUtil.isBlank(basic.getFileOverride()) ?
                true : IsNotEnum.IS.getCode().equals(basic.getFileOverride());

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig
                // 开启swagger
                .setSwagger2(MybatisPlusConfig.SWAGGER2)
                .setActiveRecord(true)
                .setBaseColumnList(true)
                .setBaseResultMap(true)
                //作者
                .setAuthor(basic.getAuthor())
                //设置输出路径
                .setOutputDir(outputdir)
                //是否覆盖已有文件
                .setFileOverride(fileOverride);

        // 自定义命名方式
        globalConfig.setEntityName(MybatisPlusConfig.GLOBAL_ENTITY_NAME);
        globalConfig.setMapperName(MybatisPlusConfig.GLOBAL_MAPPER_NAME);
        globalConfig.setXmlName(MybatisPlusConfig.GLOBAL_XML_NAME);
        if (IsNotEnum.IS.getCode().equals(basic.getIsController())) {
            globalConfig.setControllerName(MybatisPlusConfig.GLOBAL_CONTROLLER_NAME);
        }
        if (IsNotEnum.IS.getCode().equals(basic.getIsService())) {
            globalConfig.setServiceName(MybatisPlusConfig.GLOBAL_SERVICE_NAME);
            globalConfig.setServiceImplName(MybatisPlusConfig.GLOBAL_SERVICEIMPL_NAME);
        }
        return globalConfig;
    }

    /**
     * 设置包名
     *
     * @param basic  基础信息
     * @param output 生成信息
     * @return com.baomidou.mybatisplus.generator.config.PackageConfig
     * @author Stranger。
     * @since 2021/7/8
     */
    public static PackageConfig getPackageConfig(TableBasic basic, TableOutput output) {
        String outputdir = output.getOutputDir();

        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null); //模块名
        pc.setParent(null); //具体包,类似：top.plgxs
        HashMap<String, String> pathMap = CollectionUtils.newHashMapWithExpectedSize(6);
        // 如果文件放在同一模块下
        if (IsNotEnum.NOT.getCode().equals(output.getSeparate())) {
            String moduleName = output.getModuleName();
            String packageName = output.getPackageName().replace('.', '/');
            String businessName = output.getBusinessName();
            pathMap.put(ConstVal.ENTITY_PATH, outputdir + "/" + moduleName + "/src/main/java/" + packageName + "/entity/" + businessName);
            pathMap.put(ConstVal.MAPPER_PATH, outputdir + "/" + moduleName + "/src/main/java/" + packageName + "/mapper/" + businessName);
            pathMap.put(ConstVal.XML_PATH, outputdir + "/" + moduleName + "/src/main/resources/mapper/" + businessName);
            if (IsNotEnum.IS.getCode().equals(basic.getIsController())) {
                pathMap.put(ConstVal.CONTROLLER_PATH, outputdir + "/" + moduleName + "/src/main/java/" + packageName + "/controller/" + businessName);
            }
            if (IsNotEnum.IS.getCode().equals(basic.getIsService())) {
                pathMap.put(ConstVal.SERVICE_PATH, outputdir + "/" + moduleName + "/src/main/java/" + packageName + "/service/" + businessName);
                pathMap.put(ConstVal.SERVICE_IMPL_PATH, outputdir + "/" + moduleName + "/src/main/java/" + packageName + "/service/impl/" + businessName);
            }
        } else {
            // 如果文件分开放在不同模块下
            pathMap.put(ConstVal.ENTITY_PATH, outputdir + "/" + output.getEntityModuleName() + "/src/main/java/" + output.getEntityPackageName().replace('.', '/') + "/entity/" + output.getEntityBusinessName());
            pathMap.put(ConstVal.MAPPER_PATH, outputdir + "/" + output.getMapperModuleName() + "/src/main/java/" + output.getMapperPackageName().replace('.', '/') + "/mapper/" + output.getMapperBusinessName());
            pathMap.put(ConstVal.XML_PATH, outputdir + "/" + output.getMapperModuleName() + "/src/main/resources/mapper/" + output.getMapperBusinessName());
            if (IsNotEnum.IS.getCode().equals(basic.getIsController())) {
                pathMap.put(ConstVal.CONTROLLER_PATH, outputdir + "/" + output.getControllerModuleName() + "/src/main/java/" + output.getControllerPackageName().replace('.', '/') + "/controller/" + output.getControllerBusinessName());
            }
            if (IsNotEnum.IS.getCode().equals(basic.getIsService())) {
                pathMap.put(ConstVal.SERVICE_PATH, outputdir + "/" + output.getServiceModuleName() + "/src/main/java/" + output.getServicePackageName().replace('.', '/') + "/service/" + output.getServiceBusinessName());
                pathMap.put(ConstVal.SERVICE_IMPL_PATH, outputdir + "/" + output.getServiceModuleName() + "/src/main/java/" + output.getServicePackageName().replace('.', '/') + "/service/impl/" + output.getServiceBusinessName());
            }
        }

        pc.setPathInfo(pathMap);
        return pc;
    }

    /**
     * 自定义配置
     *
     * @param basic   基础信息
     * @param output  生成信息
     * @param columns 字段信息
     * @return com.baomidou.mybatisplus.generator.InjectionConfig
     * @author Stranger。
     * @since 2021/7/8
     */
    public static InjectionConfig getInjectionConfig(TableBasic basic, TableOutput output, List<TableColumn> columns) {
        InjectionConfig cfg = new InjectionConfig() {
            //自定义属性注入:abc
            //在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                // 如果文件放在同一模块下
                if (IsNotEnum.NOT.getCode().equals(output.getSeparate())) {
                    String packageName = output.getPackageName();
                    String businessName = output.getBusinessName();

                    // 实体类的package
                    map.put("customEntityPackage", packageName + ".entity." + businessName);
                    // mapper的package
                    map.put("customMapperPackage", packageName + ".mapper." + businessName);
                    // 表名前缀sys
                    map.put("customTableName", businessName);
                    if (IsNotEnum.IS.getCode().equals(basic.getIsController())) {
                        // controller的package
                        map.put("customControllerPackage", packageName + ".controller." + businessName);
                    }
                    if (IsNotEnum.IS.getCode().equals(basic.getIsService())) {
                        // service的package
                        map.put("customServicePackage", packageName + ".service." + businessName);
                        // serviceimpl的package
                        map.put("customServiceImplPackage", packageName + ".service.impl." + businessName);
                    }
                } else {
                    // 如果文件分开放在不同模块下
                    // 实体类的package
                    map.put("customEntityPackage", output.getEntityPackageName() + ".entity." + output.getEntityBusinessName());
                    // mapper的package
                    map.put("customMapperPackage", output.getMapperPackageName() + ".mapper." + output.getMapperBusinessName());
                    // 表名前缀sys
                    map.put("customTableName", output.getControllerBusinessName());
                    if (IsNotEnum.IS.getCode().equals(basic.getIsController())) {
                        // controller的package
                        map.put("customControllerPackage", output.getControllerPackageName() + ".controller." + output.getControllerBusinessName());
                    }
                    if (IsNotEnum.IS.getCode().equals(basic.getIsService())) {
                        // service的package
                        map.put("customServicePackage", output.getServicePackageName() + ".service." + output.getServiceBusinessName());
                        // serviceimpl的package
                        map.put("customServiceImplPackage", output.getServicePackageName() + ".service.impl." + output.getServiceBusinessName());
                    }
                }

                map.put("swagger", MybatisPlusConfig.SWAGGER2);
                map.put("columns", columns);
                this.setMap(map);
            }
        };
        // 自定义输出配置
        if (IsNotEnum.IS.getCode().equals(basic.getIsHtml())) {
            String htmlOutputDir = output.getOutputDir() + "/" + (IsNotEnum.NOT.getCode().equals(output.getSeparate()) ? output.getModuleName() : output.getControllerModuleName()) + "/src/main/resources/templates/" + (IsNotEnum.NOT.getCode().equals(output.getSeparate()) ? output.getBusinessName() : output.getControllerBusinessName()) + "/";
            List<FileOutConfig> focList = new ArrayList<>();
            // 自定义配置会被优先输出
            focList.add(new FileOutConfig(MybatisPlusConfig.GEN_CUSTOM_LIST_TEMPLATE + ".ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    // 去除前缀，首字母小写，例如SysUser转换后为user
                    String name = StrUtil.lowerFirst(StrUtil.removePrefixIgnoreCase(tableInfo.getEntityName(), IsNotEnum.NOT.getCode().equals(output.getSeparate()) ? output.getBusinessName() : output.getControllerBusinessName()));
                    return htmlOutputDir + name + "/list.html";
                }
            });
            focList.add(new FileOutConfig(MybatisPlusConfig.GEN_CUSTOM_ADD_TEMPLATE + ".ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    String name = StrUtil.lowerFirst(StrUtil.removePrefixIgnoreCase(tableInfo.getEntityName(), output.getControllerBusinessName()));
                    return htmlOutputDir + name + "/add.html";
                }
            });
            focList.add(new FileOutConfig(MybatisPlusConfig.GEN_CUSTOM_EDIT_TEMPLATE + ".ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    String name = StrUtil.lowerFirst(StrUtil.removePrefixIgnoreCase(tableInfo.getEntityName(), output.getControllerBusinessName()));
                    return htmlOutputDir + name + "/edit.html";
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
    public static void atuoGenerator(DataSourceConfig dataSourceConfig, StrategyConfig strategyConfig,
                                     GlobalConfig config, PackageConfig packageConfig, InjectionConfig injectionConfig) {
        TemplateConfig tc = new TemplateConfig();
        tc.setEntity(MybatisPlusConfig.GEN_TEMPLATE_ENTITY);
        tc.setMapper(MybatisPlusConfig.GEN_TEMPLATE_MAPPER);
        tc.setXml(MybatisPlusConfig.GEN_TEMPLATE_MAPPER_XML);
        tc.setController(MybatisPlusConfig.GEN_TEMPLATE_CONTROLLER);
        tc.setService(MybatisPlusConfig.GEN_TEMPLATE_SERVICE);
        tc.setServiceImpl(MybatisPlusConfig.GEN_TEMPLATE_SERVICE_IMPL);
        new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setTemplate(tc)
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .setCfg(injectionConfig)
                .execute();
    }

    public static void generate(TableBasic basic, TableOutput output, List<TableColumn> columns) {
        //配置数据源
        DataSourceConfig dataSourceConfig = getDataSourceConfig(basic);
        // 策略配置
        StrategyConfig strategyConfig = getStrategyConfig(basic);
        //全局变量配置
        GlobalConfig globalConfig = getGlobalConfig(basic, output.getOutputDir());
        //包名配置
        PackageConfig packageConfig = getPackageConfig(basic, output);
        //自主配置
        InjectionConfig injectionConfig = getInjectionConfig(basic, output, columns);
        //自动生成
        atuoGenerator(dataSourceConfig, strategyConfig, globalConfig, packageConfig, injectionConfig);
    }
}
