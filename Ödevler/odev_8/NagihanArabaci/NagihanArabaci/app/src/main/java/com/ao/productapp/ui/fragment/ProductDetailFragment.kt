package com.ao.productapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ao.productapp.R
import com.ao.productapp.databinding.FragmentProductDetailBinding
import com.ao.productapp.model.Product
import com.bumptech.glide.Glide


class ProductDetailFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailBinding
    private lateinit var product:Product

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentProductDetailBinding.inflate(layoutInflater)
        binding.toolbarProduct.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        getData()
        return binding.root
    }

    private fun getData(){
        // ürünün bilgilerini burada alıyoruz
        val bundle : ProductDetailFragmentArgs by navArgs()
        product = bundle.product

        binding.tvProductAbout.text = product.description
        binding.tvProductName.text = product.title
        binding.tvProductPrice.text = product.price.toString()
        Glide.with(binding.ivProductImage.context).load(product.thumbnail).into(binding.ivProductImage)

    }


}