package top.plgxs.admin.service.impl.sys;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.plgxs.admin.service.sys.SysUserService;
import top.plgxs.admin.utils.Convert;
import top.plgxs.mbg.dto.sys.UserDto;
import top.plgxs.mbg.entity.sys.SysUser;
import top.plgxs.mbg.entity.sys.SysUserPosition;
import top.plgxs.mbg.mapper.sys.SysUserMapper;
import top.plgxs.mbg.mapper.sys.SysUserPositionMapper;
import top.plgxs.mbg.mapper.sys.SysUserRoleMapper;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @Resource
    private SysUserPositionMapper sysUserPositionMapper;
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<SysUser> getSysUserList() {
        return sysUserMapper.selectSysUserList(null);
    }

    @Override
    public IPage<UserDto> selectUserPage(Page<UserDto> page, QueryWrapper<UserDto> queryWrapper) {
        return sysUserMapper.selectUserPage(page, queryWrapper);
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void insertUser(UserDto user) {
        SysUser sysUser = Convert.convertDtoToUser(user);
        sysUser.setGmtCreate(LocalDateTime.now());
        sysUserMapper.insert(sysUser);
        // 插入用户职位关系
        insertUserPosition(user.getPositionId(), sysUser.getId());
    }

    @Override
    public List<String> selectPositionsByUserId(String userId) {
        List<String> positionIds = new ArrayList<>();
        QueryWrapper<SysUserPosition> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<SysUserPosition> list = sysUserPositionMapper.selectList(queryWrapper);
        if (CollUtil.isNotEmpty(list)) {
            for (SysUserPosition position : list) {
                positionIds.add(position.getPositionId());
            }
        }
        return positionIds;
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void updateUser(UserDto userDto) {
        // 更新用户信息
        SysUser sysUser = Convert.convertDtoToUser(userDto);
        sysUserMapper.updateById(sysUser);

        // 插入用户职位关系
        insertUserPosition(userDto.getPositionId(), sysUser.getId());
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void deleteUser(String userId) {
        sysUserMapper.deleteById(userId);
        deleteUserPosition(userId);
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void deleteBatchUser(List<String> userIds) {
        sysUserMapper.deleteBatchIds(userIds);
        if (CollUtil.isNotEmpty(userIds)) {
            for (String userId : userIds) {
                deleteUserPosition(userId);
            }
        }
    }



    /**
     * 插入用户职位关系
     * @param positionIds 职位id
     * @param userId 用户id
     * @return void
     * @author Stranger。
     * @since 2021/2/13
     */
    @Transactional(rollbackOn = Exception.class)
    public void insertUserPosition(String positionIds, String userId) {
        // 删除已有的用户职位关系
        deleteUserPosition(userId);

        // 增加新的用户职位关系
        if (StrUtil.isNotBlank(positionIds)) {
            List<String> list = StrUtil.split(positionIds, ',');
            if (CollUtil.isNotEmpty(list)) {
                for (String position : list) {
                    SysUserPosition sysUserPosition = new SysUserPosition();
                    sysUserPosition.setPositionId(position);
                    sysUserPosition.setUserId(userId);
                    sysUserPositionMapper.insert(sysUserPosition);
                }
            }
        }
    }

    /**
     * 删除用户职位关系
     * @param userId 用户id
     * @return void
     * @author Stranger。
     * @since 2021/2/13
     */
    @Transactional(rollbackOn = Exception.class)
    public void deleteUserPosition(String userId){
        QueryWrapper<SysUserPosition> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        sysUserPositionMapper.delete(queryWrapper);
    }

}
