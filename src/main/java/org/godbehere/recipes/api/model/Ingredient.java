package org.godbehere.recipes.api.model;

import org.godbehere.recipes.api.model.request.IngredientRq;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RECIPE_ID")
    private Recipe recipe;

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
    private String units;

    @Column(name = "CALORIES")
    private Integer calories;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "PROTEIN")
    private Double protein;

    @Column(name = "CARBOHYDRATES")
    private Double carbs;

    @Column(name = "FAT")
    private Double fat;

    public Ingredient(String label) {
        this.label = label;
    }

    public Ingredient(IngredientRq ingredient) {
        this.label = ingredient.getLabel();
        this.dairyFree = ingredient.getDairyFree();
        this.glutenFree = ingredient.getGlutenFree();
        this.vegetarian = ingredient.getVegetarian();
        this.vegan = ingredient.getVegan();
        this.units = ingredient.getUnits();
        this.calories = ingredient.getCalories();
        this.amount = ingredient.getAmount();
        this.protein = ingredient.getProtein();
        this.carbs = ingredient.getCarbs();
        this.fat = ingredient.getFat();
    }
}
