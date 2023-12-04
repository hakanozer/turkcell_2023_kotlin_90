package com.ao.nagihanarabaci.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ao.nagihanarabaci.R
import com.ao.nagihanarabaci.databinding.CardFavoriteBinding
import com.ao.nagihanarabaci.models.Product
import com.bumptech.glide.Glide

class FavoriteAdapter(var favoriteList: List<Product>) :
    RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {
    inner class FavoriteViewHolder(var design: CardFavoriteBinding) :
        RecyclerView.ViewHolder(design.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding =
            CardFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return favoriteList.size
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val product = favoriteList[position]
        val design = holder.design
        design.tvProductName.text = product.title
        "${product.price} $ ".also { holder.design.tvProductPrice.text = it }

        "Stok Durumu :${product.stock} ".also { holder.design.tvProductStock.text = it }
        design.tvProductStock.setTextColor(if (product.stock > 50) design.root.context.getColor(R.color.success) else design.root.context.getColor(R.color.error))
        Glide.with(design.productImage.context).load(product.thumbnail)
            .into(design.productImage)

    }

}
