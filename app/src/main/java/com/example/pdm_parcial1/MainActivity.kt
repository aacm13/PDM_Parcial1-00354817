package com.example.pdm_parcial1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), LifecycleOwner {

    lateinit var adapter: PartidoListAdapter
    lateinit var viewModel: PartidoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            val intent = Intent(this, NewPartidoActivity::class.java)
            startActivity(intent)
        }

        bind()
    }

    fun bind(){
        adapter = PartidoListAdapter(ArrayList())
        viewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)

        recyclerview.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        viewModel.getAll().observe(this, Observer {
            adapter.updateList(it)
        })
    }
}
