package com.works.odev_8.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.works.odev_8.ProductDetail
import com.works.odev_8.R
import com.works.odev_8.model.Product
import com.works.odev_8.model.Products

class ProductAdapter : ListAdapter<Products, ProductAdapter.ProductViewHolder>(ProductDiffCallback()) {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val detail_productName: TextView = itemView.findViewById(R.id.detail_ProductName)
        val product_DetailsPrice: TextView = itemView.findViewById(R.id.product_DetailPrice)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentProduct = getItem(position)
        holder.detail_productName.text = currentProduct.title ?: "Unknown"
        holder.product_DetailsPrice.text = currentProduct.products.toString()


        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context,ProductDetail::class.java)
            intent.putExtra("productId", currentProduct.limit)
            context.startActivity(intent)
        }
    }
    private class ProductDiffCallback : DiffUtil.ItemCallback<Products>() {
        override fun areItemsTheSame(oldItem: Products, newItem: Products): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: Products, newItem: Products): Boolean {
            return oldItem == newItem
        }
    }
    fun updateData(newList: List<Product>) {
        submitList(newList)
    }
    fun filterProducts(searchTerm: String) {
        val filteredProducts = currentList.filter { it.title?.contains(searchTerm) == true }
        submitList(filteredProducts)
    }
}


