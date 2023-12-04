package com.nazlican.turkcellgelecegiyazanlarmidtermproject.ui.fragments.favorites

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nazlican.turkcellgelecegiyazanlarmidtermproject.R
import com.nazlican.turkcellgelecegiyazanlarmidtermproject.common.viewBinding
import com.nazlican.turkcellgelecegiyazanlarmidtermproject.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    private val binding by viewBinding(FragmentFavoritesBinding::bind)
    private lateinit var favoriteAdapter: FavoriteAdapter
    private lateinit var sp: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sp = requireContext().getSharedPreferences("favoriteProducts", Context.MODE_PRIVATE)
        val favoriteProductsSet = sp.all.keys
        val favoriteProductsList = mutableListOf<Int>()

        for (productIdString in favoriteProductsSet) {
            val productId = productIdString.toIntOrNull()
            if (productId != null) {
                favoriteProductsList.add(productId)
            }
        }

        favoriteAdapter = FavoriteAdapter(::favoriteToDetail, ::removeFavorite)
        binding.rvFavoriteProducts.adapter = favoriteAdapter
    }

    fun favoriteToDetail(productId: Int) {
        val action = FavoritesFragmentDirections.actionFavoritesFragmentToDetailFragment(productId)
        findNavController().navigate(action)
    }

    private fun removeFavorite(productId: Int) {
        val favoriteProductsSet = sp.getStringSet("favoriteProducts", mutableSetOf()) ?: mutableSetOf()
        favoriteProductsSet.remove(productId.toString())
        sp.edit().putStringSet("favoriteProducts", favoriteProductsSet).apply()
        //favoriteAdapter.updateList(favoriteProductsSet.mapNotNull { it.toIntOrNull() })
    }
}