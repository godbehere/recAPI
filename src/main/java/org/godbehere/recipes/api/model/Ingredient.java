package org.godbehere.recipes.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "INGREDIENT")
public class Ingredient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "INGREDIENT_ID")
    private Integer ingredientId;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "GLUTEN_FREE")
    private Boolean glutenFree;

    @Column(name = "DAIRY_FREE")
    private Boolean dairyFree;

    @Column(name = "VEGETARIAN")
    private Boolean vegetarian;

    @Column(name = "VEGAN")
    private Boolean vegan;

    @Column(name = "UNITS")
    private Unit units;

    @Column(name = "CALORIES")
    private Double calories;

    @Column(name = "PROTEIN")
    private Double protein;

    @Column(name = "CARBOHYDRATES")
    private Double carbs;

    @Column(name = "FAT")
    private Double fat;

    // public Ingredient(String label) {
    //     this.label = label;
    // }

    // public Ingredient(IngredientRq ingredient) {
    //     this.label = ingredient.getLabel();
    //     this.dairyFree = ingredient.getDairyFree();
    //     this.glutenFree = ingredient.getGlutenFree();
    //     this.vegetarian = ingredient.getVegetarian();
    //     this.vegan = ingredient.getVegan();
    //     this.units = ingredient.getUnits();
    //     this.calories = ingredient.getCalories() / ingredient.getAmount();
    //     this.protein = ingredient.getProtein() / ingredient.getAmount();
    //     this.carbs = ingredient.getCarbs() / ingredient.getAmount();
    //     this.fat = ingredient.getFat() / ingredient.getAmount();
    // }
}
