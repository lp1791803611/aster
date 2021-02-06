package top.plgxs.mbg.mapper.sys;

import top.plgxs.common.node.ZTreeNode;
import top.plgxs.mbg.entity.sys.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

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
@Repository("sysMenuMapper")
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
}
