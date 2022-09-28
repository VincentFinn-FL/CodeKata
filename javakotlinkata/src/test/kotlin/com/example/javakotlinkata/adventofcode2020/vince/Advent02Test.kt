package com.example.javakotlinkata.adventofcode2020.vince

import com.example.javakotlinkata.A
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Advent02Test {

    @Test
    fun `test`() {
        println(Advent02.toArray(input))
    }

    companion object {
        val input = A.resource("adventofcode2020/02")
    }

}