package com.ao.nagihanarabaci.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ao.nagihanarabaci.data.ProductsApi
import com.ao.nagihanarabaci.data.ProductsService
import com.ao.nagihanarabaci.databinding.FragmentProductsBinding
import com.ao.nagihanarabaci.models.Product
import com.ao.nagihanarabaci.models.Products
import com.ao.nagihanarabaci.ui.adapter.ProductsAdapter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductsFragment : Fragment() {
    private lateinit var binding: FragmentProductsBinding
    var productList = mutableListOf<Product>()
    var product:Products? = null
    lateinit var productsApi: ProductsApi

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentProductsBinding.inflate(layoutInflater)
        productsApi = ProductsService.api
        getListProducts()
        binding.fbFavorite.setOnClickListener {

            val direction = ProductsFragmentDirections.productToFavorite(product!!)
            Navigation.findNavController(it).navigate(direction)
        }
        return binding.root




    }

    private fun getListProducts() {


        productsApi.getProducts().enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        product = it
                        productList = it.products as MutableList<Product>

                        binding.rvProduct.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                        binding.rvProduct.adapter = ProductsAdapter(productList)
                    }
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("Service Error", t.toString() )
            }

        })
    }


}

