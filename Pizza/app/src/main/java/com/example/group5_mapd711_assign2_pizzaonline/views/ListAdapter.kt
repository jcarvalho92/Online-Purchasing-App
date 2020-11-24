package com.example.group5_mapd711_assign2_pizzaonline.views
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Switch
import android.widget.TextView
import com.example.group5_mapd711_assign2_pizzaonline.R
import com.example.group5_mapd711_assign2_pizzaonline.model.JoinCustomerOrderPizza
import com.example.group5_mapd711_assign2_pizzaonline.model.PurchaseOrder
import com.example.group5_mapd711_assign2_pizzaonline.viewmodels.OrderViewModel

class ListAdapter(val context: Activity, val orders:List<JoinCustomerOrderPizza>, val orderViewModel: OrderViewModel) : BaseAdapter() {


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItem(position: Int): JoinCustomerOrderPizza {
        return orders[position]
    }

    override fun getCount(): Int {

        return orders.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        convertView = LayoutInflater.from(context).inflate(R.layout.orders_list, parent, false)

        val nameTxt = convertView.findViewById<TextView>(R.id.firstNameTxt)
        val priceTxt = convertView.findViewById<TextView>(R.id.priceTxt)
        val addressTxt = convertView.findViewById<TextView>(R.id.addressTxt)
        val pizzaNameTxt = convertView.findViewById<TextView>(R.id.pizzaNameTxt)
        val quantityTxt = convertView.findViewById<TextView>(R.id.quantityTxt)
        val sizeTxt = convertView.findViewById<TextView>(R.id.sizeTxt)
        val deliveredSwt = convertView.findViewById<Switch>(R.id.statusSwt)

        val order = getItem(position)

        val price = order.price
        val fullName = order.firstName +" "+order.lastName
        val address = order.address
        val pizzaName = order.pizzaName
        val quantity = order.quantity.toString()
        val size = order.size


        nameTxt.setText(fullName)

        priceTxt.text = "Price: "+price
        addressTxt.text = "Address: "+address
        pizzaNameTxt.text = "Pizza: "+pizzaName
        quantityTxt.text = "Quantity: "+quantity
        sizeTxt.text = "Size: "+size

        var purchase = PurchaseOrder()
        deliveredSwt?.setOnCheckedChangeListener({ _ , isChecked ->

            // update the status to delivered
            purchase = orderViewModel.getOrderById(order.orderId)
            purchase.status =  "Delivered"
            orderViewModel.update(purchase)
        })
        return convertView
    }

}