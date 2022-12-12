package com.example.javakotlinkata.adventofcode2022.vince

import com.example.javakotlinkata.A
import com.example.javakotlinkata.adventofcode2022.vince.Advent01.Elf
import com.example.javakotlinkata.adventofcode2022.vince.Advent01.Food
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.containsExactly
import strikt.assertions.isEqualTo

class Advent01Test {
    private val subject = Advent01()

    @Nested
    inner class GetElves {
        @Test
        fun `should return groups of elves`() {
            val input = """
                1
                
                2
                3
            """.trimIndent()

            val actual = subject.getElves(input)

            println(actual)

            expectThat(actual).containsExactly(
                Elf(Food(1)),
                Elf(Food(2), Food(3))
            )
        }

    }

    @Nested
    inner class Part1 {

        @Test
        fun `should return total calories carried by the elf carrying the most calories`() {
            val actual = subject.part1(sampleInput)
            expectThat(actual).isEqualTo(24000)
        }

        @Test
        fun `print Solution`() {
            val input = A.resource("adventofcode2022/01")
            println(subject.part1(input))
        }

    }

    @Nested
    inner class Part2 {

        @Test
        fun `should return total calories carried by the top 3 elves carrying the most calories`() {
            val actual = subject.part2(sampleInput)
            expectThat(actual).isEqualTo(45000)
        }

        @Test
        fun `print Solution`() {
            val input = A.resource("adventofcode2022/01")
            println(subject.part2(input))
        }

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