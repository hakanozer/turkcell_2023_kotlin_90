package com.works.odev

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.works.odev.Adapter.MyAdapter
import com.works.odev.config.ApiClient
import com.works.odev.databinding.ActivityProductListBinding
import com.works.odev.model.Product
import com.works.odev.model.Products
import com.works.odev.services.DummyService
import com.works.odev.utils.Util
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductList : AppCompatActivity() {

    lateinit var dummyService: DummyService
    lateinit var binding: ActivityProductListBinding
    lateinit var adapter: MyAdapter
    lateinit var list: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dummyService = ApiClient.getClient().create(DummyService::class.java)

         binding.rcycView.setHasFixedSize(true)
         binding.rcycView.layoutManager = GridLayoutManager(this,2)

       val user =  Util().getUser(this)
        user?.let {
            Log.d("token", it.token)
        }

        dummyService.tenProducts().enqueue(object : Callback<Products>{
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                // val status = response.code()
                if (response.isSuccessful){
                    response.body()?.let {
                        Log.d("products", it.products.toString())
                        list = ArrayList(it.products)
                        adapter = MyAdapter(list)
                        binding.rcycView.adapter = adapter
                        adapter.notifyDataSetChanged()
                    }
                }else{
                    Log.e("list", "${response.code()}" )
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("Service Error", t.toString() )
            }
        })
        binding.srchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText.orEmpty().isNotEmpty()){
                    dummyService.filter(newText.orEmpty()).enqueue(object : Callback<Products>{
                        override fun onResponse(
                            call: Call<Products>,
                            response: Response<Products>
                        ) {
                            if (response.isSuccessful){
                                response.body()?.let {
                                    list.clear() // Mevcut listeyi temizle
                                    list.addAll(it.products) // Yeni filtrelenmiş listeyi ekle
                                    adapter.notifyDataSetChanged()
                                }
                            }
                        }

                        override fun onFailure(call: Call<Products>, t: Throwable) {
                            Log.e("Error", t.toString() )
                        }
                    })
                }else {
                    // Eğer boşsa, tüm ürünleri göster
                    adapter.updateList(list)
                    adapter.notifyDataSetChanged()
                }
                return true
            }
        })

    }

}

