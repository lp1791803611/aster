package top.plgxs.admin.service.impl.sys;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.plgxs.admin.service.sys.SysConfigService;
import top.plgxs.common.core.constants.Constants;
import top.plgxs.common.core.constants.enums.StatusEnum;
import top.plgxs.common.redis.constant.RedisConstant;
import top.plgxs.common.redis.util.RedisUtils;
import top.plgxs.mbg.dto.export.ConfigExport;
import top.plgxs.mbg.entity.sys.SysConfig;
import top.plgxs.mbg.mapper.sys.SysConfigMapper;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Stranger。
 * @since 2021-06-13
 * @version 1.0
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {
    @Resource
    private SysConfigMapper sysConfigMapper;
    @Resource
    private RedisUtils redisUtils;
    /**
     * 项目启动时，初始化系统设置到缓存
     * @return void
     * @author Stranger。
     * @since 2021/3/23
     */
    @PostConstruct
    public void init() {
        QueryWrapper<SysConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", StatusEnum.ENABLE.getCode());
        List<SysConfig> configs = this.list(queryWrapper);
        if (CollUtil.isNotEmpty(configs)) {
            for (SysConfig config : configs) {
                redisUtils.set(RedisConstant.SYS_CONFIG_KEY + config.getConfigKey(), config.getConfigValue());
            }
        }
    }

    /**
     * 数据查询列表
     * @return
     * @author Stranger。
     * @date 2021-06-13
     */
    @Override
    public List<SysConfig> getSysConfigList() {
        return sysConfigMapper.selectSysConfigList(null);
    }

    /**
     * 切换主题
     * @param value
     * @return int
     * @author Stranger。
     * @since 2021/6/27
     */
    @Override
    public int switchTheme(String value) {
        int result = sysConfigMapper.switchTheme(Constants.THEME_CONFIG_KEY, value);
        if (result > 0) {
            redisUtils.set(RedisConstant.SYS_CONFIG_KEY + Constants.THEME_CONFIG_KEY, value);
        }
        return result;
    }

    /**
     * 获取主题值
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/6/27
     */
    @Override
    public Integer getThemeValue() {
        String value = getValueByKey(Constants.THEME_CONFIG_KEY);
        return Integer.parseInt(value);
    }

    /**
     * 系统是否开放注册
     * @return boolean
     * @author Stranger。
     * @since 2021/6/30
     */
    @Override
    public boolean isRegister() {
        String value = getValueByKey(Constants.REGISTER_CONFIG_KEY);
        return "true".equals(value);
    }

    /**
     * 根据key获取value
     * @param key
     * @return java.lang.String
     * @author Stranger。
     * @since 2021/6/30
     */
    @Override
    public String getValueByKey(String key) {
        // 先从缓存中查一下
        String value = (String) redisUtils.get(RedisConstant.SYS_CONFIG_KEY + key);
        if (StrUtil.isNotBlank(value)) {
            return value;
        }
        // 缓存没有再从数据库查
        QueryWrapper<SysConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("config_key", key)
                .eq("status", StatusEnum.ENABLE.getCode());
        List<SysConfig> list = sysConfigMapper.selectList(queryWrapper);
        if (CollUtil.isNotEmpty(list)) {
            value = list.get(0).getConfigValue();
            if (StrUtil.isNotBlank(value)) {
                redisUtils.set(RedisConstant.SYS_CONFIG_KEY + key, value);
                return value;
            }
        }
        return null;
    }

    /**
     * 更新
     * @param sysConfig
     * @return int
     * @author Stranger。
     * @since 2021/6/30
     */
    @Override
    public int updateConfig(SysConfig sysConfig) {
        sysConfig.setGmtModified(LocalDateTime.now());
        int result = sysConfigMapper.updateById(sysConfig);
        if (result > 0) {
            redisUtils.set(RedisConstant.SYS_CONFIG_KEY + sysConfig.getConfigKey(), sysConfig.getConfigValue());
        }
        return result;
    }

    /**
     * 插入
     * @param sysConfig
     * @return int
     * @author Stranger。
     * @since 2021/6/30
     */
    @Override
    public int insertConfig(SysConfig sysConfig) {
        sysConfig.setGmtCreate(LocalDateTime.now());
        int result = sysConfigMapper.insert(sysConfig);
        if (result > 0) {
            redisUtils.set(RedisConstant.SYS_CONFIG_KEY + sysConfig.getConfigKey(), sysConfig.getConfigValue());
        }
        return result;
    }

    /**
     * 清理缓存
     * @return void
     * @author Stranger。
     * @since 2021/7/3
     */
    @Override
    public void clearAll() {
        String keyPrex = RedisConstant.SYS_CONFIG_KEY;
        redisUtils.removeAll(keyPrex);
    }

    /**
     * 导出
     * @param queryWrapper
     * @return java.util.List<top.plgxs.mbg.dto.export.ConfigExport>
     * @author Stranger。
     * @since 2021/7/24
     */
    @Override
    public List<ConfigExport> export(QueryWrapper<SysConfig> queryWrapper) {
        return sysConfigMapper.export(queryWrapper);
    }

}
