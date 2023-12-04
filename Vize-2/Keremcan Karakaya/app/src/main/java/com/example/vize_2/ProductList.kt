package com.example.vize_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vize_2.adapters.ProductAdapter
import com.example.vize_2.configs.ApiClient
import com.example.vize_2.models.Product
import com.example.vize_2.models.Products
import com.example.vize_2.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductList : AppCompatActivity() {

    lateinit var dummyService: DummyService
    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var favoritesBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        favoritesBtn = findViewById(R.id.favoritesBtn)
        favoritesBtn.setOnClickListener {
            val intent = Intent(this, ProductFavori::class.java)
            startActivity(intent)
        }
        dummyService = ApiClient.getClient().create(DummyService::class.java)
        recyclerView = findViewById(R.id.recyclerView)
        productAdapter = ProductAdapter()
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = productAdapter

        dummyService.allProducts().enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                //val status = response.code()
                if (response.isSuccessful()) {
                    response.body()?.let {
                        Log.d("products", it.products.toString())
                        productAdapter.submitList(it.products)
                    }
                }
            }
            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("Service Error", t.toString() )
            }
        } )
    }
}