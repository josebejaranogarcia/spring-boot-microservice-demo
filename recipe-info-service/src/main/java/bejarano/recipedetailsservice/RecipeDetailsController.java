package bejarano.recipedetailsservice;

import bejarano.recipedetailsservice.models.RecipeDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/details")
public class RecipeDetailsController {

    private final RestTemplate restTemplate;
    @Value("${api-key}")
    private String apiKey;
    @Value("${api-url}")
    private String apiUrl;

    public RecipeDetailsController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping
    public RecipeDetails getDetails(@RequestParam("id") int recipeId) {
        return restTemplate.getForObject(
  apiUrl + recipeId + "/summary/?apiKey="+ apiKey  + "&includeNutrition=false",
                RecipeDetails.class);

    }
}
