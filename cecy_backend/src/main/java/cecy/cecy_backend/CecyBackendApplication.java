package cecy.cecy_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients 
@SpringBootApplication
public class CecyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CecyBackendApplication.class, args);
	}

}
