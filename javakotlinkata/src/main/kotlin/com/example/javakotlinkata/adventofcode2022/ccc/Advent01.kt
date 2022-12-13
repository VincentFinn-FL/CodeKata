package com.example.javakotlinkata.adventofcode2022.ccc

import java.lang.Integer.parseInt

class Advent01 {
    fun part1(input: String): Int {
        val elves = getElves(input)
        return elves.maxOf { it.totalCalories }
    }

    fun part2(input: String): Int {
        val elves = getElves(input)
        return elves
            .sortedByDescending { it.totalCalories }
            .take(3)
            .sumOf { it.totalCalories }
    }

    fun getElves(input: String): List<Elf> {
        val split = input.split("\n\n")
        val elves = split.map { group ->
            val food = group
                .split("\n")
                .map { Food(parseInt(it)) }
            Elf(food)
        }
        return elves
    }

    data class Elf(private val food: List<Food>) {
        val totalCalories
            get() = food.sumOf { it.calories }

        companion object {
            fun withFood(vararg food: Food): Elf {
                return Elf(food.toList())
            }
        }
    }

    data class Food(val calories: Int)
}