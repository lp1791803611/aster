package top.plgxs.admin.service.monitor;

import top.plgxs.mbg.entity.monitor.SysOperLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 操作日志记录 服务类
 * </p>
 *
 * @author Stranger。
 * @since 2021-07-02
 * @version 1.0
 */
public interface SysOperLogService extends IService<SysOperLog> {
    /**
     * 数据查询列表
     * @return
     * @author Stranger。
     * @date 2021-07-02
     */
    List<SysOperLog> getSysOperLogList();

    /**
     * 清空操作日志
     * @return void
     * @author Stranger。
     * @since 2021/7/3
     */
    void clear();

}
