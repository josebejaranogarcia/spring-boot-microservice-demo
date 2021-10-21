package bejarano.ratingsservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RecipeDetails {
    private long recipeId;
    private String name;
    private String description;
    //   private List <String> ingredients;
    private int time;
  //  private List<String> directions;
}
