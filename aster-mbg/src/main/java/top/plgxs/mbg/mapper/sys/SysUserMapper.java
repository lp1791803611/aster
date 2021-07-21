package top.plgxs.mbg.mapper.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import top.plgxs.mbg.dto.sys.UserDto;
import top.plgxs.mbg.dto.gen.TableColumn;
import top.plgxs.mbg.entity.sys.SysUser;

import java.util.List;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-12
 * @version 1.0
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 分页数据查询
     * @param sysUser
     * @return
     * @author Stranger。
     * @date 2021-02-12
     */
    List<SysUser> selectSysUserList(SysUser sysUser);

    /**
     * 分页查询
     * @param page
     * @param queryWrapper
     * @return com.baomidou.mybatisplus.core.metadata.IPage<java.util.Map < java.lang.String, java.lang.Object>>
     * @author Stranger。
     * @since 2021/2/10
     */
    IPage<UserDto> selectUserPage(Page<UserDto> page, @Param(Constants.WRAPPER) QueryWrapper<UserDto> queryWrapper);

    /**
     * 获取数据库业务表名
     * @param database 数据库
     * @return java.util.List<java.lang.String>
     * @author Stranger。
     * @since 2021/7/9
     */
    List<String> getTableNames(@Param("database") String database);

    /**
     * 获取表字段信息
     * @param database 数据库
     * @param tableName 表名
     * @author Stranger。
     * @since 2021/7/9
     */
    List<TableColumn> getTableColumn(@Param("database") String database, @Param("tableName") String tableName);
}
