package br.com.lp2.apiswithspringboot;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("br.")
@ComponentScan("br.")
//@EnableJpaRepositories(basePackages="br.com.lp2.apiswithspringboot.repository")
public class ProjetospringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetospringApplication.class, args);
	}

}
