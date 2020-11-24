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

import com.example.group5_mapd711_assign2_pizzaonline.model.JoinCustomerOrderPizza;
import com.example.group5_mapd711_assign2_pizzaonline.model.PurchaseOrder;

import java.sql.Date;
import java.util.List;

@Dao
public interface PurchaseOrderDao {
    @Insert
    void insert(PurchaseOrder purchaseOrder);

    @Update
    void update(PurchaseOrder purchaseOrder);

    @Delete
    void delete(PurchaseOrder purchaseOrder);

    //Monitoring Query Result Changes with Live Data
    @Query("select * from PurchaseOrder")
    public LiveData<List<PurchaseOrder>> getAllOrders();

    @Query("select * from PurchaseOrder where orderId like :id")
    public PurchaseOrder getOrderById(int id);

    @Query("select C.customerId,P.pizzaId,O.orderId, "+
            "      firstName,lastName,address,city,postalCode, "+
            "      pizzaName,price,size," +
            "      quantity,extraToppings,status "+
            " from PurchaseOrder O " +
            " join Customer C on C.customerId = O.customerId "+
            " join Pizza P on P.pizzaId = O.pizzaId"+
            " where status like :status")

    public LiveData<List<JoinCustomerOrderPizza>> getCustomerOrderPizza(String status);

    @Query("select C.customerId,P.pizzaId,O.orderId,  "+
            "      firstName,lastName,address,city,postalCode, "+
            "      pizzaName,price,size," +
            "      quantity,extraToppings,status "+
            " from PurchaseOrder O " +
            " join Customer C on C.customerId = O.customerId "+
            " join Pizza P on P.pizzaId = O.pizzaId"+
            " where status like :status"+
            " order by orderId desc LIMIT 1")
    public JoinCustomerOrderPizza getLastCustomerOrderPizza(String status);
}

