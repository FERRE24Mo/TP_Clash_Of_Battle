package com.example.tp_clash_of_battle

import android.app.Application

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        AppDatabase.init(this)
    }
}