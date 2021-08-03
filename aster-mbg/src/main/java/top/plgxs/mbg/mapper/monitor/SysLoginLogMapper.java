package top.plgxs.mbg.mapper.monitor;

import top.plgxs.mbg.entity.monitor.SysLoginLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 系统访问记录 Mapper 接口
 * </p>
 *
 * @author Stranger。
 * @since 2021-07-02
 * @version 1.0
 */
public interface SysLoginLogMapper extends BaseMapper<SysLoginLog> {

    /**
     * 分页数据查询
     * @param sysLoginLog
     * @return
     * @author Stranger。
     * @date 2021-07-02
     */
    List<SysLoginLog> selectSysLoginLogList(SysLoginLog sysLoginLog);
}
