package top.plgxs.admin.service.impl.sys;

import top.plgxs.mbg.entity.sys.SysPosition;
import top.plgxs.mbg.mapper.sys.SysPositionMapper;
import top.plgxs.admin.service.sys.SysPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 职位 服务实现类
 * </p>
 *
 * @author Stranger。
 * @since 2021-01-30
 * @version 1.0
 */
@Service
public class SysPositionServiceImpl extends ServiceImpl<SysPositionMapper, SysPosition> implements SysPositionService {
    @Resource
    private SysPositionMapper sysPositionMapper;

    @Override
    public List<SysPosition> getSysPositionList() {
        return sysPositionMapper.selectSysPositionList(null);
    }
}
