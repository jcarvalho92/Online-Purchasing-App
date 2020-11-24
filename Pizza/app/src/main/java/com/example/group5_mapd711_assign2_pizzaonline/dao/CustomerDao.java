package com.example.group5_mapd711_assign2_pizzaonline.dao;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.group5_mapd711_assign2_pizzaonline.model.Customer;

import java.util.List;

@Dao
public interface CustomerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Customer customer);

    @Update
    void update(Customer customer);

    @Delete
    void delete(Customer customer);

    //Monitoring Query Result Changes with Live Data
    @Query("select * from Customer")
    LiveData<List<Customer>> getAllCustomers();

    @Query("select * from Customer where userName like :username")
    Customer getCustomerByUserName(String username);

    @Query("select * from Customer where firstName like :firstname and lastName like :lastname")
    Customer getCustomerByName(String firstname, String lastname);

    @Query("select * from Customer order by customerId desc LIMIT 1")
    Customer getLastCustomer();
}