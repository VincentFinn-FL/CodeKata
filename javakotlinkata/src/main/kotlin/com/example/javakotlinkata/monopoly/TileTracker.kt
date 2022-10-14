package com.example.javakotlinkata.monopoly

import com.example.javakotlinkata.monopoly.models.Player

class TileTracker {
    private val playerLocationMap = mutableMapOf<PlayerName, TileName>()

    fun getPlayerLocation(player: Player): String {
        return playerLocationMap[player.name]!!
    }

    fun setPlayerLocation(player: Player, tileName: String) {
        playerLocationMap[player.name] = tileName
    }

}