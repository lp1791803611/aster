package top.plgxs.admin.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import top.plgxs.common.core.config.BaseSwaggerConfig;
import top.plgxs.common.core.domain.SwaggerProperties;

/**
 * Swagger API文档相关配置
 * @author Stranger。
 * @version 1.0
 * @since 2021/2/25 19:51
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("top.plgxs.admin.controller")
                .title("Aster管理系统")
                .description("Aster相关接口文档")
                .contactName("Stranger.")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
