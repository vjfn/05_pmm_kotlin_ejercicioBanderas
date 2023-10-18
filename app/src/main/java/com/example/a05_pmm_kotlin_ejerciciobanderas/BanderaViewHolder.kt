package com.example.a05_pmm_kotlin_ejerciciobanderas

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.a05_pmm_kotlin_ejerciciobanderas.databinding.ItemBanderaBinding

class BanderaViewHolder(view: View):ViewHolder(view) {

    val binding = ItemBanderaBinding.bind(view)

    fun render(item: Bandera, onClickListener:(Bandera)->Unit){
        binding.tvBanderaNombre.text = item.nombre
        Glide.with(binding.ivBandera.context).load(item.imagen).fitCenter().into(binding.ivBandera)
        itemView.setOnClickListener{
            onClickListener(item)

        }
    }
}