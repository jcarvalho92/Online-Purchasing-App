package com.example.group5_mapd711_assign2_pizzaonline.Repository;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.group5_mapd711_assign2_pizzaonline.dao.AdminDao;
import com.example.group5_mapd711_assign2_pizzaonline.dbInstance.AppDatabase;
import com.example.group5_mapd711_assign2_pizzaonline.model.Admin;

import java.util.List;

public class AdminRepository {
    private final AdminDao adminDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private MutableLiveData<Integer> updateResult = new MutableLiveData<>();
    private LiveData<List<Admin>> adminList;

    public AdminRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        adminDao = db.adminDao();
        adminList = adminDao.getAllAdmins();
    }

    public LiveData<List<Admin>> getAllAdmins() {
        return adminList;
    }

    public void insert(Admin admin) {
        insertAsync(admin);
    }

    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    private void insertAsync(final Admin admin) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    adminDao.insert(admin);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    public void update(Admin admin) {
        updateAsync(admin);
    }

    public LiveData<Integer> getUpdateResult() {
        return updateResult;
    }

    private void updateAsync(final Admin admin) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    adminDao.insert(admin);
                    updateResult.postValue(1);
                } catch (Exception e) {
                    updateResult.postValue(0);
                }
            }
        }).start();
    }
}
