package com.infy.telstra.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.infy.telstra.model.FactItem

@Database(entities = [FactItem::class], version = 1, exportSchema = false)
abstract class FactDatabase : RoomDatabase() {
    abstract fun factDao(): FactDAO
}

private lateinit var INSTANCE: FactDatabase

fun getDatabase(context: Context): FactDatabase {
    synchronized(FactDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                FactDatabase::class.java,
                "database"
            ).build()
        }
    }
    return INSTANCE
}