package top.plgxs.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import top.plgxs.admin.service.AdminService;
import top.plgxs.common.security.config.SecurityConfig;

import javax.annotation.Resource;

/**
 * random-common-security模块相关配置
 * @author Stranger。
 * @version 1.0
 * @since 2021/3/4 21:30
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdminSecurityConfig extends SecurityConfig {
    @Resource
    private AdminService adminService;

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        // 获取登录用户信息
        return username -> adminService.loadUserByUsername(username);
    }
}
