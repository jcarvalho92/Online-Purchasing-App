package com.example.group5_mapd711_assign2_pizzaonline.views;

//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.group5_mapd711_assign2_pizzaonline.R;

public class UserLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        TextView signup = (TextView) findViewById(R.id.signupTextView);
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(i);
            }
        });

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Getting a reference to an inflated widget by calling the following Activity method: public View findViewById(int id)
                EditText usernameTxt = findViewById(R.id.usernameEditText);
                EditText passwordTxt = findViewById(R.id.passwordEditText);

                //Converting the above input into string assign to below variables
                String username = usernameTxt.getText().toString();
                String password = passwordTxt.getText().toString();

                if(!username.isEmpty() && !password.isEmpty()){
                    // Retrieving the value using its keys
                    SharedPreferences sh = getSharedPreferences("SignUp_Login", MODE_PRIVATE);
                    String savedUser = sh.getString("username", "");
                    String savedPassword = sh.getString("password", "");
                    String savedType = sh.getString("type", "");

                    if(savedUser.equals(username) && savedPassword.equals(password)) {
                        if (savedType.equals("Admin")){
                            Intent i = new Intent(getApplicationContext(), Admin_CustomerOrder_Edit.class);
                            startActivity(i);
                        }
                        else{
                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                        }
                    }
                    else{
                        Toast.makeText(UserLoginActivity.this, "Login or Password invalid", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(UserLoginActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}