package top.plgxs.admin.service.impl.sys;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.plgxs.admin.service.sys.SysRoleService;
import top.plgxs.common.node.ZTreeNode;
import top.plgxs.mbg.entity.sys.SysRole;
import top.plgxs.mbg.entity.sys.SysUserRole;
import top.plgxs.mbg.mapper.sys.SysRoleMapper;
import top.plgxs.mbg.mapper.sys.SysUserRoleMapper;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-13
 * @version 1.0
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<SysRole> getSysRoleList() {
        return sysRoleMapper.selectSysRoleList(null);
    }

    @Override
    public List<ZTreeNode> roleTreeList(String userId) {
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<SysUserRole> userRoles = sysUserRoleMapper.selectList(queryWrapper);
        Map<String, SysUserRole> map = new HashMap<>();
        if (CollUtil.isNotEmpty(userRoles)) {
            for (SysUserRole userRole : userRoles) {
                map.put(userRole.getRoleId(), userRole);
            }
        }
        List<ZTreeNode> list = sysRoleMapper.roleTreeList();
        if (CollUtil.isNotEmpty(list)) {
            // 若用户存在某个角色，则默认选中
            for (ZTreeNode node : list) {
                if (map.containsKey(node.getId())) {
                    node.setChecked(true);
                }
                node.setPId("0");
            }
        }
        list.add(ZTreeNode.createParent("0", "角色信息", false, true));
        return list;
    }
}
