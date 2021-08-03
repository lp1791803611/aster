package top.plgxs.admin.service.impl.monitor;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import top.plgxs.admin.service.monitor.SysLoginLogService;
import top.plgxs.common.core.util.AddressUtils;
import top.plgxs.common.core.util.ServletUtils;
import top.plgxs.mbg.entity.monitor.SysLoginLog;
import top.plgxs.mbg.mapper.monitor.SysLoginLogMapper;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 系统访问记录 服务实现类
 * </p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021-07-02
 */
@Service
public class SysLoginLogServiceImpl extends ServiceImpl<SysLoginLogMapper, SysLoginLog> implements SysLoginLogService {
    @Resource
    private SysLoginLogMapper sysLoginLogMapper;
    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public List<SysLoginLog> getSysLoginLogList() {
        return sysLoginLogMapper.selectSysLoginLogList(null);
    }

    /**
     * 新增登录日志
     *
     * @param username 用户名
     * @param status   状态
     * @param message  消息
     * @return void
     * @author Stranger。
     * @since 2021/7/3
     */
    @Override
    public void insertLoginLog(String username, String status, String message) {
        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        // 获取客户端操作系统
        String os = userAgent.getOperatingSystem().getName();
        // 获取客户端浏览器
        String browser = userAgent.getBrowser().getName();
        String ip = ServletUtils.getRequestIp(ServletUtils.getRequest());
        String address = AddressUtils.getRealAddressByIP(ip);
        SysLoginLog loginLog = new SysLoginLog();
        loginLog.setLoginName(username);
        loginLog.setIpAddress(ip);
        loginLog.setLoginLocation(address);
        loginLog.setBrowser(browser);
        loginLog.setOs(os);
        loginLog.setMsg(message);
        // 日志状态
        loginLog.setStatus(status);
        loginLog.setLoginTime(LocalDateTime.now());
        threadPoolTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                sysLoginLogMapper.insert(loginLog);
            }
        });
    }
}
