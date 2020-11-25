package com.example.appindicator.local

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appindicator.pojos.DolarIntercambio

@Entity(tableName = "indicador_table")
data class IndicadorEntity(
    @PrimaryKey @NonNull val id: Int,
    val bitcoin: String,
    val dolar: String,
    val dolarIntercambio: String,
    val euro: String,
    val imacec: String,
    val ipc: String,
    val ivp: String,
    val libraCobre: String,
    val tasaDesempleo: String,
    val tpm: String,
    val uf: String,
    val utm: String,

)