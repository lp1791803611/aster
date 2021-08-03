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
		System.out.println(
				"                         Aster启动成功                                \n" +
				"   ____        .-'''-.  ,---------.      .-''-.   .-------.          \n" +
				" .'  __ `.    / _     \\ \\          \\   .'_ _   \\  |  _ _   \\    \n" +
				"/   '  \\  \\  (`' )/`--'  `--.  ,---'  / ( ` )   ' | ( ' )  |       \n" +
				"|___|  /  | (_ o _).        |   \\    . (_ o _)  | |(_ o _) /        \n" +
				"   _.-`   |  (_,_). '.      :_ _:    |  (_,_)___| | (_,_).' __       \n" +
				".'   _    | .---.  \\  :     (_I_)    '  \\   .---. |  |\\ \\  |  |  \n" +
				"|  _( )_  | \\    `-'  |    (_(=)_)    \\  `-'    / |  | \\ `'   /   \n" +
				"\\ (_ o _) /  \\       /      (_I_)      \\       /  |  |  \\    /   \n" +
				" '.(_,_).'    `-...-'       '---'       `'-..-'   ''-'   `'-'        \n"
		);
	}

}
