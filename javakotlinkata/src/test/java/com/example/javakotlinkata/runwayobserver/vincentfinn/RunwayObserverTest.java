package com.example.javakotlinkata.runwayobserver.vincentfinn;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RunwayObserverTest {

  @ParameterizedTest
  @ValueSource(strings = {"Green", "Yellow", "Red"})
  void Set_terminal_and_traffic_control_display_to_status_for_runway18Left(String status) {
    var trafficControlDisplay = new Display();
    var terminalDisplay = new Display();
    var runway18Left = new Runway("Runway 18 Left", List.of(trafficControlDisplay, terminalDisplay));

    runway18Left.setStatus(status);

    assertThat(trafficControlDisplay.getMessages()).containsExactly("Runway 18 Left: " + status);
    assertThat(terminalDisplay.getMessages()).containsExactly("Runway 18 Left: " + status);
  }

  @Test
  void When_a_second_runway_updates_it_status_on_the_message_log() {
    var trafficControlDisplay = new Display();
    var runway18Left = new Runway("Runway 18 Left", List.of(trafficControlDisplay));
    var runway48Right = new Runway("Runway 48 Right", List.of(trafficControlDisplay));

    runway18Left.setStatus("Green");
    runway48Right.setStatus("Yellow");

    assertThat(trafficControlDisplay.getMessages()).containsExactly(
        "Runway 18 Left: " + "Green",
        "Runway 48 Right: " + "Yellow"
    );
  }
}
