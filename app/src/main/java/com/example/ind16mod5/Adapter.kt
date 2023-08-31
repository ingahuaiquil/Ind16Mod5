package com.example.ind16mod5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ind16mod5.databinding.ItemLayoutBinding

class Adapter : RecyclerView.Adapter <Adapter.ViewHolder>() {

    var paises = mutableListOf<Pais>()
    // llamado de datos
    var callback: PaisCallback ?=null

    fun setPaisCallback(c:PaisCallback){
        this.callback = c
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val item=paises[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return paises.size
    }

    fun setData(listaPaises: List<Pais>){
        this.paises=listaPaises.toMutableList()
    }


    // inner anidado
    inner class ViewHolder (val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(pais: Pais) {
            val texto ="Pais: ${pais.nombre} Población: ${pais.poblacion}"
            binding.textView2.text=pais.nombre
            binding.imageView.load(pais.imgUrl)
            binding.CardView.setOnClickListener(View.OnClickListener {
                callback?.showCountry(texto)
            })
        }
    }
}

interface PaisCallback {
    fun  showCountry(s:String)
}