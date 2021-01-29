package top.plgxs.mbg.mapper.sys;

import top.plgxs.mbg.entity.sys.SysDictType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Stranger。
 * @since 2021-01-29
 * @version 1.0
 */
@Repository("sysDictTypeMapper")
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {

    /**
     * 分页数据查询
     * @param sysDictType
     * @return
     * @author Stranger。
     * @date 2021-01-29
     */
    List<SysDictType> selectSysDictTypeList(SysDictType sysDictType);
}
