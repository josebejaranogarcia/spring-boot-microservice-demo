package bejarano.recipecatalogservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Recipe {
    private String name;
    private String description;
 //   private List <String> ingredients;
    private int time;
    private int rating;

}
