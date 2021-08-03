package top.plgxs.mbg.dto.gen;

import lombok.Data;
import top.plgxs.common.core.constants.enums.IsNotEnum;

/**
 * 表的字段信息
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/9 20:35
 */
@Data
public class TableColumn {
    /**
     * 是否为主键
     */
    private String columnKey;
    /**
     * 字段名
     */
    private String columnName;

    /**
     * 字段注释
     */
    private String columnComment;

    /**
     * 字段类型
     */
    private String columnType;

    /**
     * 是否显示在添加页面
     */
    private String isAdd = IsNotEnum.IS.getCode();

    /**
     * 是否显示在编辑页面
     */
    private String isEdit = IsNotEnum.IS.getCode();

    /**
     * 是否必填
     */
    private String isRequired = IsNotEnum.NOT.getCode();

    /**
     * 是否显示在列表
     */
    private String isList = IsNotEnum.IS.getCode();

    /**
     * 是否显示在列表的查询条件
     */
    private String isSearch = IsNotEnum.NOT.getCode();

    /**
     * 查询方式
     */
    private String searchType;

    /**
     * 显示方式
     */
    private String showType;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 驼峰字段名
     */
    private String propertyName;


}
