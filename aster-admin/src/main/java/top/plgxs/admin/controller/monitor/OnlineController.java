package top.plgxs.admin.controller.monitor;

import eu.bitwalker.useragentutils.UserAgent;
import io.swagger.annotations.Api;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.plgxs.admin.utils.ShiroUtils;
import top.plgxs.common.core.annotation.Log;
import top.plgxs.common.core.api.ResultInfo;
import top.plgxs.common.core.constants.Constants;
import top.plgxs.common.core.constants.enums.BusinessType;
import top.plgxs.common.core.util.*;
import top.plgxs.mbg.dto.sys.LoginUser;
import top.plgxs.mbg.dto.sys.OnlineUserDto;

import java.io.Serializable;
import java.util.*;

/**
 * 在线用户
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/5 19:11
 */
@Api(tags = "在线用户")
@Controller
@RequestMapping("/online")
public class OnlineController {
    @Autowired
    private RedisSessionDAO redisSessionDAO;

    /**
     * 跳转页面
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/7/6
     */
    @GetMapping("/list")
    public String list() {
        return "monitor/online/list";
    }

    /**
     * 分页
     * @param username
     * @return top.plgxs.common.core.api.ResultInfo<java.util.List<top.plgxs.mbg.dto.sys.OnlineUserDto>>
     * @author Stranger。
     * @since 2021/7/6
     */
    @PostMapping("/pageList")
    @ResponseBody
    public ResultInfo<List<OnlineUserDto>> pageList(@RequestParam(name = "username", required = false) String username){
        Collection<Session> sessions = redisSessionDAO.getActiveSessions();
        Iterator<Session> it = sessions.iterator();
        List<OnlineUserDto> sessionList = new ArrayList<>();
        while (it.hasNext()) {
            OnlineUserDto user = getSession(it.next());
            if (StringUtils.isNotNull(user)) {
                if (StringUtils.isNotEmpty(username)) {
                    if (StringUtils.equals(username, user.getUsername())) {
                        sessionList.add(user);
                    }
                } else {
                    sessionList.add(user);
                }
            }
        }
        return ResultInfo.success(sessionList);
    }

    /**
     * 批量强退用户
     * @param sysUserOnlines
     * @return top.plgxs.common.core.api.ResultInfo
     * @author Stranger。
     * @since 2021/7/6
     */
    @Log(title = "在线用户", businessType = BusinessType.FORCE)
    @PostMapping("/batchForceLogout")
    @ResponseBody
    public ResultInfo batchForceLogout(@RequestBody List<OnlineUserDto> sysUserOnlines) {
        for (OnlineUserDto userOnline : sysUserOnlines) {
            String sessionId = userOnline.getSessionId();
            String username = userOnline.getUsername();
            if (sessionId.equals(ShiroUtils.getSessionId())) {
                return ResultInfo.failed("当前登录用户无法强退");
            }
            redisSessionDAO.delete(redisSessionDAO.readSession(sessionId));
            removeUserCache(username, sessionId);
        }
        return ResultInfo.success();
    }

    private OnlineUserDto getSession(Session session) {
        Object obj = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        if (null == obj) {
            return null;
        }
        if (obj instanceof SimplePrincipalCollection) {
            SimplePrincipalCollection spc = (SimplePrincipalCollection) obj;
            obj = spc.getPrimaryPrincipal();
            if (null != obj && obj instanceof LoginUser) {
                LoginUser user = (LoginUser) obj;
                OnlineUserDto userOnline = new OnlineUserDto();
                userOnline.setSessionId(session.getId().toString());
                userOnline.setUsername(user.getUsername());
                userOnline.setIpaddr(session.getHost());
                userOnline.setStartTimestamp(TimeUtil.dateToLocalDateTime(session.getStartTimestamp()));
                userOnline.setLastAccessTime(TimeUtil.dateToLocalDateTime(session.getLastAccessTime()));

                UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                userOnline.setBrowser(browser);
                userOnline.setOs(os);
                String address = AddressUtils.getRealAddressByIP(session.getHost());
                userOnline.setLoginLocation(address);
                return userOnline;
            }
        }
        return null;
    }

    public void removeUserCache(String username, String sessionId) {
        Cache<String, Deque<Serializable>> cache = SpringUtils.getBean(RedisCacheManager.class).getCache(Constants.SYS_USER_CACHE);
        Deque<Serializable> deque = cache.get(username);
        if (StringUtils.isEmpty(deque) || deque.size() == 0) {
            return;
        }
        deque.remove(sessionId);
        cache.put(username, deque);
    }
}
