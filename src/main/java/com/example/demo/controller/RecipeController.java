package com.example.demo.controller;

import com.example.demo.model.Recipe;
import com.example.demo.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Optional<Recipe> getRecipeById(@PathVariable String id) {
        return recipeService.getRecipeById(id);
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.saveRecipe(recipe);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable String id,
                               @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(id, recipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable String id) {
        recipeService.deleteRecipe(id);
    }

    @GetMapping("/stats/categories")
    public List<Map<String, Object>> recipesPerCategory() {
        return recipeService.recipesPerCategory();
    }

    @GetMapping("/stats/preptime")
    public List<Map<String, Object>> averagePreparationTime() {
        return recipeService.averagePreparationTimeByCategory();
    }
}