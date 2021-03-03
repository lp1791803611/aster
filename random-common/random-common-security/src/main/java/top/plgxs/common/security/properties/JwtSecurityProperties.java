package top.plgxs.common.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <p>JWT配置信息</p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/3/3 0003 16:03
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtSecurityProperties {
    /**
     * JWT存储的请求头
     */
    private String tokenHeader;
    /**
     * JWT加解密使用的密钥
     */
    private String secret;
    /**
     * JWT令牌过期时间 此处单位/毫秒
     */
    private Long expiration;
    /**
     * JWT令牌前缀
     */
    private String tokenHead;

}
