package com.example.javakotlinkata.beverageprices.vince.beverages.supplements;

import com.example.javakotlinkata.beverageprices.vince.beverages.Beverage;

public class WithMilk implements Beverage {
  private final Beverage beverage;

  public WithMilk(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public double price() {
    return this.beverage.price() + 0.10;
  }
}
