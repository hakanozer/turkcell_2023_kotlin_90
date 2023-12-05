package com.works.vize2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.works.vize2.adapter.ProductAdapter
import com.works.vize2.configs.ApiClient
import com.works.vize2.databinding.ActivityProductListBinding
import com.works.vize2.models.Product
import com.works.vize2.models.Products
import com.works.vize2.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductList : AppCompatActivity() {

    private lateinit var dummyService: DummyService
    private lateinit var adapter: ProductAdapter
    private lateinit var binding: ActivityProductListBinding
    private lateinit var productList: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)




        dummyService = ApiClient.getClient().create(DummyService::class.java)
        //Öğe silindiğinde yenilendiğinde görünüm bozulmasın
        binding.recyclerView.setHasFixedSize(true)
        //Her satırda 2 öğe göster grid
        binding.recyclerView.layoutManager = GridLayoutManager(this@ProductList, 2)


        dummyService.allProducts().enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                val status = response.code()
                if (status == 200) {
                    response.body()?.let {
                        binding.ListLiked.setOnClickListener {
                            startActivity(Intent(applicationContext, ProductLike::class.java))
                        }
                        Log.d("products", it.products.toString())
                        productList = ArrayList(it.products)
                        adapter= ProductAdapter(productList)
                        binding.recyclerView.adapter = adapter
                        adapter.notifyDataSetChanged()

                    }
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("Service Error", t.toString() )
            }
        } )




    }
}