package com.works.vize_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.works.vize_2.network.ApiClient
import com.works.vize_2.network.DummySerrvice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), ProductAdapter.MyClick {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ProductAdapter(emptyList(), this@MainActivity)
        recyclerView.adapter = adapter

        // Retrofit çağrısını yap
        val service = ApiClient.getClient().create(DummySerrvice::class.java)
        val call = service.allProducts()

        call.enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        adapter.setProducts(it.products)
                    }
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("Hata", "onFailure: Veri çekilemedi", t)
            }
        })
    }

    override fun onClick(position: Int) {
        val clickedProduct = adapter.getItemAtPosition(position)

        // Burada tıklanan ürünün detay sayfasına geçiş yapabilirsiniz
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra("product", clickedProduct)
        startActivity(intent)
    }


}
