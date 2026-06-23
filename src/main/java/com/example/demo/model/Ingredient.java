package com.example.demo.model;

/**
 * Repräsentiert eine Zutat innerhalb eines Rezepts.
 *
 * Diese Klasse wird als eingebettetes Dokument (Embedded Document) in der
 * "recipes"-Collection gespeichert – sie hat keine eigene MongoDB-Collection
 * und benötigt daher keine @Document-Annotation.
 */
public class Ingredient {

    /** Name der Zutat (z.B. "Mehl", "Eier"). */
    private String name;

    /** Menge der Zutat (z.B. 250.0). */
    private double amount;

    /** Masseinheit der Menge (z.B. "g", "ml", "Stk"). */
    private String unit;

    public Ingredient() {
    }

    public Ingredient(String name, double amount, String unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    public String getName() { return name; }
    public double getAmount() { return amount; }
    public String getUnit() { return unit; }

    public void setName(String name) { this.name = name; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setUnit(String unit) { this.unit = unit; }
}