package org.godbehere.recipes.api.service;

import java.util.List;

import org.godbehere.recipes.api.model.Ingredient;
import org.godbehere.recipes.api.model.Recipe;
import org.godbehere.recipes.api.repository.IngredientRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    
    private IngredientRepository ingredientRepository;
    private RecipeService recipeService;

    public IngredientService(IngredientRepository ingredientRepository, RecipeService recipeService) {
        this.ingredientRepository = ingredientRepository;
        this.recipeService = recipeService;
    }

    public List<Ingredient> getIngredientsForRecipe(Recipe recipe) {
        return ingredientRepository.findAllIngredientByRecipe(recipe);
    }

    public List<Ingredient> getIngredientsByRecipeId(Integer recipeId) {
        Recipe recipe = recipeService.getRecipe(recipeId);
        return ingredientRepository.findAllIngredientByRecipe(recipe);
    }

}
