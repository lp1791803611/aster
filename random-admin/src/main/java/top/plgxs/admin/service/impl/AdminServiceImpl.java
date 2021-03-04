package top.plgxs.admin.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import top.plgxs.admin.service.AdminService;
import top.plgxs.admin.service.sys.SysUserService;
import top.plgxs.mbg.entity.sys.SysMenu;
import top.plgxs.mbg.entity.sys.SysUser;
import top.plgxs.mbg.mapper.AdminMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Stranger。
 * @version 1.0
 * @since 2021/3/4 22:19
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private SysUserService sysUserService;
    @Resource
    private AdminMapper adminMapper;

    @Override
    public List<SysMenu> getMenuListByUserId(String userId) {
        return adminMapper.getMenuListByUserId(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUser user = sysUserService.getUserByUsername(username);
        if (user != null) {
            List<SysMenu> menuList = this.getMenuListByUserId(user.getId());

        }
        return null;
    }
}
