package org.godbehere.recipes.api.service;

import java.util.Optional;

import org.godbehere.recipes.api.model.Ingredient;
import org.godbehere.recipes.api.model.request.IngredientRq;
import org.godbehere.recipes.api.repository.IngredientRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    
    private IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient createIngredientFromRequest(IngredientRq ingredient) {
        Ingredient newIngredient = new Ingredient();

        newIngredient.setLabel(ingredient.getLabel());
        newIngredient.setDairyFree(ingredient.getDairyFree());
        newIngredient.setGlutenFree(ingredient.getGlutenFree());
        newIngredient.setVegetarian(ingredient.getVegetarian());
        newIngredient.setVegan(ingredient.getVegan());
        newIngredient.setUnits(ingredient.getUnits());
        newIngredient.setCalories(ingredient.getCalories() / ingredient.getAmount());
        newIngredient.setProtein(ingredient.getProtein() / ingredient.getAmount());
        newIngredient.setCarbs(ingredient.getCarbs() / ingredient.getAmount());
        newIngredient.setFat(ingredient.getFat() / ingredient.getAmount());

        ingredientRepository.save(newIngredient);

        return newIngredient;
    }

    // public List<Ingredient> getIngredientsForRecipe(Recipe recipe) {
    //     return ingredientRepository.findAllIngredientByRecipe(recipe);
    // }

    // public List<Ingredient> getIngredientsByRecipeId(Integer recipeId) {
    //     Recipe recipe = recipeService.getRecipe(recipeId);
    //     return ingredientRepository.findAllIngredientByRecipe(recipe);
    // }

    public Optional<Ingredient> getIngredientByLabel(String label) {
        Optional<Ingredient> ingredient = ingredientRepository.findIngredientByLabel(label);
        return ingredient;
    }

}
