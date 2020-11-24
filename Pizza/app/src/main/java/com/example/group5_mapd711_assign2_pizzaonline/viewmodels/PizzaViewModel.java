package com.example.group5_mapd711_assign2_pizzaonline.viewmodels;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.group5_mapd711_assign2_pizzaonline.Repository.PizzaRepository;
import com.example.group5_mapd711_assign2_pizzaonline.model.Pizza;

import java.util.List;

public class PizzaViewModel extends AndroidViewModel {
    // calling repository tasks and
    // sending the results to the Activity
    private PizzaRepository pizzaRepository;
    private LiveData<Integer> insertResult;
    private LiveData<List<Pizza>> allPizzas;

    public PizzaViewModel(@NonNull Application application) {
        super(application);
        pizzaRepository = new PizzaRepository(application);
        insertResult = pizzaRepository.getInsertResult();
        allPizzas = pizzaRepository.getAllPizzas();
    }

    public void insert(Pizza pizza) {
        pizzaRepository.insert(pizza);
    }

    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    LiveData<List<Pizza>> getAllPizzas() { return allPizzas; }

    public Pizza getPizzaByNameAndSize(String pizzaName, String pizzaSize) {

        return pizzaRepository.getPizzaByNameAndSize(pizzaName , pizzaSize);
    }

}
