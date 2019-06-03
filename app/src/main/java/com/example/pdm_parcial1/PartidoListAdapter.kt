package com.example.pdm_parcial1

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item.view.*
import java.util.*

class PartidoListAdapter(var partidos :List<Partido>): RecyclerView.Adapter<PartidoListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = partidos.size

    fun updateList(newMatches:List<Partido>){
        this.partidos=newMatches
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(partidos[position])
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(partido: Partido) = with(itemView) {


            this.fecha.text = partido.date
            this.equipo1.text = partido.Equipo1
            this.equipo2.text = partido.Equipo2
            this.puntos1.text = partido.Puntos1.toString()
            this.puntos2.text = partido.Puntos2.toString()


            if(partido.Puntos1 > partido.Puntos2)
                this.ganador.text = "Ganador: "+partido.Equipo1
            else if(partido.Puntos1 < partido.Puntos2)
                this.ganador.text = "Ganador: "+partido.Equipo2
            else
                this.ganador.text = "EMPATE"
        }

    }
}