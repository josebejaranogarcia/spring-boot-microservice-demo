package bejarano.recipecatalogservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDetails {
    private long recipeId;
    private String name;
    private String description;
    //   private List <String> ingredients;
    private int time;
   // private List<String> directions;



}
