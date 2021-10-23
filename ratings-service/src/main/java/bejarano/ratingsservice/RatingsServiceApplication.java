package bejarano.ratingsservice;

import bejarano.ratingsservice.models.UserRatings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RatingsServiceApplication {

	@Bean
	public UserRatings getUserRatings(){return new UserRatings();}

	public static void main(String[] args) {
		SpringApplication.run(RatingsServiceApplication.class, args);
	}

}
