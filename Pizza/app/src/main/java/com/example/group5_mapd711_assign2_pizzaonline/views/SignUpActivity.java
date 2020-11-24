package com.example.group5_mapd711_assign2_pizzaonline.views;

//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.group5_mapd711_assign2_pizzaonline.R;
import com.example.group5_mapd711_assign2_pizzaonline.model.Admin;
import com.example.group5_mapd711_assign2_pizzaonline.model.Customer;
import com.example.group5_mapd711_assign2_pizzaonline.model.PurchaseOrder;
import com.example.group5_mapd711_assign2_pizzaonline.viewmodels.AdminViewModel;
import com.example.group5_mapd711_assign2_pizzaonline.viewmodels.CustomerViewModel;
import com.example.group5_mapd711_assign2_pizzaonline.viewmodels.OrderViewModel;

public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
    public AdminViewModel adminViewModel;
    private Admin admin;
    public CustomerViewModel customerViewModel;
    private Customer customer;
    public String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        adminViewModel = new ViewModelProvider(this).get(AdminViewModel.class);
        admin = new Admin();

        customerViewModel = new ViewModelProvider(this).get(CustomerViewModel.class);
        customer = new Customer();


        adminViewModel.getInsertResult().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer result) {
                if (result == 1) {
                    Toast.makeText(SignUpActivity.this, "successfully saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUpActivity.this, "Error saving info", Toast.LENGTH_SHORT).show();
                }
            }
        });

        customerViewModel.getInsertResult().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer result) {
                if (result == 1) {
                    Toast.makeText(SignUpActivity.this, "successfully saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUpActivity.this, "Error saving info", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Spinner element
        final Spinner spinner = (Spinner) findViewById(R.id.userTypeSpinner);
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        Button userRegisterButton = (Button) findViewById(R.id.userRegisterButton);
        userRegisterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Getting a reference to an inflated widget by calling the following Activity method: public View findViewById(int id)
                EditText firstNametxt = findViewById(R.id.firstNameEdt);
                EditText lastNametxt = findViewById(R.id.lastNameEdt);
                EditText usernametxt = findViewById(R.id.usernameEdt);
                EditText passwordtxt = findViewById(R.id.passwordEdt);

                //Converting the above input into string assign to below variables
                String firstName = firstNametxt.getText().toString();
                String lastName = lastNametxt.getText().toString();
                String username = usernametxt.getText().toString();
                String password = passwordtxt.getText().toString();

                if(!firstName.isEmpty() && !lastName.isEmpty() && !username.isEmpty() && !password.isEmpty() ){
                    // Storing data into SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences("SignUp_Login", MODE_PRIVATE);

                    // Creating an Editor object
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();

                    // Storing the key and its value
                    myEdit.putString("firstName", firstName);
                    myEdit.putString("lastName", lastName);
                    myEdit.putString("username", username);
                    myEdit.putString("password", password);
                    myEdit.putString("type", type);
                    //commiting to apply those changes made,
                    myEdit.commit();

                    //saving also in the database
                    if (type.equals("Customer")){
                        customer.setFirstName(firstName);
                        customer.setLastName(lastName);
                        customer.setUserName(username);
                        customer.setPassword(password);
                        customerViewModel.insert(customer);
                    }
                    else{
                        admin.setFirstname(firstName);
                        admin.setLastname(lastName);
                        admin.setUserName(username);
                        admin.setPassword(password);
                        adminViewModel.insert(admin);
                    }

                    Intent i = new Intent(getApplicationContext(), UserLoginActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(SignUpActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        type = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}