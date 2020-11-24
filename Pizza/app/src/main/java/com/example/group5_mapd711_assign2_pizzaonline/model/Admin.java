package com.example.group5_mapd711_assign2_pizzaonline.model;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Admin {
    @PrimaryKey(autoGenerate = true)
    private int employeeId;
    private String userName;
    private String password;
    private String firstname;
    private String lastname;

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int id) {
        this.employeeId = id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}