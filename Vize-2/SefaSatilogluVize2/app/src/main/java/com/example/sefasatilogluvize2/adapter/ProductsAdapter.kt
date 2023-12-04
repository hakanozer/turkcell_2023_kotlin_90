package com.example.sefasatilogluvize2.adapter

import android.content.Context
import android.content.Intent

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sefasatilogluvize2.ProductsDetails
import com.example.sefasatilogluvize2.databinding.ProductCardTasarimBinding
import com.example.sefasatilogluvize2.models.Product
import com.example.sefasatilogluvize2.models.Products
import com.example.sefasatilogluvize2.services.ProductService
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Response
import java.io.Serializable
import kotlin.math.log


class ProductsAdapter(private val productService: ProductService,private val cContext: Context, private val productsListesi:List<Product>): RecyclerView.Adapter<ProductsAdapter.ProductsHolder>(){



    inner class ProductsHolder(val binding:ProductCardTasarimBinding):RecyclerView.ViewHolder(binding.root) {

        val imgView: ImageView = binding.imgView
        val txtPrice: TextView = binding.txtPrice
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsHolder {
        val bindingItem = ProductCardTasarimBinding.inflate(LayoutInflater.from(cContext),parent,false)
        return ProductsHolder(bindingItem)
    }

    override fun getItemCount(): Int {
        return productsListesi.size
    }

    override fun onBindViewHolder(holder: ProductsHolder, position: Int) {
        val productsAl = productsListesi[position]
        if (!productsAl.images.isNullOrEmpty()) {
            Picasso.get()
                .load(productsAl.images.firstOrNull().toString())
                .into(holder.imgView)
        }else {
            Log.d("Foto Yok", "Hatasi ")
        }
        holder.txtPrice.text = "${productsAl.price.toString()}$"
        holder.itemView.setOnClickListener {
            var productId = productsAl.id
            productService.callDetailsProduct(productId.toInt()).enqueue(object :retrofit2.Callback<Product>{
                override fun onResponse(call: Call<Product>, response: Response<Product>) {
                    if (response.isSuccessful) {
                        val intent = Intent(cContext,ProductsDetails::class.java)
                        intent.putExtra("product",response.body() as Serializable)
                        cContext.startActivity(intent)
                    }else {
                        Log.e("ProductDetails", "Failed" )
                    }
                }

                override fun onFailure(call: Call<Product>, t: Throwable) {
                    Log.e("Service Error", t.toString())
                }
            })


        }
    }

}