package top.plgxs.mbg.mapper.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import top.plgxs.mbg.entity.sys.SysUser;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021-02-10
 */
@Repository("sysUserMapper")
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 分页数据查询
     *
     * @param sysUser
     * @return
     * @author Stranger。
     * @date 2021-02-10
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
    IPage<Map<String, Object>> selectUserPage(Page<Map<String, Object>> page,
                                              @Param(Constants.WRAPPER) QueryWrapper<Map<String, Object>> queryWrapper);

}
