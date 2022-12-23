package com.example.tp_clash_of_battle.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tp_clash_of_battle.models.Player

@Database(entities = arrayOf(Player::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun playerDao(): PlayerDAO
    companion object {
        var INSTANCE: AppDatabase? = null
        fun init(context: Context){
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "BDD"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}