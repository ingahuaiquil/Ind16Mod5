package com.example.ind16mod5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ind16mod5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PaisCallback {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
    }

    private fun initAdapter() {
        val adapter=Adapter()
        adapter.setData(PaisesLatam.paises)
        //Callback
        adapter.setPaisCallback(this)
        binding.RecyclerView.adapter = adapter
    }

    //Callback
    override fun showCountry(s: String) {
        binding.txtPoblacion.text=s
    }
}