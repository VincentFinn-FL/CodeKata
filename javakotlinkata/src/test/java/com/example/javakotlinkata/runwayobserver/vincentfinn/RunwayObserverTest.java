package com.example.javakotlinkata.runwayobserver.vincentfinn;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RunwayObserverTest {

  @Test
  void Set_traffic_control_display_to_Green_for_runway18Left() {
    var trafficControlDisplay = new Display();
    var runway18Left = new Runway("Runway 18 Left", trafficControlDisplay);

    runway18Left.setStatus("Green");

    assertThat(trafficControlDisplay.getMessage()).isEqualTo("Runway 18 Left: Green");
  }
}
