package top.plgxs.admin.service.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import top.plgxs.common.domain.TreeTable;
import top.plgxs.common.node.ZTreeNode;
import top.plgxs.mbg.entity.sys.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-02
 * @version 1.0
 */
public interface SysMenuService extends IService<SysMenu> {
    /**
     * 数据查询列表
     * @return
     * @author Stranger。
     * @date 2021-02-02
     */
    List<SysMenu> getSysMenuList();

    /**
     * treetable数据
     * @param queryWrapper
     * @author Stranger。
     * @since 2021/2/2 0002
     */
    List<TreeTable> treeTableList(QueryWrapper<SysMenu> queryWrapper);

    /**
     * 树形菜单列表
     * @return java.util.List<top.plgxs.common.node.ZTreeNode>
     * @author Stranger。
     * @since 2021/2/6
     */
    List<ZTreeNode> menuTreeList();

    /**
     * 根据code查询菜单名称
     * @param code 菜单编码
     * @author Stranger。
     * @since 2021/2/7 0007
     */
    String getMenuNameByCode(String code);
}
