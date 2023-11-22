package com.ao.nagihanarabaci

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ao.nagihanarabaci.databinding.CitiesCardBinding

class CitiesCardAdapter(var context:Context, var citiesList:List<CitiesModel>) : RecyclerView.Adapter<CitiesCardAdapter.CitiesCardViewHolder>() {

    inner class CitiesCardViewHolder(var design: CitiesCardBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesCardViewHolder {
        val design = CitiesCardBinding.inflate(LayoutInflater.from(context), parent, false)
        return CitiesCardViewHolder(design)
    }

    override fun getItemCount(): Int {
        return citiesList.size
    }

    override fun onBindViewHolder(holder: CitiesCardViewHolder, position: Int) {
        val item = citiesList[position]
        val design = holder.design
        design.bolgeTextView.text = item.bolge
        design.durumTextView.text = item.durum
        design.sehirTextView.text = item.il
        "${item.min}°C / ${item.max}°C".also { design.dereceTextView.text = it }
    }
}