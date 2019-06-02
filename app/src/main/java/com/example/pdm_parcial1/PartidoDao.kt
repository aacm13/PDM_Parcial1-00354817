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

    @Query("delete from partido_table")
    fun deleteAll()
}