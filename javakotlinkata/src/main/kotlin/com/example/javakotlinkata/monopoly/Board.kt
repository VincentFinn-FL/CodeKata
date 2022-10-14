package com.example.javakotlinkata.monopoly

import com.example.javakotlinkata.monopoly.models.Player
import com.example.javakotlinkata.monopoly.models.Tile
import com.example.javakotlinkata.monopoly.tileevents.GoEvent
import com.example.javakotlinkata.monopoly.tileevents.GoToJailEvent
import com.example.javakotlinkata.monopoly.tileevents.LuxuryTaxEvent

class Board(private val tileTracker: TileTracker) {
    private val tileMap = listOf(
        Tile("Go", GoEvent()),
        Tile("Luxury Taxes", LuxuryTaxEvent()),
        Tile("Go To Jail", GoToJailEvent(tileTracker)),
    ).associateBy { it.name }

    fun placePlayerOnTile(player: Player, tileName: String) {
        tileTracker.setPlayerLocation(player, tileName)
        tileMap[tileName]?.event?.execute(player)
    }

    fun getPlayerLocation(player: Player): String {
        return tileTracker.getPlayerLocation(player)
    }
}
