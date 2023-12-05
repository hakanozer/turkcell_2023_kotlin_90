package com.ao.productapp.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ao.productapp.R
import com.ao.productapp.databinding.FragmentProductsBinding
import com.ao.productapp.model.Product
import com.ao.productapp.model.ProductManager
import com.ao.productapp.model.Products
import com.ao.productapp.retrofit.DummyJsonApi
import com.ao.productapp.retrofit.DummyJsonService
import com.ao.productapp.ui.adapter.ProductsAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductsFragment : Fragment() {
    private lateinit var binding: FragmentProductsBinding
    private val productManager = ProductManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsBinding.inflate(layoutInflater, container, false)
        binding.root.hideKeyboard()
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ürün verilerini alırız.
        productManager.getProducts(
            onSuccess = {productList ->
                binding.rvProduct.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                binding.rvProduct.adapter = ProductsAdapter(productList)
            },
            onError = {
                Log.e("Service Error", it.toString() )
            }
        )

        // SearchView ile ürün arama işlemleri
        productManager.setSearchViewListener(
            binding.searchView,
            onSuccess = {productList ->
                binding.rvProduct.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                binding.rvProduct.adapter = ProductsAdapter(productList)
            },
            onError = {
                Log.e("Service Error", it.toString() )
            }
        )
    }


    // Klavyede herhangi bir yere tıklandığında klavyenin kapanması için
    fun View.hideKeyboard() {
        setOnClickListener {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(windowToken, 0)
            clearFocus()
        }
    }


}