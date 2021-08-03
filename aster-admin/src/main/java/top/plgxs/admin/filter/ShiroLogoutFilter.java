package top.plgxs.admin.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import top.plgxs.admin.service.monitor.SysLoginLogService;
import top.plgxs.admin.utils.ShiroUtils;
import top.plgxs.common.core.constants.Constants;
import top.plgxs.common.core.constants.enums.StatusEnum;
import top.plgxs.common.core.util.SpringUtils;
import top.plgxs.common.core.util.StringUtils;
import top.plgxs.mbg.dto.sys.LoginUser;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
import java.util.Deque;

/**
 * 退出过滤器
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/6/9 21:11
 */
@Slf4j
public class ShiroLogoutFilter extends LogoutFilter {

    /**
     * 退出后重定向的地址
     */
    private String loginUrl;

    private Cache<String, Deque<Serializable>> cache;

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    // 设置Cache的key的前缀
    public void setCacheManager(CacheManager cacheManager) {
        // 必须和ehcache缓存配置中的缓存name一致
        this.cache = cacheManager.getCache(Constants.SYS_USER_CACHE);
    }

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        try {
            Subject subject = getSubject(request, response);
            String redirectUrl = getRedirectUrl(request, response, subject);
            try {
                LoginUser user = ShiroUtils.getLoginUser();
                if (StringUtils.isNotNull(user)) {
                    String username = user.getUsername();
                    // 记录用户退出日志
                    SpringUtils.getBean(SysLoginLogService.class).insertLoginLog(username, StatusEnum.ENABLE.getCode(), "退出成功");
                    // 清理缓存
                    removeUserCache(username, ShiroUtils.getSessionId());
                }
                // 退出登录
                subject.logout();
            } catch (SessionException ise) {
                log.error("logout fail.", ise);
            }
            issueRedirect(request, response, redirectUrl);
        } catch (Exception e) {
            log.error("Encountered session exception during logout.  This can generally safely be ignored.", e);
        }
        return false;
    }

    public void removeUserCache(String username, String sessionId) {
        Deque<Serializable> deque = cache.get(username);
        if (StringUtils.isEmpty(deque) || deque.size() == 0) {
            return;
        }
        deque.remove(sessionId);
        cache.put(username, deque);
    }

    /**
     * 退出跳转URL
     */
    @Override
    protected String getRedirectUrl(ServletRequest request, ServletResponse response, Subject subject) {
        String url = getLoginUrl();
        if (StringUtils.isNotEmpty(url)) {
            return url;
        }
        return super.getRedirectUrl(request, response, subject);
    }
}
