package com.example.tp_clash_of_battle.engine

import android.content.Context
import com.example.tp_clash_of_battle.models.Capability
import com.example.tp_clash_of_battle.models.CapabilityType
import com.example.tp_clash_of_battle.models.Player
import com.example.tp_clash_of_battle.utils.getNameId

fun getTextForActionResult(context: Context, player: Player, actionResult: ActionResult) : String {
    val usedCapability = actionResult.usedCapability

    return if(usedCapability != null) {
        val capabilityName = context.getString(usedCapability.getNameId())
        val capabilitySuffix = getCapabilitySuffix(usedCapability, actionResult)

        "${player.name} utilise $capabilityName $capabilitySuffix"

    } else {
        "${player.name} fait une attaque simple et inflige ${actionResult.damage}"
    }
}

fun getCapabilitySuffix(usedCapability: Capability, result: ActionResult) =
    when (usedCapability.type) {
        CapabilityType.ATTACK -> "et inflige ${result.damage} dégâts"
        CapabilityType.DEFENSE -> ", inflige ${result.damage} dégâts et annule ${result.defense} dégâts"
        CapabilityType.HEAL -> "et se soigne de ${result.heal} PV"
    }