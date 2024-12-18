package org.godbehere.recipes.api.service;

import java.util.List;
import java.util.Optional;

import org.godbehere.recipes.api.model.Ingredient;
import org.godbehere.recipes.api.model.Recipe;
import org.godbehere.recipes.api.model.RecipeIngredient;
import org.godbehere.recipes.api.model.request.RecipeRequest;
import org.godbehere.recipes.api.repository.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;
    private IngredientService ingredientService;

    public RecipeService(RecipeRepository recipeRepository, IngredientService ingredientService) {
        this.recipeRepository = recipeRepository;
        this.ingredientService = ingredientService;
    }

    public Recipe getRecipe(Integer id) {
        return recipeRepository.findById(id).get();
    }

    public Iterable<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public void createRecipe(RecipeRequest recipe) {
        Recipe newRecipe = new Recipe(recipe.getLabel());
        recipe.getIngredients().forEach((ingredient) -> {
            Optional<Ingredient> optIngredient = ingredientService.getIngredientByLabel(ingredient.getLabel());
            RecipeIngredient recipeIngredient = new RecipeIngredient();
            Ingredient newIngredient;
            if(optIngredient.isEmpty()) {
                newIngredient = ingredientService.createIngredientFromRequest(ingredient);
            } else {
                newIngredient = optIngredient.get();
            }
            recipeIngredient.setAmount(ingredient.getAmount());
            recipeIngredient.setIngredient(newIngredient);
            recipeIngredient.setUnits(ingredient.getUnits());
            newRecipe.setCalories(newRecipe.getCalories() + ingredient.getCalories());
            newRecipe.addIngredient(recipeIngredient);
        });
        newRecipe.setDescription(recipe.getDescription());
        newRecipe.setInstructions(recipe.getInstructions());
        newRecipe.setServings(recipe.getServings());
        newRecipe.setTime(recipe.getTime());
        newRecipe.setSource(recipe.getSource());
        recipeRepository.save(newRecipe);
    }

    public List<RecipeIngredient> getRecipeIngredients(Integer recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).get();
        return recipe.getIngredients();
    }

    public Double getTotalCalories(Integer recipeId) {
        return recipeRepository
                .findById(recipeId)
                .get()
                .getIngredients()
                .stream()
                .map(RecipeIngredient::getIngredient)
                .mapToDouble(Ingredient::getCalories)
                .sum();
    }

    public Double getTotalProtein(Integer recipeId) {
        return recipeRepository
                .findById(recipeId)
                .get()
                .getIngredients()
                .stream()
                .map(RecipeIngredient::getIngredient)
                .mapToDouble(Ingredient::getProtein)
                .sum();
    }

    public Double getTotalCarbs(Integer recipeId) {
        return recipeRepository
                .findById(recipeId)
                .get()
                .getIngredients()
                .stream()
                .map(RecipeIngredient::getIngredient)
                .mapToDouble(Ingredient::getCarbs)
                .sum();
    }

    public Double getTotalFat(Integer recipeId) {
        return recipeRepository
                .findById(recipeId)
                .get()
                .getIngredients()
                .stream()
                .map(RecipeIngredient::getIngredient)
                .mapToDouble(Ingredient::getFat)
                .sum();
    }

}
