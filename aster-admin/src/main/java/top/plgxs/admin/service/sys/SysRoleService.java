package top.plgxs.admin.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import top.plgxs.common.core.api.node.ZTreeNode;
import top.plgxs.mbg.entity.sys.SysRole;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-22
 * @version 1.0
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     * 数据查询列表
     * @return
     * @author Stranger。
     * @date 2021-02-22
     */
    List<SysRole> getSysRoleList();

    /**
     * 查询组装成ztree格式
     * @param userId
     * @return java.util.List<top.plgxs.common.node.ZTreeNode>
     * @author Stranger。
     * @since 2021/2/13
     */
    List<ZTreeNode> roleTreeList(String userId);

    /**
     * 根据用户id查询角色编码
     * @param userId 用户id
     * @return java.util.Set<java.lang.String>
     * @author Stranger。
     * @since 2021/3/16
     */
    Set<String> getRoleCodeByUserId(String userId);

}
