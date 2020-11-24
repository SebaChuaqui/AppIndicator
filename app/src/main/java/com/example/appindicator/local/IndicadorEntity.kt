package com.example.appindicator.local

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "indicador_table")
data class IndicadorEntity(
    @PrimaryKey @NonNull val id: String,
    val codigo: String,
    val fecha: String,
    val nombre: String,
    val unidadMedida: String,
    val valor: String,
    val ivp: String,
    val libraCobre: String,
    val tasaDesempleo: String,
    val tpm: String,
    val uf: String,
    val utm: String
)