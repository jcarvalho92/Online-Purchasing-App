package com.example.group5_mapd711_assign2_pizzaonline.viewmodels;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.group5_mapd711_assign2_pizzaonline.Repository.AdminRepository;
import com.example.group5_mapd711_assign2_pizzaonline.model.Admin;

import java.util.List;

public class AdminViewModel extends AndroidViewModel {
    // calling repository tasks and
    // sending the results to the Activity
    private AdminRepository adminRepository;
    private LiveData<Integer> insertResult;
    private LiveData<Integer> updateResult;
    private LiveData<List<Admin>> allAdmins;

    public AdminViewModel(@NonNull Application application) {
        super(application);
        adminRepository = new AdminRepository(application);
        insertResult = adminRepository.getInsertResult();
        updateResult = adminRepository.getUpdateResult();
        allAdmins = adminRepository.getAllAdmins();
    }

    public void insert(Admin admin) {
        adminRepository.insert(admin);
    }

    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    public void update(Admin admin) {
        adminRepository.update(admin);
    }

    public LiveData<Integer> getUpdateResult() {
        return updateResult;
    }

    LiveData<List<Admin>> getAllAdmins() { return allAdmins; }
}
