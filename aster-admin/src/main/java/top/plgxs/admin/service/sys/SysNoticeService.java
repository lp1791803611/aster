package top.plgxs.admin.service.sys;

import top.plgxs.mbg.entity.sys.SysNotice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 通知公告 服务类
 * </p>
 *
 * @author Stranger.
 * @since 2021-07-16
 * @version 1.0
 */
public interface SysNoticeService extends IService<SysNotice> {
    /**
     * 数据查询列表
     * @return
     * @author Stranger.
     * @date 2021-07-16
     */
    List<SysNotice> getSysNoticeList();
}
