package com.example.vize_2.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vize_2.ProductDetail
import com.example.vize_2.models.Product
import com.example.vize_2.R

class ProductAdapter : ListAdapter<Product, ProductAdapter.ProductViewHolder>(ProductDiffCallback()) {
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.productName)
        val productPrice: TextView = itemView.findViewById(R.id.productPrice)
        val productImage: ImageView = itemView.findViewById(R.id.productImage)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentProduct = getItem(position)
        holder.productName.text = currentProduct.title ?: "Unknown"
        holder.productPrice.text = currentProduct.price.toString()
        val images = currentProduct.images
        if (images.isNotEmpty()) {
            val imageUrl = images[0] // İlk resmi göster
            Glide.with(holder.productImage.context)
                .load(imageUrl)
                .into(holder.productImage)
            holder.productImage.visibility = View.VISIBLE
        } else {
            holder.productImage.visibility = View.GONE
        }
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ProductDetail::class.java)
            intent.putExtra("productId", currentProduct.id)
            context.startActivity(intent)
        }
    }
    private class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }
}