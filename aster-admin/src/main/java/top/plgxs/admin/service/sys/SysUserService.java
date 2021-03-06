package top.plgxs.admin.service.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.plgxs.mbg.dto.export.UserExport;
import top.plgxs.mbg.dto.gen.TableColumn;
import top.plgxs.mbg.dto.sys.LoginUser;
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

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return top.plgxs.mbg.entity.sys.SysUser
     * @author Stranger。
     * @since 2021/3/4
     */
    SysUser getUserByUsername(String username);

    /**
     * 登录
     * @param username
     * @param password
     * @return top.plgxs.mbg.dto.sys.LoginUser
     * @author Stranger。
     * @since 2021/6/1
     */
    LoginUser login(String username, String password);

    /**
     * 注册
     * @param user
     * @return void
     * @author Stranger。
     * @since 2021/6/7
     */
    void register(SysUser user);

    /**
     * 登录检查
     * @param user
     * @param password
     * @return void
     * @author Stranger。
     * @since 2021/6/1
     */
    void check(SysUser user, String password);

    /**
     * 是否超级管理员
     * @param user 用户
     * @return boolean
     * @author Stranger。
     * @since 2021/6/1
     */
    boolean isAdmin(LoginUser user);

    /**
     * 用户名是否唯一
     * @param username 用户名
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/6/7
     */
    String checkUserNameUnique(String username);

    /**
     * 设置密码
     * @param username 用户名
     * @param password 密码
     * @param salt 密钥
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/6/7
     */
    String encryptPassword(String username, String password, String salt);

    /**
     * 更新用户基本资料
     * @param userDto
     * @return int
     * @author Stranger。
     * @since 2021/6/26
     */
    int updateBaseInfo(UserDto userDto);

    /**
     * 更新密码
     * @param userDto
     * @return int
     * @author Stranger。
     * @since 2021/6/26
     */
    int updatePassword(UserDto userDto);

    /**
     * 重置密码
     * @param id 用户id
     * @return int
     * @author Stranger。
     * @since 2021/6/30
     */
    int resetPassword(String id);

    /**
     * 解锁用户
     * @param username
     * @return void
     * @author Stranger。
     * @since 2021/7/4
     */
    void clearLoginRecordCache(String username);

    /**
     * 获取数据库业务表名
     * @return java.util.List<java.lang.String>
     * @author Stranger。
     * @since 2021/7/9
     */
    List<String> getTableNames();

    /**
     * 获取表字段信息
     * @param tableName
     * @author Stranger。
     * @since 2021/7/9
     */
    List<TableColumn> getTableColumn(String tableName);

    /**
     * 导出excel
     * @param name
     * @param deptId 部门id
     * @return java.util.List<top.plgxs.mbg.entity.sys.SysUser>
     * @author Stranger。
     * @since 2021/7/24
     */
    List<UserExport> export(String name, String deptId);
}
