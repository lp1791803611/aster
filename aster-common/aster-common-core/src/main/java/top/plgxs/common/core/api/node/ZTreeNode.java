package top.plgxs.common.core.api.node;

import lombok.Data;

import java.io.Serializable;

/**
 * ztree组件节点数据格式
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/2/6 21:20
 */
@Data
public class ZTreeNode implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 节点id
     */
    private String id;

    /**
     * 父节点id
     */
    private String pId;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 是否打开节点
     */
    private Boolean open;

    /**
     * 是否被选中
     */
    private Boolean checked;

    /**
     * 节点图标  single or group
     */
    private String iconSkin;

    /**
     * 禁用节点
     */
    private Boolean chkDisabled;

    /**
     * 创建ztree的父级节点
     *
     * @return top.plgxs.common.node.ZTreeNode
     * @author Stranger。
     * @since 2021/2/6
     */
    public static ZTreeNode createParent() {
        ZTreeNode zTreeNode = new ZTreeNode();
        zTreeNode.setChecked(true);
        zTreeNode.setId("0");
        zTreeNode.setName("顶级");
        zTreeNode.setOpen(true);
        zTreeNode.setPId("0");
        zTreeNode.setChkDisabled(false);
        return zTreeNode;
    }

    public static ZTreeNode createParent(String id, String name, Boolean checked, Boolean chkDisabled) {
        ZTreeNode zTreeNode = new ZTreeNode();
        zTreeNode.setChecked(checked);
        zTreeNode.setId(id);
        zTreeNode.setName(name);
        zTreeNode.setOpen(true);
        zTreeNode.setPId(id);
        zTreeNode.setChkDisabled(chkDisabled);
        return zTreeNode;
    }
}
