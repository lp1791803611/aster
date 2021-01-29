package top.plgxs.admin.service.impl.sys;

import top.plgxs.mbg.entity.sys.SysUser;
import top.plgxs.mbg.mapper.sys.SysUserMapper;
import top.plgxs.admin.service.sys.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author Stranger。
 * @since 2021-01-29
 * @version 1.0
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> getSysUserList() {
        return sysUserMapper.selectSysUserList(null);
    }
}
