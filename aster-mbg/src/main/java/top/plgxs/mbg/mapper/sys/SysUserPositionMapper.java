package top.plgxs.mbg.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.plgxs.mbg.entity.sys.SysUserPosition;

import java.util.List;

/**
 * <p>
 * 用户职位 Mapper 接口
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-13
 * @version 1.0
 */
public interface SysUserPositionMapper extends BaseMapper<SysUserPosition> {

    /**
     * 分页数据查询
     * @param sysUserPosition
     * @return
     * @author Stranger。
     * @date 2021-02-13
     */
    List<SysUserPosition> selectSysUserPositionList(SysUserPosition sysUserPosition);
}
