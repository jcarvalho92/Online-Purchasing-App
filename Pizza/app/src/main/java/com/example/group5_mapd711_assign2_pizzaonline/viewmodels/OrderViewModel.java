package com.example.group5_mapd711_assign2_pizzaonline.viewmodels;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.group5_mapd711_assign2_pizzaonline.Repository.OrderRepository;
import com.example.group5_mapd711_assign2_pizzaonline.model.JoinCustomerOrderPizza;
import com.example.group5_mapd711_assign2_pizzaonline.model.Pizza;
import com.example.group5_mapd711_assign2_pizzaonline.model.PurchaseOrder;

import java.sql.Date;
import java.util.List;

public class OrderViewModel extends AndroidViewModel {
    // calling repository tasks and
    // sending the results to the Activity
    private OrderRepository orderRepository;
    private LiveData<Integer> insertResult;
    private LiveData<Integer> updateResult;
    private LiveData<List<PurchaseOrder>> allOrders;

    public OrderViewModel(@NonNull Application application) {
        super(application);
        orderRepository = new OrderRepository(application);
        insertResult = orderRepository.getInsertResult();
        updateResult = orderRepository.getUpdateResult();
        allOrders = orderRepository.getAllOrders();
    }

    public void insert(PurchaseOrder order) {
        orderRepository.insert(order);
    }

    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    public void update(PurchaseOrder order) {
        orderRepository.update(order);
    }

    public LiveData<Integer> getUpdateResult() {
        return updateResult;
    }


    public LiveData<List<PurchaseOrder>> getAllOrders() { return allOrders; }

    public LiveData<List<JoinCustomerOrderPizza>> getCustomerOrderPizza(String status) {

        return orderRepository.getCustomerOrderPizza(status);
    }

    public JoinCustomerOrderPizza getLastCustomerOrderPizza(String status) {

        return orderRepository.getLastCustomerOrderPizza(status);
    }

    public PurchaseOrder getOrderById(int id) {

        return orderRepository.getOrderById(id);
    }
}
