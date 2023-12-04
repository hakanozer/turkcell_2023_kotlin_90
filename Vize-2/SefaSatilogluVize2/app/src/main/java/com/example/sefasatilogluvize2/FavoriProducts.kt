package com.example.sefasatilogluvize2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.sefasatilogluvize2.adapter.ProductsAdapter
import com.example.sefasatilogluvize2.configs.ApiClient
import com.example.sefasatilogluvize2.databinding.ActivityFavoriProductsBinding
import com.example.sefasatilogluvize2.models.Product
import com.example.sefasatilogluvize2.models.Products
import com.example.sefasatilogluvize2.services.ProductService
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoriProducts : AppCompatActivity() {
    private lateinit var productService: ProductService
    private lateinit var favoriProductListesi:List<Product>
    private lateinit var adapter:ProductsAdapter
    private lateinit var binding: ActivityFavoriProductsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productService = ApiClient.getClient().create(ProductService::class.java)

        showFavoriteProducts()


    }
    private fun showFavoriteProducts() {
        val favoriSet = getFavorites()
        val favoriList = favoriSet.map { it.toLong() }.toSet()

        // Favori ürünleri ProductService ile al ve RecyclerView'e bağla
        productService.callProduct().enqueue(object :Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    val productsList = response.body()?.products ?: emptyList()
                    val favoriProducts = productsList.filter { favoriList.contains(it.id) }
                    favoriGoster(favoriProducts)
                } else {
                    Log.e("FavoriProducts", "Failed to get products")
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("Service Error", t.toString())
            }
        })
    }

    private fun getFavoriteProducts(productsList: List<Product>, favoriList: Set<Long>): List<Product> {
        return productsList.filter { favoriList.contains(it.id) }
    }
    private fun favoriGoster(favoriProducts: List<Product>) {

        if (favoriProducts.isNotEmpty()) {
            val firstProduct = favoriProducts.first()
            binding.txtDescriptionFavori.text = favoriProducts.joinToString { it.description }
            binding.txtRaitingFavori.text = favoriProducts.joinToString { it.rating.toString() }
            binding.txtPriceFavori.text = favoriProducts.joinToString { it.price.toString() }
            if (!firstProduct.images.isNullOrEmpty()) {
                Picasso.get().load(favoriProducts.joinToString { it.images.toString() }).into(binding.imgFavori)
                Glide.with(this).load(firstProduct.images).into(binding.imgFavori)
            }
        }
    }
    private fun getFavorites(): Set<String> {
        val sharedPreferences = this.getSharedPreferences("favorites", Context.MODE_PRIVATE)
        return sharedPreferences.getStringSet("favorites", setOf()) ?: setOf()
    }
    }


