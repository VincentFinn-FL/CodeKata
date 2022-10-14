package com.example.javakotlinkata.monopoly

import com.example.javakotlinkata.monopoly.models.Player

typealias PlayerName = String
typealias TileName = String

class Monopoly(private val board: Board) {

    fun placePlayerOnTile(player: Player, tileName: String) {
        board.placePlayerOnTile(player, tileName)
    }

    fun getPlayerLocation(player: Player): String {
        return board.getPlayerLocation(player)
    }

}