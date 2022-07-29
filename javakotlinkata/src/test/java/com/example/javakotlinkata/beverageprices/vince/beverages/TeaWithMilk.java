package com.example.javakotlinkata.beverageprices.vince.beverages;

public class TeaWithMilk extends Tea {
    @Override
    public double price() {
        return super.price() +  0.10;
    }
}
