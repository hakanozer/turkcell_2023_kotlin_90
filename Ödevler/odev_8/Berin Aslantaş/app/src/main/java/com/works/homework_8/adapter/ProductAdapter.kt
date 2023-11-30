package com.works.homework_8.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.works.homework_8.databinding.ListItemProductBinding
import com.works.homework_8.model.Products
import com.works.homework_8.model.Product


class ProductAdapter(private var products: Products, private val onItemClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ListItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.products[position]
        Glide.with(holder.binding.imageView)
            .load(product.image)
            .into(holder.binding.imageView)
        holder.binding.titleTextView.text = product.title
        holder.binding.descriptionTextView.text = product.price.toString()

        holder.binding.root.setOnClickListener {
            onItemClick.invoke(position)
        }
    }

    override fun getItemCount(): Int {
        return products.products.size
    }

    fun setData(newProducts: Products) {
        products = newProducts
        notifyDataSetChanged()
    }

    fun getItemAtPosition(position: Int): Product {
        return products.products[position]
    }
}
