package top.plgxs.mbg.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.data.repository.query.Param;
import top.plgxs.common.core.api.node.ZTreeNode;
import top.plgxs.mbg.entity.sys.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单 Mapper 接口
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-02
 * @version 1.0
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 分页数据查询
     * @param sysMenu
     * @return
     * @author Stranger。
     * @date 2021-02-02
     */
    List<SysMenu> selectSysMenuList(SysMenu sysMenu);

    /**
     * 树形菜单列表
     * @return java.util.List<top.plgxs.common.node.ZTreeNode>
     * @author Stranger。
     * @since 2021/2/6
     */
    List<ZTreeNode> menuTreeList();

    /**
     * 根据编码查询子孙菜单集合
     * @param code 编码
     * @author Stranger。
     * @since 2021/2/8 0008
     */
    List<SysMenu> getChildMenusByCode(@Param("code") String code);

    /**
     * 查询角色所属的菜单
     * @param roleId 角色id
     * @return java.util.List<top.plgxs.mbg.entity.sys.SysMenu>
     * @author Stranger。
     * @since 2021/2/22
     */
    List<SysMenu> getMenuByRoleId(@Param("roleId") String roleId);

    /**
     * 根据用户id查询菜单
     * @param userId
     * @return java.util.List<top.plgxs.mbg.entity.sys.SysMenu>
     * @author Stranger。
     * @since 2021/6/9
     */
    List<SysMenu> selectMenusByUserId(@Param("userId") String userId);
}
