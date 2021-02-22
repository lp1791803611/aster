package top.plgxs.common.node;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>layui tree节点数据格式</p>
 * @author Stranger。
 * @version 1.0
 * @since 2021/2/9 23:41
 */
@Data
public class LayuiTreeNode {
    /**
     * 节点id
     */
    private String id;

    /**
     * 父级节点id
     */
    private String pid;

    /**
     * 节点名称
     */
    private String title;

    /**
     * 节点是否初始展开
     */
    private Boolean spread;

    /**
     * 节点是否初始为选中状态
     */
    private Boolean checked;

    /**
     * 节点是否为禁用状态
     */
    private Boolean disabled;

    private List<LayuiTreeNode> children = new ArrayList<>();

    public LayuiTreeNode () {
        super();
    }

    public LayuiTreeNode (String id, String title, boolean checked, boolean disabled ) {
        this.id = id;
        this.title = title;
        this.checked = checked;
        this.disabled = disabled;
    }
}
