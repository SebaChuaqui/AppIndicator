package com.example.appindicator.local

import androidx.room.TypeConverter
import com.google.gson.Gson

class HeightTypeConverter {
    @TypeConverter
    fun fromListToString(list: List<String>) = Gson().toJson(list)

    @TypeConverter
    fun jsonToString(value: String) =
        Gson().fromJson(value,Array<String>::class.java).toList()
}