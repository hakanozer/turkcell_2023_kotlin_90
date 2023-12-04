package com.example.kotlinvize2.ui

import MyFavoriListViewModel
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinvize2.R
import com.example.kotlinvize2.databinding.ActivityMyFavoriListBinding
import com.example.kotlinvize2.helper.Utils
import com.example.kotlinvize2.model.Product
import com.example.kotlinvize2.ui.adapter.ProductAdapter
import com.google.gson.Gson

class MyFavoriList : AppCompatActivity() {
    private lateinit var binding: ActivityMyFavoriListBinding
    private lateinit var viewModel: MyFavoriListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyFavoriListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MyFavoriListViewModel::class.java]

        viewModel.products.observe(this) {
            binding.rcProducts.adapter = ProductAdapter(it, onClick = {getProductDetail(it)})
        }

        viewModel.singleProductLiveData.observe(this) { goProductDetails(it) }

        binding.bottomNavigation.menu.findItem(R.id.my_favorite)?.isChecked = true
        binding.bottomNavigation.setOnNavigationItemSelectedListener  { item ->
            when(item.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.my_favorite -> {
                    val intent = Intent(applicationContext, MyFavoriList::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                else -> false
            }

        }
    }

    private fun getProductDetail(product: Product){
        viewModel.getProductById(product.id.toString())
    }

    private fun goProductDetails(product: Product){
        val jsonStringProduct = Gson().toJson(product)
        val intent = Intent(applicationContext, ProductDetailActivity::class.java)
        intent.putExtra(Utils.INTENT_DATA_KEY, jsonStringProduct)
        startActivity(intent)
    }
}