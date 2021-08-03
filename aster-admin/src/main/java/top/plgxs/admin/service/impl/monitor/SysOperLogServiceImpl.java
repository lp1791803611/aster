package top.plgxs.admin.service.impl.monitor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.plgxs.admin.service.monitor.SysOperLogService;
import top.plgxs.mbg.entity.monitor.SysOperLog;
import top.plgxs.mbg.mapper.monitor.SysOperLogMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author Stranger。
 * @since 2021-07-02
 * @version 1.0
 */
@Service
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements SysOperLogService {
    @Resource
    private SysOperLogMapper sysOperLogMapper;

    /**
     * 数据查询列表
     * @return
     * @author Stranger。
     * @date 2021-07-02
     */
    @Override
    public List<SysOperLog> getSysOperLogList() {
        return sysOperLogMapper.selectSysOperLogList(null);
    }

    /**
     * 清空操作日志
     * @return void
     * @author Stranger。
     * @since 2021/7/3
     */
    @Override
    public void clear() {
        QueryWrapper<SysOperLog> queryWrapper = new QueryWrapper<>();
        sysOperLogMapper.delete(queryWrapper);
    }
}
