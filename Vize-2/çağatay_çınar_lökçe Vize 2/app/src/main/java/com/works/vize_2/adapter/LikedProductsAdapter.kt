package com.works.vize_2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.works.vize_2.databinding.ActivityLikedProductsBinding
import com.works.vize_2.databinding.DetailDesignUiBinding
import com.works.vize_2.models.Product

class LikedProductsAdapter(private var products:List<Product?>) : RecyclerView.Adapter<LikedProductsAdapter.LikedViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DetailDesignUiBinding.inflate(inflater, parent, false)
        return LikedViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: LikedViewHolder, position: Int) {
        val product = products[position]
        holder.binding.apply {
            tvProductTitle.text = product?.title
            tvDescription.text = product?.description
            tvPrice.text = product?.price.toString()
    }
    }

    inner class LikedViewHolder(val binding: DetailDesignUiBinding) :
        RecyclerView.ViewHolder(binding.root)
}