package bejarano.recipecatalogservice;

import bejarano.recipecatalogservice.models.Rating;
import bejarano.recipecatalogservice.models.Recipe;
import bejarano.recipecatalogservice.models.RecipeDetails;
import bejarano.recipecatalogservice.models.UserRatings;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/catalog")
@Log
public class RecipeCatalogController {

    private final RestTemplate restTemplate;
    private List<Rating>ratings;
    @Value("${rating-service-url}")
    private String urlRating;
    @Value("${details-service-url}")
    private String urlDetails;

    public RecipeCatalogController(RestTemplate template) {
        restTemplate = template;
    }

    

    @GetMapping
    public List<Recipe> getRecipes(@RequestParam("id") int userId) {

        UserRatings userRatings = restTemplate.getForObject(urlRating + "?id=" +
                userId, UserRatings.class);
        assert userRatings != null;
        ratings = userRatings.getRatings();

       checkRatingsFromUserRatings();

        return ratings.stream().map(rating -> {
            RecipeDetails recipeDetails = restTemplate.getForObject(urlDetails+"?id=" +
                    rating.getRecipeId(), RecipeDetails.class);
            assert recipeDetails != null;

            return new Recipe(recipeDetails.getTitle(),
                    recipeDetails.getSummary(),
                    rating.getRating());
        }).collect(Collectors.toList());
    }

    //Only to check ,delete later
    private void checkRatingsFromUserRatings() {
        for(Rating r: ratings) log.info(String.valueOf(r.getRating()));
    }
}

/*  WebClient Approach

    @Autowired
    private WebClient.Builder webClientBuilder;*/

      /*
               RecipeDetails recipeDetails = webClientBuilder.build()
                        .get()//Type of call
                        .uri("http://localhost:7072/api/v1/details?id=" + rating.getRecipeId())
                        .retrieve()// OK ahora fetch the data
                        .bodyToMono(RecipeDetails.class) //La clase a la que me tiene que adaptar los datos, es lo mismo que el segundo arg en restTemplate
                        .block();// Bloqueamos la ejecuci'on hasta que tengamos la lista, es decir, convertimos la comunicacion en sincrona*/

