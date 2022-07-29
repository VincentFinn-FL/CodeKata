package com.example.javakotlinkata.beverageprices.beverages;

public class HotChocolateWithCream extends HotChocolate {
    @Override
    public double price() {
        return 1.45 + 0.15;
    }
}
