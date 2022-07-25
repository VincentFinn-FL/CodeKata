package com.example.javakotlinkata.runwayobserver.vincentfinn;

import java.util.List;

public class Runway {
  private final String name;
  private final List<Display> observers;

  public Runway(String name, List<Display> observers) {
    this.name = name;
    this.observers = observers;
  }

  public void setStatus(String status) {
    for (var observer : this.observers) {
      observer.addMessage(name + ": " + status);
    }
  }
}
