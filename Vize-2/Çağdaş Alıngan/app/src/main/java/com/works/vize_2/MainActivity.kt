package com.works.vize_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.works.vize_2.Adapter.MyAdapter
import com.works.vize_2.configs.ApiClient
import com.works.vize_2.databinding.ActivityMainBinding
import com.works.vize_2.models.Product
import com.works.vize_2.models.Products
import com.works.vize_2.services.DummyService
import com.works.vize_2.utils.Util
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var dummyService : DummyService
    lateinit var binding : ActivityMainBinding
    lateinit var adapter : MyAdapter
    lateinit var list : ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dummyService = ApiClient.getClient().create(DummyService::class.java)

        binding.rcyclrView.setHasFixedSize(true)
        binding.rcyclrView.layoutManager = GridLayoutManager(this,2)

        dummyService.allProducts().enqueue(object : Callback<Products>{
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        Log.d("products", it.toString())
                        list= ArrayList(it.products)
                        adapter = MyAdapter(list)
                        binding.rcyclrView.adapter = adapter
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

    }
}