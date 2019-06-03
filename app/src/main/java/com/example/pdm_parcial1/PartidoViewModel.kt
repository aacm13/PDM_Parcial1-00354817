package com.example.pdm_parcial1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PartidoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PartidoRepository

    init{
        val partidoDao = PartidoRoomDatabase.getInstance(application).partidoDao()
        repository=PartidoRepository(partidoDao)
    }

    fun insert(partido: Partido) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(partido)
    }

    fun getAll(): LiveData<List<Partido>>{
        return repository.getAll()
    }
    fun delete() = viewModelScope.launch(Dispatchers.IO) {
        repository.delete()
    }

    fun update(puntos1: Int, puntos2: Int, id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(puntos1, puntos2, id)
    }
}