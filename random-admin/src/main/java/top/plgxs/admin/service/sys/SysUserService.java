package top.plgxs.admin.service.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.plgxs.mbg.dto.sys.UserDto;
import top.plgxs.mbg.entity.sys.SysUser;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-12
 * @version 1.0
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 数据查询列表
     * @return
     * @author Stranger。
     * @date 2021-02-12
     */
    List<SysUser> getSysUserList();

    /**
     * 分页查询
     * @param page
     * @param queryWrapper
     * @return com.baomidou.mybatisplus.core.metadata.IPage<top.plgxs.mbg.dto.sys.UserDto>
     * @author Stranger。
     * @since 2021/2/12
     */
    IPage<UserDto> selectUserPage(Page<UserDto> page, QueryWrapper<UserDto> queryWrapper);
}
