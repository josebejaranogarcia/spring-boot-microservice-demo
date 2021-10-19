package bejarano.ratingsservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rating")
public class RatingController {


    @GetMapping
    public int getRating(@RequestParam ("id") long recipeId){
        return 3;
    }
}
