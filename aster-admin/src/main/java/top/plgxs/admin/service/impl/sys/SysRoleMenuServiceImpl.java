package top.plgxs.admin.service.impl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.plgxs.admin.service.sys.SysRoleMenuService;
import top.plgxs.mbg.entity.sys.SysMenu;
import top.plgxs.mbg.entity.sys.SysRoleMenu;
import top.plgxs.mbg.mapper.sys.SysMenuMapper;
import top.plgxs.mbg.mapper.sys.SysRoleMenuMapper;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 角色菜单 服务实现类
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-22
 * @version 1.0
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysRoleMenu> getSysRoleMenuList() {
        return sysRoleMenuMapper.selectSysRoleMenuList(null);
    }

    @Transactional
    @Override
    public boolean saveRoleMenu(String roleId, String menuCodes) {
        // 先删除原有的角色菜单关系
        QueryWrapper<SysRoleMenu> deleteQw = new QueryWrapper<>();
        deleteQw.eq("role_id", roleId);
        sysRoleMenuMapper.delete(deleteQw);
        // 再插入现在的角色菜单关系
        List<SysRoleMenu> roleMenus = new ArrayList<>();
        String[] codeArray = menuCodes.split(",");
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("code", codeArray);
        List<SysMenu> list = sysMenuMapper.selectList(queryWrapper);
        if (list != null && list.size() > 0) {
            for (SysMenu menu : list) {
                SysRoleMenu roleMenu = new SysRoleMenu();
                roleMenu.setRoleId(roleId);
                roleMenu.setMenuId(menu.getId());
                roleMenus.add(roleMenu);
            }
        }
        return this.saveBatch(roleMenus);
    }
}
