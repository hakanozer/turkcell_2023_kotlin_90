package com.bugcompany.dummyjsonapp.ui.like

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bugcompany.dummyjsonapp.databinding.LikedProductBinding

class LikeAdapter(val likedProducts: MutableList<String>) :
    RecyclerView.Adapter<LikeAdapter.LikedProductHolder>() {

    class LikedProductHolder(val binding: LikedProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikedProductHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = LikedProductBinding.inflate(layoutInflater)
        return LikedProductHolder(binding)
    }

    override fun getItemCount(): Int {
        return likedProducts.size
    }

    override fun onBindViewHolder(holder: LikedProductHolder, position: Int) {
        val productId = likedProducts[position]
        holder.binding.id.text = "Product ID: $productId"
    }

}
