package com.appsroved.muhammed_zeyd_satilmis_vize2.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appsroved.muhammed_zeyd_satilmis_vize2.R
import com.appsroved.muhammed_zeyd_satilmis_vize2.adapters.CustomRVProductListAdapter
import com.appsroved.muhammed_zeyd_satilmis_vize2.configs.ApiClient
import com.appsroved.muhammed_zeyd_satilmis_vize2.databinding.FragmentFavoritesBinding
import com.appsroved.muhammed_zeyd_satilmis_vize2.models.Product
import com.appsroved.muhammed_zeyd_satilmis_vize2.services.DummyService
import com.appsroved.muhammed_zeyd_satilmis_vize2.utils.Util
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FavoritesFragment : Fragment() {
    lateinit var binding: FragmentFavoritesBinding
    private lateinit var dummyService: DummyService
    private lateinit var recyclerView: RecyclerView
    private lateinit var customRVAdapter: CustomRVProductListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(layoutInflater, container, false)

        dummyService = ApiClient.getClient().create(DummyService::class.java)


        getList()

        return binding.root
    }


    fun getList() {
        // SharedPreferences'ten favori ürün listesini al
        val favStringList = Util().getFavList(requireContext())

        favStringList?.let { favList ->
            // FavStringList'ten Long List oluştur
            val longList: List<Long> = favList.mapNotNull { item ->
                item.toLongOrNull()
            }

            // Her bir favori ürün için işlemleri gerçekleştir
            for (favPro in longList) {
                // Örnek bir işlem
                fetchFavoriteProduct(favPro)
            }
        }
    }

    fun fetchFavoriteProduct(favPro: Long) {
        dummyService.getFavorites(favPro).enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                if (response.isSuccessful) {
                    val product = response.body()
                    if (product != null) {
                        processFavoriteProduct(product)
                    }
                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                Log.e("err", "onFailure: $t")
            }
        })
    }

    fun processFavoriteProduct(product: Product) {

    }


    private fun setupRecyclerView(productList: ArrayList<Product>) {
        customRVAdapter = CustomRVProductListAdapter(productList)
        recyclerView = binding.reclView
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = customRVAdapter
    }
}
