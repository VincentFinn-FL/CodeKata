package com.example.javakotlinkata.monopoly.tileevents

import com.example.javakotlinkata.monopoly.TileTracker
import com.example.javakotlinkata.monopoly.models.Player

class GoToJailEvent(private val tileTracker: TileTracker) : TileEvent {
    override fun execute(player: Player) {
        tileTracker.setPlayerLocation(player, "Jail")
    }

}
