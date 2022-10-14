package com.example.javakotlinkata.monopoly.models

import com.example.javakotlinkata.monopoly.tileevents.GoEvent
import com.example.javakotlinkata.monopoly.tileevents.TileEvent

data class Tile(val name: String, val event: TileEvent)
