package com.example.tp_clash_of_battle

import android.app.Application
import com.example.tp_clash_of_battle.database.AppDatabase

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        AppDatabase.init(this)
    }
}