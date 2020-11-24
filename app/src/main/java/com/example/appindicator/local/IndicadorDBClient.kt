package com.example.appindicator.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [IndicadorEntity::class], version = 1)
@TypeConverters(HeightTypeConverter::class)
abstract class IndicadorDBClient : RoomDatabase() {
    abstract fun indicadorDao(): IndicadorDao

    companion object {
        @Volatile
        private var INSTANCE: IndicadorDBClient? = null
        fun getDatabase(context: Context): IndicadorDBClient {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, IndicadorDBClient::class.java,
                        "superHeroesBd")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}