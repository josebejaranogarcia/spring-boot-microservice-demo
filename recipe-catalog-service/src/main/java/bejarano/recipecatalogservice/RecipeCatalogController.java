package bejarano.recipecatalogservice;


import bejarano.recipecatalogservice.model.Recipe;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
public class RecipeCatalogController {

    @GetMapping//http://localhost:7071/api/v1/catalog?id=3
    public List<Recipe> getRecipies(@RequestParam("id")  Long userId) {

        return Collections.singletonList(
                new Recipe("Broiled Paprika",
                        "The great blend of spices on these broiled chicken breasts has a wonderful flavor and pairs well with many vegetable side dishes.",
                        4));
    }


}
