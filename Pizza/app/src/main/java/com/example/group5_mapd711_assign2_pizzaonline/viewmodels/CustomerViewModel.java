package com.example.group5_mapd711_assign2_pizzaonline.viewmodels;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.group5_mapd711_assign2_pizzaonline.Repository.CustomerRepository;
import com.example.group5_mapd711_assign2_pizzaonline.model.Customer;
import com.example.group5_mapd711_assign2_pizzaonline.model.JoinCustomerOrderPizza;

import java.util.List;

public class CustomerViewModel extends AndroidViewModel {
    // calling repository tasks and
    // sending the results to the Activity
    private CustomerRepository customerRepository;
    private LiveData<Integer> insertResult;
    private LiveData<Integer> updateResult;
    private LiveData<List<Customer>> allCustomers;

    public CustomerViewModel(@NonNull Application application) {
        super(application);
        customerRepository = new CustomerRepository(application);
        insertResult = customerRepository.getInsertResult();
        updateResult = customerRepository.getUpdateResult();
        allCustomers = customerRepository.getAllCustomers();
    }

    public void insert(Customer customer) {
        customerRepository.insert(customer);
    }

    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    public LiveData<Integer> getUpdateResult() {
        return updateResult;
    }

    public LiveData<List<Customer>> getAllCustomers() { return allCustomers; }

    public Customer getLastCustomer() {
        return customerRepository.getLastCustomer();
    }

    public Customer getCustomerByUserName(String username) {

        return customerRepository.getCustomerByUserName(username);
    }

    public Customer getCustomerByName(String firstname, String lastname) {

        return customerRepository.getCustomerByName(firstname, lastname);
    }
}