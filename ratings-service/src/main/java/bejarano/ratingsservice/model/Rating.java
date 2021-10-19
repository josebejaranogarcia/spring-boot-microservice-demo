package bejarano.ratingsservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Rating {

   private long recipeId;
   private int rating;

}
