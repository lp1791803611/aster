package top.plgxs.mbg.mapper.sys;

import top.plgxs.mbg.entity.sys.SysUserPosition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

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
@Repository("sysUserPositionMapper")
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
