package org.godbehere.recipes.api.service;

import java.util.List;

import org.godbehere.recipes.api.model.Ingredient;
import org.godbehere.recipes.api.model.Recipe;
import org.godbehere.recipes.api.model.request.RecipeRequest;
import org.godbehere.recipes.api.repository.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe getRecipe(Integer id) {
        return recipeRepository.findById(id).get();
    }

    public void createRecipe(RecipeRequest recipe) {
        Recipe newRecipe = new Recipe(recipe.getLabel());
        recipe.getIngredients().forEach((ingredient) -> {
            Ingredient newIngredient = new Ingredient(ingredient);
            // newIngredient.setRecipe(newRecipe);
            newRecipe.addIngredient(newIngredient);
        });
        newRecipe.setDescription(recipe.getDescription());
        newRecipe.setInstructions(recipe.getInstructions());
        newRecipe.setServings(recipe.getServings());
        newRecipe.setTime(recipe.getTime());
        newRecipe.setSource(recipe.getSource());
        recipeRepository.save(newRecipe);
    }

    public List<Ingredient> getRecipeIngredients(Integer recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).get();
        return recipe.getIngredients();
    }

    public Double getTotalCalories(Integer recipeId) {
        return recipeRepository.findById(recipeId).get().getIngredients().stream().mapToDouble(Ingredient::getCalories).sum();
    }

    public Double getTotalProtein(Integer recipeId) {
        return recipeRepository.findById(recipeId).get().getIngredients().stream().mapToDouble(Ingredient::getProtein).sum();
    }

    public Double getTotalCarbs(Integer recipeId) {
        return recipeRepository.findById(recipeId).get().getIngredients().stream().mapToDouble(Ingredient::getCarbs).sum();
    }

    public Double getTotalFat(Integer recipeId) {
        return recipeRepository.findById(recipeId).get().getIngredients().stream().mapToDouble(Ingredient::getFat).sum();
    }

}
