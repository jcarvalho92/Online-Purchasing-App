package com.example.group5_mapd711_assign2_pizzaonline.model;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity
public class PurchaseOrder {
    @PrimaryKey(autoGenerate = true)
    private int orderId;
    @ForeignKey
            (entity = Customer.class,
                    parentColumns = "customerId",
                    childColumns = "customerId"
            )
    private int customerId;
    @ForeignKey
            (entity = Admin.class,
                    parentColumns = "employeeId",
                    childColumns = "employeeId"
            )
    private int employeeId;
    @ForeignKey
            (entity = Pizza.class,
                    parentColumns = "pizzaId",
                    childColumns = "pizzaId"
            )
    private int pizzaId;
    private Date orderDate;
    private int quantity;
    private String extraToppings;
    private String status;

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int id) {
        this.orderId = id;
    }

    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int id) {
        this.customerId = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int id) {
        this.employeeId = id;
    }

    public int getPizzaId() {
        return pizzaId;
    }
    public void setPizzaId(int id) {
        this.pizzaId = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getExtraToppings() {
        return extraToppings;
    }
    public void setExtraToppings(String extraToppings) { this.extraToppings = extraToppings; }

    public String getStatus() {
        return status;
    }
    public void setStatus(String name) {
        this.status = name;
    }

}