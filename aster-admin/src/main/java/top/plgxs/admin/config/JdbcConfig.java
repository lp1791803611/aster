package top.plgxs.admin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Stranger。
 * @version 1.0
 * @since 2021/7/11 19:16
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.dynamic.datasource.master")
public class JdbcConfig {
    private String url;
    private String username;
    private String password;
}
