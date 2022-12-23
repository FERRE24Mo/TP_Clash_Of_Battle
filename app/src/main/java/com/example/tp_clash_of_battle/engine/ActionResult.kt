package com.example.tp_clash_of_battle.engine

import com.example.tp_clash_of_battle.models.Capability


data class ActionResult(
    val damage: Int = 0,
    val defense: Int = 0,
    val heal: Int = 0,
    val usedCapability: Capability? = null,
)