package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Repräsentiert ein Rezept in der MongoDB-Datenbank.
 *
 * @Document mappt diese Klasse auf die MongoDB-Collection "recipes".
 * Jede Instanz dieser Klasse entspricht einem Dokument in dieser Collection.
 */
@Document(collection = "recipes")
public class Recipe {

    /**
     * Eindeutiger Bezeichner des Rezepts.
     * @Id mappt dieses Feld auf das _id-Feld in MongoDB.
     */
    @Id
    private String id;

    /** Name des Rezepts (z.B. "Spaghetti Carbonara"). */
    private String name;

    /** Kategorie des Rezepts (z.B. "Pasta", "Dessert"). */
    private String category;

    /** Zubereitungszeit des Rezepts in Minuten. */
    private int preparationTime;

    /** Liste der Zutaten, die für dieses Rezept benötigt werden. */
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

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getPreparationTime() { return preparationTime; }
    public List<Ingredient> getIngredients() { return ingredients; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setPreparationTime(int preparationTime) { this.preparationTime = preparationTime; }
    public void setIngredients(List<Ingredient> ingredients) { this.ingredients = ingredients; }
}