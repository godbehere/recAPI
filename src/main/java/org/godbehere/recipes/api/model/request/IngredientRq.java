package org.godbehere.recipes.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngredientRq {

    private String label;
    private Boolean glutenFree;
    private Boolean dairyFree;
    private Boolean vegetarian;
    private Boolean vegan;
    private String units;
    private Integer calories;
    private Double amount;
    private Double protein;
    private Double carbs;
    private Double fat;

}
