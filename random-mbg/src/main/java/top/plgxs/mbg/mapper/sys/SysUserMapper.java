package top.plgxs.mbg.mapper.sys;

import top.plgxs.mbg.entity.sys.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author Stranger
 * @since 2020-12-23
 * @version 1.0
 */
@Repository("sysUserMapper")
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 分页数据查询
     * @param sysUser
     * @return
     * @author Stranger
     * @date 2020-12-23
     */
    List<SysUser> selectSysUserList(SysUser sysUser);
}
