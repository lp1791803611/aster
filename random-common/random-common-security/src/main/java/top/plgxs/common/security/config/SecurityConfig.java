package top.plgxs.common.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import top.plgxs.common.security.component.JwtAccessDeniedHandler;
import top.plgxs.common.security.component.JwtAuthenticationEntryPoint;
import top.plgxs.common.security.component.JwtAuthenticationTokenFilter;
import top.plgxs.common.security.properties.IgnoreUrlsProperties;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Spring Security配置类</p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/3/4 0004 15:43
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private JwtAccessDeniedHandler jwtAccessDeniedHandler;
    @Resource
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Resource
    private IgnoreUrlsProperties ignoreUrlsProperties;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity
                .authorizeRequests();
        // 无需认证的资源路径允许访问
        for (String url : ignoreUrlsProperties.getUrls()) {
            registry.antMatchers(url).permitAll();
        }
        // 允许跨域请求的OPTIONS请求
        registry.antMatchers(HttpMethod.OPTIONS)
                .permitAll();

        registry.and()
                // 默认其他请求都需要身份认证
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                // 关闭跨站请求防护及不使用session
                .and()
                .csrf().disable()  // 禁用csrf
                .sessionManagement() // 不创建会话
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // 自定义权限拒绝处理类
                .and()
                .exceptionHandling()
                .accessDeniedHandler(jwtAccessDeniedHandler)
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                // 自定义权限拦截器JWT过滤器
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
