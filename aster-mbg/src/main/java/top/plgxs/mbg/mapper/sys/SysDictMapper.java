package top.plgxs.mbg.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.plgxs.mbg.entity.sys.SysDict;

import java.util.List;

/**
 * <p>
 * 字典数据 Mapper 接口
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-23
 * @version 1.0
 */
public interface SysDictMapper extends BaseMapper<SysDict> {

    /**
     * 分页数据查询
     * @param sysDict
     * @return
     * @author Stranger。
     * @date 2021-02-23
     */
    List<SysDict> selectSysDictList(SysDict sysDict);
}
