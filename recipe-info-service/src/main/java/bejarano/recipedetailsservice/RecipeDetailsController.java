package bejarano.recipedetailsservice;

import bejarano.recipedetailsservice.model.RecipeDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/details/")
public class RecipeDetailsController {

    List<String> directions = new ArrayList<String>();

    RecipeDetailsController() {
        directions.add ("Set an oven rack");
        directions.add ("Rinse chicken breasts");
    }

    @GetMapping("{recipeId}")
    public RecipeDetails getInfo(@PathVariable("recipeId") Long recipeId){
        return new RecipeDetails(recipeId, 30, directions);
    }
}
