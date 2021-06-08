package top.plgxs.api.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import top.plgxs.api.bo.AdminDetail;
import top.plgxs.api.service.AdminService;
import top.plgxs.common.redis.util.RedisUtils;
import top.plgxs.common.security.component.UserPasswordEncoder;
import top.plgxs.common.security.util.JwtTokenUtil;
import top.plgxs.mbg.entity.sys.SysMenu;
import top.plgxs.mbg.entity.sys.SysUser;
import top.plgxs.mbg.mapper.AdminMapper;
import top.plgxs.mbg.mapper.sys.SysUserMapper;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Stranger。
 * @version 1.0
 * @since 2021/3/4 22:19
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private UserPasswordEncoder userPasswordEncoder;
    @Resource
    private RedisUtils redisUtils;
    @Value("${redis.prefix}")
    private String REDIS_PREFIX;
    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCELIST;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE_COMMON;

    @Override
    public List<SysMenu> getMenuListByUserId(String userId) {
        String key = REDIS_PREFIX + ":" + REDIS_KEY_RESOURCELIST + ":" + userId;
        List<SysMenu> menus = (List<SysMenu>) redisUtils.get(key);
        if (CollUtil.isNotEmpty(menus)) {
            return menus;
        }
        menus = adminMapper.getMenuListByUserId(userId);
        if (CollUtil.isNotEmpty(menus)) {
            redisUtils.set(key, menus, REDIS_EXPIRE_COMMON);
        }
        return menus;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUser user = this.getUserByUsername(username);
        if (user != null) {
            List<SysMenu> menuList = this.getMenuListByUserId(user.getId());
            return new AdminDetail(user, menuList);
        }
        return null;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        // 密码需要加密传输，在这里需要进行解密成原始密码
        // 解密步骤省略了
        UserDetails userDetails = loadUserByUsername(username);
        if (userPasswordEncoder.passwordEncoder().matches(password, userDetails.getPassword()) && userDetails.isEnabled()) {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,
                    null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
            // 添加登录日志，省略了
        }
        return token;
    }

    @Override
    public SysUser register(String username, String password) {
        // 查询是否有相同的用户名
        SysUser existUser = this.getUserByUsername(username);
        if (existUser != null) {
            return null;
        }
        SysUser user = new SysUser();
        user.setUsername(username);
        // 将密码加密
        String encodePassword = userPasswordEncoder.passwordEncoder().encode(password);
        user.setPassword(encodePassword);
        user.setGmtCreate(LocalDateTime.now());
        sysUserMapper.insert(user);
        return user;
    }

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
}
