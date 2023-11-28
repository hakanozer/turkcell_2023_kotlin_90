package com.gorkemarslanbogan.ecommer1234.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.gorkemarslanbogan.ecommer1234.R
import com.gorkemarslanbogan.ecommer1234.helper.Utils
import com.gorkemarslanbogan.ecommer1234.model.Product
import com.gorkemarslanbogan.ecommer1234.model.Products
import com.gorkemarslanbogan.ecommer1234.repository.DummyServiceRepository
import com.gorkemarslanbogan.ecommer1234.ui.adapter.ProductAdapter
import com.gorkemarslanbogan.ecommer1234.ui.viewmodel.HomeScreenViewModel
import kotlinx.coroutines.launch

class HomeScreenActivity : AppCompatActivity() {
    private lateinit var searchView : androidx.appcompat.widget.SearchView
    private lateinit var productRecylerView : RecyclerView
    private lateinit var viewModel: HomeScreenViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        searchView = findViewById(R.id.my_search_view)
        productRecylerView = findViewById(R.id.rc_products)

        viewModel = ViewModelProvider(this)[HomeScreenViewModel::class.java]
        viewModel.getProducts()

        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.searchProduct(newText)
                return true
            }
        })

        viewModel.products.observe(this) { it ->
            productRecylerView.adapter = ProductAdapter(it, onClick = { goProductDetails(it) })
        }
    }

    private fun goProductDetails(product: Product){
        val jsonStringProduct = Gson().toJson(product)
        val intent = Intent(applicationContext, ProductDetailsActivity::class.java)
        intent.putExtra(Utils.INTENT_DATA_KEY, jsonStringProduct)
        startActivity(intent)
    }
}