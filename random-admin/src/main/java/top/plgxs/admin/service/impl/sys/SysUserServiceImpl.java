package top.plgxs.admin.service.impl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.plgxs.admin.service.sys.SysUserService;
import top.plgxs.mbg.dto.sys.UserDto;
import top.plgxs.mbg.entity.sys.SysUser;
import top.plgxs.mbg.mapper.sys.SysUserMapper;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021-02-12
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> getSysUserList() {
        return sysUserMapper.selectSysUserList(null);
    }

    @Override
    public IPage<UserDto> selectUserPage(Page<UserDto> page, QueryWrapper<UserDto> queryWrapper) {
        return sysUserMapper.selectUserPage(page, queryWrapper);
    }
}
