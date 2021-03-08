package top.plgxs.common.security.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <p>装载BCrypt密码编码器</p>
 *
 * @author Stranger。
 * @version 1.0
 * @since 2021/3/8 0008 16:27
 */
@Configuration
public class UserPasswordEncoder {

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
