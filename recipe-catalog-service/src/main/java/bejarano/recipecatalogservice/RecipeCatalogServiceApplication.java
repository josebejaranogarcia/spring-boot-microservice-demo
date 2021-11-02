package bejarano.recipecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RecipeCatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeCatalogServiceApplication.class, args);
    }
}
