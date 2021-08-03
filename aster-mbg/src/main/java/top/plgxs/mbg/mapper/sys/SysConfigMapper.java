package top.plgxs.mbg.mapper.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import top.plgxs.mbg.dto.export.ConfigExport;
import top.plgxs.mbg.entity.sys.SysConfig;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Stranger。
 * @since 2021-06-13
 * @version 1.0
 */
public interface SysConfigMapper extends BaseMapper<SysConfig> {

    /**
     * 分页数据查询
     * @param sysConfig
     * @return
     * @author Stranger。
     * @date 2021-06-13
     */
    List<SysConfig> selectSysConfigList(SysConfig sysConfig);

    /**
     * 切换主题
     * @param key
     * @param value
     * @return int
     * @author Stranger。
     * @since 2021/6/27
     */
    int switchTheme(@Param("key") String key, @Param("value") String value);

    /**
     * 导出
     * @param queryWrapper
     * @return java.util.List<top.plgxs.mbg.dto.export.ConfigExport>
     * @author Stranger。
     * @since 2021/7/24
     */
    List<ConfigExport> export(@Param(Constants.WRAPPER) QueryWrapper<SysConfig> queryWrapper);
}
