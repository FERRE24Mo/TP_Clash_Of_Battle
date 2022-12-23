package com.example.tp_clash_of_battle.engine

interface RandomGenerator {

    fun getD6() : Int

    fun getRiskyD6() : Int

    fun getDoubleD6() : Int

    fun getPreciseD6() : Int

    fun getRandomAction(remainingCapabilitiesCount: Int) : Int
}