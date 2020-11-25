package com.example.appindicator.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.appindicator.local.IndicadorDao
import com.example.appindicator.local.IndicadorEntity
import com.example.appindicator.network.Indicadores
import com.example.appindicator.network.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IndicadorRepository(private val indicadorDao: IndicadorDao) {

    private val retroService = RetrofitClient.getRetrofitClient()

    // Este muestra toda la tabla de super heroes entity
    val allIndicadorLiveData = indicadorDao.showAllIndicador()

    fun getIndicadorByid(id: Int): LiveData<IndicadorEntity> {
        return indicadorDao.showOneIndicadorById(id)
    }

    fun deleteAllIndicador() {
        indicadorDao.deleteAllIndicador()
    }

    fun insertOneIndicador(mIndicador: IndicadorEntity) {
        indicadorDao.insertOneIndicador(mIndicador)
    }

    fun getDataFromServerWithOutCoroutines() {
        val call = retroService.fetchAllIndicadores()
        call.enqueue(object : Callback<Indicadores> {
            override fun onResponse(
                call: Call<Indicadores>,
                response: Response<Indicadores>
            ) {
                when (response.code()) {
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {
                            indicadorDao.insertAllIndicador(converters(listOf(it)))
                        }
                    }
                    in 300..399 -> Log.d("acierto", response.body().toString())
                    in 400..499 -> Log.d("acierto", response.body().toString())
                    in 500..599 -> Log.d("acierto", response.body().toString())
                    else -> Log.d("acierto", response.body().toString())
                }
            }

            override fun onFailure(call: Call<Indicadores>, t: Throwable) {
                Log.e("error", t.message.toString())
            }
        })
    }

    fun converters(listFromNetwork: List<Indicadores>): List<IndicadorEntity> {
        val listMutable = mutableListOf<IndicadorEntity>()

        listFromNetwork.map {
            listMutable.add(
                IndicadorEntity(
                        id = 0,
                    it.bitcoin.nombre,
                    it.dolar.nombre,
                    it.dolarIntercambio.nombre,
                    it.euro.nombre,
                    it.imacec.nombre,
                    it.ipc.nombre,
                    it.ivp.nombre,
                    it.libraCobre.nombre,
                    it.tasaDesempleo.nombre,
                    it.tpm.nombre,
                    it.uf.nombre,
                    it.utm.nombre

                    )
            )
        }
        return listMutable
    }
}

