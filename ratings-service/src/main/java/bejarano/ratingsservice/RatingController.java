package bejarano.ratingsservice;

import bejarano.ratingsservice.models.Rating;
import bejarano.ratingsservice.models.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rating")
public class RatingController {

    private UserRatings userRatings;
    @Autowired
    public void setUserRatings(UserRatings userRatings) {
        this.userRatings = userRatings;
    }

    List<Rating> ratingList = Arrays.asList(
            new Rating(2, 4, 40),
            new Rating(3, 2, 30)
    );

    @GetMapping
    public UserRatings getRating(@RequestParam("id") long userId) {
        userRatings.setUserId(userId);
        userRatings.setRaintings(ratingList);
        return userRatings;
    }
}
