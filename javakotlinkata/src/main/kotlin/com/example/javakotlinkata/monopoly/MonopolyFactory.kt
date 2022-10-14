package com.example.javakotlinkata.monopoly

object MonopolyFactory {
    fun create(): Monopoly {
        return Monopoly(Board(TileTracker()))
    }
}