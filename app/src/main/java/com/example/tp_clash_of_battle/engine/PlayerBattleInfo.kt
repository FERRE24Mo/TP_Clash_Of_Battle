package com.example.tp_clash_of_battle.engine

import com.example.tp_clash_of_battle.models.Capability


data class PlayerBattleInfo(
    val remainingCapabilities: List<Capability>,
    val pv: Int = 50
)