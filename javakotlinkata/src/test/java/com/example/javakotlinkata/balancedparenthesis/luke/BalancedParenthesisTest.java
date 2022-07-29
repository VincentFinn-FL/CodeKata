package com.example.javakotlinkata.balancedparenthesis.luke;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BalancedParenthesisTest {

    private BalancedParenthesis subject;

    @BeforeEach
    public void setup() {
        subject = new BalancedParenthesis();
    }

    @Test
    public void test_singleSetOfParens() {
        assertThat(subject.isBalanced("()")).isTrue();
        assertThat(subject.isBalanced("[({})]")).isTrue();
        assertThat(subject.isBalanced("{}([])")).isTrue();
        assertThat(subject.isBalanced("{()}[[{}]]")).isTrue();

        assertThat(subject.isBalanced("{{)(}}")).isFalse();
        assertThat(subject.isBalanced("({)}")).isFalse();

        assertThat(subject.isBalanced("}")).isFalse();
        assertThat(subject.isBalanced("]")).isFalse();
        assertThat(subject.isBalanced(")")).isFalse();

        assertThat(subject.isBalanced("{")).isFalse();
        assertThat(subject.isBalanced("[")).isFalse();
        assertThat(subject.isBalanced("(")).isFalse();
    }

}