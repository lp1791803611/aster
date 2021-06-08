package top.plgxs.admin.service.impl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.plgxs.admin.service.sys.SysUserRoleService;
import top.plgxs.mbg.entity.sys.SysUserRole;
import top.plgxs.mbg.mapper.sys.SysUserRoleMapper;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户角色关系 实现类
 * @author Stranger。
 * @version 1.0
 * @since 2021/2/19 20:48
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void saveUserRole(SysUserRole userRole) {
        String[] roleIds = userRole.getRoleId().split(",");
        String userId = userRole.getUserId();
        // 先删除原有的用户角色关系
        deleteUserRole(userId);
        // 再插入变更后的用户角色关系
        List<SysUserRole> userRoles = new ArrayList<>(roleIds.length);
        for (String roleId : roleIds) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(userId);
            sysUserRole.setRoleId(roleId);
            userRoles.add(sysUserRole);
        }
        this.saveBatch(userRoles);
    }

    /**
     * 删除用户角色关系
     * @param userId 用户id
     * @return void
     * @author Stranger。
     * @since 2021/2/19
     */
    @Transactional(rollbackOn = Exception.class)
    public void deleteUserRole(String userId) {
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        sysUserRoleMapper.delete(queryWrapper);
    }
}
