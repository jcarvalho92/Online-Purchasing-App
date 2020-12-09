package com.example.group5_mapd711_assign2_pizzaonline.views;

//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.group5_mapd711_assign2_pizzaonline.R
import com.example.group5_mapd711_assign2_pizzaonline.model.JoinCustomerOrderPizza
import com.example.group5_mapd711_assign2_pizzaonline.model.PurchaseOrder
import com.example.group5_mapd711_assign2_pizzaonline.viewmodels.OrderViewModel


class Admin_CustomerOrder_Edit : AppCompatActivity() {

     lateinit var ordersListView: ListView
     lateinit var orderViewModel: OrderViewModel
     lateinit var orders:List<JoinCustomerOrderPizza>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin__customer_order__edit)

        // initializing order view model
        orderViewModel = ViewModelProvider(this).get(OrderViewModel::class.java)

        // get all orders from the database
        orderViewModel.getCustomerOrderPizza("In Progress")?.observe(this, Observer {

            // error finding orders
            if (it == null) {
                Toast.makeText(this, "No orders found!", Toast.LENGTH_LONG).show()
            }
            else {
                orders = it

                // pass the orders list to custom list view adaptor
                ordersListView = findViewById(R.id.ordersListView)
                val listAdapter = ListAdapter(this, orders, orderViewModel)
                ordersListView.adapter = listAdapter
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //adding the Options menu in the activity
        menuInflater.inflate(R.menu.addpizza,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val i = Intent(this, AddPizzaActivity::class.java)

        //checking which menu was selected
        /*when (item.itemId){
            R.id.addpizza ->
                i.putExtra("type", "standard")
        }*/

        startActivity(i)
        return true
    }


}