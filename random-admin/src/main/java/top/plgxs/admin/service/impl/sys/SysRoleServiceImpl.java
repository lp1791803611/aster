package top.plgxs.admin.service.impl.sys;

import top.plgxs.mbg.entity.sys.SysRole;
import top.plgxs.mbg.mapper.sys.SysRoleMapper;
import top.plgxs.admin.service.sys.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author Stranger。
 * @since 2020-12-27
 * @version 1.0
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> getSysRoleList() {
        return sysRoleMapper.selectSysRoleList(null);
    }
}
