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
            "{ '$lookup': { 'from': 'recipes', 'localField': 'recipeId', 'foreignField': '_id', 'as': 'recipe' } }",
            "{ '$unwind': '$recipe' }",
            "{ '$group': { '_id': '$recipe.name', 'avgRating': { '$avg': '$stars' } } }"
    })
    List<Map<String, Object>> averageRatingPerRecipe();

    @Aggregation(pipeline = {
            "{ '$lookup': { 'from': 'recipes', 'localField': 'recipeId', 'foreignField': '_id', 'as': 'recipe' } }",
            "{ '$unwind': '$recipe' }",
            "{ '$group': { '_id': '$recipe.name', 'count': { '$sum': 1 } } }",
            "{ '$project': { '_id': 0, 'recipeName': '$_id', 'count': 1 } }"
    })
    List<Map<String,Object>> ratingCountPerRecipe();

    @Aggregation(pipeline = {
            "{ '$group': { '_id': '$stars', 'count': { '$sum': 1 }}}",
            "{ '$project': { '_id': 0, 'stars': '$_id', 'count': 1 }}"
    })
    List<Map<String, Object>> starsDistribution();
}