package com.example.javakotlinkata.balancedparenthesis.lukemueller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BalancedParenthesisTest {

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
            Arguments.of("()", true),
            Arguments.of("[({})]", true),
            Arguments.of("{}([])", true),
            Arguments.of("{()}[[{}]]", true),
            Arguments.of("{{)(}}", false),
            Arguments.of("({)}", false),
            Arguments.of("}", false),
            Arguments.of("]", false),
            Arguments.of(")", false),
            Arguments.of("{", false),
            Arguments.of("[", false),
            Arguments.of("(", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        assertThat(BalancedParenthesis.isBalanced(input)).isEqualTo(expected);
    }

}