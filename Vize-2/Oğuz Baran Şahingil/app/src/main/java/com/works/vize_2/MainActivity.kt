package com.works.vize_2

import android.annotation.SuppressLint
import android.media.tv.AdResponse
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.PixelCopy.Request
import android.widget.ListView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.works.vize_2.confige.ApiClient
import com.works.vize_2.databinding.ActivityDetayListBinding
import com.works.vize_2.databinding.ActivityMainBinding
import com.works.vize_2.models.Contents
import com.works.vize_2.models.Products
import com.works.vize_2.services.DummySService
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {

    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var getProducts: List<Contents>
    private lateinit var products: Products


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        productsAdapter = ProductsAdapter(emptyList())
        recyclerView.adapter = productsAdapter

        val url : RequestQueue = Volley.newRequestQueue(this)
        val urun_listesi = "https://dummyjson.com/products"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET , urun_listesi, null,
            Response.Listener { responsse ->

            }
        )


        }

    private fun parseProducts(json : JSONObject) :  List<Products>{
        val productslist = mutableListOf<Products>()
        val productsArray : JSONArray = json.getJSONArray("products")

        for (i in 0 until productsArray.length()){
            val proObject = productsArray.getJSONObject(i)
            val id = proObject.getLong("id")
            val title = proObject.getString("title")
            val description = proObject.getString("description")
            val price = proObject.getLong("price")
            val rating = proObject.getDouble("rating")
            val brand = proObject.getString("brand")
            val images = mutableListOf<String>()
            val discountPercentage = proObject.getDouble("discountPercentage")

        }

            val product = Contents(id , title, description, description, price, rating, brand, images ,discountPercentage)
            productslist.add(product)
    }

    return productlist



}