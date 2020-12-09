package com.example.group5_mapd711_assign2_pizzaonline.views

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.group5_mapd711_assign2_pizzaonline.R
import kotlinx.android.synthetic.main.activity_add_pizza.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException


class AddPizzaActivity : AppCompatActivity() {
    var userString = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_pizza)


        addPizzaBtn.setOnClickListener {

            val pizzaEdt = findViewById<EditText>(R.id.pizzaEdt)
            val ingredientsEdt = findViewById<EditText>(R.id.ingredientsEdt)

            //Converting the above input into string assign to below variables

            //Converting the above input into string assign to below variables
            val pizzaName = pizzaEdt.text.toString()
            val ingredients = ingredientsEdt.text.toString()

            val jsonObject = JSONObject()
            try {
                jsonObject.put("pizza", pizzaName)
                jsonObject.put("ingredients", ingredients)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            // Convert JsonObject to String Format
            userString = jsonObject.toString()

            val filename = "pizzas.txt"

            try {
                val out = openFileOutput(filename, Context.MODE_PRIVATE)
                out.use {
                    out.write(userString.toByteArray())
                }
                runOnUiThread(Runnable {
                    Toast.makeText(this,"Saved", Toast.LENGTH_LONG).show()
                })
            }
            catch(ioe:IOException) {
                print("Error while saving ${filename} : ${ioe}")
            }

        }
    }



}