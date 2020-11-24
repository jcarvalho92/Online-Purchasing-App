package com.example.group5_mapd711_assign2_pizzaonline.views
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.group5_mapd711_assign2_pizzaonline.R
import com.example.group5_mapd711_assign2_pizzaonline.model.Pizza
import com.example.group5_mapd711_assign2_pizzaonline.viewmodels.PizzaViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var pizzaViewModel: PizzaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val intent = intent
        val userType = intent.getStringExtra("userType")

        logout.setOnClickListener(){
            val i = Intent(this, UserLoginActivity::class.java)
            startActivity(i)
        }

        updateProfile.setOnClickListener(){
            val i = Intent(this, UpdateProfileActivity::class.java)
            startActivity(i)
        }

        mississaugaLoc.setOnClickListener(){
            val i = Intent(this, MapsActivity::class.java)
            i.putExtra("location", "mississauga")
            startActivity(i)
        }
        northyorkLoc.setOnClickListener(){
            val i = Intent(this, MapsActivity::class.java)
            i.putExtra("location", "northyork")
            startActivity(i)
        }
        oakvilleLoc.setOnClickListener(){
            val i = Intent(this, MapsActivity::class.java)
            i.putExtra("location", "oakville")
            startActivity(i)
        }
        scarboroughLoc.setOnClickListener(){
            val i = Intent(this, MapsActivity::class.java)
            i.putExtra("location", "scarborough")
            startActivity(i)
        }
        torontoLoc.setOnClickListener(){
            val i = Intent(this, MapsActivity::class.java)
            i.putExtra("location", "toronto")
            startActivity(i)
        }
        allLoc.setOnClickListener(){
            val i = Intent(this, MapsActivity::class.java)
            i.putExtra("location", "all")
            startActivity(i)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //adding the Options menu in the activity
        menuInflater.inflate(R.menu.main, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val i = Intent(this, PizzaDetailsActivity::class.java)

        //checking which menu was selected and passing it to the PizzaDetails Activity
        when (item.itemId){
            R.id.meatSupreme ->
                i.putExtra("typeofPizza", "Meat Supreme")
            R.id.superHawaiian ->
                i.putExtra("typeofPizza", "Super Hawaiian")
            R.id.veggie ->
                i.putExtra("typeofPizza", "Veggie")
            R.id.mediterranean ->
                i.putExtra("typeofPizza", "Mediterranean")
            R.id.cheddarSupreme ->
                i.putExtra("typeofPizza", "Cheddar Supreme")
        }

        startActivity(i)
        return true
    }

}

