package com.example.appindicator.Repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.appindicator.local.IndicadorDBClient
import com.example.appindicator.local.IndicadorEntity

class IndicadorViewModel(application: Application): AndroidViewModel(application) {
    private val mRepository: IndicadorRepository
    val liveDataFromLocal : LiveData<List<IndicadorEntity>>

    init {
        val indicadorDao = IndicadorDBClient.getDatabase(application).indicadorDao()
        mRepository = IndicadorRepository(indicadorDao)
        mRepository.getDataFromServerWithOutCoroutines()
        liveDataFromLocal = mRepository.allIndicadorLiveData
    }
    fun getIndicadorByid(id: Int): LiveData<IndicadorEntity> {
        return mRepository.getIndicadorByid(id)
    }
    fun deleteAll(){
        mRepository.deleteAllIndicador()
    }
    fun insertOneIndicador(mIndicadorEntity: IndicadorEntity) {
        mRepository.insertOneIndicador(mIndicadorEntity)
    }
}