package com.example.pdm_parcial1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.sql.Time

@Entity(tableName = "partido_table")
data class Partido (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int,
    @ColumnInfo(name = "Equipo1") val Equipo1:String,
    @ColumnInfo(name = "Equipo2") val Equipo2:String,
    @ColumnInfo(name = "Puntos1") val Puntos1:Int,
    @ColumnInfo(name = "Puntos2") val Puntos2:Int,
    @ColumnInfo(name = "date") val date: Date,
    @ColumnInfo(name = "time") val time: Time
)