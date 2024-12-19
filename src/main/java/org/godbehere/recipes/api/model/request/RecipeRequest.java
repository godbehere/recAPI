package org.godbehere.recipes.api.model.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeRequest {
    
    private String label;
    private String description;
    private List<String> instructions;
    private Integer servings;
    private String time;
    private String source;
    private List<IngredientRq> ingredients;

}
