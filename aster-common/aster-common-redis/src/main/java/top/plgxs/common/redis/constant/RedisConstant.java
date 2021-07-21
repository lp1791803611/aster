package top.plgxs.common.redis.constant;

/**
 * <p>Redis常量</p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/3/1 0001 16:40
 */
public class RedisConstant {
    /**
     * 默认过期时间
     * @author Stranger。
     * @since 2021/3/15
     */
    public static final Long DEFAULT_EXPIRE = 3600L;

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "aster:dict:";

    /**
     * 系统设置 cache key
     */
    public static final String SYS_CONFIG_KEY = "aster:config:";

    /**
     * 用户锁定 cache key
     */
    public static final String SYS_LOCK_USER = "aster:lock:";
}
