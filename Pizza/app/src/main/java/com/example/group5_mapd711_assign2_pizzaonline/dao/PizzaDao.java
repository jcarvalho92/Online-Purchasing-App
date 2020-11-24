package com.example.group5_mapd711_assign2_pizzaonline.dao;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.group5_mapd711_assign2_pizzaonline.model.Pizza;

import java.util.List;

@Dao
public interface PizzaDao {
    @Insert
    void insert(Pizza pizza);

    @Update
    void update(Pizza pizza);

    @Delete
    void delete(Pizza pizza);

    //Monitoring Query Result Changes with Live Data
    @Query("select * from Pizza")
    LiveData<List<Pizza>> getAllPizzas();

    @Query("select * from Pizza where pizzaName like :pizzaName and size like :pizzaSize")
    Pizza getPizzaByNameAndSize(String pizzaName, String pizzaSize);
}