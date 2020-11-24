package com.example.group5_mapd711_assign2_pizzaonline.dbInstance;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.group5_mapd711_assign2_pizzaonline.dao.AdminDao;
import com.example.group5_mapd711_assign2_pizzaonline.dao.CustomerDao;
import com.example.group5_mapd711_assign2_pizzaonline.dao.PurchaseOrderDao;
import com.example.group5_mapd711_assign2_pizzaonline.dao.PizzaDao;
import com.example.group5_mapd711_assign2_pizzaonline.model.Admin;
import com.example.group5_mapd711_assign2_pizzaonline.model.Customer;
import com.example.group5_mapd711_assign2_pizzaonline.model.PurchaseOrder;
import com.example.group5_mapd711_assign2_pizzaonline.model.Pizza;

import java.sql.Date;


@Database(entities = {Customer.class, Pizza.class, PurchaseOrder.class, Admin.class}, version = 1)
@TypeConverters({AppDatabase.Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;
    private static final String DATABASE_NAME = "PizzaOnlineDB";
    public abstract CustomerDao customerDao();
    public abstract PizzaDao pizzaDao();
    public abstract PurchaseOrderDao purchaseOrderDao();
    public abstract AdminDao adminDao();

    public static synchronized AppDatabase getInstance(Context context) {

        if (INSTANCE == null) {
            //Create database object
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
        }
        return INSTANCE;

    }

    public static class Converters {
        @TypeConverter
        public static Date fromTimestamp(Long value) {
            return value == null ? null : new Date(value);
        }
        @TypeConverter
        public static Long dateToTimestamp(Date date) {
            return date == null ? null : date.getTime();
        }
    }

}