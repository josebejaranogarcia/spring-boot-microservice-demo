package bejarano.recipecatalogservice;


import bejarano.recipecatalogservice.models.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
public class RecipeCatalogController {

    @GetMapping//http://localhost:7071/api/v1/catalog?id=3
    public List<Recipe> getRecipies(@RequestParam("id") Long userId) {


        ///Get all recipes IDs
        RestTemplate restTemplate=new RestTemplate();
        ArrayList ratingsList= restTemplate.getForObject("http://localhost:7073/api/v1/rating?id="+
                userId, ArrayList.class);

        System.out.println(ratingsList.get(0));
        System.out.println(ratingsList.get(1));


        //For each recipe, call recipes info service and get details
        //Put them together
        return Collections.singletonList(
                new Recipe("Broiled Paprika",
                        "The great blend of spices on these broiled chicken breasts has a wonderful flavor and pairs well with many vegetable side dishes.",
                        4));
    }


}
