package com.example.vize_2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vize_2.databinding.ProductRecylerRowBinding
import com.example.vize_2.model.ProductDetailInformation

class ProductAdapter :
    ListAdapter<ProductDetailInformation, ProductAdapter.ProductViewHolder>(ProductDiffutil) {

    var onClickListener: (ProductDetailInformation) -> Unit = {}

    inner class ProductViewHolder(private val binding: ProductRecylerRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(productDetailInformation: ProductDetailInformation) {
            Glide.with(binding.imageView).load(productDetailInformation.images?.get(0))
                .into(binding.imageView)
            binding.txtTitle.text = productDetailInformation.title
            binding.linearProduct.setOnClickListener { onClickListener(productDetailInformation) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(
            ProductRecylerRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.bind(getItem(position))
}

object ProductDiffutil : DiffUtil.ItemCallback<ProductDetailInformation>() {
    override fun areItemsTheSame(
        oldItem: ProductDetailInformation,
        newItem: ProductDetailInformation
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: ProductDetailInformation,
        newItem: ProductDetailInformation
    ): Boolean {
        return oldItem == newItem
    }
}