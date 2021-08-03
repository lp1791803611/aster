package top.plgxs.admin.service.impl.sys;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.plgxs.admin.service.monitor.SysLoginLogService;
import top.plgxs.admin.service.sys.SysConfigService;
import top.plgxs.admin.service.sys.SysUserService;
import top.plgxs.admin.utils.ShiroUtils;
import top.plgxs.common.core.constants.Constants;
import top.plgxs.common.core.constants.enums.DeleteEnum;
import top.plgxs.common.core.constants.enums.StatusEnum;
import top.plgxs.common.core.exception.BusinessException;
import top.plgxs.common.redis.constant.RedisConstant;
import top.plgxs.common.redis.util.RedisUtils;
import top.plgxs.mbg.dto.export.UserExport;
import top.plgxs.mbg.dto.gen.TableColumn;
import top.plgxs.mbg.dto.sys.LoginUser;
import top.plgxs.mbg.dto.sys.UserDto;
import top.plgxs.mbg.entity.sys.SysRole;
import top.plgxs.mbg.entity.sys.SysUser;
import top.plgxs.mbg.entity.sys.SysUserPosition;
import top.plgxs.mbg.mapper.sys.SysRoleMapper;
import top.plgxs.mbg.mapper.sys.SysUserMapper;
import top.plgxs.mbg.mapper.sys.SysUserPositionMapper;
import top.plgxs.mbg.utils.Convert;

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
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysLoginLogService sysLoginLogService;
    @Resource
    private SysConfigService sysConfigService;
    @Value(value = "${user.password.maxRetryCount}")
    private String maxRetryCount;
    @Value(value = "${user.password.lockMinutes}")
    private String lockMinutes;
    @Resource
    private RedisUtils redisUtils;

    /**
     * 数据查询列表
     *
     * @return
     * @author Stranger。
     * @date 2021-02-12
     */
    @Override
    public List<SysUser> getSysUserList() {
        return sysUserMapper.selectSysUserList(null);
    }

    /**
     * 分页查询
     *
     * @param page
     * @param queryWrapper
     * @return com.baomidou.mybatisplus.core.metadata.IPage<top.plgxs.mbg.dto.sys.UserDto>
     * @author Stranger。
     * @since 2021/2/12
     */
    @Override
    public IPage<UserDto> selectUserPage(Page<UserDto> page, QueryWrapper<UserDto> queryWrapper) {
        return sysUserMapper.selectUserPage(page, queryWrapper);
    }

    /**
     * 插入
     *
     * @param user
     * @return void
     * @author Stranger。
     * @since 2021/6/7
     */
    @Transactional(rollbackOn = Exception.class)
    @Override
    public void insertUser(UserDto user) {
        SysUser sysUser = Convert.convertDtoToUser(user);
        String password = this.encryptPassword(user.getUsername(), user.getPassword(), Constants.PASSWORD_SALT);
        sysUser.setPassword(password);
        sysUser.setGmtCreate(LocalDateTime.now());
        sysUserMapper.insert(sysUser);
        // 插入用户职位关系
        insertUserPosition(user.getPositionId(), sysUser.getId());
    }

    /**
     * 根据用户id查询职位
     *
     * @param userId 用户id
     * @return java.util.List<java.lang.String>
     * @author Stranger。
     * @since 2021/2/13
     */
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

    /**
     * 更新
     *
     * @param userDto
     * @return void
     * @author Stranger。
     * @since 2021/6/7
     */
    @Transactional(rollbackOn = Exception.class)
    @Override
    public void updateUser(UserDto userDto) {
        // 更新用户信息
        SysUser sysUser = Convert.convertDtoToUser(userDto);
        sysUser.setGmtModified(LocalDateTime.now());
        sysUserMapper.updateById(sysUser);

        // 插入用户职位关系
        insertUserPosition(userDto.getPositionId(), sysUser.getId());
    }

    /**
     * 删除
     *
     * @param userId
     * @return void
     * @author Stranger。
     * @since 2021/6/7
     */
    @Transactional(rollbackOn = Exception.class)
    @Override
    public void deleteUser(String userId) {
        sysUserMapper.deleteById(userId);
        deleteUserPosition(userId);
    }

    /**
     * 批量删除
     *
     * @param userIds
     * @return void
     * @author Stranger。
     * @since 2021/6/7
     */
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
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return top.plgxs.mbg.entity.sys.SysUser
     * @author Stranger。
     * @since 2021/3/4
     */
    @Override
    public SysUser getUserByUsername(String username) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<SysUser> list = sysUserMapper.selectList(queryWrapper);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return top.plgxs.mbg.dto.sys.LoginUser
     * @author Stranger。
     * @since 2021/6/7
     */
    @Override
    public LoginUser login(String username, String password) {
        // 用户名或密码为空 错误
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            sysLoginLogService.insertLoginLog(username, StatusEnum.DISABLE.getCode(), "用户名或密码为空");
            throw new BusinessException("用户名或密码为空！");
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < Constants.PASSWORD_MIN_LENGTH
                || password.length() > Constants.PASSWORD_MAX_LENGTH) {
            sysLoginLogService.insertLoginLog(username, StatusEnum.DISABLE.getCode(), "密码不在指定范围内");
            throw new BusinessException("密码不在指定范围内！");
        }

        // 用户名不在指定范围内 错误
        if (username.length() < Constants.USERNAME_MIN_LENGTH
                || username.length() > Constants.USERNAME_MAX_LENGTH) {
            sysLoginLogService.insertLoginLog(username, StatusEnum.DISABLE.getCode(), "用户名不在指定范围内");
            throw new BusinessException("用户名不在指定范围内！");
        }

        SysUser user = this.getUserByUsername(username);
        if (user == null) {
            sysLoginLogService.insertLoginLog(username, StatusEnum.DISABLE.getCode(), "用户不存在");
            throw new BusinessException("用户不存在！");
        }

        if (DeleteEnum.DELETEED.getCode().equals(user.getIsDeleted())) {
            sysLoginLogService.insertLoginLog(username, StatusEnum.DISABLE.getCode(), "用户已被删除");
            throw new BusinessException("用户已被删除！");
        }

        if (StatusEnum.DISABLE.getCode().equals(user.getStatus())) {
            sysLoginLogService.insertLoginLog(username, StatusEnum.DISABLE.getCode(), "用户已被冻结");
            throw new BusinessException("用户已被冻结，请联系管理员解封！");
        }

        this.check(user, password);

        sysLoginLogService.insertLoginLog(username, StatusEnum.ENABLE.getCode(), "登录成功");

        return new LoginUser(user.getId(), username, user.getPassword());
    }

    @Override
    public void register(SysUser user) {
        String username = user.getUsername(), password = user.getPassword();
        String msg = "";
        if (StrUtil.isBlank(username)) {
            msg = "用户名不能为空";
        } else if (StrUtil.isBlank(password)) {
            msg = "用户密码不能为空";
        } else if (password.length() < Constants.PASSWORD_MIN_LENGTH
                || password.length() > Constants.PASSWORD_MAX_LENGTH) {
            msg = "密码长度必须在5到20个字符之间";
        } else if (username.length() < Constants.USERNAME_MIN_LENGTH
                || username.length() > Constants.USERNAME_MAX_LENGTH) {
            msg = "账户长度必须在2到20个字符之间";
        } else if (Constants.USER_NAME_NOT_UNIQUE.equals(this.checkUserNameUnique(username))) {
            msg = "保存用户'" + username + "'失败，注册账号已存在";
        } else {
            user.setUsername(username);
            user.setPassword(this.encryptPassword(user.getUsername(), user.getPassword(), Constants.PASSWORD_SALT));
            user.setSalt(ShiroUtils.randomSalt());
            user.setGmtCreate(LocalDateTime.now());
            user.setStatus(StatusEnum.ENABLE.getCode());
            user.setIsDeleted(DeleteEnum.OK.getCode());
            int regFlag = sysUserMapper.insert(user);
            if (regFlag <= 0) {
                msg = "注册失败";
            }
        }
        if (StrUtil.isNotBlank(msg)) {
            sysLoginLogService.insertLoginLog(username, StatusEnum.DISABLE.getCode(), msg);
            throw new BusinessException(msg);
        } else {
            sysLoginLogService.insertLoginLog(username, StatusEnum.ENABLE.getCode(), "注册成功");
        }
    }

    @Override
    public void check(SysUser user, String password) {
        String loginName = user.getUsername();
        Integer retryCount = (Integer) redisUtils.get(RedisConstant.SYS_LOCK_USER + loginName);
        if (retryCount == null) {
            retryCount = 0;
            redisUtils.set(RedisConstant.SYS_LOCK_USER + loginName, retryCount, Long.valueOf(lockMinutes) * 60);
        }
        // 密码错误次数
        if (retryCount > Integer.valueOf(maxRetryCount).intValue()) {
            // 更新缓存失效时间
            redisUtils.expire(RedisConstant.SYS_LOCK_USER + loginName, Long.valueOf(lockMinutes) * 60);
            sysLoginLogService.insertLoginLog(user.getUsername(), StatusEnum.DISABLE.getCode(), "密码错误" + Integer.valueOf(maxRetryCount).intValue() + "次，账户锁定");
            throw new BusinessException("密码错误" + Integer.valueOf(maxRetryCount).intValue() + "次，账户锁定" + lockMinutes + "分钟！");
        }
        if (!newMatches(user, password)) {
            retryCount = retryCount + 1;
            redisUtils.set(RedisConstant.SYS_LOCK_USER + loginName, retryCount, Long.valueOf(lockMinutes) * 60);
            sysLoginLogService.insertLoginLog(user.getUsername(), StatusEnum.DISABLE.getCode(), "密码错误");
            throw new BusinessException("密码错误！");
        } else {
            clearLoginRecordCache(loginName);
        }
    }

    /**
     * 是否超级管理员
     *
     * @param user 用户
     * @return boolean
     * @author Stranger。
     * @since 2021/6/1
     */
    @Override
    public boolean isAdmin(LoginUser user) {
        List<SysRole> roles = sysRoleMapper.isAdmin(user.getId(), Constants.SUPER_ADMIN_ROLE);
        if (CollUtil.isNotEmpty(roles)) {
            return true;
        }
        return false;
    }

    /**
     * 判断用户名是否唯一
     *
     * @param username
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/6/7
     */
    @Override
    public String checkUserNameUnique(String username) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<SysUser> list = sysUserMapper.selectList(queryWrapper);
        if (CollUtil.isEmpty(list)) {
            return Constants.USER_NAME_UNIQUE;
        }
        return Constants.USER_NAME_NOT_UNIQUE;
    }

    /**
     * 解锁用户
     *
     * @param username 用户名
     * @return void
     * @author Stranger。
     * @since 2021/7/4
     */
    @Override
    public void clearLoginRecordCache(String username) {
        redisUtils.del(RedisConstant.SYS_LOCK_USER + username);
    }

    /**
     * 获取数据库业务表名
     * @return java.util.List<java.lang.String>
     * @author Stranger。
     * @since 2021/7/9
     */
    @Override
    public List<String> getTableNames() {
        return sysUserMapper.getTableNames("aster");
    }

    /**
     * 获取表字段信息
     * @param tableName
     * @author Stranger。
     * @since 2021/7/9
     */
    @Override
    public List<TableColumn> getTableColumn(String tableName) {
        return sysUserMapper.getTableColumn("aster", tableName);
    }

    @Override
    public List<UserExport> export(String name, String deptId) {

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u.is_deleted", DeleteEnum.OK.getCode());
        if (StringUtils.isNotBlank(deptId) && !Constants.TOP_DEPT_ID.equals(deptId)) {
            queryWrapper.eq("u.dept_id", deptId);
        }
        if (StringUtils.isNotBlank(name)) {
            queryWrapper.and(qw -> qw.like("u.username", name).or().like("u.nickname", name)
                    .or().like("u.mobile", name)).or().like("u.email", name);
        }
        queryWrapper.orderByDesc("u.gmt_create");
        return sysUserMapper.export(queryWrapper);
    }

    public boolean newMatches(SysUser user, String newPassword) {
        return user.getPassword().equals(encryptPassword(user.getUsername(), newPassword, Constants.PASSWORD_SALT));
    }

    /**
     * 生成密码
     *
     * @param loginName 用户名
     * @param password  密码
     * @param salt      秘钥
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/6/26
     */
    @Override
    public String encryptPassword(String loginName, String password, String salt) {
        return new Md5Hash(loginName + password + salt).toHex();
    }

    /*
     * 更新用户基本资料
     * @param userDto
     * @return int
     * @author Stranger。
     * @since 2021/6/26
     */
    @Override
    public int updateBaseInfo(UserDto userDto) {
        if (StrUtil.isBlank(userDto.getUsername())) {
            throw new BusinessException("用户名为空！");
        }
        SysUser user = this.getUserByUsername(userDto.getUsername());
        user.setMobile(userDto.getMobile());
        user.setEmail(userDto.getEmail());
        user.setGmtModified(LocalDateTime.now());
        return sysUserMapper.updateById(user);
    }

    /**
     * 更新密码
     *
     * @param userDto
     * @return int
     * @author Stranger。
     * @since 2021/6/26
     */
    @Override
    public int updatePassword(UserDto userDto) {
        String username = userDto.getUsername();
        SysUser user = this.getUserByUsername(username);
        String oldPassword = this.encryptPassword(username, userDto.getOldPassword(), Constants.PASSWORD_SALT);
        if (!user.getPassword().equals(oldPassword)) {
            throw new BusinessException("旧的密码不正确！");
        }
        if (StrUtil.isBlank(userDto.getPassword())) {
            throw new BusinessException("新的密码为空！");
        }
        String password = this.encryptPassword(username, userDto.getPassword(), Constants.PASSWORD_SALT);
        user.setPassword(password);
        return sysUserMapper.updateById(user);
    }

    /**
     * 重置密码
     *
     * @param id
     * @return int
     * @author Stranger。
     * @since 2021/6/30
     */
    @Override
    public int resetPassword(String id) {
        String password = sysConfigService.getValueByKey(Constants.PASSWORD_CONFIG_KEY);
        SysUser user = sysUserMapper.selectById(id);
        user.setPassword(this.encryptPassword(user.getUsername(), password, Constants.PASSWORD_SALT));
        user.setGmtModified(LocalDateTime.now());
        return sysUserMapper.updateById(user);
    }

    /**
     * 插入用户职位关系
     *
     * @param positionIds 职位id
     * @param userId      用户id
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
     *
     * @param userId 用户id
     * @return void
     * @author Stranger。
     * @since 2021/2/13
     */
    @Transactional(rollbackOn = Exception.class)
    public void deleteUserPosition(String userId) {
        QueryWrapper<SysUserPosition> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        sysUserPositionMapper.delete(queryWrapper);
    }

}
