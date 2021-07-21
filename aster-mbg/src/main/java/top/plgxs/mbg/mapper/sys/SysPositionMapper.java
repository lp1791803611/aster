package top.plgxs.mbg.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.plgxs.mbg.entity.sys.SysPosition;

import java.util.List;

/**
 * <p>
 * 职位 Mapper 接口
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-01
 * @version 1.0
 */
public interface SysPositionMapper extends BaseMapper<SysPosition> {

    /**
     * 分页数据查询
     * @param sysPosition
     * @return
     * @author Stranger。
     * @date 2021-02-01
     */
    List<SysPosition> selectSysPositionList(SysPosition sysPosition);
}
