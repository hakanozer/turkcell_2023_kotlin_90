package com.example.kotlinvize2.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinvize2.R
import com.example.kotlinvize2.databinding.ProductCardsBinding
import com.example.kotlinvize2.helper.Utils
import com.example.kotlinvize2.model.Product

class ProductAdapter(private var productList: List<Product>, private val onClick: (Product) -> Unit) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ProductCardsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val viewHolder = ProductCardsBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        setProductInfoUIComponent(holder, productList[position])
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    @SuppressLint("SetTextI18n")
    private fun setProductInfoUIComponent(holder: ViewHolder, product: Product){
        holder.apply {
            binding.productNameTextview.text = product.title
            binding.productDescTextview.text = product.description
            binding.productPriceTextview.text = "${product.price} ${itemView.context.getString(R.string.str_tl)}"
            if(product.images.isNotEmpty()) {
                Utils.getImageByURL(itemView.context, product.images[0], binding.productImage)
            }
        }
        holder.binding.card.setOnClickListener { onClick(product) }
    }
}