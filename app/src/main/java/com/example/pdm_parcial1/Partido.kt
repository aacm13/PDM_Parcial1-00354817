package com.example.pdm_parcial1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "partido_table")
data class Partido (
    @ColumnInfo(name = "Equipo1") val Equipo1:String,
    @ColumnInfo(name = "Equipo2") val Equipo2:String,
    @ColumnInfo(name = "Puntos1") val Puntos1:Int,
    @ColumnInfo(name = "Puntos2") val Puntos2:Int,
    //@ColumnInfo(name = "fecha") val date: Calendar = Calendar.getInstance(),
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
)