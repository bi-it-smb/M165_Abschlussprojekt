package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ratings")
public class Rating {

    @Id
    private String id;

    private String recipeId;
    private String username;
    private int stars;
    private String comment;

    public Rating() {
    }

    public Rating(String recipeId,
                  String username,
                  int stars,
                  String comment) {

        this.recipeId = recipeId;
        this.username = username;
        this.stars = stars;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public String getUsername() {
        return username;
    }

    public int getStars() {
        return stars;
    }

    public String getComment() {
        return comment;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
