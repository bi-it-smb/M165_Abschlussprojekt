package com.example.demo.service;

import com.example.demo.model.Recipe;
import com.example.demo.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> getRecipeById(String id) {
        return recipeRepository.findById(id);
    }

    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(String id, Recipe recipe) {
        recipe.setId(id);
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(String id) {
        recipeRepository.deleteById(id);
    }

    public List<Map<String, Object>> recipesPerCategory() {
        return recipeRepository.recipesPerCategory();
    }

    public List<Map<String, Object>> averagePreparationTimeByCategory() {
        return recipeRepository.averagePreparationTimeByCategory();
    }
}