package com.example.javakotlinkata.adventofcode2020.vince

import java.lang.Integer.parseInt
import kotlin.math.abs

object Advent01 {

    fun toArray(input: String): List<Int> {
        return input.split("\n").map { parseInt(it) }
    }

    fun findTwoEntriesThatSumToTarget(array: List<Int>, target: Int): Pair<Int, Int> {
        val targetMap = mutableMapOf<Int, Unit>()
        array.forEach {
            val entryNeeded = abs(it - target)
            if (targetMap.containsKey(entryNeeded)) {
                return it to entryNeeded
            } else {
                targetMap[it] = Unit
            }
        }
        throw Exception("Unable to find entries that sum up to target")
    }

    fun findThreeEntriesThatSumToTarget(array: List<Int>, target: Int): Triple<Int, Int, Int> {
        array.forEachIndexed { i, _ ->
            array.forEachIndexed { j, _ ->
                array.forEachIndexed { k, _ ->
                    try {
                        if (array[i] + array[j] + array[k] == target) {
                            return Triple(array[i], array[j], array[k])
                        }
                    } catch (ex: Exception) {

                    }
                }
            }
        }

        throw Exception("Unable to find entries that sum up to target")
    }

}