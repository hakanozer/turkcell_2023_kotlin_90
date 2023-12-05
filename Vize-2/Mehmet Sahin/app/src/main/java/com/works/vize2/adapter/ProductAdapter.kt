package com.works.vize2.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.works.vize2.ui.ProductDetails
import com.works.vize2.databinding.ProductCardBinding
import com.works.vize2.models.Product
import java.io.Serializable

class ProductAdapter(private var productList: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    //private lateinit var binding: ProductCardBinding
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
        Glide.with(holder.itemView.context)
            .load(productPosition.images.first())
            .into(holder.productCard)
        holder.productPrice.text = "Price: ${productPosition.price}$"
        holder.productName.text = productPosition.title

        holder.itemView.setOnClickListener {holderView ->
            val intent = Intent(holderView.context, ProductDetails::class.java)
            intent.putExtra("whichProduct?", productPosition as Serializable)
            holderView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}