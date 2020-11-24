package com.example.group5_mapd711_assign2_pizzaonline.views;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.group5_mapd711_assign2_pizzaonline.R;
import com.example.group5_mapd711_assign2_pizzaonline.model.Admin;
import com.example.group5_mapd711_assign2_pizzaonline.model.Customer;
import com.example.group5_mapd711_assign2_pizzaonline.model.Pizza;
import com.example.group5_mapd711_assign2_pizzaonline.model.PurchaseOrder;
import com.example.group5_mapd711_assign2_pizzaonline.viewmodels.AdminViewModel;
import com.example.group5_mapd711_assign2_pizzaonline.viewmodels.CustomerViewModel;
import com.example.group5_mapd711_assign2_pizzaonline.viewmodels.OrderViewModel;
import com.example.group5_mapd711_assign2_pizzaonline.viewmodels.PizzaViewModel;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public class CheckOutActivity extends AppCompatActivity {
    public CustomerViewModel customerViewModel;
    private Customer customer;
    public OrderViewModel orderViewModel;
    private PurchaseOrder order;
    public AdminViewModel adminViewModel;
    private Admin admin;
    public PizzaViewModel pizzaViewModel;
    private TextView textViewDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        //getting today's date
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final String date = sdf.format(cal.getTime());

        customerViewModel = new ViewModelProvider(this).get(CustomerViewModel.class);
        pizzaViewModel = new ViewModelProvider(this).get(PizzaViewModel.class);
        adminViewModel = new ViewModelProvider(this).get(AdminViewModel.class);
        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);

        order = new PurchaseOrder();
        admin = new Admin();
        customer = new Customer();

        //observing getInsertResult and showing the message "sucessfully saved" when inserting the customer or showing "Error saving info" in case of error
        customerViewModel.getInsertResult().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer result) {
                if (result == 1) {
                    Toast.makeText(CheckOutActivity.this, "successfully saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CheckOutActivity.this, "Error saving info", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button buttonOrder = (Button) findViewById(R.id.buttonOrder);
        //button order listener
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Boolean validInputs = true;
                String msg = "";

                //Getting a reference to an inflated widget by calling the following Activity method: public View findViewById(int id)
                EditText firstNametxt = findViewById(R.id.txtFirstName);
                EditText lastNametxt = findViewById(R.id.txtLastName);
                EditText addresstxt = findViewById(R.id.txtAddr);
                EditText citytxt = findViewById(R.id.txtCity);
                EditText postalCodetxt = findViewById(R.id.txtPostalCode);
                EditText mobileNumbertxt= findViewById(R.id.txtMobileNumber);
                EditText cardNumbertxt = findViewById(R.id.txtCCNum);
                EditText expiryDatetxt = findViewById(R.id.txtExpiryDate);

                //Converting the above input into string assign to below variables
                String firstName = firstNametxt.getText().toString();
                String lastName = lastNametxt.getText().toString();
                String address = addresstxt.getText().toString();
                String city = citytxt.getText().toString();
                String postalCode = postalCodetxt.getText().toString();
                String mobileNumber = mobileNumbertxt.getText().toString();
                String cardNumber = cardNumbertxt.getText().toString();
                String expiryDate = expiryDatetxt.getText().toString();

                //validations
                if (firstName.isEmpty()){
                    validInputs= false;
                    msg = "Please Enter Your First Name";
                }
                else
                if (lastName.isEmpty()){
                    validInputs= false;
                    msg = "Please Enter Your Last Name";
                }
                else
                if (address.isEmpty()) {
                    validInputs= false;
                    msg = "Please Enter Your Address";
                }
                else
                if (city.isEmpty()) {
                    validInputs= false;
                    msg = "Please Enter Your City";
                }
                else
                if (postalCode.length() < 6) {
                    validInputs= false;
                    msg = "Please Enter a valid Postal Code";
                }
                else
                if (checkLuhn(cardNumber) == false) {
                    validInputs = false;
                    msg = "Please Enter a Valid Card Number";
                }
                else
                if (mobileNumber.length() != 10) {
                    validInputs = false;
                    msg ="Please Enter a Valid Mobile Number";
                }
                else
                if (expiryDate.length() > 7) {
                    validInputs= false;
                    msg = "Please Enter a valid Expiry Date";
                }

                Intent intent = getIntent();

                //getting the info from PizzaDetails Activity
                String typeofPizza = intent.getStringExtra("typeofPizza");
                String size = intent.getStringExtra("size");
                String chkGreenPepper = intent.getStringExtra("chkGreenPepper");
                String chkBlackOlivies = intent.getStringExtra("chkBlackOlivies");
                String chkSmokedHam = intent.getStringExtra("chkSmokedHam");
                String chkSpanishOnions = intent.getStringExtra("chkSpanishOnions");
                String chkSpinach = intent.getStringExtra("chkSpinach");
                String chkExtraMozzarella = intent.getStringExtra("chkExtraMozzarella");

                //validating the extra toppings
                String toppings = "";

                //concatenating the extra toppings to show in the Checkout Display Activity
                if (chkGreenPepper != null && chkGreenPepper.equals("yes")) {
                    toppings += "Green Pepper,";
                }
                if(chkBlackOlivies != null && chkBlackOlivies.equals("yes")){
                    toppings += "Black Olives,";
                }
                if(chkSmokedHam != null && chkSmokedHam.equals("yes")){
                    toppings += "Smoked Ham,";
                }
                if(chkSpanishOnions != null && chkSpanishOnions.equals("yes")){
                    toppings += "Spanish Onions,";
                }
                if(chkSpinach != null && chkSpinach.equals("yes")){
                    toppings += "Spinach,";
                }
                if(chkExtraMozzarella != null && chkExtraMozzarella.equals("yes")){
                    toppings += "Extra Mozzarella";
                }

                Intent i = new Intent(getApplicationContext(), CheckOutDetailsActivity.class);

                //after validating the inputs we are saving the information in the database and then starting the Checkout Details Activity
                if(validInputs){
                    customer.setFirstName(firstName);
                    customer.setLastName(lastName);
                    customer.setAddress(address);
                    customer.setCity(city);
                    customer.setPostalCode(postalCode);
                    customer.setMobileNumber(mobileNumber);
                    customer.setCardNumber(cardNumber);
                    customer.setExpiryDate(expiryDate);
                    customerViewModel.insert(customer);

                    //getting the customer id
                    Customer cust = customerViewModel.getLastCustomer();
                    int customerId = cust.getCustomerId();
                    order.setStatus("In Progress");
                    order.setQuantity(1);
                    order.setOrderDate(Date.valueOf(date));
                    order.setExtraToppings(toppings);
                    order.setCustomerId(customerId);
                    //getting the pizza id
                    Pizza pizza = pizzaViewModel.getPizzaByNameAndSize(typeofPizza, size);
                    order.setPizzaId(pizza.getPizzaId());
                    orderViewModel.insert(order);

                    //starting the activity
                    startActivity(i);
                }
                else{ //showing to the user which input is not correct
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

    static boolean checkLuhn(String cardNo)
    {
        int nDigits = cardNo.length();

        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--)
        {

            int d = cardNo.charAt(i) - '0';

            if (isSecond == true)
                d = d * 2;

            // We add two digits to handle
            // cases that make two digits
            // after doubling
            nSum += d / 10;
            nSum += d % 10;

            isSecond = !isSecond;
        }
        return (nSum % 10 == 0);
    }

}