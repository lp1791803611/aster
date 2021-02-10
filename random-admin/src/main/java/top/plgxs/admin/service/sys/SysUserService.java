package top.plgxs.admin.service.sys;

import top.plgxs.mbg.entity.sys.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-10
 * @version 1.0
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 数据查询列表
     * @return
     * @author Stranger。
     * @date 2021-02-10
     */
    List<SysUser> getSysUserList();
}
