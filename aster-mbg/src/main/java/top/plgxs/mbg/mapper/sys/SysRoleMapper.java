package top.plgxs.mbg.mapper.sys;

import top.plgxs.common.core.api.node.ZTreeNode;
import top.plgxs.mbg.entity.sys.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-13
 * @version 1.0
 */
@Repository("sysRoleMapper")
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 分页数据查询
     * @param sysRole
     * @return
     * @author Stranger。
     * @date 2021-02-13
     */
    List<SysRole> selectSysRoleList(SysRole sysRole);

    /**
     * 查询ztree格式的角色列表
     * @return java.util.List<top.plgxs.common.node.ZTreeNode>
     * @author Stranger。
     * @since 2021/2/13
     */
    List<ZTreeNode> roleTreeList();

}
