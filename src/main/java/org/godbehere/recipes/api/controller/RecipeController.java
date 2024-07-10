package org.godbehere.recipes.api.controller;

import java.net.http.HttpResponse;
import java.util.List;

import org.godbehere.recipes.api.model.Ingredient;
import org.godbehere.recipes.api.model.Recipe;
import org.godbehere.recipes.api.model.request.RecipeRequest;
import org.godbehere.recipes.api.service.IngredientService;
import org.godbehere.recipes.api.service.RecipeService;
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

    @GetMapping("recipe")
    public Recipe getRecipe(@RequestParam Integer recipeId) {
        return recipeService.getRecipe(recipeId);
    }
    

    @GetMapping("ingredients")
    public List<Ingredient> getIngredients(@RequestParam Integer recipeId) {
        List<Ingredient> ingredients = recipeService.getRecipeIngredients(recipeId);
        return ingredients;
    }

    @GetMapping("calories")
    public Double getCalories(@RequestParam Integer recipeId) {
        return recipeService.getTotalCalories(recipeId);
    }

    @PostMapping("recipe")
    public HttpResponse<Status> createRecipe(@RequestBody RecipeRequest recipe) {
        recipeService.createRecipe(recipe);
        return null;
    }

}
