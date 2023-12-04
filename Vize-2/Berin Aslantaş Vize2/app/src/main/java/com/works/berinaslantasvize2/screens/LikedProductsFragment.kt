package com.works.berinaslantasvize2.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.works.berinaslantasvize2.LikedProductsData
import com.works.berinaslantasvize2.R
import com.works.berinaslantasvize2.adapters.LikedProductAdapter

class LikedProductsFragment : Fragment() {

    private lateinit var listView: ListView
    private lateinit var likedProductsData: LikedProductsData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_liked_products, container, false)
        listView = view.findViewById(R.id.likedProductsListView)
        likedProductsData = LikedProductsData(requireContext())

        val likedProducts = likedProductsData.getLikedProducts()
        val adapter =
            LikedProductAdapter(requireContext(), R.layout.product_list_item, likedProducts)
        listView.adapter = adapter

        return view
    }
}



