package com.example.vize_2.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.vize_2.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val productArgs: DetailArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(binding.imageView).load(productArgs.ProductDetailInformation.images?.get(0))
            .into(binding.imageView)
        binding.txtTitle.text = productArgs.ProductDetailInformation.title
        binding.txtDescripton.text = productArgs.ProductDetailInformation.description
        binding.txtBrand.text = productArgs.ProductDetailInformation.brand
        binding.txtPrice.text = productArgs.ProductDetailInformation.price.toString()
        binding.txtCategory.text = productArgs.ProductDetailInformation.category

    }
}