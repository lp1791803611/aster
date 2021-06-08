package top.plgxs.mbg.mapper.sys;

import top.plgxs.mbg.entity.sys.SysRoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色菜单 Mapper 接口
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-22
 * @version 1.0
 */
@Repository("sysRoleMenuMapper")
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    /**
     * 分页数据查询
     * @param sysRoleMenu
     * @return
     * @author Stranger。
     * @date 2021-02-22
     */
    List<SysRoleMenu> selectSysRoleMenuList(SysRoleMenu sysRoleMenu);
}
