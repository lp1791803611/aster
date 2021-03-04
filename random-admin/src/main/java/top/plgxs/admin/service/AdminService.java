package top.plgxs.admin.service;

import org.springframework.security.core.userdetails.UserDetails;
import top.plgxs.mbg.entity.sys.SysMenu;

import java.util.List;

/**
 * 权限相关多表查询
 * @author Stranger。
 * @version 1.0
 * @since 2021/3/4 22:17
 */
public interface AdminService {
    /**
     * 根据用户Id获取菜单列表
     * @param userId 用户Id
     * @return java.util.List<SysMenu>
     * @author Stranger。
     * @since 2021/3/4
     */
    List<SysMenu> getMenuListByUserId(String userId);

    /**
     * 获取用户信息
     * @param username 用户名
     * @return org.springframework.security.core.userdetails.UserDetails
     * @author Stranger。
     * @since 2021/3/4
     */
    UserDetails loadUserByUsername(String username);
}
