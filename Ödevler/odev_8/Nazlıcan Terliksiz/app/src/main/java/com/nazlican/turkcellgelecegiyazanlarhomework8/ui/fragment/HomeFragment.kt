package com.nazlican.turkcellgelecegiyazanlarhomework8.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.findNavController
import com.nazlican.turkcellgelecegiyazanlarhomework8.R
import com.nazlican.turkcellgelecegiyazanlarhomework8.common.viewBinding
import com.nazlican.turkcellgelecegiyazanlarhomework8.data.model.Product
import com.nazlican.turkcellgelecegiyazanlarhomework8.data.model.ProductResponse
import com.nazlican.turkcellgelecegiyazanlarhomework8.databinding.FragmentHomeBinding
import com.nazlican.turkcellgelecegiyazanlarhomework8.common.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private lateinit var productAdapter: ProductAdapter
    private val productService = RetrofitClient
    private var productList: List<Product> = emptyList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getProduct()

        productAdapter = ProductAdapter(productList, ::homeToDetail)
        binding.rvProducts.adapter = productAdapter
    }

    fun getProduct() {
        productService.service?.getProducts()?.enqueue(object : Callback<ProductResponse> {

            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        productList = response.body()!!.products
                        productAdapter = ProductAdapter(productList, ::homeToDetail)
                        binding.rvProducts.adapter = productAdapter
                    } else {
                        Toast.makeText(requireContext(), response.message(), Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
            }
        })
    }

    fun search() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                search(newText)
                return true
            }
        })
    }
    fun search(query:String) {
        productService.service?.searchProduct(query)?.enqueue(object : Callback<ProductResponse> {

            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        productList = response.body()!!.products
                        productAdapter = ProductAdapter(productList, ::homeToDetail)
                        binding.rvProducts.adapter = productAdapter
                    } else {
                        Toast.makeText(requireContext(), response.message(), Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
            }
        })
    }
    private fun homeToDetail(product: Product,id: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(product,id)
        findNavController().navigate(action)
    }
}