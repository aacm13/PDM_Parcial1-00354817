package com.example.pdm_parcial1

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class PartidoRepository(private val PartidoDao: PartidoDao) {

    @WorkerThread
    suspend fun insert(partido: Partido){
        PartidoDao.insert(partido)
    }

    @WorkerThread
    suspend fun delete(){
        return PartidoDao.deleteAll()
    }

    @WorkerThread
    suspend fun update(puntos1: Int, puntos2: Int, id:Int){
        PartidoDao.update(puntos1, puntos2, id)
    }

    fun getAll():LiveData<List<Partido>>{
        return PartidoDao.getAll()
    }
}