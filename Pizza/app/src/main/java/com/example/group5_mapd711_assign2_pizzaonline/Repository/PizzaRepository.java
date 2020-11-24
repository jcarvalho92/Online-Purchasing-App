package com.example.group5_mapd711_assign2_pizzaonline.Repository;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.group5_mapd711_assign2_pizzaonline.dao.PizzaDao;
import com.example.group5_mapd711_assign2_pizzaonline.dbInstance.AppDatabase;
import com.example.group5_mapd711_assign2_pizzaonline.model.Pizza;

import java.util.List;

public class PizzaRepository {
    private final PizzaDao pizzaDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private LiveData<List<Pizza>> pizzasList;
    private LiveData<Pizza> pizzaByName;

    public PizzaRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        pizzaDao = db.pizzaDao();
        pizzasList = pizzaDao.getAllPizzas();


    }

    public LiveData<List<Pizza>> getAllPizzas() {
        return pizzasList;
    }

    public Pizza getPizzaByNameAndSize(String pizzaName, String pizzaSize) {

        return pizzaDao.getPizzaByNameAndSize(pizzaName, pizzaSize);
    }

    public void insert(Pizza pizza) {
        insertAsync(pizza);
    }

    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    private void insertAsync(final Pizza pizza) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pizzaDao.insert(pizza);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }
}