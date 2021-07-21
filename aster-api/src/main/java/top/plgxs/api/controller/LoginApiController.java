package top.plgxs.api.controller;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.plgxs.api.service.AdminService;
import top.plgxs.common.core.api.ResultInfo;
import top.plgxs.common.security.properties.JwtSecurityProperties;
import top.plgxs.mbg.dto.sys.LoginUser;
import top.plgxs.mbg.entity.sys.SysUser;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>登录</p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/3/8 0008 15:29
 */
@Api(tags = "LoginController", value = "用户登录")
@RestController
public class LoginApiController {
    @Resource
    private AdminService adminService;
    @Resource
    private JwtSecurityProperties jwtSecurityProperties;

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public ResultInfo<Object> login(@RequestBody LoginUser loginUser) {
        if (loginUser == null || StrUtil.isBlank(loginUser.getUsername())
                || StrUtil.isBlank(loginUser.getPassword())) {
            return ResultInfo.validateFailed();
        }
        String token = adminService.login(loginUser.getUsername(), loginUser.getPassword());
        if (token == null) {
            return ResultInfo.validateFailed("用户名或密码错误");
        }
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("tokenHead", jwtSecurityProperties.getTokenHead());
        return ResultInfo.success(map);
    }

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    public ResultInfo<SysUser> register(@RequestBody LoginUser loginUser) {
        if (loginUser == null || StrUtil.isBlank(loginUser.getUsername())
                || StrUtil.isBlank(loginUser.getPassword())) {
            return ResultInfo.validateFailed();
        }
        SysUser user = adminService.register(loginUser.getUsername(), loginUser.getPassword());
        if (user == null) {
            return ResultInfo.failed();
        }
        return ResultInfo.success(user);
    }
}
