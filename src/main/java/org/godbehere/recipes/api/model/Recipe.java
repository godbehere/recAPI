package org.godbehere.recipes.api.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "RECIPE")
public class Recipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "RECIPE_ID")
    private Integer recipeId;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "DESCRIPTION",
            columnDefinition = "TEXT")
    private String description;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Step> instructions;

    @Column(name = "CALORIES")
    private Double calories;

    @Column(name = "SERVINGS")
    private Integer servings;

    @Column(name = "TIME")
    private String time;

    @Column(name = "SOURCE")
    private String source;

    @Column(name = "GLUTEN_FREE")
    private Boolean glutenFree;

    @Column(name = "DAIRY_FREE")
    private Boolean dairyFree;

    @Column(name = "VEGETARIAN")
    private Boolean vegetarian;

    @Column(name = "VEGAN")
    private Boolean vegan;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="recipe")
    private List<RecipeIngredient> ingredients;

    public Recipe() {
        this.calories = 0.0;
        this.instructions = new ArrayList<Step>();
        this.ingredients = new ArrayList<RecipeIngredient>();
        this.dairyFree = true;
        this.glutenFree = true;
        this.vegetarian = true;
        this.vegan = true;
    }

    public Recipe(String label) {
        this();
        this.label = label;
    }

    public void addIngredient(RecipeIngredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
    }

    public void addStep(Step step) {
        this.instructions.add(step);
    }
    
}
