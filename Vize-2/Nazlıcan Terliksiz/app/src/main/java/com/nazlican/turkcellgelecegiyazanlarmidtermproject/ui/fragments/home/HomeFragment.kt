package com.nazlican.turkcellgelecegiyazanlarmidtermproject.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.findNavController
import com.nazlican.turkcellgelecegiyazanlarmidtermproject.R
import com.nazlican.turkcellgelecegiyazanlarmidtermproject.common.RetrofitClient
import com.nazlican.turkcellgelecegiyazanlarmidtermproject.common.viewBinding
import com.nazlican.turkcellgelecegiyazanlarmidtermproject.data.model.Product
import com.nazlican.turkcellgelecegiyazanlarmidtermproject.data.model.ProductResponse
import com.nazlican.turkcellgelecegiyazanlarmidtermproject.databinding.FragmentHomeBinding
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
                        Toast.makeText(requireContext(), response.message(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
            }
        })
    }

    private fun homeToDetail(id: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(id)
        findNavController().navigate(action)
    }
}