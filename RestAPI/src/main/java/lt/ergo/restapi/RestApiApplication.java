package lt.ergo.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
@EnableConfigurationProperties
//@EntityScan(basePackages = {"lt.ergo.entities"})
//@ComponentScan(basePackages = { "lt.ergo.restapi","lt.ergo.repositories","lt.ergo.services"} )
//@SpringBootApplication(scanBasePackages = "lt.ergo")
@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}
