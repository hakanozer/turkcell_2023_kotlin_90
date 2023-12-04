package com.ao.nagihanarabaci.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.ao.nagihanarabaci.data.SharedPreferencesHelper
import com.ao.nagihanarabaci.databinding.FragmentFavoriteProductsBinding
import com.ao.nagihanarabaci.models.Product
import com.ao.nagihanarabaci.ui.adapter.FavoriteAdapter

class FavoriteProductsFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteProductsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteProductsBinding.inflate(layoutInflater)

        binding.toolbarFavorite.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        val bundle: FavoriteProductsFragmentArgs by navArgs()
        val productList = bundle.products


        val sharedPref = SharedPreferencesHelper()
        val sharedPreferences =
            sharedPref.getSharedPreferences(binding.root.context, "my_preferences")
        val getIds = sharedPref.getString(sharedPreferences, "ids", "")

        if (getIds != null && getIds.trim().isNotEmpty()) {
            val ids = getIds.split(",")
            val favoriteList = mutableListOf<Product>()
            for (id in ids) {
                for (product in productList.products) {
                    if (product.id.toString() == id) {
                        favoriteList.add(product)
                    }
                }
            }
            binding.rvFavorite.layoutManager = LinearLayoutManager(binding.root.context)
            binding.rvFavorite.adapter = FavoriteAdapter(favoriteList)
        }

        return binding.root
    }


}