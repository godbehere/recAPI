package org.godbehere.recipes.api.controller;

import java.net.http.HttpResponse;
import java.util.List;

import org.godbehere.recipes.api.model.Recipe;
import org.godbehere.recipes.api.model.RecipeIngredient;
import org.godbehere.recipes.api.model.request.RecipeRequest;
import org.godbehere.recipes.api.service.IngredientService;
import org.godbehere.recipes.api.service.RecipeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.status.Status;

@RestController
public class RecipeController {

    private RecipeService recipeService;
    // private IngredientService ingredientService;

    public RecipeController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        // this.ingredientService = ingredientService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("recipe")
    public Recipe getRecipe(@RequestParam Integer recipeId) {
        return recipeService.getRecipe(recipeId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("recipes")
    public Iterable<Recipe> getAllRecipe() {
        return recipeService.getAllRecipes();
    }
    
    @GetMapping("ingredients")
    public List<RecipeIngredient> getIngredients(@RequestParam Integer recipeId) {
        List<RecipeIngredient> ingredients = recipeService.getRecipeIngredients(recipeId);
        return ingredients;
    }

    @GetMapping("calories")
    public Double getCalories(@RequestParam Integer recipeId) {
        return recipeService.getTotalCalories(recipeId);
    }

    @GetMapping("protein")
    public Double getProtein(@RequestParam Integer recipeId) {
        return recipeService.getTotalProtein(recipeId);
    }

    @GetMapping("carbs")
    public Double getCarbs(@RequestParam Integer recipeId) {
        return recipeService.getTotalCarbs(recipeId);
    }

    @GetMapping("fat")
    public Double getFat(@RequestParam Integer recipeId) {
        return recipeService.getTotalFat(recipeId);
    }

    @PostMapping("recipe")
    public HttpResponse<Status> createRecipe(@RequestBody RecipeRequest recipe) {
        recipeService.createRecipe(recipe);
        return null;
    }

}
