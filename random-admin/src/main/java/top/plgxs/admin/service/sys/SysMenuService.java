package top.plgxs.admin.service.sys;

import top.plgxs.mbg.entity.sys.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author Stranger。
 * @since 2021-01-29
 * @version 1.0
 */
public interface SysMenuService extends IService<SysMenu> {
    /**
     * 数据查询列表
     * @return
     * @author Stranger。
     * @date 2021-01-29
     */
    List<SysMenu> getSysMenuList();
}
