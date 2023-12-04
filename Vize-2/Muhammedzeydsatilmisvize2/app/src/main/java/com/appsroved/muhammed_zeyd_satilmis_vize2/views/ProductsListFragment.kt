package com.appsroved.muhammed_zeyd_satilmis_vize2.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appsroved.muhammed_zeyd_satilmis_vize2.adapters.CustomRVProductListAdapter
import com.appsroved.muhammed_zeyd_satilmis_vize2.configs.ApiClient
import com.appsroved.muhammed_zeyd_satilmis_vize2.databinding.FragmentProductsListBinding
import com.appsroved.muhammed_zeyd_satilmis_vize2.models.Product
import com.appsroved.muhammed_zeyd_satilmis_vize2.models.ProductsModel
import com.appsroved.muhammed_zeyd_satilmis_vize2.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductsListFragment : Fragment() {
    private lateinit var binding: FragmentProductsListBinding
    private lateinit var dummyService: DummyService
    private lateinit var recyclerView: RecyclerView
    private lateinit var customRVAdapter: CustomRVProductListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsListBinding.inflate(layoutInflater, container, false)

        dummyService = ApiClient.getClient().create(DummyService::class.java)

        getProduct()


        return binding.root


    }

    private fun setupRecyclerView(productList: ArrayList<Product>) {
        customRVAdapter = CustomRVProductListAdapter(productList)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = customRVAdapter
    }


    private fun getProduct() {

        dummyService.getProducts().enqueue(object : Callback<ProductsModel> {
            override fun onResponse(call: Call<ProductsModel>, response: Response<ProductsModel>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        setupRecyclerView(it.products as ArrayList<Product>)
                    }
                }
            }

            override fun onFailure(call: Call<ProductsModel>, t: Throwable) {
                Log.e("Api on fail", "$t")
            }
        })
    }

}
