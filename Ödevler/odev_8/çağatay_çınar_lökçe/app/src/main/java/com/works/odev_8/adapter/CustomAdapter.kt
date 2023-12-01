package com.works.odev_8.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.works.odev_8.ProductsDetail
import com.works.odev_8.R
import com.works.odev_8.databinding.RecyclerviewDesignUiBinding
import com.works.odev_8.models.Product

class CustomAdapter(private var products: List<Product>, private val onClick: (Product) -> Unit) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    class ViewHolder(val binding: RecyclerviewDesignUiBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val productViewBinding = RecyclerviewDesignUiBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(productViewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, index: Int) {
        val currentData = products[index]

        holder.binding.tvPrice.text = "${currentData.price}$"
        holder.binding.tvProductTitle.text = currentData.title
        holder.binding.tvDescription.text = currentData.description

        Picasso.get()
            .load(currentData.images[0])
            .centerCrop()
            .resize(128,128)
            .into(holder.binding.productImage)

        holder.binding.cardView.setOnClickListener{
           onClick(currentData)
        }
    }



    override fun getItemCount(): Int {
        return products.size
    }

    fun filterProducts(filteredProducts: List<Product>) {

        this.products = filteredProducts
        notifyDataSetChanged()
    }
}


