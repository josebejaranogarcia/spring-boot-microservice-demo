package bejarano.recipedetailsservice;

import bejarano.recipedetailsservice.models.RecipeDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/details")
public class RecipeDetailsController {

    List<String> directions = new ArrayList<String>();

    RecipeDetailsController() {
        directions.add ("Set an oven rack");
        directions.add ("Rinse chicken breasts");
    }

    @GetMapping//http://localhost:7072/api/v1/details?id=2
    public RecipeDetails getDetails(@RequestParam ("id") Long recipeId){
        return new RecipeDetails(recipeId, 30, directions);
    }
}
