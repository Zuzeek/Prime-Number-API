package ag.demo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class DemoPrimeNumberApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoPrimeNumberApplication.class, args);
	}

}
