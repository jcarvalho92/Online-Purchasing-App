package com.example.group5_mapd711_assign2_pizzaonline.views;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.group5_mapd711_assign2_pizzaonline.R;
import com.example.group5_mapd711_assign2_pizzaonline.model.Customer;
import com.example.group5_mapd711_assign2_pizzaonline.model.JoinCustomerOrderPizza;
import com.example.group5_mapd711_assign2_pizzaonline.model.PurchaseOrder;
import com.example.group5_mapd711_assign2_pizzaonline.viewmodels.CustomerViewModel;
import com.example.group5_mapd711_assign2_pizzaonline.viewmodels.OrderViewModel;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CheckOutDetailsActivity extends AppCompatActivity {
    public OrderViewModel orderViewModel;
    private JoinCustomerOrderPizza joinCustomerOrderPizza;
    private TextView textCustomerName;
    private TextView textTypePizza;
    private TextView textSizePizza;
    private TextView textToppings;
    private TextView textAddress;
    private TextView textPostalCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out_details);

        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);
        joinCustomerOrderPizza = orderViewModel.getLastCustomerOrderPizza("In Progress");

        //Getting a reference to an inflated widget by calling the following Activity method: public View findViewById(int id)
        textCustomerName = (TextView)  findViewById(R.id.txtCustomerName);
        textTypePizza = (TextView)  findViewById(R.id.txtTOP);
        textSizePizza = (TextView)  findViewById(R.id.txtSOP);
        textToppings = (TextView)  findViewById(R.id.txtToppings);
        textAddress = (TextView)  findViewById(R.id.txtAddr);
        textPostalCode = (TextView)  findViewById(R.id.txtPostalCode);

        //passing the information from the database to the TextViews
        textCustomerName.setText("Customer's Name: " +joinCustomerOrderPizza.getFirstName()+" "+joinCustomerOrderPizza.getLastName());
        textTypePizza.setText("Type of Pizza: " +joinCustomerOrderPizza.getPizzaName());
        textSizePizza.setText("Size of Pizza: " +joinCustomerOrderPizza.getSize());
        textToppings.setText("Toppings: " +joinCustomerOrderPizza.getExtraToppings());
        textAddress.setText("Address: " +joinCustomerOrderPizza.getAddress());
        textPostalCode.setText("Postal Code: " +joinCustomerOrderPizza.getPostalCode());
    }
}

