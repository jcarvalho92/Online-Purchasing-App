package com.example.group5_mapd711_assign2_pizzaonline.Repository;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.group5_mapd711_assign2_pizzaonline.dao.PurchaseOrderDao;
import com.example.group5_mapd711_assign2_pizzaonline.dbInstance.AppDatabase;
import com.example.group5_mapd711_assign2_pizzaonline.model.JoinCustomerOrderPizza;
import com.example.group5_mapd711_assign2_pizzaonline.model.PurchaseOrder;

import java.sql.Date;
import java.util.List;

public class OrderRepository {
    private final PurchaseOrderDao purchaseOrderDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private MutableLiveData<Integer> updateResult = new MutableLiveData<>();
    private LiveData<List<PurchaseOrder>> ordersList;
    private LiveData<List<JoinCustomerOrderPizza>> orderInfo;

    public OrderRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        purchaseOrderDao = db.purchaseOrderDao();
        ordersList = purchaseOrderDao.getAllOrders();
    }

    public LiveData<List<PurchaseOrder>> getAllOrders() {
        return ordersList;
    }

    public void insert(PurchaseOrder order) {
        insertAsync(order);
    }

    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    private void insertAsync(final PurchaseOrder order) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    purchaseOrderDao.insert(order);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    public void update(PurchaseOrder order) {
        updateAsync(order);
    }

    public LiveData<Integer> getUpdateResult() {
        return updateResult;
    }

    private void updateAsync(final PurchaseOrder order) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    purchaseOrderDao.update(order);
                    updateResult.postValue(1);
                } catch (Exception e) {
                    updateResult.postValue(0);
                }
            }
        }).start();
    }

    public LiveData<List<JoinCustomerOrderPizza>> getCustomerOrderPizza(String status) {

        return purchaseOrderDao.getCustomerOrderPizza(status);
    }

    public JoinCustomerOrderPizza getLastCustomerOrderPizza(String status) {

        return purchaseOrderDao.getLastCustomerOrderPizza(status);
    }

    public PurchaseOrder getOrderById(int id) {
        return purchaseOrderDao.getOrderById(id);
    }
}
