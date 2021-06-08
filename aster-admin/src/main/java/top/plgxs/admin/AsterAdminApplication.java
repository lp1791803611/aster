package top.plgxs.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "top.plgxs")
@MapperScan("top.plgxs.mbg.mapper")
@EnableTransactionManagement
public class AsterAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsterAdminApplication.class, args);
	}

}
