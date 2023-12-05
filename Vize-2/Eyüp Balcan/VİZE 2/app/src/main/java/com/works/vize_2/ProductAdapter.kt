package com.works.vize_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter(private var productList: List<Product>, val listener: MyClick) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImage: ImageView = view.findViewById(R.id.productImg)
        val productName: TextView = view.findViewById(R.id.textProductName)
        val productPrice: TextView = view.findViewById(R.id.textPrice)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onClick(position)
                }
            }
        }

        fun bindTo(product: Product) {
            productName.text = product.title
            productPrice.text = product.price.toString()

            Glide.with(itemView.context)
                .load(product.images.firstOrNull())
                .into(productImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_desing, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        holder.bindTo(product)
    }

    fun setProducts(products: List<Product>) {
        productList = products
        notifyDataSetChanged()
    }

    fun getItemAtPosition(position: Int): Product {
        return productList[position]
    }


    interface MyClick {
        fun onClick(position: Int)
        
    }
}
