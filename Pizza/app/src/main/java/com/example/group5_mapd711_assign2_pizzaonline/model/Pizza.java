package com.example.group5_mapd711_assign2_pizzaonline.model;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pizza {
    @PrimaryKey(autoGenerate = true)
    private int pizzaId;
    private String pizzaName;
    private String ingredients;
    private String price;
    private String size;


    public int getPizzaId() {
        return pizzaId;
    }
    public void setPizzaId(int id) {
        this.pizzaId = id;
    }

    public String getPizzaName() {
        return pizzaName;
    }
    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getIngredients() {
        return ingredients;
    }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) { this.price = price; }

    public String getSize() {
        return size;
    }
    public void setSize(String size) { this.size = size; }
}