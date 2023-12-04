package com.works.snav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoriteProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_products)




        val recyclerView = findViewById<RecyclerView>(R.id.favoriteRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        fun getFavoriteProductIds(): List<Int> {
            val prefs = getProductPreferences()
            val favoriteIds = mutableListOf<Int>()

            return favoriteIds
        }
    }
}


