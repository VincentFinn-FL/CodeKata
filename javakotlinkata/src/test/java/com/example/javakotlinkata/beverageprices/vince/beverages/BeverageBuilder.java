package com.example.javakotlinkata.beverageprices.vince.beverages;

import com.example.javakotlinkata.beverageprices.vince.beverages.supplements.WithCinnamon;
import com.example.javakotlinkata.beverageprices.vince.beverages.supplements.WithCream;
import com.example.javakotlinkata.beverageprices.vince.beverages.supplements.WithMilk;

public class BeverageBuilder {
  public static CoffeeBuilder coffee() {
    return new CoffeeBuilder();
  }

  public static TeaBuilder tea() {
    return new TeaBuilder();
  }

  public static HotChocolateBuilder hotChocolate() {
    return new HotChocolateBuilder();
  }

  public static class CoffeeBuilder {
    private Beverage beverage;

    private CoffeeBuilder() {
      this.beverage = new Coffee();
    }

    public Beverage make() {
      return beverage;
    }

    public CoffeeBuilder withMilk() {
      beverage = new WithMilk(beverage);
      return this;
    }

    public CoffeeBuilder withCinnamon() {
      beverage = new WithCinnamon(beverage);
      return this;
    }

    public CoffeeBuilder withCream() {
      beverage = new WithCream(beverage);
      return this;
    }
  }

  public static class TeaBuilder {
    private Beverage beverage;

    private TeaBuilder() {
      this.beverage = new Tea();
    }

    public Beverage make() {
      return beverage;
    }

    public TeaBuilder withMilk() {
      beverage = new WithMilk(beverage);
      return this;
    }

    public TeaBuilder withCinnamon() {
      beverage = new WithCinnamon(beverage);
      return this;
    }
  }

  public static class HotChocolateBuilder {
    private Beverage beverage;

    private HotChocolateBuilder() {
      this.beverage = new HotChocolate();
    }

    public Beverage make() {
      return beverage;
    }

    public HotChocolateBuilder withCinnamon() {
      beverage = new WithCinnamon(beverage);
      return this;
    }

    public HotChocolateBuilder withCream() {
      beverage = new WithCream(beverage);
      return this;
    }
  }
}
