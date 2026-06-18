package com.example.demo.repository;

import com.example.demo.model.Recipe;
import org.bson.Document;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Map;

public interface RecipeRepository extends MongoRepository<Recipe, String> {

    List<Recipe> findByCategory(String category);

    List<Recipe> findByPreparationTimeLessThan(int time);

    @Aggregation(pipeline = {
            "{ '$group': { '_id': '$category', 'count': { '$sum': 1 }}}"
    })
    List<Map<String, Object>> recipesPerCategory();

    @Aggregation(pipeline = {
            "{ '$group': { '_id': '$category', 'avgTime': { '$avg': '$preparationTime' }}}"
    })
    List<Map<String, Object>> averagePreparationTimeByCategory();
}