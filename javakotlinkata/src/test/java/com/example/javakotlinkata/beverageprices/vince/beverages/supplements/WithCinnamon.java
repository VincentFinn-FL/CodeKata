package com.example.javakotlinkata.beverageprices.vince.beverages.supplements;

import com.example.javakotlinkata.beverageprices.vince.beverages.Beverage;
import com.example.javakotlinkata.beverageprices.vince.beverages.Coffee;

public class WithCinnamon implements Beverage {
  private final Beverage beverage;

  public WithCinnamon(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public double price() {
    return beverage.price() + 0.05;
  }
}
