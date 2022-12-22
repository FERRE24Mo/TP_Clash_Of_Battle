package com.example.tp_clash_of_battle.listPlayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp_clash_of_battle.api.PlayerApi
import com.example.tp_clash_of_battle.models.Player
import com.example.tp_clash_of_battle.utils.toListOfPlayers
import kotlinx.coroutines.launch

class ListPlayerViewModel : ViewModel(){

    val api: PlayerApi =PlayerApi.service
    var dao = AppDatabase.INSTANCE!!.playerDao()

    var playerList = listOf<Player>()
    init{
        getPlayers()
    }
    fun getPlayers(){
        viewModelScope.launch {
            playerList = api.getItems().toListOfPlayers()
            dao.replace(playerList)
        }
    }
}