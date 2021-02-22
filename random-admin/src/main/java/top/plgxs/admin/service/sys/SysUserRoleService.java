package top.plgxs.admin.service.sys;

import top.plgxs.mbg.entity.sys.SysUserRole;

/**
 * @author Stranger。
 * @version 1.0
 * @since 2021/2/19 20:47
 */
public interface SysUserRoleService {
    /**
     * 保存用户角色关系
     * @param userRole
     * @return void
     * @author Stranger。
     * @since 2021/2/19
     */
    void saveUserRole(SysUserRole userRole);
}
