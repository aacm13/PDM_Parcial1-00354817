package com.example.pdm_parcial1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PartidoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PartidoRepository
    val allPartidos: LiveData<List<Partido>>

    init{
        val partidosDao = PartidoRoomDatabase.getDatabase(application, viewModelScope).partidoDao()
        repository = PartidoRepository(partidosDao)
        allPartidos = repository.allPartidos
    }

    fun insert(partido: Partido) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(partido)
    }
}