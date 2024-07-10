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

    @Column(name = "INSTRUCTIONS",
            columnDefinition = "TEXT")
    private String instructions;

    @Column(name = "SERVINGS")
    private Integer servings;

    @Column(name = "TIME")
    private String time;

    @Column(name = "SOURCE")
    private String source;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="recipe")
    private List<Ingredient> ingredients;

    public Recipe() {
        this.ingredients = new ArrayList<Ingredient>();
    }

    public Recipe(String label) {
        this();
        this.label = label;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
    }
    
}
