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

import com.example.group5_mapd711_assign2_pizzaonline.model.Admin;

import java.util.List;

@Dao
public interface AdminDao {
    @Insert
    void insert(Admin admin);

    @Update
    void update(Admin admin);

    @Delete
    void delete(Admin admin);

    //Monitoring Query Result Changes with Live Data
    @Query("select * from Admin where userName LIKE :userName " +
            "and password LIKE :password")
    public Admin findAdminByUserNameAndPassword(String userName, String password);

    @Query("select * from Admin")
    LiveData<List<Admin>> getAllAdmins();
}