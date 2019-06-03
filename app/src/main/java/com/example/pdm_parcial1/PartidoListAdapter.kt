package com.example.pdm_parcial1

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PartidoListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<PartidoListAdapter.PartidoViewHolder>(){
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var partidos = emptyList<Partido>()

    inner class PartidoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var E1: TextView? = null
        var E2: TextView? = null
        var S1: TextView? = null
        var S2: TextView? = null
        init{
            E1 = itemView.findViewById(R.id.team1)
            E2 = itemView.findViewById(R.id.team2)
            S1 = itemView.findViewById(R.id.score1)
            S2 = itemView.findViewById(R.id.score2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartidoViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return PartidoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PartidoViewHolder, position: Int) {
        val current = partidos[position]
        holder!!.E1!!.text = current.Equipo1
        holder.E2!!.text = current.Equipo2
        holder.S1!!.text = current.Puntos1.toString()
        holder.S2!!.text = current.Puntos2.toString()
    }

    internal fun setPartidos(partidos: List<Partido>){
        this.partidos = partidos
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int= partidos.size

}