package com.works.vize_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.works.vize_2.ProductsDetail
import com.works.vize_2.network.services.DummyService
import com.works.vize_2.adapter.CustomAdapter
import com.works.vize_2.databinding.ActivityMainBinding
import com.works.vize_2.models.Product
import com.works.vize_2.models.Products
import com.works.vize_2.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var dummyService: DummyService
    lateinit var urunler10: List<Product>
    private lateinit var adapter: CustomAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dummyService = ApiClient.getClient().create(DummyService::class.java)

        recyclerView = binding.rvProductlist



        dummyService.products().enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        urunler10 = ArrayList(it.products)
                        adapter = CustomAdapter(urunler10, onClick = {DetaySayfasinaGit(it)})
                        recyclerView.adapter = adapter
                    }

                }else{
                    Toast.makeText(applicationContext,"Lütfen internet bağlantınızı kontrol ediniz.",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        binding.btnLikedlist.setOnClickListener {
            val intent = Intent(applicationContext, LikedProducts::class.java)
            startActivity(intent)
        }
    }


    private fun DetaySayfasinaGit(product: Product){
        val intent = Intent(applicationContext, ProductsDetail::class.java)
        val gson = Gson()
        val productString = gson.toJson(product)
        intent.putExtra("product", productString)
        startActivity(intent)
    }


}