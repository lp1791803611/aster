package top.plgxs.mbg.utils;

import cn.hutool.core.collection.CollUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import top.plgxs.common.redis.constant.RedisConstant;
import top.plgxs.common.redis.util.RedisUtils;
import top.plgxs.mbg.entity.sys.SysDict;

import javax.annotation.Resource;
import java.util.List;

/**
 * 字典工具类
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/3/23 22:04
 */
@Component
public class DictUtils {
    @Resource
    private RedisUtils redisUtils;

    /**
     * 分隔符
     */
    public static final String SEPARATOR = ",";

    /**
     * 设置字典缓存
     *
     * @param key       参数键
     * @param dictDatas 字典数据列表
     */
    public void setDictCache(String key, List<SysDict> dictDatas) {
        redisUtils.set(getCacheKey(key), dictDatas);
    }

    /**
     * 获取字典缓存
     *
     * @param key 参数键
     * @return dictDatas 字典数据列表
     */
    public List<SysDict> getDictCache(String key) {
        Object cacheObj = redisUtils.get(getCacheKey(key));
        if (cacheObj != null) {
            List<SysDict> dictDatas = (List<SysDict>) cacheObj;
            return dictDatas;
        }
        return null;
    }

    /**
     * 根据字典类型和字典值获取字典标签
     *
     * @param dictType  字典类型
     * @param dictValue 字典值
     * @return 字典标签
     */
    public String getDictLabel(String dictType, String dictValue) {
        return getDictLabel(dictType, dictValue, SEPARATOR);
    }

    /**
     * 根据字典类型和字典标签获取字典值
     *
     * @param dictType  字典类型
     * @param dictLabel 字典标签
     * @return 字典值
     */
    public String getDictValue(String dictType, String dictLabel) {
        return getDictValue(dictType, dictLabel, SEPARATOR);
    }

    /**
     * 根据字典类型和字典值获取字典标签
     *
     * @param dictType  字典类型
     * @param dictValue 字典值
     * @param separator 分隔符
     * @return 字典标签
     */
    public String getDictLabel(String dictType, String dictValue, String separator) {
        StringBuilder propertyString = new StringBuilder();
        List<SysDict> datas = getDictCache(dictType);

        if (StringUtils.containsAny(separator, dictValue) && CollUtil.isNotEmpty(datas)) {
            for (SysDict dict : datas) {
                for (String value : dictValue.split(separator)) {
                    if (value.equals(dict.getDictValue())) {
                        propertyString.append(dict.getDictLabel() + separator);
                        break;
                    }
                }
            }
        } else {
            for (SysDict dict : datas) {
                if (dictValue.equals(dict.getDictValue())) {
                    return dict.getDictLabel();
                }
            }
        }
        return StringUtils.stripEnd(propertyString.toString(), separator);
    }

    /**
     * 根据字典类型和字典标签获取字典值
     *
     * @param dictType  字典类型
     * @param dictLabel 字典标签
     * @param separator 分隔符
     * @return 字典值
     */
    public String getDictValue(String dictType, String dictLabel, String separator) {
        StringBuilder propertyString = new StringBuilder();
        List<SysDict> datas = getDictCache(dictType);

        if (StringUtils.containsAny(separator, dictLabel) && CollUtil.isNotEmpty(datas)) {
            for (SysDict dict : datas) {
                for (String label : dictLabel.split(separator)) {
                    if (label.equals(dict.getDictLabel())) {
                        propertyString.append(dict.getDictValue() + separator);
                        break;
                    }
                }
            }
        } else {
            for (SysDict dict : datas) {
                if (dictLabel.equals(dict.getDictLabel())) {
                    return dict.getDictValue();
                }
            }
        }
        return StringUtils.stripEnd(propertyString.toString(), separator);
    }

    /**
     * 清空字典缓存
     */
    public void clearDictCache() {
        redisUtils.removeAll(RedisConstant.SYS_DICT_KEY);
    }


    /**
     * 设置cache key
     *
     * @param configKey 参数键
     * @return 缓存键key
     */
    public String getCacheKey(String configKey) {
        return RedisConstant.SYS_DICT_KEY + configKey;
    }
}
