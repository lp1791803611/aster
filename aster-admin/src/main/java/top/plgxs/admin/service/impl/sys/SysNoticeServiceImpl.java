package top.plgxs.admin.service.impl.sys;

import top.plgxs.mbg.entity.sys.SysNotice;
import top.plgxs.mbg.mapper.sys.SysNoticeMapper;
import top.plgxs.admin.service.sys.SysNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 通知公告 服务实现类
 * </p>
 *
 * @author Stranger.
 * @since 2021-07-16
 * @version 1.0
 */
@Service
public class SysNoticeServiceImpl extends ServiceImpl<SysNoticeMapper, SysNotice> implements SysNoticeService {
    @Resource
    private SysNoticeMapper sysNoticeMapper;

    @Override
    public List<SysNotice> getSysNoticeList() {
        return sysNoticeMapper.selectSysNoticeList(null);
    }
}
