package top.plgxs.mbg.config;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>Mybatis-plus Config</p>
 *
 * @Author Stranger。
 * @Date 2020/12/22 10:08
 * @Version 1.0
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisPlusConfig {

    /**
     * mybatis-plus 分页插件
     * @param
     * @return {@link PaginationInnerInterceptor}
     * @throws
     * @author Stranger。
     * @date 2020/12/22 10:17
     */
    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor(){
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        return paginationInnerInterceptor;
    }
}
