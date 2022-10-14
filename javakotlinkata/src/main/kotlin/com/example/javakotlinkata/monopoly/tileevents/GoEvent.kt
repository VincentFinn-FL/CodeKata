package com.example.javakotlinkata.monopoly.tileevents

import com.example.javakotlinkata.monopoly.models.Player

class GoEvent: TileEvent {
    override fun execute(player: Player) {
        player.balance += 200
    }
}