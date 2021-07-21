package top.plgxs.admin.config.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Lazy;
import top.plgxs.admin.service.sys.SysMenuService;
import top.plgxs.admin.service.sys.SysRoleService;
import top.plgxs.admin.service.sys.SysUserService;
import top.plgxs.admin.utils.ShiroUtils;
import top.plgxs.mbg.dto.sys.LoginUser;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义realm
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/6/1 17:16
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {
    @Lazy
    @Resource
    private SysUserService sysUserService;
    @Lazy
    @Resource
    private SysRoleService sysRoleService;
    @Lazy
    @Resource
    private SysMenuService sysMenuService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LoginUser user = ShiroUtils.getLoginUser();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 角色列表
        Set<String> roles = new HashSet<String>();
        // 功能列表
        Set<String> menus = new HashSet<String>();
        // 管理员拥有所有权限
        if (sysUserService.isAdmin(user)) {
            info.addRole("admin");
            info.addStringPermission("*:*:*");
        } else {
            roles = sysRoleService.getRoleCodeByUserId(user.getId());
            menus = sysMenuService.getPermissionByUserId(user.getId());
            // 角色加入AuthorizationInfo认证对象
            info.setRoles(roles);
            // 权限加入AuthorizationInfo认证对象
            info.setStringPermissions(menus);
        }
        return info;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String username = upToken.getUsername();
        String password = "";
        if (upToken.getPassword() != null) {
            password = new String(upToken.getPassword());
        }
        LoginUser user = null;
        try {
            user = sysUserService.login(username, password);
        } catch (Exception e) {
            log.info("对用户[" + username + "]进行登录验证..验证未通过{}", e.getMessage());
            throw new AuthenticationException(e.getMessage(), e);
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
