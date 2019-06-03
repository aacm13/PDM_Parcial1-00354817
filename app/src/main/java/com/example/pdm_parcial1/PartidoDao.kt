package com.example.pdm_parcial1

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PartidoDao {
    @Query("select * from partido_table")
    fun getAll(): LiveData<List<Partido>>

    @Insert
    suspend fun insert(word: Partido)

    @Query("update partido_table set equipo1=:puntosEquipo1, equipo2=:puntosEquipo2 where id=:id")
    suspend fun update(puntosEquipo1: Int, puntosEquipo2: Int, id: Int)

    @Query("delete from partido_table")
    fun deleteAll()
}