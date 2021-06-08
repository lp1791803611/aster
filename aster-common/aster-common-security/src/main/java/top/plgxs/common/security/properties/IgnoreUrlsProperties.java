package top.plgxs.common.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>配置白名单资源路径</p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/3/4 0004 15:59
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "secure.ignored")
public class IgnoreUrlsProperties {
    private List<String> urls = new ArrayList<>();
}
