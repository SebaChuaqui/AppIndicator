package com.example.appindicator.network

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface IndicadorApi {

    //vieja confiable
    @GET("api/")
    fun fetchAllIndicadores(): Call<Indicadores>


    //Corroutines
    @GET("api/")
    suspend fun ferchAllIndicadorWithCorroutines(): Response<Indicadores>
}