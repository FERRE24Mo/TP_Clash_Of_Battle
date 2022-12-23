package com.example.tp_final_clashofbattle.engine

interface RandomGenerator {

    fun getD6() : Int

    fun getRiskyD6() : Int

    fun getDoubleD6() : Int

    fun getPreciseD6() : Int

    fun getRandomAction(remainingCapabilitiesCount: Int) : Int
}