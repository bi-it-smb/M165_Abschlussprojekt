package com.example.demo.repository;

import com.example.demo.model.Rating;
import org.bson.Document;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Map;

public interface RatingRepository extends MongoRepository<Rating, String> {

    @Query("{ 'stars' : ?0 }")
    List<Rating> findByStars(int stars);

    @Aggregation(pipeline = {
            "{ '$group': { '_id': '$recipeId', 'avgRating': { '$avg': '$stars' }}}"
    })
    List<Map<String, Object>> averageRatingPerRecipe();

    @Aggregation(pipeline = {
            "{ '$group': { '_id': '$recipeId', 'count': { '$sum': 1 }}}"
    })
    List<Map<String, Object>> ratingCountPerRecipe();

    @Aggregation(pipeline = {
            "{ '$group': { '_id': '$stars', 'count': { '$sum': 1 }}}"
    })
    List<Map<String, Object>> starsDistribution();
}