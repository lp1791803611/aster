package top.plgxs.mbg.mapper.sys;

import top.plgxs.mbg.entity.sys.SysNotice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 通知公告 Mapper 接口
 * </p>
 *
 * @author Stranger.
 * @since 2021-07-16
 * @version 1.0
 */
public interface SysNoticeMapper extends BaseMapper<SysNotice> {

    /**
     * 分页数据查询
     * @param sysNotice
     * @return
     * @author Stranger.
     * @date 2021-07-16
     */
    List<SysNotice> selectSysNoticeList(SysNotice sysNotice);
}
