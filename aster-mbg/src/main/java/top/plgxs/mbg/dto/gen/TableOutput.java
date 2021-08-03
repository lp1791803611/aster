package top.plgxs.mbg.dto.gen;

import lombok.Data;

/**
 * 表输出信息
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/11 16:23
 */
@Data
public class TableOutput {
    /**
     * 输出路径
     */
    private String outputDir;

    /**
     * 是否将文件生成在不同模块下
     */
    private String separate;

    /**
     * 模块名
     */
    private String moduleName;
    /**
     * 包名
     */
    private String packageName;
    /**
     * 业务名
     */
    private String businessName;

    /**
     * controller模块名
     */
    private String controllerModuleName;

    /**
     * controller包名
     */
    private String controllerPackageName;

    /**
     * controller业务名
     */
    private String controllerBusinessName;

    /**
     * service模块名
     */
    private String serviceModuleName;

    /**
     * service包名
     */
    private String servicePackageName;

    /**
     * service业务名
     */
    private String serviceBusinessName;

    /**
     * entity模块名
     */
    private String entityModuleName;

    /**
     * entity包名
     */
    private String entityPackageName;

    /**
     * entity业务名
     */
    private String entityBusinessName;

    /**
     * mapper模块名
     */
    private String mapperModuleName;

    /**
     * mapper包名
     */
    private String mapperPackageName;

    /**
     * mapper业务名
     */
    private String mapperBusinessName;
}
