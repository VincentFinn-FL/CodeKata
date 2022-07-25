package com.example.javakotlinkata.runwayobserver.vincentfinn;

public class Runway {
  private final String name;
  private final Display display;

  private String status;

  public Runway(String name, Display display) {
    this.name = name;
    this.display = display;
  }

  public void setStatus(String status) {
    this.status = status;
    this.display.setMessage("Runway 18 Left: Green");
  }
}
