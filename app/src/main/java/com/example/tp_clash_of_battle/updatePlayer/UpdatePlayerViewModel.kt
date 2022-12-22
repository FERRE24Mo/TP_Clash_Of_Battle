package com.example.tp_clash_of_battle.updatePlayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp_clash_of_battle.api.PlayerApi
import com.example.tp_clash_of_battle.models.Player
import kotlinx.coroutines.launch

class UpdatePlayerViewModel: ViewModel() {

    val api: PlayerApi = PlayerApi.service
    var dao = AppDatabase.INSTANCE!!.playerDao()

    fun updatePlayer(player: Player){
        viewModelScope.launch {
        }
    }
}