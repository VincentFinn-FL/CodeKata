package com.example.javakotlinkata.beverageprices.vince.beverages;

public class CoffeeWithMilk extends Coffee {
    @Override
    public double price() {
        return super.price() +  0.10;
    }
}
