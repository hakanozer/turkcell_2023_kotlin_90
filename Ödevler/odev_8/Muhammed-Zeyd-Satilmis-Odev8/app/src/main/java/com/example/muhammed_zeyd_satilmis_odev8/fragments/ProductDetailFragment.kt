package com.example.muhammed_zeyd_satilmis_odev8.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.muhammed_zeyd_satilmis_odev8.R
import com.example.muhammed_zeyd_satilmis_odev8.databinding.FragmentProductDetailBinding
import com.example.muhammed_zeyd_satilmis_odev8.models.Product
import com.example.muhammed_zeyd_satilmis_odev8.models.Products


class ProductDetailFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailBinding.inflate(layoutInflater, container, false)

        binding.btnBuy.text = getString(R.string.btn_buy)

        viewInitialization()

        return binding.root
    }

    private fun viewInitialization() {
        val bundle: ProductDetailFragmentArgs by navArgs()

        Glide.with(this).load(bundle.productArg.images[0]).placeholder(R.drawable.pass)
            .into(binding.imageView)

        binding.txtBrand.text = bundle.productArg.brand
        binding.txtTitle.text = bundle.productArg.title
        binding.txtDiscountPrice.text = "İndirim: %${bundle.productArg.discountPercentage}"
        binding.txtSale.text = "$${bundle.productArg.price}"
        binding.txtDescription.text = bundle.productArg.description
        binding.txtRating.text = bundle.productArg.rating.toString()
        binding.txtStock.text = bundle.productArg.stock.toString()
        binding.txtCategory.text = bundle.productArg.category.capitalize()
    }


}
