package com.example.javakotlinkata.beverageprices.vince.beverages.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import com.example.javakotlinkata.beverageprices.vince.beverages.Beverage;
import com.example.javakotlinkata.beverageprices.vince.beverages.BeverageBuilder;
import com.example.javakotlinkata.beverageprices.vince.beverages.BeverageFactory;
import com.example.javakotlinkata.beverageprices.vince.beverages.Coffee;
import com.example.javakotlinkata.beverageprices.vince.beverages.HotChocolate;
import com.example.javakotlinkata.beverageprices.vince.beverages.Tea;
import com.example.javakotlinkata.beverageprices.vince.beverages.supplements.WithCinnamon;
import com.example.javakotlinkata.beverageprices.vince.beverages.supplements.WithCream;
import com.example.javakotlinkata.beverageprices.vince.beverages.supplements.WithMilk;
import org.junit.jupiter.api.Test;

class BeveragesPricingTest {
  private static final float PRECISION = 0.001f;

  @Test
  void computes_coffee_price() {
    Beverage coffee = new Coffee();
    assertThat(coffee.price(), is(closeTo(1.20, 0.001)));
  }

  @Test
  void computes_tea_price() {
    Beverage tea = new Tea();
    assertThat(tea.price(), is(closeTo(1.50, 0.001)));
  }

  @Test
  void computes_hot_chocolate_price() {
    Beverage hotChocolate = new HotChocolate();
    assertThat(hotChocolate.price(), is(closeTo(1.45, 0.001)));
  }

  @Test
  void computes_coffee_with_milk_price() {
    Beverage coffeeWithMilk = new WithMilk(new Coffee());
    assertThat(coffeeWithMilk.price(), is(closeTo(1.30, 0.001)));
  }

  @Test
  void computes_hot_chocolate_with_cream_price() {
    Beverage hotChocolateWithCream = new WithCream(new HotChocolate());
    assertThat(hotChocolateWithCream.price(), is(closeTo(1.60, 0.001)));
  }

  @Test
  void computes_tea_with_milk_price() {
    Beverage teaWithMilk = new WithMilk(new Tea());
    assertThat(teaWithMilk.price(), is(closeTo(1.60, PRECISION)));
  }

  @Test
  void computes_coffee_with_milk_and_cream_price() {
    Beverage coffeeWithMilkAndCream = new WithMilk(new WithCream(new Coffee()));
    assertThat(coffeeWithMilkAndCream.price(), is(closeTo(1.45, PRECISION)));
  }

  @Test
  void computes_coffee_with_cinnamon() {
    Beverage coffeeWithCinnamon = new WithCinnamon(new Coffee());
    assertThat(coffeeWithCinnamon.price(), is(closeTo(1.25, PRECISION)));
  }

  @Test
  void compute_drink_with_factory_method() {
    Beverage teaWithCreamAndCinnamon = BeverageFactory.teaWithCreamAndCinnamon();
    assertThat(teaWithCreamAndCinnamon.price(), is(closeTo(1.70, PRECISION)));
  }

  @Test
  void compute_drink_with_builder() {
    Beverage teaWithCreamAndCinnamon = BeverageBuilder.tea().withMilk().withCinnamon().make();
    assertThat(teaWithCreamAndCinnamon.price(), is(closeTo(1.65, PRECISION)));
  }
}
