package bejarano.recipecatalogservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Recipe {
    private String name;
    private String description;
    private int rating;

}
