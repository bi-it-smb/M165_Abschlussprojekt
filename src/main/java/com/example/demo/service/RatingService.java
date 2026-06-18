package com.example.demo.service;

import com.example.demo.model.Rating;
import com.example.demo.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Map<String, Object>> averageRatingPerRecipe() {
        return ratingRepository.averageRatingPerRecipe();
    }

    public List<Map<String, Object>> ratingCountPerRecipe() {
        return ratingRepository.ratingCountPerRecipe();
    }

    public List<Map<String, Object>> starsDistribution() {
        return ratingRepository.starsDistribution();
    }
}