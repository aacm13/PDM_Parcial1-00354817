package com.example.pdm_parcial1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_new_partido.*

class NewPartidoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_partido)

        clickListeners()
    }
    private fun Puntos(puntos1: Int, puntos2: Int){
        edit_score1.text = (edit_score1.text.toString().toInt() + puntos1).toString()
        edit_score2.text = (edit_score2.text.toString().toInt() + puntos2).toString()
    }
    private fun clickListeners(){
        uno.setOnClickListener{
            Puntos(1,0)
        }
        dos.setOnClickListener{
            Puntos(2,0)
        }
        tres.setOnClickListener{
            Puntos(3,0)
        }
        uno2.setOnClickListener{
            Puntos(0,1)
        }
        dos2.setOnClickListener{
            Puntos(0, 2)
        }
        tres2.setOnClickListener{
            Puntos(0, 3)
        }

        button_final.setOnClickListener{
            val viewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)
            val equipo1 = edit_team1.text.toString()
            val equipo2 = edit_team2.text.toString()
            val puntos1 = edit_score1.text.toString().toInt()
            val puntos2 = edit_score2.text.toString().toInt()


            viewModel.insert(Partido(equipo1, equipo2, puntos1, puntos2))
            this.finish()
        }
    }
}
