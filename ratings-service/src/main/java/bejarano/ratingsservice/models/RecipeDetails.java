package bejarano.ratingsservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RecipeDetails {
    private int id;
    private String title;
    private String summary;
}
