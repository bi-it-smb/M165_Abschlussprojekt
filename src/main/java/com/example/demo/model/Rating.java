package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Repräsentiert eine Bewertung eines Rezepts in der MongoDB-Datenbank.
 *
 * @Document mappt diese Klasse auf die MongoDB-Collection "ratings".
 * Jede Instanz dieser Klasse entspricht einem Bewertungs-Dokument in dieser Collection.
 */
@Document(collection = "ratings")
public class Rating {

    /**
     * Eindeutiger Bezeichner der Bewertung.
     * @Id mappt dieses Feld auf das _id-Feld in MongoDB.
     */
    @Id
    private String id;

    /** Die ID des Rezepts, auf das sich diese Bewertung bezieht. */
    private String recipeId;

    /** Benutzername der Person, die die Bewertung abgegeben hat. */
    private String username;

    /** Sterne-Bewertung (1–5). */
    private int stars;

    /** Optionaler Kommentar zur Bewertung. */
    private String comment;

    public Rating() {
    }

    public Rating(String recipeId, String username, int stars, String comment) {
        this.recipeId = recipeId;
        this.username = username;
        this.stars = stars;
        this.comment = comment;
    }

    public String getId() { return id; }
    public String getRecipeId() { return recipeId; }
    public String getUsername() { return username; }
    public int getStars() { return stars; }
    public String getComment() { return comment; }

    public void setId(String id) { this.id = id; }
    public void setRecipeId(String recipeId) { this.recipeId = recipeId; }
    public void setUsername(String username) { this.username = username; }
    public void setStars(int stars) { this.stars = stars; }
    public void setComment(String comment) { this.comment = comment; }
}