package com.example.javakotlinkata.beverageprices.beverages;

public class CoffeeWithMilk extends Coffee {
    @Override
    public double price() {
        return super.price() +  0.10;
    }
}
