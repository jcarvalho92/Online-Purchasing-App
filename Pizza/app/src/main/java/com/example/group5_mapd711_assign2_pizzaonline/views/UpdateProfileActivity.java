package com.example.group5_mapd711_assign2_pizzaonline.views;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.group5_mapd711_assign2_pizzaonline.R;
import com.example.group5_mapd711_assign2_pizzaonline.model.Customer;
import com.example.group5_mapd711_assign2_pizzaonline.viewmodels.AdminViewModel;
import com.example.group5_mapd711_assign2_pizzaonline.viewmodels.CustomerViewModel;
import com.example.group5_mapd711_assign2_pizzaonline.viewmodels.OrderViewModel;
import com.example.group5_mapd711_assign2_pizzaonline.viewmodels.PizzaViewModel;

public class UpdateProfileActivity extends AppCompatActivity {
    public CustomerViewModel customerViewModel;
    private Customer customer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        customerViewModel = new ViewModelProvider(this).get(CustomerViewModel.class);

        Button updateBtn = (Button) findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Getting a reference to an inflated widget by calling the following Activity method: public View findViewById(int id)
                EditText usernameTxt = findViewById(R.id.usernameEdt);
                EditText passwordTxt = findViewById(R.id.passwordEdt);
                EditText firstNameTxt = findViewById(R.id.firstNameEdt);
                EditText lastNameTxt = findViewById(R.id.lastNameEdt);
                //Converting the above input into string assign to below variables
                String username = usernameTxt.getText().toString();
                String password = passwordTxt.getText().toString();
                String firstName = firstNameTxt.getText().toString();
                String lastName = lastNameTxt.getText().toString();

                //updating shared preferances
                SharedPreferences sharedPreferences = getSharedPreferences("SignUp_Login", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();

                // Storing the key and its value
                myEdit.putString("firstName", firstName);
                myEdit.putString("lastName", lastName);
                myEdit.putString("username", username);
                myEdit.putString("password", password);
                myEdit.putString("type", "Customer");
                //commiting to apply those changes made,
                myEdit.commit();


                customer = customerViewModel.getCustomerByUserName(username);

                customer.setFirstName(firstName);
                customer.setLastName(lastName);
                customer.setUserName(username);
                customer.setPassword(password);
                customerViewModel.update(customer);

                Toast.makeText(UpdateProfileActivity.this, "Profile Updated", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}