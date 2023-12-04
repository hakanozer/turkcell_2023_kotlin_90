package com.works.snav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.works.snav.Product
import com.works.snav.RetrofitClient
import android.content.SharedPreferences
import android.content.Context


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.works.snav.ProductAdapter



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productId = 1 // Örnek ürün ID'si
        val prefs = getProductPreferences()
        val isFavorite = prefs.isProductFavorite(productId)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val productList = listOf(
            Product(1, "Ürün 1", "Uçlu kalem", 9.99, 4.5,"https://cdn.akakce.com/x/faber-castell/faber-castell-grip-1347-0-7-mm-versatil-kalem.jpg"),
            Product(2, "Ürün 2", "Normal Kalem", 19.99, 4.8,"https://ideacdn.net/idea/al/14/myassets/products/356/naturenotesdogalkursunkalem.jpg?revision=1697143329"),

        )


        val adapter = ProductAdapter(productList)
        recyclerView.adapter = adapter




    }
    }


fun SharedPreferences.Editor.putProduct(productId: Int, isFavorite: Boolean): SharedPreferences.Editor {
    if (isFavorite) {
        this.putInt("FAVORITE_PRODUCT_$productId", productId)
    } else {
        this.remove("FAVORITE_PRODUCT_$productId")
    }
    return this
}

fun SharedPreferences.isProductFavorite(productId: Int): Boolean {
    return this.contains("FAVORITE_PRODUCT_$productId")
}

fun Context.getProductPreferences(): SharedPreferences {
    return this.getSharedPreferences("MY_APP_PREFERENCES", Context.MODE_PRIVATE)
}