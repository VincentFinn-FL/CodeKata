package com.example.javakotlinkata.runwayobserver.vincentfinn;

import java.util.ArrayList;
import java.util.List;

public class Display {
  private List<String> messages = new ArrayList<>();

  public List<String> getMessages() {
    return messages;
  }

  public void addMessage(String message) {
    this.messages.add(message);
  }
}
