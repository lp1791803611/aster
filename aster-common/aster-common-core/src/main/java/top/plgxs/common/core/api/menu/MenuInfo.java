package top.plgxs.common.core.api.menu;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单信息
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/6/9 11:43
 */
@Data
public class MenuInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 菜单名称
     */
    private String title;
    /**
     * 图标
     */
    private String icon;
    /**
     * 链接
     */
    private String href;
    /**
     * 打开方式
     */
    private String target;
    /**
     * 子菜单集合
     */
    private List<MenuInfo> child = new ArrayList<>();
    /**
     * 编码
     */
    private String code;
    /**
     * 父编码
     */
    private String parentCode;
    /**
     * 父编码
     */
    private Integer sort;

}
