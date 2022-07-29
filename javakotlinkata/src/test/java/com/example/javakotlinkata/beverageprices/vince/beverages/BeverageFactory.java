package com.example.javakotlinkata.beverageprices.vince.beverages;

import com.example.javakotlinkata.beverageprices.vince.beverages.supplements.WithCinnamon;
import com.example.javakotlinkata.beverageprices.vince.beverages.supplements.WithCream;
import com.example.javakotlinkata.beverageprices.vince.beverages.supplements.WithMilk;

// Encapsulate object creation, but introduces Method Combinatorial Explosion
public class BeverageFactory {
  public static Beverage coffeeWithMilk() {
    return new WithMilk(new Coffee());
  }

  public static Beverage teaWithCreamAndCinnamon() {
    return new WithCream(new WithCinnamon(new Tea()));
  }
}
