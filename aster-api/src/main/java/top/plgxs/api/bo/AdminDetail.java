package top.plgxs.api.bo;

import cn.hutool.core.util.StrUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import top.plgxs.common.core.constants.enums.StatusEnum;
import top.plgxs.mbg.entity.sys.SysMenu;
import top.plgxs.mbg.entity.sys.SysUser;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用户详情
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/3/4 22:43
 */
public class AdminDetail implements UserDetails {
    private SysUser sysUser;
    private List<SysMenu> menuList;

    public AdminDetail(SysUser user, List<SysMenu> menus) {
        this.sysUser = user;
        this.menuList = menus;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 返回当前用户的权限
        return menuList.stream()
                .filter(menu -> StrUtil.isNotBlank(menu.getMenuAuth())
                        && StatusEnum.ENABLE.getCode().equals(menu.getStatus()))
                .map(menu -> new SimpleGrantedAuthority(menu.getMenuAuth()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUsername();
    }

    /**
     * 帐号是否不过期，false则验证不通过
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 帐号是否不锁定，false则验证不通过
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 凭证是否不过期，false则验证不通过
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 该帐号是否启用，false则验证不通过
     */
    @Override
    public boolean isEnabled() {
        return StatusEnum.ENABLE.getCode().equals(sysUser.getStatus());
    }
}
