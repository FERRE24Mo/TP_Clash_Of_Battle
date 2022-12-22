package com.example.tp_clash_of_battle.utils

import com.example.tp_clash_of_battle.models.Player

fun Map<String, Player>.toListOfPlayers() = entries.map {
    it.value.copy(remoteId = it.key)
}