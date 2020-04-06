package rs.in.andric.demo.PraksaPrvi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "rs.in.andric.demo.PraksaPrvi.Repository")
@SpringBootApplication
public class PraksaPrviApplication {

	public static void main(String[] args) {
		SpringApplication.run(PraksaPrviApplication.class, args);
	}

}
