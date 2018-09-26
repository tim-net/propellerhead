package netisov.timofei.propellerhead.customersapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"netisov.timofei"})
public class CustomersAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersAppApplication.class, args);
	}
}
