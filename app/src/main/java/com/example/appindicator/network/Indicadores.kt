package com.example.appindicator.network
import com.example.appindicator.pojos.*
import com.google.gson.annotations.SerializedName

data class Indicadores(
    @SerializedName("autor")
    val autor: String,
    @SerializedName("bitcoin")
    val bitcoin: Bitcoin,
    @SerializedName("dolar")
    val dolar: Dolar,
    @SerializedName("dolar_intercambio")
    val dolarIntercambio: DolarIntercambio,
    @SerializedName("euro")
    val euro: Euro,
    @SerializedName("fecha")
    val fecha: String,
    @SerializedName("imacec")
    val imacec: Imacec,
    @SerializedName("ipc")
    val ipc: Ipc,
    @SerializedName("ivp")
    val ivp: Ivp,
    @SerializedName("libra_cobre")
    val libraCobre: LibraCobre,
    @SerializedName("tasa_desempleo")
    val tasaDesempleo: TasaDesempleo,
    @SerializedName("tpm")
    val tpm: Tpm,
    @SerializedName("uf")
    val uf: Uf,
    @SerializedName("utm")
    val utm: Utm,
    @SerializedName("version")
    val version: String
)