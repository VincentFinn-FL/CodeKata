package com.example.javakotlinkata.monopoly.tileevents

import com.example.javakotlinkata.monopoly.models.Player

interface TileEvent {
    fun execute(player: Player)
}