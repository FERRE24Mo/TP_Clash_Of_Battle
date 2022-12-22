package com.example.tp_clash_of_battle.listPlayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp_clash_of_battle.api.PlayerApi
import com.example.tp_clash_of_battle.utils.toListOfPlayers
import kotlinx.coroutines.launch

class ListPlayerViewModel : ViewModel(){

    val api:PlayerApi = PlayerApi.service
    var dao = AppDatabase.INSTANCE!!.playerDao()

    var listPlayer = dao.getAll()
    fun getPlayers(){
        viewModelScope.launch {
            val playerList = api.getItems().toListOfPlayers()
            dao.replace(playerList)
        }
    }



}