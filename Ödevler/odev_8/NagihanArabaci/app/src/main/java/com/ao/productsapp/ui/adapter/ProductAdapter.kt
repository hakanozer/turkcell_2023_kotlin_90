package com.ao.productsapp.ui.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.ao.productsapp.databinding.CardProductBinding
import com.ao.productsapp.model.Product
import com.ao.productsapp.model.Products
import com.ao.productsapp.ui.activity.ProductDetailActivity
import com.bumptech.glide.Glide

class ProductAdapter(var context:Context, var products: MutableList<Product>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(var design:CardProductBinding): RecyclerView.ViewHolder(design.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = CardProductBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        Log.d("1", product.title.toString())
        holder.design.textViewProductName.text = product.title
        Log.d("productprice", product.title.toString())
        Glide.with(holder.design.imageViewProduct.context).load(product.thumbnail).into(holder.design.imageViewProduct)
        holder.design.imageViewProduct.setOnClickListener {
            val intent = Intent(holder.design.imageViewProduct.context, ProductDetailActivity::class.java)
            startActivity(holder.design.imageViewProduct.context, intent, null)

        }

    }
}