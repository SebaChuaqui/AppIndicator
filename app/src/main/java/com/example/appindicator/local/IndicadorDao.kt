package com.example.appindicator.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface IndicadorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOneIndicador(mIndicador: IndicadorEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAllIndicador(mList: List<IndicadorEntity>)

    @Update
    fun updateOneIndicador(mIndicador: IndicadorEntity)

    @Update
    fun updateAllIndicador(mList: List<IndicadorEntity>)

    @Query("SELECT * FROM indicador_table")
    fun showAllIndicador(): LiveData<List<IndicadorEntity>>

    @Query("SELECT * FROM indicador_table WHERE id=:mId" )
    fun showOneIndicadorById(mId: Int): LiveData<IndicadorEntity>

    @Query("SELECT * FROM indicador_table WHERE codigo=:mCodigo" )
    fun showAllIndicadorByCodigo(mCodigo: String): LiveData<List<IndicadorEntity>>

    @Delete
    fun deleteOneIndicador(mIndicador:IndicadorEntity)

    @Query("DELETE  FROM indicador_table")
    fun  deleteAllIndicador()

    @Delete
    fun delleteAllIndicador(mList: List<IndicadorEntity>)
}