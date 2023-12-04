package com.ao.nagihanarabaci.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.ao.nagihanarabaci.R
import com.ao.nagihanarabaci.data.SharedPreferencesHelper
import com.ao.nagihanarabaci.databinding.FragmentDetailBinding
import com.ao.nagihanarabaci.models.Product
import com.bumptech.glide.Glide

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var product: Product
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        binding.toolbarDetail.setNavigationOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        setFragmentView()
        return binding.root
    }

    private fun setFragmentView() {
        val bundle: DetailFragmentArgs by navArgs()
        product = bundle.product

        binding.tvProductName.text = product.title
        binding.tvProductPrice.text = product.price.toString()
        binding.tvProductDescription.text = product.description
        val rate = product.rating.toInt()
        val notRate = 5 - rate
        for (i in 1..rate) {
            val filledImageView = ImageView(binding.root.context)
            filledImageView.setImageResource(R.drawable.star_filled)
            binding.ratebar.addView(filledImageView)
        }
        for (i in 1..notRate) {
            val notFilledImageView = ImageView(binding.root.context)
            notFilledImageView.setImageResource(R.drawable.star_outline)
            binding.ratebar.addView(notFilledImageView)
        }
        Glide.with(binding.ivProductImage.context).load(product.images.first())
            .into(binding.ivProductImage)
        binding.ivFavorite.setOnClickListener {
            val sharedPref = SharedPreferencesHelper()
            val sharedPreferences =
                sharedPref.getSharedPreferences(binding.root.context, "my_preferences")
            val getIds = sharedPref.getString(sharedPreferences, "ids","")

            if (getIds != null && getIds.trim().isNotEmpty() && getIds.contains(product.id.toString())) {
                Toast.makeText(binding.root.context, "Bu ürün zaten favorilerinizde", Toast.LENGTH_SHORT).show()
            } else {
                getIds?.let {
                    sharedPref.put(sharedPreferences, "ids", it + "," + product.id.toString())
                }
            }


        }


    }

    fun rateOptions() {

    }


}