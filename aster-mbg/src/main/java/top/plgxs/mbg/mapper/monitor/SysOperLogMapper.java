package top.plgxs.mbg.mapper.monitor;

import top.plgxs.mbg.entity.monitor.SysOperLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 操作日志记录 Mapper 接口
 * </p>
 *
 * @author Stranger。
 * @since 2021-07-02
 * @version 1.0
 */
public interface SysOperLogMapper extends BaseMapper<SysOperLog> {

    /**
     * 分页数据查询
     * @param sysOperLog
     * @return
     * @author Stranger。
     * @date 2021-07-02
     */
    List<SysOperLog> selectSysOperLogList(SysOperLog sysOperLog);
}
