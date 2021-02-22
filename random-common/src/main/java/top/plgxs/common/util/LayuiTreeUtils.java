package top.plgxs.common.util;

import top.plgxs.common.constants.Constants;
import top.plgxs.common.node.LayuiTreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Stranger。
 * @version 1.0
 * @since 2021/2/9 23:48
 */
public class LayuiTreeUtils {
    /**
     * 生成layuiTree根节点
     *
     * @return top.plgxs.common.node.LayuiTreeNode
     * @author Stranger。
     * @since 2021/2/9
     */
    public static LayuiTreeNode createRoot(boolean checked,boolean disabled) {
        LayuiTreeNode treeNode = new LayuiTreeNode();
        treeNode.setChecked(checked);
        treeNode.setId(Constants.TOP_DEPT_ID);
        treeNode.setTitle("顶级");
        treeNode.setSpread(true);
        treeNode.setDisabled(disabled);
        treeNode.setPid(Constants.TOP_DEPT_PARENT_ID);
        return treeNode;
    }

    /**
     * 递归构建树
     *
     * @param nodes        所有待组装的数据
     * @param rootParentId root节点的父id
     * @return
     */
    public static List<LayuiTreeNode> doTreeBuildByRecursion(List<LayuiTreeNode> nodes, String rootParentId) {
        List<LayuiTreeNode> list = new ArrayList<>();
        for (LayuiTreeNode node : nodes) {
            // 从root节点开始组合树
            if (rootParentId.equals(node.getPid())) {
                node.setChildren(getChildren(node.getId(), nodes));
                list.add(node);
            }
        }
        return list;
    }

    /**
     * 获取叶子节点，递归遍历
     *
     * @param id
     * @param nodes
     * @return java.util.List<top.plgxs.common.node.LayuiTreeNode>
     * @author Stranger。
     * @since 2021/2/10
     */
    public static List<LayuiTreeNode> getChildren(String id, List<LayuiTreeNode> nodes) {
        List<LayuiTreeNode> list = new ArrayList<>();
        for (LayuiTreeNode node : nodes) {
            if (node.getPid().equals(id)) {
                node.setChildren(getChildren(node.getId(), nodes));
                list.add(node);
            }
        }
        return list;
    }

    /**
     * 非递归构建树
     * @param nodes 所有待组装的数据
     * @param rootParentId root节点的父id
     * @return java.util.List<top.plgxs.common.node.LayuiTreeNode>
     * @author Stranger。
     * @since 2021/2/10
     */
    public static List<LayuiTreeNode> doTreeBuildByMap(List<LayuiTreeNode> nodes, String rootParentId) {
        List<LayuiTreeNode> list = new ArrayList<>();
        Map<String, LayuiTreeNode> map = new HashMap<>();
        // 将所有的list集合转为map
        for (LayuiTreeNode node : nodes) {
            map.put(node.getId(), node);
        }
        // 组合父子关系
        for (LayuiTreeNode node : nodes) {
            // 将所有的节点先看成子节点
            // 如果节点的pid为rootParentId，则代表该机构为根机构
            if (node.getPid().equals(rootParentId)) {
                list.add(node);
            } else {
                // 如果节点的pid不是rootParentId，则代表该节点肯定有父节点
                LayuiTreeNode parent = map.get(node.getPid());
                // 组合父子关系
                if (parent == null) {
                    // 若map中不存在该节点的父节点，则可以将该节点当作根节点
                    list.add(node);
                } else {
                    parent.getChildren().add(node);
                }
            }
        }
        return list;
    }
}
