package com.works.odev_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.works.odev_8.adapter.ProductAdapter
import com.works.odev_8.model.Products
import com.works.odev_8.service.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuList : AppCompatActivity() {

    lateinit var dummyService: DummyService
    lateinit var search_view : SearchView
    lateinit var recycler_view : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_list)

        search_view = findViewById(R.id.search_view)
        recycler_view = findViewById(R.id.recycler_view)
        val productAdapter = ProductAdapter()

        dummyService.allProducts().enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        it.products
                        productAdapter.updateData(it.products)
                    }
                }
            }
            override fun onFailure(call: Call<Products>, t: Throwable) {
            }
        })
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            private val handler = Handler()
            private var currentQuery: String? = null

            private val filterRunnable = object : Runnable {
                override fun run() {
                    if (currentQuery != null && currentQuery!!.isNotEmpty()) {
                        DummyService.searchProduct(currentQuery!!).enqueue(object : Callback<Products> {
                            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                                if (response.isSuccessful) {
                                    response.body()?.let {
                                    }
                                }
                            }
                            override fun onFailure(call: Call<Products>, t: Throwable) {
                            }
                        })
                    }
                }
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                currentQuery = newText
                handler.removeCallbacks(filterRunnable)

                if (newText.isNullOrEmpty()) {
                    val unfilteredProducts = null
                    unfilteredProducts?.let { productAdapter.updateData(it) }
                } else {
                    handler.postDelayed(filterRunnable, 300)
                }
                return true
            }
        })
    }
}