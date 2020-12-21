package top.plgxs.mbg.mapper.sys;

import top.plgxs.mbg.entity.sys.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
    *  Mapper 接口
    * </p>
 *
 * @author Stranger
 * @since 2020-12-21
 */
@Repository("sysUserMapper")
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 分页数据查询
     * @param sysUser
     * @return
     */
    List<SysUser> selectSysUserList(SysUser sysUser);
}
