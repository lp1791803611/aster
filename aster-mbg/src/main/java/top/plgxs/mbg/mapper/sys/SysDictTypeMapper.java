package top.plgxs.mbg.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.plgxs.mbg.entity.sys.SysDictType;

import java.util.List;

/**
 * <p>
 * 字典类型 Mapper 接口
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-23
 * @version 1.0
 */
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {

    /**
     * 分页数据查询
     * @param sysDictType
     * @return
     * @author Stranger。
     * @date 2021-02-23
     */
    List<SysDictType> selectSysDictTypeList(SysDictType sysDictType);
}
