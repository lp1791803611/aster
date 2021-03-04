package top.plgxs.common.security.component;

import cn.hutool.json.JSONUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import top.plgxs.common.core.api.ResultInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>自定义返回结果：未登录或登录过期，认证失败时</p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/3/4 0004 15:34
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Cache-Control","no-cache");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().println(JSONUtil.parse(ResultInfo.unauthorized(e.getMessage())));
        httpServletResponse.getWriter().flush();
    }
}
