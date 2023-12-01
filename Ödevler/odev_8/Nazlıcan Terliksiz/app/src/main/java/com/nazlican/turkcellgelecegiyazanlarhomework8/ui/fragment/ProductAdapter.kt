package com.nazlican.turkcellgelecegiyazanlarhomework8.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nazlican.turkcellgelecegiyazanlarhomework8.data.model.Product
import com.nazlican.turkcellgelecegiyazanlarhomework8.databinding.ItemViewProductBinding
import com.squareup.picasso.Picasso

class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ItemViewProductBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductAdapter.ProductViewHolder {
       val binding = ItemViewProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ProductAdapter.ProductViewHolder, position: Int) {
        val product = productList[position]

        Picasso.get().load(product.images.get(0)).into(holder.binding.ivProduct)
        holder.binding.tvProductName.text = product.title
    }
}
