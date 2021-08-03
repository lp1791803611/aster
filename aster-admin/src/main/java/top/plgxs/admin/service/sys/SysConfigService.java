package top.plgxs.admin.service.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import top.plgxs.mbg.dto.export.ConfigExport;
import top.plgxs.mbg.entity.sys.SysConfig;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Stranger。
 * @since 2021-06-13
 * @version 1.0
 */
public interface SysConfigService extends IService<SysConfig> {
    /**
     * 数据查询列表
     * @return
     * @author Stranger。
     * @date 2021-06-13
     */
    List<SysConfig> getSysConfigList();

    /**
     * 切换主题
     * @param value 值
     * @return int
     * @author Stranger。
     * @since 2021/6/27
     */
    int switchTheme(String value);

    /**
     * 获取主题值
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/6/27
     */
    Integer getThemeValue();

    /**
     * 系统是否开放注册
     * @return boolean
     * @author Stranger。
     * @since 2021/6/30
     */
    boolean isRegister();

    /**
     * 根据key获取value
     * @param key
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/6/30
     */
    String getValueByKey(String key);

    /**
     * 更新
     * @param sysConfig
     * @return int
     * @author Stranger。
     * @since 2021/6/30
     */
    int updateConfig(SysConfig sysConfig);

    /**
     * 插入
     * @param sysConfig
     * @return int
     * @author Stranger。
     * @since 2021/6/30
     */
    int insertConfig(SysConfig sysConfig);

    /**
     * 清理缓存
     * @return void
     * @author Stranger。
     * @since 2021/7/3
     */
    void clearAll();

    /**
     * 导出
     * @param queryWrapper
     * @return java.util.List<top.plgxs.mbg.dto.export.ConfigExport>
     * @author Stranger。
     * @since 2021/7/24
     */
    List<ConfigExport> export(QueryWrapper<SysConfig> queryWrapper);
}
