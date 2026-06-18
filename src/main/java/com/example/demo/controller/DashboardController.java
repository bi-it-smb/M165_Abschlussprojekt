package com.example.demo.controller;

import com.example.demo.service.RecipeService;
import com.example.demo.service.RatingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class DashboardController {

    private final RecipeService recipeService;
    private final RatingService ratingService;

    public DashboardController(RecipeService recipeService, RatingService ratingService) {
        this.recipeService = recipeService;
        this.ratingService = ratingService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        // Daten
        model.addAttribute("recipes", recipeService.getAllRecipes());
        model.addAttribute("ratings", ratingService.getAllRatings());

        // Aggregationen
        model.addAttribute("categories", recipeService.recipesPerCategory());
        model.addAttribute("prepTimes", recipeService.averagePreparationTimeByCategory());
        model.addAttribute("avgRatings", ratingService.averageRatingPerRecipe());

        return "dashboard";
    }
}