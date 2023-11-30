package com.example.sefasatilogluodev8

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sefasatilogluodev8.models.Product
import com.example.sefasatilogluodev8.models.Products
import com.squareup.picasso.Picasso
import java.io.Serializable
import java.util.Locale

class ProductsAdapter(private val mContext:Context,private var productsListesi:List<Product>):RecyclerView.Adapter<ProductsAdapter.ProductsNesneTutucusu>() {
    private var originalProductsList:List<Product> = productsListesi.toList()
    //RecyclerView icindeki her bir ogenin gorunumunu temsil eder
    inner class ProductsNesneTutucusu(view:View):RecyclerView.ViewHolder(view) {

        var imgProducts:ImageView
        var txtTitle:TextView
        var txtPrice:TextView
        var txtRaiting:TextView

        init {
            imgProducts = view.findViewById(R.id.imgProducts)
            txtTitle = view.findViewById(R.id.txtTitle)
            txtPrice = view.findViewById(R.id.txtPrice)
            txtRaiting = view.findViewById(R.id.txtRaiting)
        }

    }
    //Her bir ogenin gorunumunu olusturur.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsNesneTutucusu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.product__tasarim,parent,false)
        return ProductsNesneTutucusu(tasarim)
    }
    //Gonderilen ogelerin sayisini dondurur.
    override fun getItemCount(): Int {
        return productsListesi.size
    }

    override fun onBindViewHolder(holder: ProductsNesneTutucusu, position: Int) {
        //adaptorde bulunan ogelerin konumunu belirtir.
        val productVerileri = productsListesi[position]
        //Urunun resmini yukler (firstOrNull urunun birden fazla resmi olabileceginden resim listesinin ilk elemanini alir)
        Picasso.get()
            .load(productVerileri.images.firstOrNull())
            .into(holder.imgProducts)
        holder.txtTitle.text = productVerileri.title
        holder.txtPrice.text = "Price: ${productVerileri.price}$"
        holder.txtRaiting.text ="Raiting: ${productVerileri.rating}/5"
        //Urunlere tiklandiginda
        holder.itemView.setOnClickListener {
            val intent = Intent(mContext,ProductsDetails::class.java)
            intent.putExtra("product",productVerileri as Serializable)
            mContext.startActivity(intent)
        }

    }
    fun filterProducts(charString: String) {
        if (charString.isNotEmpty()) {
            val filter = productsListesi.filter {
                it.title.toLowerCase(Locale.ROOT).contains(charString.toLowerCase(Locale.ROOT))
            }
            productsListesi = filter
        }
        else {
            //Eger search bos ise verileri tekrardan goster
            productsListesi = originalProductsList.toList()
        }
        notifyDataSetChanged()
    }
    // Yeni ürün listesini adapter'a set etmek için
    fun updateProductsList(newList: List<Product>) {
        productsListesi = newList
        notifyDataSetChanged()
    }


}