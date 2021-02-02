package top.plgxs.admin.service.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import top.plgxs.common.domain.TreeTable;
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
}
