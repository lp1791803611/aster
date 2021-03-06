package top.plgxs.mbg.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.data.repository.query.Param;
import top.plgxs.common.core.api.node.ZTreeNode;
import top.plgxs.mbg.entity.sys.SysRole;

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

    /**
     * 根据用户查询角色
     * @param userId
     * @return java.util.List<top.plgxs.mbg.entity.sys.SysRole>
     * @author Stranger。
     * @since 2021/6/10
     */
    List<SysRole> selectByUserId(@Param("userId") String userId);

    /**
     * 查询用户是否为超级管理员
     * @param userId 用户id
     * @param superCode 超级管理员角色编码
     * @return java.util.List<top.plgxs.mbg.entity.sys.SysRole>
     * @author Stranger。
     * @since 2021/6/10
     */
    List<SysRole> isAdmin(@Param("userId") String userId, @Param("superCode") String superCode);
}
