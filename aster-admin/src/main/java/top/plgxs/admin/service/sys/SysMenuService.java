package top.plgxs.admin.service.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import top.plgxs.common.core.api.TreeTable;
import top.plgxs.common.core.api.menu.MenuInfo;
import top.plgxs.common.core.api.node.ZTreeNode;
import top.plgxs.mbg.dto.sys.LoginUser;
import top.plgxs.mbg.entity.sys.SysMenu;

import java.util.List;
import java.util.Set;

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

    /**
     * 新增一条菜单
     * @param sysMenu
     * @author Stranger。
     * @since 2021/2/8 0008
     */
    int insertMenu(SysMenu sysMenu);

    /**
     * 更新一条菜单
     * @param oldCode 旧编码
     * @param sysMenu
     * @author Stranger。
     * @since 2021/2/8 0008
     */
    int updateMenu(String oldCode, SysMenu sysMenu);

    /**
     * 逻辑删除一条菜单，包含子菜单
     * @param code 菜单编码
     * @author Stranger。
     * @since 2021/2/8 0008
     */
    void deleteMenuContainChildren(String code);

    /**
     * 批量删除
     * @param codes
     * @return void
     * @author Stranger。
     * @since 2021/2/9
     */
    void batchDelete(List<String> codes);

    /**
     * 切换启用状态
     * @param code 菜单编码
     * @param status 状态
     * @return void
     * @author Stranger。
     * @since 2021/2/9
     */
    void switchStatus(String code, String status);

    /**
     * 根据角色id组装菜单树
     * @param roleId
     * @return java.util.List<top.plgxs.common.node.ZTreeNode>
     * @author Stranger。
     * @since 2021/2/22
     */
    List<ZTreeNode> getMenuTreeByRoleId(String roleId);

    /**
     * 当前角色所属的菜单
     * @param roleId
     * @return java.util.List<top.plgxs.mbg.entity.sys.SysMenu>
     * @author Stranger。
     * @since 2021/2/22
     */
    List<SysMenu> getMenuByRoleId(String roleId);

    /**
     * 根据用户id查询权限
     * @param userId 用户id
     * @return java.util.Set<java.lang.String>
     * @author Stranger。
     * @since 2021/3/16
     */
    Set<String> getPermissionByUserId(String userId);

    /**
     * 根据角色id查询菜单id
     * @param roleIds 角色id集合
     * @return java.util.List<java.lang.String>
     * @author Stranger。
     * @since 2021/3/16
     */
    List<String> getMenuIdByRoleId(List<String> roleIds);

    /**
     * 根据用户id查询菜单
     * @param user
     * @return java.util.List<top.plgxs.common.core.api.menu.MenuInfo>
     * @author Stranger。
     * @since 2021/6/9
     */
    List<MenuInfo> selectMenusByUserId(LoginUser user);
}
