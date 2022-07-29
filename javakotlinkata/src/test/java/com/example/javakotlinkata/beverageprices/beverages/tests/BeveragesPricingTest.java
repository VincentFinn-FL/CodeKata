package com.example.javakotlinkata.beverageprices.beverages.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import com.example.javakotlinkata.beverageprices.beverages.Beverage;
import com.example.javakotlinkata.beverageprices.beverages.Coffee;
import com.example.javakotlinkata.beverageprices.beverages.CoffeeWithMilk;
import com.example.javakotlinkata.beverageprices.beverages.CoffeeWithMilkAndCream;
import com.example.javakotlinkata.beverageprices.beverages.HotChocolate;
import com.example.javakotlinkata.beverageprices.beverages.HotChocolateWithCream;
import com.example.javakotlinkata.beverageprices.beverages.Tea;
import com.example.javakotlinkata.beverageprices.beverages.TeaWithMilk;
import org.junit.jupiter.api.Test;

class BeveragesPricingTest {
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
  void computes_tea_with_milk_price() {
    Tea teaWithMilk = new TeaWithMilk();
    assertThat(teaWithMilk.price(), is(closeTo(1.60, 0.001)));
  }

  @Test
  void computes_coffee_with_milk_price() {
    Coffee coffeeWithMilk = new CoffeeWithMilk();
    assertThat(coffeeWithMilk.price(), is(closeTo(1.30, 0.001)));
  }

  @Test
  void computes_coffee_with_milk_and_cream_price() {
    Coffee coffeeWithMilkAndCream = new CoffeeWithMilkAndCream();
    assertThat(coffeeWithMilkAndCream.price(), is(closeTo(1.45, 0.001)));
  }

  @Test
  void computes_hot_chocolate_with_cream_price() {
    HotChocolateWithCream hotChocolateWithCream = new HotChocolateWithCream();
    assertThat(hotChocolateWithCream.price(), is(closeTo(1.60, 0.001)));
  }
}
