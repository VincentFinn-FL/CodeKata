package com.example.javakotlinkata.monopoly

import com.example.javakotlinkata.monopoly.models.Player
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MonopolyTest {
    //xshould set player location when landing on a named tile
    //xshould add 200 to balance when player lands on Go
    //xshould subtract 75 to balance when player lands on luxury taxes
    //xshould set player location to jail when landing on Go to jail
    //-should subtract 10% of balance when landing on income tax when balance is under 2000
    //-should never pay more than 200 of income tax
    //-should reward 1 dollar for every letter in your name when land on Gift of name
    //-should pay 10 for every utility the player owns when landing on Utility Tax
    //-should pay rent on unimproved properties (example driven)

    val monopoly = MonopolyFactory.create()
    val alice = Player("Alice", 1000)

    @Test
    fun `should set player location when landing on tile`() {
        monopoly.placePlayerOnTile(alice, "Free Parking")

        assertThat(monopoly.getPlayerLocation(alice)).isEqualTo("Free Parking")
    }

    @Test
    fun `should add 200 to player balance when player lands on Go`() {
        monopoly.placePlayerOnTile(alice, "Go")

        assertThat(alice.balance).isEqualTo(1200)
    }

    @Test
    fun `should subtract 75 from player balance when player lands on Luxury Taxes`() {
        monopoly.placePlayerOnTile(alice, "Luxury Taxes")

        assertThat(alice.balance).isEqualTo(925)
    }

    @Test
    fun `should set player location to Jail when the player lands on Go To Jail`() {
        monopoly.placePlayerOnTile(alice, "Go To Jail")

        assertThat(monopoly.getPlayerLocation(alice)).isEqualTo("Jail")
    }
}