package com.example.group5_mapd711_assign2_pizzaonline.views

//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.group5_mapd711_assign2_pizzaonline.R
import kotlinx.android.synthetic.main.activity_pizza_details.*


class PizzaDetailsActivity : AppCompatActivity()
{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_details)

        //defining a reference object for type of pizza image, pizza name textView and pizza details text View
        val ivTypeofPizza = findViewById<ImageView>(R.id.ivTypeofPizza)
        val txtPizzaName = findViewById<TextView>(R.id.txtPizzaName)
        val txtPizzaDetail = findViewById<TextView>(R.id.txtPizzaDetail)

        val intent = intent

        //getting values from previous activity using intent object
        val typeofPizza = intent.getStringExtra("typeofPizza")

        //checking what type of pizza have been choosen from the menu items
        //changing image, pizza name and details about the pizza  on selection of pizza
        when (typeofPizza) {
            "Meat Supreme" -> {
                ivTypeofPizza.setImageResource(R.drawable.meat)
                txtPizzaName.text = resources.getString(R.string.meatSupreme)
                txtPizzaDetail.text = resources.getString(R.string.detailMeatSupreme)
            }
            "Super Hawaiian" -> {
                ivTypeofPizza.setImageResource(R.drawable.hawaiian)
                txtPizzaName.text = resources.getString(R.string.superHawaiian)
                txtPizzaDetail.text = resources.getString(R.string.detailSuperHawaiian)
            }
            "Veggie" -> {
                ivTypeofPizza.setImageResource(R.drawable.veggie)
                txtPizzaName.text = resources.getString(R.string.veggie)
                txtPizzaDetail.text = resources.getString(R.string.detailVeggie)
            }
            "Mediterranean" -> {
                ivTypeofPizza.setImageResource(R.drawable.mediterranean)
                txtPizzaName.text = resources.getString(R.string.mediterranean)
                txtPizzaDetail.text = resources.getString(R.string.detailMediterranean)
            }
            "Cheddar Supreme" -> {
                ivTypeofPizza.setImageResource(R.drawable.cheddar)
                txtPizzaName.text = resources.getString(R.string.cheddarSupreme)
                txtPizzaDetail.text = resources.getString(R.string.detailCheddarSupreme)
            }
            else -> {
                ivTypeofPizza.setImageResource(R.drawable.meat)
                txtPizzaName.text = resources.getString(R.string.meatSupreme)
                txtPizzaDetail.text = resources.getString(R.string.detailMeatSupreme)
            }
        }

        val i = Intent(this, CheckOutActivity::class.java)

        //passing type of pizza to Checkout Activity
        i.putExtra("typeofPizza", typeofPizza)

        //checking which radioButton was checked and using putExtra to pass the data to Checkout Activity
        val radioGroup = findViewById<RadioGroup>(R.id.rgSize)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radio = findViewById<RadioButton>(checkedId)
            val size  = radio.text.toString()
            i.putExtra("size", size)
        }

        //checking which checkboxes were checked and using putExtra to pass the data to Checkout Activity
        chkGreenPepper.setOnClickListener{
            if(chkGreenPepper.isChecked) {
                i.putExtra("chkGreenPepper", "yes")
            }
            else
            {
                i.putExtra("chkGreenPepper", "no")
            }
        }

        chkBlackOlivies.setOnClickListener{
            if(chkBlackOlivies.isChecked) {
                i.putExtra("chkBlackOlivies", "yes")
            }
            else
            {
                i.putExtra("chkBlackOlivies", "no")
            }
        }

        chkSmokedHam.setOnClickListener{
            if(chkSmokedHam.isChecked) {
                i.putExtra("chkSmokedHam", "yes")
            }
            else
            {
                i.putExtra("chkSmokedHam", "no")
            }
        }

        chkSpanishOnions.setOnClickListener{
            if(chkSpanishOnions.isChecked) {
                i.putExtra("chkSpanishOnions", "yes")
            }
            else
            {
                i.putExtra("chkSpanishOnions", "no")
            }
        }

        chkSpinach.setOnClickListener{
            if(chkSpinach.isChecked) {
                i.putExtra("chkSpinach", "yes")
            }
            else
            {
                i.putExtra("chkSpinach", "no")
            }
        }

        chkExtraMozzarella.setOnClickListener{
            if(chkExtraMozzarella.isChecked) {
                i.putExtra("chkExtraMozzarella", "yes")
            }
            else
            {
                i.putExtra("chkExtraMozzarella", "no")
            }
        }

        //CHECK OUT BUTTON
        btnCheckOut.setOnClickListener{
            startActivity(i)
        }

    }

}

