package com.example.sefasatilogluodev8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sefasatilogluodev8.configs.ApiClient
import com.example.sefasatilogluodev8.databinding.ActivityProductListBinding
import com.example.sefasatilogluodev8.models.Product
import com.example.sefasatilogluodev8.models.Products
import com.example.sefasatilogluodev8.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import kotlin.math.log

class ProductList : AppCompatActivity() {
    private lateinit var dummyService: DummyService
    private lateinit var binding: ActivityProductListBinding
    private lateinit var adapter: ProductsAdapter
    private lateinit var productsListesi:ArrayList<Product>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dummyService = ApiClient.getClient().create(DummyService::class.java)

        //RecyclerView Görüntülenmesi
        binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = GridLayoutManager(this,2)

        dummyService.allProducts(10).enqueue(object :Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    val status = response.code()
                    if (response.isSuccessful) {
                        response.body()?.let {
                            Log.d("products",it.products.toString())
                            productsListesi = ArrayList(it.products)
                            adapter = ProductsAdapter(this@ProductList,productsListesi)
                            binding.rv.adapter = adapter
                            adapter.notifyDataSetChanged()
                        }
                    }

                }else {
                    Log.e("ProductList", "Failed to retrieve products. Response code: ${response.code()}")
                }
            }
            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("Service Error",t.toString() )
            }
        })
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                // Ara butonuna basıldığında yapılacak işlemler
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                // Arama sorgusu değiştikçe yapılacak işlemler
                if (p0.orEmpty().isNotEmpty()) {
                    //Eger arama sorgusu var tüm ürünleri getir
                    dummyService.filterProducts(p0.orEmpty()).enqueue(object :Callback<Products>{
                        override fun onResponse(call: Call<Products>, response: Response<Products>) {
                            if (response.isSuccessful){
                                response.body()?.let {
                                    productsListesi = ArrayList(it.products)
                                    adapter.updateProductsList(productsListesi)
                                }
                            }else {
                                Log.e("response code", "onResponse: ${response.code()}", )
                            }
                        }

                        override fun onFailure(call: Call<Products>, t: Throwable) {
                            Log.e("Service Error", t.toString() )
                        }
                    })
                }else {
                    //Eger arama sorgusu boş ise ilk 10 ürünü getir
                    dummyService.allProducts(10).enqueue(object : Callback<Products>{
                        override fun onResponse(
                            call: Call<Products>,
                            response: Response<Products>
                        ) {
                            if (response.isSuccessful) {
                                response.body()?.let {
                                    productsListesi = ArrayList(it.products)
                                    adapter.updateProductsList(productsListesi)

                                }
                            }else {
                                Log.e("response code", "onResponse: ${response.code()}", )

                            }
                        }

                        override fun onFailure(call: Call<Products>, t: Throwable) {
                            Log.e("Service Error", t.toString() )
                        }
                    })
                }
                return true
            }
        })
    }
}