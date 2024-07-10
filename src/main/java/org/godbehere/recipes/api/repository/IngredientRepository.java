package org.godbehere.recipes.api.repository;

import java.util.List;

import org.godbehere.recipes.api.model.Ingredient;
import org.godbehere.recipes.api.model.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
    
    public List<Ingredient> findAllIngredientByRecipe(Recipe recipe);

    @Query("select i from Ingredient i where i.recipe = :#{#recipeId}")
    public List<Ingredient> findAllIngredientsByRecipeId(@Param("recipeId") Integer recipeId);

}

