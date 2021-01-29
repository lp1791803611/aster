package top.plgxs.mbg.mapper.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.data.repository.query.Param;
import top.plgxs.mbg.entity.sys.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author Stranger。
 * @since 2021-01-29
 * @version 1.0
 */
@Repository("sysUserMapper")
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 分页数据查询
     * @param sysUser
     * @return
     * @author Stranger。
     * @date 2021-01-29
     */
    List<SysUser> selectSysUserList(SysUser sysUser);

    IPage<Map<String,Object>> selectUserPage(Page<Map<String,Object>> page,
                                             @Param(Constants.WRAPPER) QueryWrapper<Map<String,Object>> queryWrapper);
}
