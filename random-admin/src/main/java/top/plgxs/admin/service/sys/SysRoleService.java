package top.plgxs.admin.service.sys;

import top.plgxs.mbg.entity.sys.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author Stranger。
 * @since 2020-12-27
 * @version 1.0
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     * 数据查询列表
     * @return
     * @author Stranger。
     * @date 2020-12-27
     */
    List<SysRole> getSysRoleList();
}
