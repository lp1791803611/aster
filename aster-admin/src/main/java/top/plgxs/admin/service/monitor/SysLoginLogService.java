package top.plgxs.admin.service.monitor;

import com.baomidou.mybatisplus.extension.service.IService;
import top.plgxs.mbg.entity.monitor.SysLoginLog;

import java.util.List;

/**
 * <p>
 * 系统访问记录 服务类
 * </p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021-07-02
 */
public interface SysLoginLogService extends IService<SysLoginLog> {
    /**
     * 数据查询列表
     *
     * @return
     * @author Stranger。
     * @date 2021-07-02
     */
    List<SysLoginLog> getSysLoginLogList();

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
    void insertLoginLog(String username, String status, String message);
}
