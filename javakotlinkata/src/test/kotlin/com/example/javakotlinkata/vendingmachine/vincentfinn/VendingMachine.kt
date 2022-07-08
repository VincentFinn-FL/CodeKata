package com.example.javakotlinkata.vendingmachine.vincentfinn

class VendingMachine {
    private var displayMessage: String = "Welcome!!!"
    private var slots = mutableMapOf<String, Int>();

    fun select(slotId: String) {
        if (!slots.containsKey(slotId)) {
            displayMessage = "Invalid Slot!"
            return
        }
        val slotPrice = slots[slotId]!!
        if (slotPrice == 0) {
            displayMessage = "Sold Out!"
            return
        }
        displayMessage = getPriceMessage(slotPrice)
    }

    fun getDisplay(): String {
        return displayMessage
    }

    fun setSlot(slotId: String, quantity: Int, priceInPennies: Int) {
        slots[slotId] = priceInPennies
    }

    fun emptySlot(slotId: String) {
        slots[slotId] = 0
    }

    fun insertPennies(pennies: Int) {
        displayMessage = getPriceMessage(pennies)
    }

    private fun getPriceMessage(pennies: Int): String {
        val dollar = pennies / 100
        val cents = pennies % 100
        val centsString = if (cents < 10) "0$cents" else cents
        return "\$$dollar.$centsString"
    }
}
