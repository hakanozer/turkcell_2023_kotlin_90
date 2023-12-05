package com.ao.productapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ao.productapp.databinding.CardProductBinding
import com.ao.productapp.model.Product
import com.ao.productapp.ui.fragment.ProductsFragment
import com.ao.productapp.ui.fragment.ProductsFragmentDirections
import com.bumptech.glide.Glide

class ProductsAdapter(var productList:List<Product>):RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(var design: CardProductBinding): RecyclerView.ViewHolder(design.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = CardProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.design.productName.text = product.title
        holder.design.productPrice.text = product.price.toString()
        holder.design.productBrandName.text = product.brand

        Glide.with(holder.design.productImageSingleProduct.context).load(product.thumbnail).into(holder.design.productImageSingleProduct)
        holder.design.productImageSingleProduct.setOnClickListener {
            val direction = ProductsFragmentDirections.productDetailTrans(product)
            Navigation.findNavController(it).navigate(direction)

        }

    }
}