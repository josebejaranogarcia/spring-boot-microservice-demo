package bejarano.recipecatalogservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Recipe {
    private String title;
    private String summary;
    private int rating;
}
