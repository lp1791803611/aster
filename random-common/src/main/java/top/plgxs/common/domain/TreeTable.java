package top.plgxs.common.domain;

import lombok.Data;

/**
 * <p>layui treetable格式</p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/2/2 0002 16:35
 */
@Data
public class TreeTable {
    /**
     * 编码
     */
    private String code;
    /**
     * 父编码
     */
    private String parentCode;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 名称
     */
    private String name;
    /**
     * url
     */
    private String url;
    /**
     * 图标
     */
    private String icon;
    /**
     * 权限标识
     */
    private String auth;
    /**
     * 状态
     */
    private String status;
    /**
     * 类型
     */
    private String type;

    public TreeTable(){
        super();
    }
}
