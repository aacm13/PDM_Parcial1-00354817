package com.example.pdm_parcial1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Partido::class], version = 1, exportSchema = false)
public abstract class PartidoRoomDatabase : RoomDatabase() {
    abstract fun partidoDao(): PartidoDao

    companion object{
        @Volatile
        private var INSTANCE: PartidoRoomDatabase? = null

        fun getInstance(context: Context): PartidoRoomDatabase{
            val temp = INSTANCE
            if (temp != null){
                return temp
            }
            synchronized(this){
                val instance = Room
                    .databaseBuilder(context, PartidoRoomDatabase::class.java, "Partido_Database")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}