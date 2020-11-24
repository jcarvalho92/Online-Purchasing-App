package com.example.group5_mapd711_assign2_pizzaonline.model;
//Group 5 - Assignment 4
//Student1: Abdeali Mody - Student ID: 301085484
//Student2: Juliana de Carvalho - Student ID: 301137060
public class JoinCustomerOrderPizza {
    private int customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String postalCode;

    private int pizzaId;
    private String pizzaName;
    private String price;
    private String size;

    private int orderId;
    private int quantity;
    private String extraToppings;
    private String status;

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int id) { this.customerId = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public int getPizzaId() {
        return pizzaId;
    }
    public void setPizzaId(int id) {
        this.pizzaId = id;
    }

    public String getPizzaName() {
        return pizzaName;
    }
    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) { this.price = price; }

    public String getSize() {
        return size;
    }
    public void setSize(String size) { this.size = size; }

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int id) {
        this.orderId = id;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getExtraToppings() {
        return extraToppings;
    }
    public void setExtraToppings(String extraToppings) { this.extraToppings = extraToppings; }

    public String getStatus() {
        return status;
    }
    public void setStatus(String name) {
        this.status = name;
    }

}