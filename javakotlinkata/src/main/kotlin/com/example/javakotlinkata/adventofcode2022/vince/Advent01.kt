package com.example.javakotlinkata.adventofcode2022.vince

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
        val lines = input.split("\n")

        val elves = mutableListOf<Elf>()
        var elf = Elf()
        lines.forEach { line ->
            if (line == "") {
                elves.add(elf)
                elf = Elf()
            } else {
                val calories = parseInt(line)
                elf.addFood(Food(calories))
            }
        }
        elves.add(elf)
        return elves
    }

    data class Elf(private val food: MutableList<Food> = mutableListOf()) {
        constructor(vararg storedFood: Food) : this(storedFood.toMutableList())

        val totalCalories: Int
            get() = food.sumOf { it.calories }

        fun addFood(food: Food) {
            this.food.add(food)
        }

    }

    data class Food(val calories: Int)
}