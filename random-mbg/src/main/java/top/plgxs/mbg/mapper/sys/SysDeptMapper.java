package top.plgxs.mbg.mapper.sys;

import top.plgxs.mbg.entity.sys.SysDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 部门 Mapper 接口
 * </p>
 *
 * @author Stranger。
 * @since 2021-01-30
 * @version 1.0
 */
@Repository("sysDeptMapper")
public interface SysDeptMapper extends BaseMapper<SysDept> {

    /**
     * 分页数据查询
     * @param sysDept
     * @return
     * @author Stranger。
     * @date 2021-01-30
     */
    List<SysDept> selectSysDeptList(SysDept sysDept);
}