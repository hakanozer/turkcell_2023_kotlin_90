package com.works.digivista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.works.digivista.adapter.ProductAdapter
import com.works.digivista.configs.ApiClient
import com.works.digivista.databinding.ActivityProductListBinding
import com.works.digivista.models.Product
import com.works.digivista.models.Products
import com.works.digivista.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductList : AppCompatActivity() {

    private lateinit var dummyService: DummyService
    private lateinit var adapter: ProductAdapter
    private lateinit var binding: ActivityProductListBinding
    private var productList: ArrayList<Product> = ArrayList()
    private var filteredList: ArrayList<Product> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dummyService = ApiClient.getClient().create(DummyService::class.java)
        initRecyclerView()
        fetchProduct()
        setupSearchView()
    }

    private fun initRecyclerView() {
        adapter= ProductAdapter(filteredList)
        //Her satırda 2 öğe göster grid
        binding.recyclerView.layoutManager = GridLayoutManager(this@ProductList, 2)
        binding.recyclerView.adapter = adapter

    }


    private fun fetchProduct() {
        dummyService.allProducts().enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                val status = response.code()
                if (status == 200) {
                    //Servis başarılı ise ürün listesini ve filtre edilmiş listeyi güncelle
                    response.body()?.let {products->
                        productList.addAll(products.products)
                        filteredList.addAll(productList)
                        adapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("Service Error", t.toString() )
            }
        })
    }

    //ürünleri ürün adına göre filreleme
    private fun filterProduct(query: String) {
        filteredList.clear()
        if(query.isEmpty()) {
            filteredList.addAll(productList)
        }else {
            val filterList = query.toLowerCase().trim()
            productList.filterTo(filteredList) {product->
                product.title.toLowerCase().contains(filterList)
            }
        }
        adapter.notifyDataSetChanged()
    }

    //Arama görünümü
    private fun setupSearchView () {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //arama metni değiştiğinde ürün filtrele
                newText?.let { str ->
                    filterProduct(str)
                }
                return true
            }
        })
    }

}