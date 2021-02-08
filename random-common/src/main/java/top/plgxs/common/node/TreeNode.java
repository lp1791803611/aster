package top.plgxs.common.node;

import lombok.Data;

import java.util.List;

/**
 * <p>layui tree节点数据格式</p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/2/8 0008 14:20
 */
@Data
public class TreeNode {
    /**
     * 唯一值
     */
    private String id;
    /**
     * 节点名称
     */
    private String name;
    /**
     * 节点链接（可选），未设则不会跳转
     */
    private String href;
    /**
     * 是否展开状态（默认false）
     */
    private Boolean spread;
    /**
     * 子节点
     */
    private List<TreeNode> children;

}
