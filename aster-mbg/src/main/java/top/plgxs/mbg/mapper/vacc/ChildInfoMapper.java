package top.plgxs.mbg.mapper.vacc;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.plgxs.mbg.entity.vacc.ChildInfo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Stranger.
 * @since 2021-08-02
 * @version 1.0
 */
public interface ChildInfoMapper extends BaseMapper<ChildInfo> {

    /**
     * 分页数据查询
     * @param childInfo
     * @return
     * @author Stranger.
     * @date 2021-08-02
     */
    List<ChildInfo> selectChildInfoList(ChildInfo childInfo);
}
