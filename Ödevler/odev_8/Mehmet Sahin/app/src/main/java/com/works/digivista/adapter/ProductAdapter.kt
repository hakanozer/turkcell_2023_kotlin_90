package com.works.digivista.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.works.digivista.ProductDetails
import com.works.digivista.databinding.ProductCardBinding
import com.works.digivista.models.Product
import java.io.Serializable

class ProductAdapter(private var productList: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    class ProductViewHolder(private val binding: ProductCardBinding): RecyclerView.ViewHolder(binding.root) {
        val productCard: ImageView = binding.imgProductCard
        val productName: TextView = binding.txtProductName
        val productPrice: TextView = binding.txtProductPrice
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val createDesign = ProductCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(createDesign)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val productPosition = productList[position]
        holder.productPrice.text = "Price: ${productPosition.price}$"
        holder.productName.text = productPosition.title
        Glide.with(holder.itemView.context)
            .load(productPosition.images.first())
            .into(holder.productCard)

        holder.itemView.setOnClickListener {holderView ->
            val intent = Intent(holderView.context, ProductDetails::class.java)
            intent.putExtra("ProductDetails", productPosition as Serializable)
            holderView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}


