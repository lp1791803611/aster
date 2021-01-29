package top.plgxs.mbg.mapper.sys;

import top.plgxs.mbg.entity.sys.SysDict;
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
@Repository("sysDictMapper")
public interface SysDictMapper extends BaseMapper<SysDict> {

    /**
     * 分页数据查询
     * @param sysDict
     * @return
     * @author Stranger。
     * @date 2021-01-29
     */
    List<SysDict> selectSysDictList(SysDict sysDict);
}
