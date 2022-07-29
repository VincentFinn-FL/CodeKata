package com.example.javakotlinkata.beverageprices.vince.beverages;

public class CoffeeWithMilkAndCream extends Coffee {
    @Override
    public double price() {
        return super.price() +  0.25;
    }
}
