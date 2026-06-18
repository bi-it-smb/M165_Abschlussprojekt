package com.example.demo.controller;

import com.example.demo.model.Rating;
import com.example.demo.service.RatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }

    @PostMapping
    public Rating createRating(@RequestBody Rating rating) {
        return ratingService.saveRating(rating);
    }

    @GetMapping("/stats/average")
    public List<Map<String, Object>> averageRatingPerRecipe() {
        return ratingService.averageRatingPerRecipe();
    }

    @GetMapping("/stats/count")
    public List<Map<String, Object>> ratingCountPerRecipe() {
        return ratingService.ratingCountPerRecipe();
    }

    @GetMapping("/stats/distribution")
    public List<Map<String, Object>> starsDistribution() {
        return ratingService.starsDistribution();
    }
}