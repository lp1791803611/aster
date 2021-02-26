package top.plgxs.mbg.mapper.sys;

import top.plgxs.common.core.api.node.LayuiTreeNode;
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
 * @since 2021-02-08
 * @version 1.0
 */
@Repository("sysDeptMapper")
public interface SysDeptMapper extends BaseMapper<SysDept> {

    /**
     * 分页数据查询
     * @param sysDept
     * @return
     * @author Stranger。
     * @date 2021-02-08
     */
    List<SysDept> selectSysDeptList(SysDept sysDept);

    /**
     * 获取layui tree集合
     * @return java.util.List<top.plgxs.common.node.LayuiTreeNode>
     * @author Stranger。
     * @since 2021/2/10
     */
    List<LayuiTreeNode> layuiTree();

}
