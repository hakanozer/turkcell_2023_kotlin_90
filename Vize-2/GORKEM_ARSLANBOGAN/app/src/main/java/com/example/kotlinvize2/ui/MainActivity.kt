package com.example.kotlinvize2.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinvize2.R
import com.example.kotlinvize2.databinding.ActivityMainBinding
import com.example.kotlinvize2.helper.Utils
import com.example.kotlinvize2.helper.shared.SharedManagment
import com.example.kotlinvize2.model.Product
import com.example.kotlinvize2.ui.adapter.ProductAdapter
import com.example.kotlinvize2.viewmodel.MainActivityViewModel
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        SharedManagment.getSharedInstance(applicationContext)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        binding.mySearchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.searchProduct(newText)
                return true
            }
        })

        viewModel.products.observe(this) { it ->
            binding.rcProducts.adapter = ProductAdapter(it, onClick = { getProductDetail(it) })
        }

        viewModel.singleProductLiveData.observe(this) { goProductDetails(it) }

        binding.bottomNavigation.selectedItemId = R.id.navigation_home
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