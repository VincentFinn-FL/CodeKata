package com.example.javakotlinkata.adventofcode2020.vince

import com.example.javakotlinkata.A
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.contains
import strikt.assertions.hasSize
import strikt.assertions.isEqualTo

class Advent01Test {

    private val subject = Advent01

    @Test
    fun `convert input to array`() {
        val actual = subject.toArray(input)

        expectThat(actual).hasSize(200)
        expectThat(actual).contains(1834, 1546, 1760)
    }

    @Test
    fun `find two numbers that add up to target`() {
        val target = 2020

        val actual = subject.findTwoEntriesThatSumToTarget(subject.toArray(input), target)

        expectThat(actual.first + actual.second).isEqualTo(target)
        println(actual.first * actual.second)
    }

    @Test
    fun `find three numbers that add up to target`() {
        val target = 2020

        val actual = subject.findThreeEntriesThatSumToTarget(subject.toArray(input), target)

        expectThat(actual.first + actual.second + actual.third).isEqualTo(target)
        println(actual.first * actual.second * actual.third)
    }

    companion object {
        val input = A.resource("adventofcode2020/01")
    }
}