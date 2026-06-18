package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "recipes")
public class Recipe {

    @Id
    private String id;

    private String name;
    private String category;
    private int preparationTime;

    private List<Ingredient> ingredients;

    public Recipe() {
    }

    public Recipe(String name, String category, int preparationTime,
                  List<Ingredient> ingredients) {
        this.name = name;
        this.category = category;
        this.preparationTime = preparationTime;
        this.ingredients = ingredients;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}