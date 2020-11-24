package com.example.group5_mapd711_assign2_pizzaonline.Repository;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.group5_mapd711_assign2_pizzaonline.dao.CustomerDao;
import com.example.group5_mapd711_assign2_pizzaonline.dbInstance.AppDatabase;
import com.example.group5_mapd711_assign2_pizzaonline.model.Customer;
import com.example.group5_mapd711_assign2_pizzaonline.model.JoinCustomerOrderPizza;

import java.util.List;

public class CustomerRepository {
    private final CustomerDao customerDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private MutableLiveData<Integer> updateResult = new MutableLiveData<>();
    private LiveData<List<Customer>> customersList;

    public CustomerRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        customerDao = db.customerDao();
        customersList = customerDao.getAllCustomers();
    }

    public LiveData<List<Customer>> getAllCustomers() {
        return customersList;
    }

    public Customer getLastCustomer() {
        return customerDao.getLastCustomer();
    }

    public Customer getCustomerByUserName(String username) {

        return customerDao.getCustomerByUserName(username);
    }

    public Customer getCustomerByName(String firstname, String lastname) {

        return customerDao.getCustomerByName(firstname, lastname);
    }

    public void insert(Customer customer) {
        insertAsync(customer);
    }

    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    private void insertAsync(final Customer customer) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    customerDao.insert(customer);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    public void update(Customer customer) {
        updateAsync(customer);
    }

    public LiveData<Integer> getUpdateResult() {
        return updateResult;
    }

    private void updateAsync(final Customer customer) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    customerDao.update(customer);
                    updateResult.postValue(1);
                } catch (Exception e) {
                    updateResult.postValue(0);
                }
            }
        }).start();
    }
}