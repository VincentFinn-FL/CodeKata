package com.example.javakotlinkata.vendingmachine.vincentfinn

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class VendingMachineTests {
    private val vendingMachine = VendingMachine()

    @BeforeEach
    fun setup() {
        vendingMachine.emptySlot("A1")
        vendingMachine.setSlot("B1", 1, 200)
        vendingMachine.setSlot("B2", 2, 300)
    }

    @Test
    fun `Should display Welcome!!!`() {
        expectThat(vendingMachine.getDisplay()).isEqualTo("Welcome!!!")
    }

    @Test
    fun `Should display sold out when empty slot is selected`() {
        vendingMachine.select("A1")

        expectThat(vendingMachine.getDisplay()).isEqualTo("Sold Out!")
    }

    @Test
    fun `Should display $2 when B1 is selected`() {
        vendingMachine.select("B1")

        expectThat(vendingMachine.getDisplay()).isEqualTo("$2.00")
    }

    @Test
    fun `Should display $3 when B2 is selected`() {
        vendingMachine.select("B2")

        expectThat(vendingMachine.getDisplay()).isEqualTo("$3.00")
    }

    @Test
    fun `Should display invalid slot`() {
        vendingMachine.select("CAT")

        expectThat(vendingMachine.getDisplay()).isEqualTo("Invalid Slot!")
    }

    @Test
    fun `Should display amount of currency inserted`() {
        vendingMachine.insertPennies(1)

        expectThat(vendingMachine.getDisplay()).isEqualTo("$0.01")
    }
}