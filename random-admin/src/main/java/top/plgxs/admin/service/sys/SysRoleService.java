package top.plgxs.admin.service.sys;

import top.plgxs.common.api.node.ZTreeNode;
import top.plgxs.mbg.entity.sys.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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
}
