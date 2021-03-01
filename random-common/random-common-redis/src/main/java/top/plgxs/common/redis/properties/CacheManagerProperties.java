package top.plgxs.common.redis.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>redis缓存过期时间</p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/3/1 0001 16:16
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "random.cache-manager")
public class CacheManagerProperties {
    private List<CacheConfig> configs;

    @Getter
    @Setter
    public static class CacheConfig{
        /**
         * cache key
         */
        private String key;
        /**
         * 过期时间
         */
        private long second = 3600L;
    }
}
