package org.godbehere.recipes.api.repository;

import java.util.Optional;

import org.godbehere.recipes.api.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
    
    // public List<Ingredient> findAllIngredientByRecipe(Recipe recipe);

    // @Query("select i from Ingredient i where i.recipe = :#{#recipeId}")
    // public List<Ingredient> findAllIngredientsByRecipeId(@Param("recipeId") Integer recipeId);

    public Optional<Ingredient> findIngredientByLabel(String label);

}

