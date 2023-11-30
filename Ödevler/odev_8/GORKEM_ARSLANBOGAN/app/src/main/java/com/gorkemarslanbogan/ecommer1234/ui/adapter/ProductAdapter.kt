package com.gorkemarslanbogan.ecommer1234.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.gorkemarslanbogan.ecommer1234.R
import com.gorkemarslanbogan.ecommer1234.helper.Utils
import com.gorkemarslanbogan.ecommer1234.model.Product

class ProductAdapter(private var productList: List<Product>, private val onClick: (Product) -> Unit) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val card: CardView = view.findViewById(R.id.card)
        val productImage: ImageView = view.findViewById(R.id.productImage)
        val productName: TextView = view.findViewById(R.id.productNameTextview)
        val productDesc: TextView = view.findViewById(R.id.productDescTextview)
        val productPrice: TextView = view.findViewById(R.id.productPriceTextview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.products_card, parent, false)
        return ViewHolder(view)
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
            productName.text = product.title
            productDesc.text = product.description
            productPrice.text = "${product.price} ${itemView.context.getString(R.string.str_fiyat)}"
            if(product.images.isNotEmpty()) {
                Utils.getImageByURL(itemView.context, product.images[0], productImage)
            }
        }
        holder.card.setOnClickListener { onClick(product) }
    }
}