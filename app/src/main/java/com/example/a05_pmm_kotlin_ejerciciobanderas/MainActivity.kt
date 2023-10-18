package com.example.a05_pmm_kotlin_ejerciciobanderas

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a05_pmm_kotlin_ejerciciobanderas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvBanderas.layoutManager=LinearLayoutManager(this)
        binding.rvBanderas.adapter=BanderaAdapter(BanderaProvider.banderas){ fruta ->
            onItemSelected(fruta)
        }

        binding.rvBanderas.setHasFixedSize(true)

    }
    private fun onItemSelected(bandera: Bandera){
        Toast.makeText(this,"Yo soy de ${bandera.nombre}",Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when {
            item.itemId == R.id.recargar -> recargar()
            item.itemId == R.id.limpiar -> limpiar()
            else -> super.onOptionsItemSelected(item)
        }

        return true
    }


    private fun recargar(){
        BanderaProvider.banderas.addAll(BanderaProvider.banderasCopia)
        binding.rvBanderas.adapter?.notifyDataSetChanged()
    }

    private fun limpiar(){
        BanderaProvider.banderas.removeAll(BanderaProvider.banderas)
        binding.rvBanderas.adapter?.notifyDataSetChanged()
    }
}