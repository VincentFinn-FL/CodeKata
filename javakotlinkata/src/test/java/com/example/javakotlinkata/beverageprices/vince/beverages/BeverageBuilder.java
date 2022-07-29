package com.example.javakotlinkata.beverageprices.vince.beverages;

import com.example.javakotlinkata.beverageprices.vince.beverages.supplements.WithCinnamon;
import com.example.javakotlinkata.beverageprices.vince.beverages.supplements.WithCream;
import com.example.javakotlinkata.beverageprices.vince.beverages.supplements.WithMilk;

public class BeverageBuilder {
  public static BeverageBuilder coffee() {
    return new BeverageBuilder(new Coffee());
  }

  public static BeverageBuilder tea() {
    return new BeverageBuilder(new Tea());
  }

  public static BeverageBuilder hotChocolate() {
    return new BeverageBuilder(new HotChocolate());
  }

  private Beverage beverage;

  private BeverageBuilder(Beverage beverage) {
    this.beverage = beverage;
  }

  public BeverageBuilder withMilk() {
    beverage = new WithMilk(beverage);
    return this;
  }

  public BeverageBuilder withCinnamon() {
    beverage = new WithCinnamon(beverage);
    return this;
  }

  public BeverageBuilder withCream() {
    beverage = new WithCream(beverage);
    return this;
  }

  public Beverage build() {
    return beverage;
  }
}
