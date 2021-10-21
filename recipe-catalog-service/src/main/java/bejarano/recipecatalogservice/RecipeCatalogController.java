package bejarano.recipecatalogservice;


import bejarano.recipecatalogservice.models.Rating;
import bejarano.recipecatalogservice.models.Recipe;
import bejarano.recipecatalogservice.models.RecipeDetails;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RecipeCatalogController {

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate template) {
        restTemplate = template;
    }

    @GetMapping//http://localhost:7071/api/v1/catalog?id=3
    public List<Recipe> getRecipies(@RequestParam("id") Long userId) {

        /*restTemplate.getForObject(.getForObject("http://localhost:7073/api/v1/rating?id="+
                userId, ArrayList.class);)*/

        List<Rating> ratingList = Arrays.asList(
                new Rating(2, 4),
                new Rating(3, 2)
        );


            return ratingList.stream().map(rating -> {
                RecipeDetails recipeDetails = restTemplate.getForObject("http://localhost:7072/api/v1/details?id=" +
                        rating.getRecipeId(), RecipeDetails.class);

                return new Recipe(recipeDetails.getName(),
                        "The great blend of spices on these broiled chicken breasts has a wonderful " +
                                "flavor and pairs well with many vegetable side dishes.",
                        4);
            }).collect(Collectors.toList());
    }
}




