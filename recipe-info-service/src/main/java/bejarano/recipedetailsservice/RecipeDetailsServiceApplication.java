package bejarano.recipedetailsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RecipeDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeDetailsServiceApplication.class, args);
	}

}
