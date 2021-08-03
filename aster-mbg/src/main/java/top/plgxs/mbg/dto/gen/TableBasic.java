package top.plgxs.mbg.dto.gen;

import lombok.Data;

/**
 * 表基本信息
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/11 16:13
 */
@Data
public class TableBasic {
    /**
     * 数据库类型
     */
    private String dbType;
    /**
     * 数据库url
     */
    private String dbUrl;
    /**
     * 用户名
     */
    private String dbUsername;
     /**
     * 密码
     */
    private String dbPassword;
    /**
     * driver
     */
    private String dbDriver;

    /**
     * 表名
     */
    private String tableName;
    /**
     * 表前缀
     */
    private String tablePrefix;
    /**
     * 作者
     */
    private String author;
    /**
     * 是否覆盖文件
     */
    private String fileOverride;
    /**
     * 是否生成Controller
     */
    private String isController;
    /**
     * 是否生成Service
     */
    private String isService;
    /**
     * 是否生成Html
     */
    private String isHtml;
    /**
     * 表逻辑删除字段
     */
    private String deleteColumn;

}
