package com.works.vize_2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.works.vize_2.models.Contents
import com.works.vize_2.services.DummySService
import com.squareup.picasso.Picasso
import com.works.vize_2.models.Products
import java.io.Serializable
import java.text.FieldPosition

class ProductsAdapter (private var productsList : List<Contents>) :
        RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>(){


            class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
                val img : ImageView = itemView.findViewById(R.id.img)
                val txt_id : TextView = itemView.findViewById(R.id.txt_id)
                val txt_title : TextView = itemView.findViewById(R.id.txt_title)
                val txt_description : TextView = itemView.findViewById(R.id.txt_description)
                val txt_price : TextView = itemView.findViewById(R.id.txt_price)
                val txt_rating : TextView = itemView.findViewById(R.id.txt_rating)
                val txt_brand : TextView = itemView.findViewById(R.id.txt_brand)
                val txt_discountPercentage: TextView = itemView.findViewById(R.id.txt_discountPercentage)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tasarim , parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder : ProductViewHolder,position: Int){
        val product = productsList[position]

        Picasso.get()
            .load(product.images.firstOrNull())
            .into(holder.img)

        holder.txt_id.text = product.id.toString()
        holder.txt_title.text = product.title.toString()
        holder.txt_description.text = product.description.toString()
        holder.txt_price.text = product.price.toString()
        holder.txt_rating.text = product.rating.toString()
        holder.txt_brand.text = product.brand.toString()
        holder.txt_discountPercentage.text = product.discountPercentage.toString()

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context , detay_list::class.java)

            intent.putExtra("product",product as Serializable)
            holder.itemView.context.startActivity(intent)
        }

    }






}




