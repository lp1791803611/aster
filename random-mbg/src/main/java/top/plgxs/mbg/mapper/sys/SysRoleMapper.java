package top.plgxs.mbg.mapper.sys;

import top.plgxs.mbg.entity.sys.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author Stranger。
 * @since 2021-01-27
 * @version 1.0
 */
@Repository("sysRoleMapper")
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 分页数据查询
     * @param sysRole
     * @return
     * @author Stranger。
     * @date 2021-01-27
     */
    List<SysRole> selectSysRoleList(SysRole sysRole);
}
