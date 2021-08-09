package com.example.ejemplo_1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejemplo_1.databinding.ItemPersonajeBinding
import com.example.ejemplo_1.model.Personaje

class PersonajeAdapter(private var listPersonaje: List<Personaje>) : RecyclerView.Adapter<PersonajeAdapter.ViewHolder>(){

    inner class ViewHolder(val binding: ItemPersonajeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeAdapter.ViewHolder {
        val binding = ItemPersonajeBinding.inflate(LayoutInflater
            .from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonajeAdapter.ViewHolder, position: Int) {
        with(holder){
            with(listPersonaje[position]){
                binding.tvNombre.text = name
                binding.tvGenero.text = gender
                Glide.with(itemView.context).load(image).into(binding.ivPersonaje)
            }

        }
    }

    override fun getItemCount(): Int = listPersonaje.size
}