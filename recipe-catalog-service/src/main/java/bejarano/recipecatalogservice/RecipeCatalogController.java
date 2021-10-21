package bejarano.recipecatalogservice;


import bejarano.recipecatalogservice.models.Rating;
import bejarano.recipecatalogservice.models.Recipe;
import bejarano.recipecatalogservice.models.RecipeDetails;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/catalog")
@Log
public class RecipeCatalogController {

    private RestTemplate restTemplate;

/*    @Autowired
    private WebClient.Builder webClientBuilder;*/

    @Autowired
    public void setRestTemplate(RestTemplate template) {
        restTemplate = template;
    }

    @GetMapping//http://localhost:7071/api/v1/catalog?id=3
    public List<Recipe> getRecipies(@RequestParam("id") Long userId) {

        Rating[] ratings = restTemplate.getForObject("http://localhost:7073/api/v1/rating?id=" +
                userId, Rating[].class);
        assert ratings != null;
        //for(Rating r: ratings) log.info(String.valueOf(r.getRating()));
        //List<Rating> ratingList = Arrays.asList(ratings);

        return Arrays.asList(ratings).stream().map(rating -> {
            RecipeDetails recipeDetails = restTemplate.getForObject("http://localhost:7072/api/v1/details?id=" +
                    rating.getRecipeId(), RecipeDetails.class);

               /* WebClient Aproach
               RecipeDetails recipeDetails = webClientBuilder.build()
                        .get()//Type of call
                        .uri("http://localhost:7072/api/v1/details?id=" + rating.getRecipeId())
                        .retrieve()// OK ahora fetch the data
                        .bodyToMono(RecipeDetails.class) //La clase a la que me tiene que adaptar los datos, es lo mismo que el segundo arg en restTemplate
                        .block();*/

            return new Recipe(recipeDetails.getName(),
                    "The great blend of spices on these broiled chicken breasts has a wonderful " +
                            "flavor and pairs well with many vegetable side dishes.",
                    4);
        }).collect(Collectors.toList());
    }
}




