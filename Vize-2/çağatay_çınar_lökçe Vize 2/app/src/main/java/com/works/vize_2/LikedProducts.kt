package com.works.vize_2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.works.vize_2.adapter.LikedProductsAdapter
import com.works.vize_2.databinding.ActivityLikedProductsBinding
import com.works.vize_2.models.Product
import com.works.vize_2.models.Products
import com.works.vize_2.ProductsDetail
import com.works.vize_2.MainActivity
import com.works.vize_2.adapter.CustomAdapter
import com.works.vize_2.databinding.ActivityMainBinding
import com.works.vize_2.network.ApiClient
import com.works.vize_2.network.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LikedProducts : AppCompatActivity() {
    private lateinit var binding : ActivityLikedProductsBinding
    private lateinit var dummyService: DummyService
    lateinit var urunler10: List<Product>
    private lateinit var adapter: CustomAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLikedProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dummyService = ApiClient.getClient().create(DummyService::class.java)

        recyclerView = binding.rvProductlist

        var ids =  getSharedPreferences("likedProd", Context.MODE_PRIVATE)
        val idssplitted = ids.getString("likedProd", "0")



        dummyService.products().enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        urunler10 = it.products.toMutableList()




                    }
                    val furunler = urunler10.filter {idssplitted!!.contains(it.id.toString())}
                    adapter = CustomAdapter(furunler, onClick = {DetaySayfasinaGit(it)})
                    recyclerView.adapter = adapter

                }else{
                    Toast.makeText(applicationContext,"Lütfen internet bağlantınızı kontrol ediniz.",
                        Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }


    private fun DetaySayfasinaGit(product: Product){
        val intent = Intent(applicationContext, ProductsDetail::class.java)
        val gson = Gson()
        val productString = gson.toJson(product)
        intent.putExtra("product", productString)
        startActivity(intent)
    }


}