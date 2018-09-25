package netisov.timofei.customersapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = {"netisov.timofei"})
public class CustomersAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersAppApplication.class, args);
	}
}
