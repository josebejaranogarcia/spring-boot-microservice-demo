package bejarano.recipecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class RecipeCatalogServiceApplication {

    @Bean
    public RestTemplate getRestTemplate() {
       HttpComponentsClientHttpRequestFactory clientHttpRequestFactory= new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectionRequestTimeout(3000);
        return new RestTemplate();
    }

/*   To Web ClientApproach
 @Bean
    public WebClient.Builder getWebClient() {
        return WebClient.builder();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(RecipeCatalogServiceApplication.class, args);
    }
}
