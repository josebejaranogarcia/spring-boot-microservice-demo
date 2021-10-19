package bejarano.recipecatalogservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog/api/v1/")
public class RecipeCatalogController {

    @GetMapping("{userId}")
    public List<Recipe> getRecipies(@PathVariable Long userId) {

        return Collections.singletonList(
                new Recipe("Broiled Paprika",
                        "The great blend of spices on these broiled chicken breasts has a wonderful flavor and pairs well with many vegetable side dishes.",
                        30, 4));
    }


}
