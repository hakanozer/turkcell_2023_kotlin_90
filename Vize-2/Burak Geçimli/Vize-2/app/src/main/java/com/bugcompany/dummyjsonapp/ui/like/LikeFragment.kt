package com.bugcompany.dummyjsonapp.ui.like

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bugcompany.dummyjsonapp.databinding.FragmentLike2Binding


class LikeFragment : Fragment() {

    private var _binding: FragmentLike2Binding? = null
    private val binding get() = _binding!!

    private val likedProducts = mutableListOf<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentLike2Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val likedProductsSet = sharedPref.getStringSet("liked_products", mutableSetOf()) ?: mutableSetOf()
        likedProducts.addAll(likedProductsSet)

        val likedProductsAdapter = LikeAdapter(likedProducts)
        binding.rvLikedProducts.layoutManager = LinearLayoutManager(requireContext())
        binding.rvLikedProducts.adapter = likedProductsAdapter
    }
}