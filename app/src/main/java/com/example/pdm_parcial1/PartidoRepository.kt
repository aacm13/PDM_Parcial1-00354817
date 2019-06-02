package com.example.pdm_parcial1

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class PartidoRepository(private val PartidoDao: PartidoDao) {

    val allPartidos: LiveData<List<Partido>> = PartidoDao.getAll()

    @WorkerThread
    suspend fun insert(partido: Partido){
        PartidoDao.insert(partido)
    }
}