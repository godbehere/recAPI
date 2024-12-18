package org.godbehere.recipes.api.model.request;

import org.godbehere.recipes.api.model.Unit;

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
    private Unit units;
    private Double calories;
    private Double amount;
    private Double protein;
    private Double carbs;
    private Double fat;

}
