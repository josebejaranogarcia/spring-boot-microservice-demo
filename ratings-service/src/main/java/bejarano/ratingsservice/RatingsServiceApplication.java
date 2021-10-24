package bejarano.ratingsservice;

import bejarano.ratingsservice.models.UserRatings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class RatingsServiceApplication {

	@Bean
	public UserRatings getUserRatings(){return new UserRatings();}

	public static void main(String[] args) {
		SpringApplication.run(RatingsServiceApplication.class, args);
	}

}
