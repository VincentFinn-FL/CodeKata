package com.example.javakotlinkata.monopoly.tileevents

import com.example.javakotlinkata.monopoly.models.Player

class LuxuryTaxEvent: TileEvent {
    override fun execute(player: Player) {
        player.balance -= 75
    }
}