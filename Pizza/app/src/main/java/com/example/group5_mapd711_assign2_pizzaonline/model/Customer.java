package com.example.group5_mapd711_assign2_pizzaonline.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
import java.sql.Date;

@Entity
public class Customer {
    @PrimaryKey(autoGenerate = true)
    private int customerId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String postalCode;
    private String mobileNumber;
    private String cardNumber;
    private String expiryDate;

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int id) { this.customerId = id; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

}