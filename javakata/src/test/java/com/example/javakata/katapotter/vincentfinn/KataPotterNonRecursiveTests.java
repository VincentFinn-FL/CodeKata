package com.example.javakata.katapotter.vincentfinn;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class KataPotterNonRecursiveTests {
    private final KataPotterNonRecursive kataPotter = new KataPotterNonRecursive();

    @Test
    void one_book() {
        assertThat(kataPotter.purchase(List.of(1))).isEqualTo(8f);
    }

    @Test
    void two_of_the_second_book() {
        assertThat(kataPotter.purchase(List.of(0, 2))).isEqualTo(16f);
    }

    @Test
    void buy_different_books() {
        assertThat(kataPotter.purchase(List.of(1, 1))).isEqualTo(16f * (1 - .05f));
        assertThat(kataPotter.purchase(List.of(1, 1, 1))).isEqualTo(24f * (1 - .10f));
        assertThat(kataPotter.purchase(List.of(1, 1, 1, 1))).isEqualTo(32f * (1 - .20f));
        assertThat(kataPotter.purchase(List.of(1, 1, 1, 1, 1))).isEqualTo(40f * (1 - .25f));
    }

    @Test
    void buy_some_different_books() {
        assertThat(kataPotter.purchase(List.of(2, 1))).isEqualTo((16f * (1 - .05f)) + 8);
        assertThat(kataPotter.purchase(List.of(2, 1, 1))).isEqualTo((24f * (1 - .10f)) + 8);
    }
}