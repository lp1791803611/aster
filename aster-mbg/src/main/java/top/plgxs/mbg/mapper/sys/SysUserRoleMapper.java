package top.plgxs.mbg.mapper.sys;

import org.springframework.data.repository.query.Param;
import top.plgxs.mbg.entity.sys.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户角色 Mapper 接口
 * </p>
 *
 * @author Stranger。
 * @since 2021-02-13
 * @version 1.0
 */
@Repository("sysUserRoleMapper")
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    /**
     * 分页数据查询
     * @param sysUserRole
     * @return
     * @author Stranger。
     * @date 2021-02-13
     */
    List<SysUserRole> selectSysUserRoleList(SysUserRole sysUserRole);

    /**
     * 查询用户所属角色id
     * @param userId 用户id
     * @return java.util.List<java.lang.String>
     * @author Stranger。
     * @since 2021/3/16
     */
    List<String> getRoleIdByUserId(@Param("userId") String userId);
}
