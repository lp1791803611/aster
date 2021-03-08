package top.plgxs.api.service;

import org.springframework.security.core.userdetails.UserDetails;
import top.plgxs.mbg.entity.sys.SysMenu;
import top.plgxs.mbg.entity.sys.SysUser;

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

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @author Stranger。
     * @since 2021/3/8 0008
     */
    String login(String username, String password);

    /**
     * 用户注册
     * @param username 用户名
     * @param password 密码
     * @author Stranger。
     * @since 2021/3/8 0008
     */
    SysUser register(String username, String password);
}
