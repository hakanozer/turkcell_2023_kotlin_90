package com.example.muhammed_zeyd_satilmis_odev8.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.muhammed_zeyd_satilmis_odev8.adapters.RecyclerProductAdapter
import com.example.muhammed_zeyd_satilmis_odev8.configs.ApiClient
import com.example.muhammed_zeyd_satilmis_odev8.databinding.FragmentProductBinding
import com.example.muhammed_zeyd_satilmis_odev8.models.Product
import com.example.muhammed_zeyd_satilmis_odev8.models.Products
import com.example.muhammed_zeyd_satilmis_odev8.services.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductFragment : Fragment() {
    private lateinit var binding: FragmentProductBinding
    private lateinit var dummyService: IDummyService
    private lateinit var recyclerView: RecyclerView
    private lateinit var recAdapter: RecyclerProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductBinding.inflate(layoutInflater, container, false)

        dummyService = ApiClient.getClient().create(IDummyService::class.java)

        getProduct()
        searchProduct()

        return binding.root
    }

    private fun setupRecyclerView(productList: List<Product>) {
        recAdapter = RecyclerProductAdapter(productList)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = recAdapter
    }


    private fun getProduct() {
        dummyService.getProducts().enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        setupRecyclerView(it.products)
                    }
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("API Failure:", "$t")
            }
        })
    }

    private fun searchProduct() {
        binding.searchView.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    dummyService.searchProducts(newText).enqueue(object : Callback<Products> {
                        override fun onResponse(
                            call: Call<Products>,
                            response: Response<Products>
                        ) {
                            if (response.isSuccessful) {
                                response.body()?.let {
                                    val filteredList = ArrayList<Product>(it.products)
                                    recAdapter.setFilteredList(filteredList)

                                }
                            }
                        }

                        override fun onFailure(call: Call<Products>, t: Throwable) {
                            Log.e("API Failure:", "$t")
                        }
                    })
                }
                return true

            }
        })
    }
}
