package top.plgxs.admin.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.plgxs.admin.service.sys.SysUserService;
import top.plgxs.common.core.api.ResultInfo;
import top.plgxs.common.core.constants.Constants;
import top.plgxs.common.core.exception.BusinessException;
import top.plgxs.mbg.entity.sys.SysUser;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>登录</p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/1/7 0007 15:44
 */
@Controller
public class LoginController {
    @Resource
    private SysUserService sysUserService;
    @Value("${aster.isRegister}")
    private Boolean isRegister;

    /**
     * 登录界面
     *
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/6/8
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 登录
     *
     * @param username   用户名
     * @param password   密码
     * @param rememberMe 记住我
     * @return top.plgxs.common.core.api.ResultInfo
     * @author Stranger。
     * @since 2021/6/8
     */
    @PostMapping("/login")
    @ResponseBody
    public ResultInfo login(String username, String password, Boolean rememberMe, HttpServletRequest request) {
        // 验证码校验
        if (!ObjectUtil.isEmpty(request.getAttribute(Constants.CURRENT_CAPTCHA))) {
            throw new BusinessException("验证码错误");
        }
        if (rememberMe == null) {
            rememberMe = false;
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return ResultInfo.success();
        } catch (AuthenticationException e) {
            String msg = "用户或密码错误";
            if (StrUtil.isNotEmpty(e.getMessage())) {
                msg = e.getMessage();
            }
            return ResultInfo.failed(msg);
        }
    }

    /**
     * 跳转注册页面
     *
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/6/8
     */
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 注册
     *
     * @param user 注册信息
     * @return top.plgxs.common.core.api.ResultInfo
     * @author Stranger。
     * @since 2021/6/8
     */
    @PostMapping("/register")
    @ResponseBody
    public ResultInfo register(SysUser user, HttpServletRequest request) {
        if (!isRegister) {
            throw new BusinessException("当前系统没有开启注册功能！");
        }
        if (!ObjectUtil.isEmpty(request.getAttribute(Constants.CURRENT_CAPTCHA))) {
            throw new BusinessException("验证码错误");
        }
        sysUserService.register(user);
        return ResultInfo.success();
    }

    /**
     * 首页
     *
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/6/8
     */
    @GetMapping("/index")
    public String index() {
        return "index";
    }


}
