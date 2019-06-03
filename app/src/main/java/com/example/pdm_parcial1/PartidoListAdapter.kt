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
        val partidoItemView: TextView = itemView.findViewById(R.id.team1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartidoViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return PartidoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PartidoViewHolder, position: Int) {
        val current = partidos[position]
        holder.partidoItemView.text = current.Equipo1
    }

    internal fun setPartidos(partidos: List<Partido>){
        this.partidos = partidos
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int= partidos.size

}