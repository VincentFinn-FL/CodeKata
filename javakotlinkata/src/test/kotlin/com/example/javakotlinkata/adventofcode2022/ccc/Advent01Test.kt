package com.example.javakotlinkata.adventofcode2022.ccc

import com.example.javakotlinkata.adventofcode2022.ccc.Advent01.*
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.containsExactly
import strikt.assertions.isEqualTo

class Advent01Test {

    private val subject = Advent01()

    @Test
    fun `getElves`() {
        val input = """
         1
         
         2
         3
     """.trimIndent()

        val actual = subject.getElves(input)

        expectThat(actual).containsExactly(
            Elf.withFood(Food(1)),
            Elf.withFood(Food(2), Food(3))
        )
        expectThat(actual[0].totalCalories).isEqualTo(1)
        expectThat(actual[1].totalCalories).isEqualTo(5)
    }


    @Test
    fun `should return total calories carried by the elf carrying the most calories`() {
        val actual = subject.part1(sampleInput)
        expectThat(actual).isEqualTo(24000)
    }

    @Test
    fun `should return total calories carried by the elf top 3 elves carrying the most calories`() {
        val actual = subject.part2(sampleInput)
        expectThat(actual).isEqualTo(45000)
    }

    companion object {
        val sampleInput = """
            1000
            2000
            3000

            4000

            5000
            6000

            7000
            8000
            9000

            10000
        """.trimIndent()
    }
}