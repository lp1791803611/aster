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

    /**
     * 插入
     * @param user
     * @return void
     * @author Stranger。
     * @since 2021/2/13
     */
    void insertUser(UserDto user);

    /**
     * 根据用户id查询职位
     * @param userId 用户id
     * @return java.util.List<java.lang.String>
     * @author Stranger。
     * @since 2021/2/13
     */
    List<String> selectPositionsByUserId(String userId);

    /**
     * 更新
     * @param userDto
     * @return void
     * @author Stranger。
     * @since 2021/2/13
     */
    void updateUser(UserDto userDto);

    /**
     * 删除
     * @param userId 用户id
     * @return void
     * @author Stranger。
     * @since 2021/2/13
     */
    void deleteUser(String userId);

    /**
     * 批量删除
     * @param userIds 用户ids
     * @return void
     * @author Stranger。
     * @since 2021/2/13
     */
    void deleteBatchUser(List<String> userIds);


}
