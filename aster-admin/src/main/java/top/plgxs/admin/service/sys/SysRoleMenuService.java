package top.plgxs.admin.service.sys;

import top.plgxs.mbg.entity.sys.SysRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色菜单 服务类
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-22
 * @version 1.0
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {
    /**
     * 数据查询列表
     * @return
     * @author Stranger。
     * @date 2021-02-22
     */
    List<SysRoleMenu> getSysRoleMenuList();

    /**
     * 保存角色菜单关系
     * @param roleId 角色id
     * @param menuCodes 菜单编码
     * @return void
     * @author Stranger。
     * @since 2021/2/22
     */
    boolean saveRoleMenu(String roleId, String menuCodes);
}
